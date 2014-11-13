package cognitivabrasil.obaa.builder;


import cognitivabrasil.obaa.OBAA;
import cognitivabrasil.obaa.Educational.Educational;

public class EducationalBuilder extends AbstractObaaBuilder {
  
    public EducationalBuilder(OBAA obaa) {
        super(obaa);
        getObaa().setEducational(new Educational());
    }

    public EducationalBuilder interactivityType(String string) {
        getObaa().getEducational().setInteractivityType(string);
        
        return this;
    }

    public EducationalBuilder learningResourceType(String string) {
        getObaa().getEducational().addLearningResourceType(string);
        
        return this;
    }

    public EducationalBuilder intendedEndUserRole(String string) {
        getObaa().getEducational().addIntendedEndUserRole(string);
        
        return this;        
    }

    public EducationalBuilder context(String string) {
        getObaa().getEducational().addContext(string);
        
        return this;
    }

    public EducationalBuilder difficulty(String string) {
        getObaa().getEducational().setDifficulty(string);        
        return this;
    }


}