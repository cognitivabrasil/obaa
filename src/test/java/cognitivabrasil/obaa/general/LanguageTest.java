package cognitivabrasil.obaa.general;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import cognitivabrasil.obaa.General.Language;

public class LanguageTest {
    
    @Test 
    public void canonicalizationWorks() {
        Language l = new Language("pt-BR");
        assertThat(l.getCanonicalTextForTranslation(), equalTo("pt"));
        
        Language l2 = new Language("en_DF");
        assertThat(l2.getCanonicalTextForTranslation(), equalTo("en"));
    }
    
    @Test 
    public void canonicalizationReturnsLiteralStringIfNotLangCode() {
        Language l = new Language("se-foi");
        assertThat(l.getCanonicalTextForTranslation(), equalTo("se-foi"));

    }

    @Test
    public void translationWorks() {   
        assertThat(translatedLanguage("pt-BR", "pt-BR"), equalTo("Português"));
        
        assertThat(translatedLanguage("pt-BR", "en-US"), equalTo("Inglês"));
        assertThat(translatedLanguage("pt-BR", "en_US"), equalTo("Inglês"));
        assertThat(translatedLanguage("pt-BR", "en"), equalTo("Inglês"));

    }

    private String translatedLanguage(String translateTo, String locale) {
        Language l = new Language(locale);
        l.setLocale(translateTo);
        
        return l.getTranslated();
    }
}
