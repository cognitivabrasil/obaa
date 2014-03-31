/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class BooleanElement extends TextElement {
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public BooleanElement(String text) {
        super(text);
        this.addTerms(TRUE);
        this.addTerms(FALSE);
    }

    public BooleanElement() {
        super();
        this.addTerms(TRUE);
        this.addTerms(FALSE);
    }

    public void setBoolean(boolean b) {
        setText(String.valueOf(b));
    }

    public boolean getBoolean() {
        validate(getText());
        return Boolean.parseBoolean(getText());
    }
    
    public void validate(String trueorfalse) {
        if(trueorfalse == null){
            throw new IllegalArgumentException("A String é um null, provavemente a classe não foi inicializada");
        }
        if (!(trueorfalse.equals(TRUE) || trueorfalse.equals(FALSE))) {
            throw new IllegalArgumentException(
                    "booleanElement must be \"true\" or \"false\".");
        }
    }

}
