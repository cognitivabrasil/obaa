/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.classification;

import cognitivabrasil.obaa.Classification.Classification;
import cognitivabrasil.obaa.Classification.Taxon;
import cognitivabrasil.obaa.Classification.TaxonPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class ClassificationTest {

    private String json;
    private Classification cl;

    @Before
    public void init() {
        json = "{\"description\":\"Class desc\",\"purpose\":\"class purpose\",\"keywords\":[\"class k1\",\"class k2\"],"
                + "\"taxonPath\":[{\"source\":\"http://taxon\",\"taxons\":[{\"id\":\"tid\",\"entry\":\"tlabel\"}]}]}";
        cl = new Classification();
        cl.setDescription("Class desc");
        cl.setPurpose("class purpose");
        cl.addKeyword("class k1");
        cl.addKeyword("class k2");
        TaxonPath taxon = new TaxonPath();
        taxon.setSource("http://taxon");
        taxon.addTaxons(new Taxon("tid", "tlabel"));
        cl.addTaxonPath(taxon);
    }


    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(cl);
        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Classification result = mapper.readValue(json, Classification.class);
        assertThat(result.getDescription(), equalTo(cl.getDescription()));
        assertThat(result.getPurpose(), equalTo(cl.getPurpose()));
        assertThat(result.getKeywords(), equalTo(cl.getKeywords()));
        assertThat(result.getTaxonPath().get(0).getSource(), equalTo(cl.getTaxonPath().get(0).getSource()));
        assertThat(result.getTaxonPath().get(0).getTaxons(), equalTo(cl.getTaxonPath().get(0).getTaxons()));

    }
}
