/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.General;

import metadata.TextElement;

import org.simpleframework.xml.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
public class Language extends TextElement {
    private static final Logger log = LoggerFactory.getLogger(Language.class);
    
	public Language() {}
	public Language(String t) {super(t);}
	
	/**
	 * Will strip country part, ie, for en-US or en-US this will look up "en".
	 * 
	 * @return stripped language code, or literal text
	 **/
	@Override
    public String getCanonicalTextForTranslation() {
	    if(getText().length() == 5 &&
	            (getText().charAt(2) == '-' ||
	            getText().charAt(2) == '_')
	            ) {
	        return getText().substring(0, 2);
	    }
	    else {
	        return getText();
	    }
    }
}
