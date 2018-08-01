/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.LifeCycle;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos at cognitivabrasil.com.br>
 */
public class LifeCycleTest {

    private ObjectMapper mapper;

    @Before
    public void init(){
        mapper = new ObjectMapper();
    }

    @Test
    public void testJsonSerialize() throws Exception{
        LifeCycle d = new LifeCycle();
        d.setStatus(Status.DRAFT);
        d.setVersion("0.0.1");
        Contribute contribute = new Contribute();
        contribute.addEntity("UFRGS");
        Entity e2 = new Entity();
        e2.setText("BEGIN:VCARD\nVERSION:3.0\nN:do Brasil;Ministério da Educação;;;\nFN:Ministério da Educação do Brasil\nEND:VCARD");
        contribute.addEntity(e2);
        contribute.setDate("2018-09-01");
        contribute.setRole(Role.PUBLISHER);
        d.addContribute(contribute);

        String jsonResult = mapper.writeValueAsString(d);
        String jsonModel = "{\"status\":\"draft\",\"version\":\"0.0.1\",\"contribute\":[{\"role\":\"publisher\",\"date\":\"01/09/2018\",\"entities\":[\"UFRGS\" ,\"Ministério da Educação do Brasil\"]}]}";

        JSONAssert.assertEquals(jsonModel, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void testJsonDeserialize() throws Exception{
        String lcJson = "{\"status\":\"draft\",\"version\":\"0.0.1\",\"contribute\":[{\"role\":\"publisher\",\"date\":\"01/09/2018\",\"entities\":[\"UFRGS\"]}]}";

        LifeCycle obj = mapper.readValue(lcJson, LifeCycle.class);
        assertThat(obj.getStatus(), equalTo(Status.DRAFT));
        assertThat(obj.getVersion(), equalTo("0.0.1"));
        assertThat(obj.getContribute(), hasSize(1));
        assertThat(obj.getContribute().get(0).getDate().getText(), equalTo("01/09/2018"));
        assertThat(obj.getContribute().get(0).getRole().getText(), equalTo(Role.PUBLISHER));
        System.out.println(obj.getContribute().get(0).getEntities());
        assertThat(obj.getContribute().get(0).getEntities(), hasSize(1));
        assertThat(obj.getContribute().get(0).getEntities().get(0), equalTo("UFRGS"));

    }
}
