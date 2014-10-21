package cognitivabrasil.obaa.builder;

import cognitivabrasil.obaa.OBAA;

public class ObaaBuilder {
    OBAA obaa;
    
    public static ObaaBuilder buildObaa() {
        return new ObaaBuilder();
    }
    
    public ObaaBuilder() {
        obaa = new OBAA();
    }
    
    public GeneralBuilder general() {
        return new GeneralBuilder(obaa);
    }
}
