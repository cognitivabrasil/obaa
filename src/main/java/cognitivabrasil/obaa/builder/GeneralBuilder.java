package cognitivabrasil.obaa.builder;

import java.util.Arrays;

import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.General.General;

public class GeneralBuilder {
    OBAA obaa;
    
    public GeneralBuilder(OBAA obaa) {
        this.obaa = obaa;
        this.obaa.setGeneral(new General());
    }

    public GeneralBuilder title(String title) {

        obaa.getGeneral().addTitle(title);
        return this;
    }
    
    public GeneralBuilder language(String lang) {
        
        obaa.getGeneral().setLanguage(Arrays.asList(lang));
        
        return this;
    }
    
    public OBAA build() {
        return obaa;
    }
}
