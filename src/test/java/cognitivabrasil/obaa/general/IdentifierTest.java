/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.general;

import cognitivabrasil.obaa.General.Identifier;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class IdentifierTest {

    Identifier id1;

    @Before
    public void setUp() {
        id1 = new Identifier();
        id1.setCatalog("URI");
        id1.setEntry("123");

    }

    @Test
    public void testEqualTrue() {

        Identifier id2 = new Identifier();
        id2.setCatalog("URI");
        id2.setEntry("123");

        assertThat(id1.equals(id2), equalTo(true));
    }

    @Test
    public void testEqualFalse() {

        Identifier id2 = new Identifier();
        id2.setCatalog("URI");
        id2.setEntry("1233");

        assertThat(id1.equals(id2), equalTo(false));
    }
    
    @Test
    public void testContains(){
        List<Identifier> ids = new ArrayList<Identifier>();
        ids.add(id1);
        
        ids.add(new Identifier("URI", "1234"));
        ids.add(new Identifier("XX", "123"));
        
        assertThat(ids.contains(new Identifier("URI", "123")), equalTo(true));
        
    }
}
