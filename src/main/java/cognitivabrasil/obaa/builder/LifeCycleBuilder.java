package cognitivabrasil.obaa.builder;

import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;

public class LifeCycleBuilder extends AbstractObaaBuilder {
    public LifeCycleBuilder(OBAA obaa) {
        super(obaa);
        getObaa().setLifeCycle(new LifeCycle());
    }

    public LifeCycleBuilder status(String string) {
        getObaa().getLifeCycle().setStatus(string);
        
        return this;
    }

}
