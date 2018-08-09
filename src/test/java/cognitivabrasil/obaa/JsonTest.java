/*
 * Copyright (c) 2014 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.General.Thumbnail;
import cognitivabrasil.obaa.LifeCycle.Contribute;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;
import cognitivabrasil.obaa.LifeCycle.Role;
import cognitivabrasil.obaa.LifeCycle.Status;
import cognitivabrasil.obaa.Rights.Rights;
import cognitivabrasil.obaa.Technical.OrComposite;
import cognitivabrasil.obaa.Technical.Requirement;
import cognitivabrasil.obaa.Technical.Technical;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class JsonTest {

    @Test
    public void testJson() {
        OBAA obaa = new OBAA();
        General general = new General();
        general.addTitle("title text");
        general.addDescription("This is a description");
        Identifier id = new Identifier("URI", "www.cognitivabrasil.com.br");
        general.addIdentifier(id);
        general.setStructure(new Structure());
        obaa.setGeneral(general);

        JsonGenerator jsonG = new JsonGenerator();
        String json = jsonG.getJson(obaa);

        String correctJson = "[{\"label\":\"general\",\"children\":[{\"label\":\"titles\",\"value\":\"title text\"},{\"label\":\"descriptions\",\"value\":\"This is a description\"},{\"label\":\"identifiers\",\"children\":[{\"label\":\"catalog\",\"value\":\"URI\"},{\"label\":\"entry\",\"value\":\"www.cognitivabrasil.com.br\"}]}]}]";

        assertThat(json, equalTo(correctJson));
    }

    @Test
    public void testJsonSerialize() throws Exception {
        OBAA obaa = new OBAA();
        General g = new General();
        //g.addIdentifiers("Catalog");
        g.addTitle("Título aleatório");
        g.addLanguage("pt");
        g.addLanguage("pt-br");
        Structure s = new Structure();
        s.setText(Structure.ATOMIC);
        g.setStructure(s);
        g.setAggregationLevel("1");
        g.addDescription("descri");
        g.addDescription("description");
        g.addKeyword("chaves");
        g.addCoverage("cover");
        g.setAggregationLevel("1");
        g.addThumbnail(new Thumbnail("http://img", "800", "600"));
        Identifier i = new Identifier();
        i.setCatalog("catalog");
        i.setEntry("entry");
        Identifier id = new Identifier("catalogo", "http://id");
        g.addIdentifier(id);
        obaa.setGeneral(g);
        LifeCycle lifeCycle = new LifeCycle();
        lifeCycle.setStatus(Status.DRAFT);
        lifeCycle.setVersion("0.0.1");
        Contribute contribute = new Contribute();
        contribute.addEntity("UFRGS");
        contribute.setDate("2018-09-01");
        contribute.setRole(Role.PUBLISHER);
        lifeCycle.addContribute(contribute);
        obaa.setLifeCycle(lifeCycle);
        Rights r = new Rights();
        r.setCopyright(true);
        r.setCost(false);
        r.setDescription("Right Description");
        obaa.setRights(r);

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(obaa);
        System.out.println(jsonResult);

        JSONAssert.assertEquals("{\"general\":{\"titles\":[\"Título aleatório\"]}}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{\"lifeCycle\":{\"version\":\"0.0.1\"}}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{rights:{cost:\"false\",copyright:\"true\", description:\"Right Description\"}}",
                jsonResult, JSONCompareMode.LENIENT);

//        System.out.println(jsonResult);
    }

    @Test
    public void testGeneralDeserialize() throws IOException {
        String json = "{\"structure\":\"atomic\"}";
        ObjectMapper mapper = new ObjectMapper();
        General g = mapper.readValue(json, General.class);

        assertThat(g.getStructure().toString(), equalTo(Structure.ATOMIC));

        //g.addIdentifiers("Catalog");
//            g.addTitle("Título aleatório");
//            g.addLanguage("pt");
//            g.addLanguage("pt-br");
//            Structure s = new Structure();
//            s.setText(Structure.ATOMIC);
//            g.setStructure(s);
//            g.setAggregationLevel("1");
//            g.addDescription("descri");
//            g.addDescription("description");
//            g.addKeyword("chaves");
//            g.addCoverage("cover");
//            g.setAggregationLevel("1");
//            g.addThumbnail(new Thumbnail("http://img", "800", "600"));
//
//            Identifier i = new Identifier();
//            i.setCatalog("catalog");
//            i.setEntry("entry");
//            Identifier id = new Identifier("catalogo", "http://id");
//            g.addIdentifier(id);
    }

    private OBAA createOrComposite() {
        OBAA obaa = new OBAA();
        Technical tec = new Technical();
        obaa.setTechnical(tec);
        Requirement req = new Requirement();
        tec.addRequirement(req);
        OrComposite orComp = new OrComposite();
        req.addOrComposite(orComp);
        orComp.setType("browser");
        orComp.setName("firefox");
        return obaa;
    }

    @Test
    public void testOrCompositeEn() {
        JsonGenerator jsonG = new JsonGenerator();
        String json = jsonG.getJson(createOrComposite());

        String correctJson
                = "[{\"label\":\"technical\","
                + "\"children\":[{\"label\":\"requirement\","
                + "\"children\":[{\"label\":\"orComposite\","
                + "\"children\":["
                + "{\"label\":\"type\",\"value\":\"browser\"},"
                + "{\"label\":\"name\",\"value\":\"firefox\"}"
                + "]"
                + "}]"
                + "}]"
                + "}]";

        assertThat(json, equalTo(correctJson));
    }

    @Test
    public void testOrCompositePtBR() {
        OBAA obaa = createOrComposite();

        JsonGenerator jsonG = new JsonGenerator("pt-BR");
        String json = jsonG.getJson(obaa);

        String correctJson
                = "[{\"label\":\"Informações técnicas\","
                + "\"children\":[{\"label\":\"Requisitos\","
                + "\"children\":[{\"label\":\"Opção\","
                + "\"children\":["
                + "{\"label\":\"Tipo\",\"value\":\"browser\"},"
                + "{\"label\":\"Nome\",\"value\":\"firefox\"}"
                + "]"
                + "}]"
                + "}]"
                + "}]";

        assertThat(json, equalTo(correctJson));
    }

}
