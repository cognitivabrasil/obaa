package cognitivabrasil.obaa.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Title;

public class GeneralBuilder {
    OBAA obaa;
    
    public GeneralBuilder(OBAA obaa) {
        this.obaa = obaa;
        this.obaa.setGeneral(new General());
    }

    public GeneralBuilder title(String title) {
        List<Title> t = new ArrayList<Title>();
        Title tit = new Title(title);
        t.add(tit);
        obaa.getGeneral().setTitle(t);
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
