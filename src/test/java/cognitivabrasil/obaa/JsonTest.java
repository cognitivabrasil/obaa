/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.Technical.OrComposite;
import cognitivabrasil.obaa.Technical.Requirement;
import cognitivabrasil.obaa.Technical.Technical;
import static cognitivabrasil.obaa.builder.ObaaBuilder.buildObaa;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.jayway.jsonassert.JsonAssert;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class JsonTest {

    @Test
    public void testJson() {
        OBAA obaa = new OBAA();
        General general = new General();
        general.addTitle("title text");
        general.addDescription("This is a description");
        Identifier id = new Identifier("URI", "www.cognitivabrasil.com.br");
        general.addIdentifier(id);
        general.setStructure(new Structure());
        obaa.setGeneral(general);
        
        JsonGenerator jsonG = new JsonGenerator();
        String json = jsonG.getJson(obaa);
        
        String correctJson = "[{\"label\":\"general\",\"children\":[{\"label\":\"titles\",\"value\":\"title text\"},{\"label\":\"descriptions\",\"value\":\"This is a description\"},{\"label\":\"identifiers\",\"children\":[{\"label\":\"catalog\",\"value\":\"URI\"},{\"label\":\"entry\",\"value\":\"www.cognitivabrasil.com.br\"}]}]}]";
        
        assertThat(json, equalTo(correctJson));
    }
    
    private OBAA createOrComposite(){
        OBAA obaa = new OBAA();
        Technical tec = new Technical();
        obaa.setTechnical(tec);
        Requirement req = new Requirement();
        tec.addRequirement(req);
        OrComposite orComp = new OrComposite();
        req.addOrComposite(orComp);
        orComp.setType("browser");
        orComp.setName("firefox");
        return obaa;
    }
    
    @Test
    public void testOrCompositeEn(){
        JsonGenerator jsonG = new JsonGenerator();
        String json = jsonG.getJson(createOrComposite());
        
        String correctJson = 
                "[{\"label\":\"technical\","
                    + "\"children\":[{\"label\":\"requirement\","
                        + "\"children\":[{\"label\":\"orComposite\","
                            + "\"children\":["
                                + "{\"label\":\"type\",\"value\":\"browser\"},"
                                + "{\"label\":\"name\",\"value\":\"firefox\"}"
                            + "]"
                        + "}]"
                    + "}]"
                + "}]";
        
        assertThat(json, equalTo(correctJson));
    }
    
    @Test
    public void testOrCompositePtBR(){
        OBAA obaa = createOrComposite();
  
        JsonGenerator jsonG = new JsonGenerator("pt-BR");
        String json = jsonG.getJson(obaa);
        
        String correctJson = 
                "[{\"label\":\"Informações técnicas\","
                    + "\"children\":[{\"label\":\"Requisitos\","
                        + "\"children\":[{\"label\":\"Opção\","
                            + "\"children\":["
                                + "{\"label\":\"Tipo\",\"value\":\"browser\"},"
                                + "{\"label\":\"Nome\",\"value\":\"firefox\"}"
                            + "]"
                        + "}]"
                    + "}]"
                + "}]";
        
        assertThat(json, equalTo(correctJson));
    }
    
}
