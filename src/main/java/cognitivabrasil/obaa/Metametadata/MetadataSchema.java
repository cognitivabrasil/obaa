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
package cognitivabrasil.obaa.Metametadata;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;

/**
 *
 * <div class="en">
 * The name and version of the authoritative specification used to create this 
 * metadata instance.
 * 
 * NOTE:--This data element may be user selectable or system generated.
 * If multiple values are provided, then the metadata instance shall conform to 
 * multiple metadata schemas.
 * 
 * 
 * Example "OBAAv1.0"
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 * <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class MetadataSchema extends TextElement {    
    
    public MetadataSchema() {
        super();
        this.setText("OBAAv1.0");
        
    }
}
