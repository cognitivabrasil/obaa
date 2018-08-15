/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.metametadata;

import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.LifeCycle.LifeCycleDate;
import cognitivabrasil.obaa.Metametadata.Contribute;
import cognitivabrasil.obaa.Metametadata.Language;
import cognitivabrasil.obaa.Metametadata.Metametadata;
import cognitivabrasil.obaa.Metametadata.Role;
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
public class MetametadataTest {

    private String json;
    private Metametadata metameta;

    @Before
    public void init() {
        json = "{\"language\":\"pt-BR\",\"metadataSchema\":[\"OBAAv1.0\"],\"contribute\":[{\"role\":\"creator\",\"entity\":[\"Marcos\"], \"date\":\"14/08/2018\"}],\"identifier\":[{\"catalog\":\"cat\",\"entry\":\"ftp://entry\"}]}";
        metameta = new Metametadata();

        metameta.setLanguage(new Language("pt-BR"));
        Contribute contribute = new Contribute();
        contribute.addEntity("Marcos");
        contribute.setDate(new LifeCycleDate("2018-08-14T15:03:30"));
        contribute.setRole(Role.fromText(Role.CREATOR));
        metameta.addContribute(contribute);
        metameta.addIdentifier(new Identifier("cat", "ftp://entry"));
    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(metameta);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Metametadata e = mapper.readValue(json, Metametadata.class);

        assertThat(e.getContribute().size(), equalTo(metameta.getContribute().size()));
        assertThat(e.getContribute().get(0).getRole(), equalTo(metameta.getContribute().get(0).getRole()));
        assertThat(e.getContribute().get(0).getFirstEntity(), equalTo(metameta.getContribute().get(0).getFirstEntity()));
        assertThat(e.getContribute().get(0).getDate().getTranslated(), equalTo(metameta.getContribute().get(0).getDate().getTranslated()));
        assertThat(e.getIdentifier(), equalTo(metameta.getIdentifier()));
        assertThat(e.getLanguage(), equalTo(metameta.getLanguage()));
        assertThat(e.getMetadataSchema(), equalTo(metameta.getMetadataSchema()));
    }

}
