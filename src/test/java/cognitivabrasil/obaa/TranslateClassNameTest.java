/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cognitivabrasil.obaa;

import cognitivabrasil.util.Translate;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class TranslateClassNameTest {
    
    @Test
    public void testGeneral(){
        assertThat(Translate.translateToPtBR("general"), equalTo("Informações Gerais"));
    }
    @Test
    public void testTitle(){
        assertThat(Translate.translateToPtBR("titles"), equalTo("Título"));
    }
    
}
