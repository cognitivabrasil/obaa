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

import cognitivabrasil.obaa.Accessibility.Accessibility;
import cognitivabrasil.obaa.Accessibility.Primary;
import cognitivabrasil.obaa.Accessibility.ResourceDescription;
import cognitivabrasil.obaa.Annotation.Annotation;
import cognitivabrasil.obaa.Classification.Classification;
import cognitivabrasil.obaa.Educational.Difficulty;
import cognitivabrasil.obaa.Educational.Educational;
import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.General.Thumbnail;
import cognitivabrasil.obaa.LifeCycle.Contribute;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;
import cognitivabrasil.obaa.LifeCycle.Role;
import cognitivabrasil.obaa.LifeCycle.Status;
import cognitivabrasil.obaa.Metametadata.Language;
import cognitivabrasil.obaa.Metametadata.Metametadata;
import cognitivabrasil.obaa.Relation.Kind;
import cognitivabrasil.obaa.Relation.Relation;
import cognitivabrasil.obaa.Rights.Rights;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformation;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformationTable;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentList;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentMediaType;
import cognitivabrasil.obaa.Technical.OrComposite;
import cognitivabrasil.obaa.Technical.Requirement;
import cognitivabrasil.obaa.Technical.Size;
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

    private OBAA createTinyObaaTest() {
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
        Educational educational = new Educational();
        educational.setDifficulty(Difficulty.EASY);
        educational.addDescription("desc abc");
        obaa.setEducational(educational);
        Technical technical = new Technical();
        technical.setSize(new Size("9876"));
        technical.addFormat("pdf");
        obaa.setTechnical(technical);
        Metametadata metameta = new Metametadata();
        metameta.setLanguage(new Language("pt-BR"));
        obaa.setMetametadata(metameta);
        Relation rel = new Relation();
        rel.setKind(Kind.HAS_PART);
        obaa.addRelation(rel);
        Annotation annotation = new Annotation();
        annotation.setDate("2018/08/15");
        annotation.setDescription("Annontation desc");
        annotation.setEntity("annotation ent");
        obaa.addAnnotation(annotation);

        Classification classification = new Classification();
        classification.setDescription("Class description");
        classification.setPurpose("class purpose");
        obaa.addClassification(classification);

        Accessibility acc = new Accessibility();
        ResourceDescription rd = new ResourceDescription();
        Primary primary = new Primary();
        primary.setVisual(true);
        primary.setText(true);
        primary.setTactile(false);
        rd.setPrimary(primary);
        acc.setResourceDescription(rd);
        obaa.setAccessibility(acc);

        SegmentInformationTable sit = new SegmentInformationTable();
        SegmentList segmentList = new SegmentList();
        SegmentInformation si = new SegmentInformation();

        si.setIdentifier("1");
        si.setTitle("tubarão");
        si.setEnd("00:15");
        si.setStart("00:10");
        si.setSegmentMediaType(SegmentMediaType.fromText(SegmentMediaType.DOCUMENT));
        segmentList.addSegmentList(si);
        sit.addSegmentList(segmentList);
        obaa.setSegmentInformationTable(sit);
        return obaa;
    }

    @Test
    public void testJsonSerialize() throws Exception {
        OBAA obaa = createTinyObaaTest();

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(obaa);
        System.out.println(jsonResult);

        JSONAssert.assertEquals("{\"general\":{\"titles\":[\"Título aleatório\"]}}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{\"lifeCycle\":{\"version\":\"0.0.1\"}}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{rights:{cost:\"false\",copyright:\"true\", description:\"Right Description\"}}",
                jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{educational:{difficulty:\"easy\",descriptions:[\"desc abc\"]}}",
                jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{technical:{size:\"9876\",formats:[\"pdf\"]}}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{metametadata:{language:\"pt-BR\",metadataSchema:[\"OBAAv1.0\"]}}", jsonResult,
                JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{relations:[{kind:\"haspart\"}]}", jsonResult, JSONCompareMode.LENIENT);
        String annotationJson = "{annotations:[{date:\"2018/08/15\",\"description\":\"Annontation desc\", "
                + "\"entity\":\"annotation ent\"}]}";
        JSONAssert.assertEquals(annotationJson, jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{classifications: [{\"description\":\"Class description\",\"purpose\":\"class purpose\"}]}", jsonResult, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{accessibility: {\"resourceDescription\":{\"primary\":{\"hasVisual\":true,\"hasText\":true,\"hasTactile\":false}}}}", jsonResult, JSONCompareMode.LENIENT);

        String segInfTabJson = "{\"segmentInformationTable\":{\"segmentList\":[{\"segmentInformation\":[{"
                + "\"identifier\":\"1\",\"title\":\"tubarão\", \"end\":\"00:15\", \"start\":\"00:10\", "
                + "\"segmentMediaType\":\"document\"}] }]} }";
        JSONAssert.assertEquals(segInfTabJson, jsonResult, JSONCompareMode.LENIENT);

    }

//    @Test
    public void testGeneralDeserialize() throws IOException {
        String json = "{\"general\":{\"titles\":[\"Título aleatório\"]}, "
                + "\"lifeCycle\":{\"version\":\"0.0.1\"},"
                + "\"rights\":{\"cost\":\"false\",\"copyright\":\"true\", \"description\":\"Right Description\"},"
                + "\"educational\":{\"difficulty\":\"easy\",\"descriptions\":[\"desc abc\"]},"
                + "\"technical\":{\"size\":\"9876\",\"formats\":[\"pdf\"]},"
                + "\"metametadata\":{\"language\":\"pt-BR\",\"metadataSchema\":[\"OBAAv1.0\"]},"
                + "\"relations\":[{\"kind\":\"haspart\"}],"
                + "\"annotations\":[{\"date\":\"2018/08/15\",\"description\":\"Annontation desc\",\"entity\":\"annotation ent\"}],"
                + "\"classifications\": [{\"description\":\"Class description\",\"purpose\":\"class purpose\"}],"
                + "\"accessibility\": {\"resourceDescription\":{\"primary\":{\"hasVisual\":true,\"hasText\":true,\"hasTactile\":false}}},"
                + "\"segmentInformationTable\":{\"segmentList\":[{\"segmentInformation\":[{"
                + "     \"identifier\":\"1\",\"title\":\"tubarão\", \"end\":\"00:15\", \"start\":\"00:10\", "
                + "     \"segmentMediaType\":\"document\"}] }]}"
                + "}";
        ObjectMapper mapper = new ObjectMapper();
        OBAA obaaResult = mapper.readValue(json, OBAA.class);

        assertThat(obaaResult, equalTo(createTinyObaaTest()));
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
