package cognitivabrasil.obaa.Technical;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

public class DurationTest {
    
    @Test
    public void translatesToPortuguese() {
        
        Duration d = new Duration();
        d.set(1,Calendar.HOUR);
        d.setLanguage("pt-BR");
        
        assertThat(d.getTranslated(), equalTo("1 hora"));
    }
    
    @Test
    public void translatesToPortuguesePlural() {
        
        Duration d = new Duration();
        d.set(2 ,Calendar.HOUR);
        d.setLanguage("pt-BR");
        
        assertThat(d.getTranslated(), equalTo("2 horas"));
    }
    
    @Test
    public void translatesToPortugueseMinutes() {
        Duration d = new Duration();
        d.set(30 ,Calendar.MINUTE);
        d.setLanguage("pt-BR");
        
        assertThat(d.getTranslated(), equalTo("30 minutos"));
    }
    
    @Test
    public void translatesHorasComMinutes() {
        Duration d = new Duration();
        d.set(3 ,Calendar.HOUR);
        d.set(15 ,Calendar.MINUTE);
        d.setLanguage("pt-BR");
        
        assertThat(d.getTranslated(), equalTo("3 horas e 15 minutos"));
    }
    
    @Test
    public void funcionaComSetText() {
        Duration d = new Duration();
        d.setText("PT3H15M");
        d.setLanguage("pt-BR");
        
        assertThat(d.getTranslated(), equalTo("3 horas e 15 minutos"));
    }
    
}
