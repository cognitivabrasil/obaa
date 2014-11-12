package cognitivabrasil.obaa.builder;

import cognitivabrasil.obaa.OBAA;

public abstract class AbstractObaaBuilder {
    private OBAA obaa;
    
    public AbstractObaaBuilder() {
        obaa = new OBAA();
    }

    public AbstractObaaBuilder(OBAA obaa) {
        this.obaa = obaa;
    }

    public GeneralBuilder general() {
        return new GeneralBuilder(obaa);
    }

    public LifeCycleBuilder lifeCycle() {
        return new LifeCycleBuilder(obaa);
    }
    
    public ContributeBuilder contribute() {
        return new ContributeBuilder(obaa); 
    }
    
    /**
     * Constrói um objeto OBAA a partir das configurações especificadas no Builder.
     * @return um objeto obaa construído.
     */
    public OBAA build() {
        return getObaa();
    }
    
    protected OBAA getObaa() {
        return obaa;
    }
}
