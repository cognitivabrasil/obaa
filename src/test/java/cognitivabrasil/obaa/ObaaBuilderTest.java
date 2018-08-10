package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Educational.Context;
import cognitivabrasil.obaa.Educational.IntendedEndUserRole;
import static cognitivabrasil.obaa.builder.ObaaBuilder.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
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
    
    @Test
    public void educational() {
        OBAA o = buildObaa().educational()
                    .interactivityType("mixed")
                    .learningResourceType("slide")
                    .intendedEndUserRole("learner")
                    .context("other")
                 .build();

        assertThat(o.getEducational().getContexts(), hasItem(Context.fromString("other")));
        assertThat(o.getEducational().getIntendedEndUserRoles(), hasItem(IntendedEndUserRole.fromText("learner")));
        assertThat(o.getEducational().getLearningResourceTypesString(), hasItem("slide"));
        assertThat(o.getEducational().getInteractivityType(), equalTo("mixed"));


    }

}
