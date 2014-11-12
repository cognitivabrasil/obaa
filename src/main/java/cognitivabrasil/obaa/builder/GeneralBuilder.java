package cognitivabrasil.obaa.builder;

import java.util.Arrays;

import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.General.General;

public class GeneralBuilder extends AbstractObaaBuilder {
  
    public GeneralBuilder(OBAA obaa) {
        super(obaa);
        getObaa().setGeneral(new General());
    }

    public GeneralBuilder title(String title) {

        getObaa().getGeneral().addTitle(title);
        return this;
    }
    
    public GeneralBuilder language(String lang) {
        
        getObaa().getGeneral().setLanguage(Arrays.asList(lang));
        
        return this;
    }

}
