package cognitivabrasil.obaa;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static cognitivabrasil.obaa.builder.ObaaBuilder.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    
    
    @Test
    public void lifeCycle() {
        OBAA o = buildObaa().lifeCycle().status("draft").build();
        
        assertThat(o.getLifeCycle().getStatus(), equalTo("draft"));
    }

    @Test 
    public void stack() {
        OBAA o = buildObaa().general().title("Bla")
                    .lifeCycle().status("draft")
                    .build();

        assertThat(o.getLifeCycle().getStatus(), equalTo("draft"));
        assertThat(o.getGeneral().getTitles(), hasItem("Bla"));                 
    }
    
    @Test
    public void lifeCycleContribue() {
        OBAA o = buildObaa().lifeCycle()
                .contribute()
                    .role("author")
                    .entity("Paulo Schreiner")
                    .date("2012")
                .contribute()
                    .entity("Zeca Baleiro")
                .build();
        
        assertThat(o.getLifeCycle().getContribute().get(0).getFirstEntity(), equalTo("Paulo Schreiner"));
        assertThat(o.getLifeCycle().getContribute().get(1).getFirstEntity(), equalTo("Zeca Baleiro"));
        
        assertThat(o.getLifeCycle().getContribute().get(0).getRole().getText(), equalTo("author"));


    }

}
