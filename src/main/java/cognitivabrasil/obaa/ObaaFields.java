package cognitivabrasil.obaa;

/**
 * Este Enum contém constantes com os campos OBAA, para não ser necessário o uso de strings.
 * 
 * @author Paulo Schreiner
 */
public enum ObaaFields {
    GENERAL_DESCRIPTION ("obaa.general.description"), 
    ENTRY ("obaa.general.identifier.entry"), 
    GENERAL_KEYWORD ("obaa.general.keyword"), 
    GENERAL_TITLE ("obaa.general.title"),
    TECHNICAL_LOCATION ("obaa.technical.location"),
    ACCESSIBILITY_HAS_VISUAL ("", "hasVisual"),
    ACCESSIBILITY_HAS_TEXT ("", "hasText"),
    ACCESSIBILITY_HAS_AUDITORY ("", "hasAuditory"),
    ACCESSIBILITY_HAS_TACTILE ("", "hasTactile")

    
    
    ;
    
    private final String fullPath;
    private final String shortName;
     
    
    private ObaaFields(String fullName, String shortName) {
        this.fullPath = fullName;
        this.shortName = shortName;
    }
    
    private ObaaFields(String fullName) {
        this.fullPath = fullName;
        String[] r = fullName.split("\\.");
        this.shortName = r[r.length-1];  
    }


    /**
     * @return the full path of the obaa field
     */
    public String full() {
        return fullPath;
    }


    public static ObaaFields enumFor(String fieldName2) {
        return GENERAL_DESCRIPTION;
    }


    public String getShort() {
        // TODO Auto-generated method stub
        return null;
    }

}
