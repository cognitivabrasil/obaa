/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.Metametadata;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;



@Root(strict=false)
@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
public class Language extends cognitivabrasil.obaa.General.Language {

    public Language(String language) {
        super(language);
    }
    
    public Language() {
        super();
    }

}