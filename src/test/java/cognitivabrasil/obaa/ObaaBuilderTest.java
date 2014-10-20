package cognitivabrasil.obaa;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import static cognitivabrasil.obaa.builder.ObaaBuilder.buildObaa;

import org.junit.Test;


public class ObaaBuilderTest {

    @Test
    public void testBuildSimpleObaa() {
        OBAA a = buildObaa().general().title("Meu título").build();
        
        assertThat(a.getGeneral().getTitles(), hasItem("Meu título"));                
    }
    
    @Test
    public void testBuildLanguage() {
        OBAA a = buildObaa()
                    .general()
                        .title("Meu título")
                        .language("pt-BR")
                 .build();
        
        assertThat(a.getGeneral().getLanguages(), hasItem("pt-BR"));

    }


}
