/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.rights;

import cognitivabrasil.obaa.Rights.Rights;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class RightsTest {

    private String json;

    @Before
    public void init() {
        json = "{\"cost\":\"false\",\"copyright\":\"true\", \"description\":\"Right Description\"}";
    }

    @Test
    public void serializeJson() throws Exception {
        Rights r = new Rights();
        r.setCopyright(true);
        r.setCost(false);
        r.setDescription("Right Description");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(r);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Rights g = mapper.readValue(json, Rights.class);

        assertThat(g.getDescription(), equalTo("Right Description"));
        assertThat(g.getCopyright().getBoolean(), equalTo(true));
        assertThat(g.getCost().getBoolean(), equalTo(false));
    }

}
