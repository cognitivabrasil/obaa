/*
 * Copyright (c) 2016 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.general;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Thumbnail;
import cognitivabrasil.obaa.OBAA;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class ThumbnailTest {

    @Test
    public void testThumbnailXml() {
        OBAA o = new OBAA();
        General g = new General();
        g.addThumbnail(new Thumbnail("www.cognitivabrasil.com.br", "800", "600"));
        o.setGeneral(g);

        String xml = o.toXml();

        assertThat(xml, containsString("<obaa:thumbnail>"));
        int begin = xml.indexOf("<obaa:thumbnail>");
        int end = xml.indexOf("</obaa:thumbnail>");
        String xmlThumbnail = xml.substring(begin, end);

        assertThat(xmlThumbnail, containsString("<obaa:location>www.cognitivabrasil.com.br</obaa:location>"));
        assertThat(xmlThumbnail, containsString("<obaa:height>800</obaa:height>"));
        assertThat(xmlThumbnail, containsString("<obaa:width>600</obaa:width>"));

    }
}
