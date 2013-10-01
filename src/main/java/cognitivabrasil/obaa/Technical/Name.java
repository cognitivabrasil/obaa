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
package cognitivabrasil.obaa.Technical;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;

/**
 *
 * <div class="en">
 *
 * Name of the required technology to use this learning object.
 *
 * NOTE 1:--The value for this data element may be derived from 4.1:Technical.
 * Format automatically, e.g., "video/mpeg" implies "multi-os". NOTE 2:--This
 * vocabulary includes most values in common use at the time that this Standard
 * was approved.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div> <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Name extends TextElement {

    public Name() {
        this.addTerms("pcDos");
        this.addTerms("msWindows");
        this.addTerms("macOS");
        this.addTerms("unix");
        this.addTerms("multiOs");
        this.addTerms("none");
        this.addTerms("any");
        this.addTerms("netscapeComunicator");
        this.addTerms("msInternetExplorer");
        this.addTerms("amaya");
        this.addTerms("mozillaFirefox");
        this.addTerms("appleSafari");
        this.addTerms("googleChrome");
        
    }
}
