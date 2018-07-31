/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.General.Thumbnail;
import cognitivabrasil.obaa.Technical.OrComposite;
import cognitivabrasil.obaa.Technical.Requirement;
import cognitivabrasil.obaa.Technical.Technical;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

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
    public void testGeneralSerialize() throws JsonProcessingException{

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

            ObjectMapper mapper = new ObjectMapper();
        String obaaJson = mapper.writeValueAsString(g);

        System.out.println(obaaJson);
    }
    @Test
    public void testGeneralDeserialize() throws IOException{
        String json = "{\"titles\":[\"Título aleatório\"],\"keywords\":[\"chaves\"],\"descriptions\":[\"descri\",\"description\"],\"coverages\":[\"cover\"],\"aggregationLevel\":\"1\",\"identifiers\":[{\"catalog\":\"catalogo\",\"entry\":\"http://id\"}],\"languages\":[\"pt\",\"pt-br\"],\"structure\":\"atomic\",\"thumbnails\":[{\"location\":\"http://img\",\"height\":\"800\",\"width\":\"600\"}],\"identifier\":{\"catalog\":\"catalogo\",\"entry\":\"http://id\"}}";
        ObjectMapper mapper = new ObjectMapper();
        General g = mapper.readValue(json, General.class);

        assertThat(g.getTitles().get(0), equalTo("Título aleatório"));

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

    private OBAA createOrComposite(){
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
    public void testOrCompositeEn(){
        JsonGenerator jsonG = new JsonGenerator();
        String json = jsonG.getJson(createOrComposite());

        String correctJson =
                "[{\"label\":\"technical\","
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
    public void testOrCompositePtBR(){
        OBAA obaa = createOrComposite();

        JsonGenerator jsonG = new JsonGenerator("pt-BR");
        String json = jsonG.getJson(obaa);

        String correctJson =
                "[{\"label\":\"Informações técnicas\","
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
