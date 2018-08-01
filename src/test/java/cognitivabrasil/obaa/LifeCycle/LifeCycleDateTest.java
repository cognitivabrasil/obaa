package cognitivabrasil.obaa.LifeCycle;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class LifeCycleDateTest {

    @Test
    public void testData() {
        LifeCycleDate d = new LifeCycleDate();

        d.setText("2013-08-02");
        d.setLocale("pt-BR");

        assertThat(d.getTranslated(), equalTo("02/08/2013"));
    }

    @Test
    public void testData2() {
        LifeCycleDate d = new LifeCycleDate();

        d.setText("2011-03-06");
        d.setLocale("pt-BR");

        assertThat(d.getTranslated(), equalTo("06/03/2011"));
    }

    @Test
    public void testData3() {
        LifeCycleDate d = new LifeCycleDate();

        d.setText("2009-12-11T21:41:55");
        d.setLocale("pt-BR");

        assertThat(d.getTranslated(), equalTo("11/12/2009"));

    }
}
