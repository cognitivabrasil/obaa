/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.accessibility;

import cognitivabrasil.obaa.Accessibility.ReducedSpeed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class ReducedSpeedTest {

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNotNumber() {
        ReducedSpeed rs = new ReducedSpeed();
        rs.setCaptionRate("erro");

    }

    @Test
    public void testValidate() {
        ReducedSpeed rs = new ReducedSpeed();
        rs.setCaptionRate("10");
        assertThat(rs.getCaptionRate(), equalTo("10"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateWithoutLimit() {
        ReducedSpeed rs = new ReducedSpeed();
        rs.setCaptionRate("350");
    }
}
