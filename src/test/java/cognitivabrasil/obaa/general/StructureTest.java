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

import cognitivabrasil.obaa.General.Structure;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Tests Structure object.
 * @author Marcos Freitas Nunes <marcos at cognitivabrasil.com.br>
 */
public class StructureTest {


    @Test
    public void testDeserializeStructure() throws Exception{
        String json = "\"atomic\"";
        ObjectMapper mapper = new ObjectMapper();
        Structure obj = mapper.readValue(json, Structure.class);
        assertThat(obj.getText(), equalTo(Structure.ATOMIC));
    }
}
