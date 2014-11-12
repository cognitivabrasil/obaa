package cognitivabrasil.obaa.builder;

import java.util.ArrayList;
import java.util.Date;

import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.LifeCycle.Contribute;
import cognitivabrasil.obaa.LifeCycle.LifeCycleDate;

public class ContributeBuilder extends AbstractContributeBuilder {
    private Contribute contribute;

    public ContributeBuilder(OBAA obaa) {
        super(obaa);
        
        if(getObaa().getLifeCycle().getContribute() == null) {
            getObaa().getLifeCycle().setContribute(new ArrayList<>());
        }
        
        contribute = new Contribute();
        getObaa().getLifeCycle().getContribute().add(contribute);
    }
    
    /**
     * @param role 
     * @return
     */
    public ContributeBuilder role(String role) {
        contribute.setRole(role);
        
        return this;
    }
    
    public ContributeBuilder entity(String entity) {
        contribute.addEntity(entity);
        
        return this;
    }
    
    public ContributeBuilder date(String d) {
                
        contribute.setDate(d);
        
        return this;
    }

    protected Contribute getContribute() {
        return contribute;
    }


}
