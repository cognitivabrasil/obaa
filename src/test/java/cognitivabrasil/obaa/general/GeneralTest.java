/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.general;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.General.Thumbnail;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos at cognitivabrasil.com.br>
 */
public class GeneralTest {

    String json;
    General general;

    @Before
    public void init() {
        json = "{\"titles\":[\"Título aleatório\"],\"keywords\":[\"chaves\"],\"descriptions\":[\"descri\",\"description\"],\"coverages\":[\"cover\"],\"aggregationLevel\":\"1\",\"identifiers\":[{\"catalog\":\"URI\",\"entry\":\"www.cognitivabrasil.com.br\"},{\"catalog\":\"catalogo\",\"entry\":\"http://id\"}],\"languages\":[\"pt\",\"pt-br\"],\"structure\":\"atomic\",\"thumbnails\":[{\"location\":\"http://img\",\"height\":\"800\",\"width\":\"600\"}]}";

        general = new General();
        general.addIdentifier(new Identifier("URI", "www.cognitivabrasil.com.br"));
        general.addIdentifier(new Identifier("catalogo", "http://id"));
        general.addTitle("Título aleatório");
        general.addLanguage("pt");
        general.addLanguage("pt-br");
        general.setStructure(Structure.fromText(Structure.ATOMIC));
        general.setAggregationLevel("1");
        general.addDescription("descri");
        general.addDescription("description");
        general.addKeyword("chaves");
        general.addCoverage("cover");
        general.addThumbnail(new Thumbnail("http://img", "800", "600"));

    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(general);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        General g2 = mapper.readValue(json, General.class);
        assertThat(g2.getTitles(), equalTo(general.getTitles()));
        assertThat(g2.getLanguages(), equalTo(general.getLanguages()));
        assertThat(g2.getKeywords(), equalTo(general.getKeywords()));
        assertThat(g2.getDescriptions(), equalTo(general.getDescriptions()));
        assertThat(g2.getCoverages(), equalTo(general.getCoverages()));
        assertThat(g2.getAggregationLevel(), equalTo(general.getAggregationLevel()));
        assertThat(g2.getIdentifiers(), equalTo(general.getIdentifiers()));
        assertThat(g2.getStructure(), equalTo(general.getStructure()));
        assertThat(g2.getThumbnails().size(), equalTo(general.getThumbnails().size()));
        assertThat(g2.getThumbnails().get(0).getHeight(), equalTo(general.getThumbnails().get(0).getHeight()));
        assertThat(g2.getThumbnails().get(0).getWidth(), equalTo(general.getThumbnails().get(0).getWidth()));
        assertThat(g2.getThumbnails().get(0).getLocation(), equalTo(general.getThumbnails().get(0).getLocation()));
    }
}
