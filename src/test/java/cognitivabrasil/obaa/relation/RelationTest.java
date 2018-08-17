/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.relation;

import cognitivabrasil.obaa.General.Description;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.Relation.Kind;
import cognitivabrasil.obaa.Relation.Relation;
import cognitivabrasil.obaa.Relation.Resource;
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
public class RelationTest {

    private String json;
    private Relation rel;

    @Before
    public void init() {
        json = "{\"kind\":\"requires\",\"resource\":{\"identifier\":[{\"catalog\":\"cat\",\"entry\":\"c001\"}],"
                + "\"description\":[\"rel desc\"]}}";
        rel = new Relation();
        rel.setKind(Kind.fromText(Kind.REQUIRES));
        Resource resource = new Resource();
        resource.addIdentifier(new Identifier("cat", "c001"));
        resource.addDescription(new Description("rel desc"));
        rel.setResource(resource);
    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(rel);
        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Relation result = mapper.readValue(json, Relation.class);
        assertThat(result.getKind(), equalTo(rel.getKind()));
        assertThat(result.getResource().getDescription(), equalTo(rel.getResource().getDescription()));
        assertThat(result.getResource().getIdentifier(), equalTo(rel.getResource().getIdentifier()));
    }
}
