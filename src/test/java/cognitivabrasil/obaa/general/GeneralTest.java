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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos at cognitivabrasil.com.br>
 */
public class GeneralTest {

    @Test
    public void testGeneralSerializeAndThenDeserialize() throws IOException, JsonProcessingException {

        cognitivabrasil.obaa.General.General g = new cognitivabrasil.obaa.General.General();
        //g.addIdentifiers("Catalog");
        g.addTitle("Título aleatório");
        g.addLanguage("pt");
        g.addLanguage("pt-br");
        cognitivabrasil.obaa.General.Structure s = new cognitivabrasil.obaa.General.Structure();
        s.setText(cognitivabrasil.obaa.General.Structure.ATOMIC);
        g.setStructure(s);
        g.setAggregationLevel("1");
        g.addDescription("descri");
        g.addDescription("description");
        g.addKeyword("chaves");
        g.addCoverage("cover");
        g.setAggregationLevel("1");
        g.addThumbnail(new cognitivabrasil.obaa.General.Thumbnail("http://img", "800", "600"));

        cognitivabrasil.obaa.General.Identifier i = new cognitivabrasil.obaa.General.Identifier();
        i.setCatalog("catalog");
        i.setEntry("entry");
        cognitivabrasil.obaa.General.Identifier id = new cognitivabrasil.obaa.General.Identifier("catalogo", "http://id");
        g.addIdentifier(id);

        ObjectMapper mapper = new ObjectMapper();
        String obaaJson = mapper.writeValueAsString(g);

        cognitivabrasil.obaa.General.General g2 = mapper.readValue(obaaJson, cognitivabrasil.obaa.General.General.class);
        assertThat(g2.getTitles(), equalTo(g.getTitles()));
        assertThat(g2.getLanguages(), equalTo(g.getLanguages()));
        assertThat(g2.getKeywords(), equalTo(g.getKeywords()));
        assertThat(g2.getDescriptions(), equalTo(g.getDescriptions()));
        assertThat(g2.getCoverages(), equalTo(g.getCoverages()));
        assertThat(g2.getAggregationLevel(), equalTo(g.getAggregationLevel()));
        assertThat(g2.getIdentifiers(), equalTo(g.getIdentifiers()));
        assertThat(g2.getStructure(), equalTo(g.getStructure()));
        assertThat(g2.getThumbnails().size(), equalTo(g.getThumbnails().size()));
        assertThat(g2.getThumbnails().get(0).getHeight(), equalTo(g.getThumbnails().get(0).getHeight()));
        assertThat(g2.getThumbnails().get(0).getWidth(), equalTo(g.getThumbnails().get(0).getWidth()));
        assertThat(g2.getThumbnails().get(0).getLocation(), equalTo(g.getThumbnails().get(0).getLocation()));

    }
}
