/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

/**
 *
 * <div class="en">
 *
 * The technical capabilities necessary for using this learning object. The
 * composite requirement is satisfied when one of the component requirements is
 * satisfied, i.e., the logical connector is AND.
 *
 *
 * adapted from IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 *
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Requirement {

    @ElementList(required = false, inline = true)
    private List<OrComposite> orComposite;

    public Requirement() {
        orComposite = new ArrayList<OrComposite>();
    
    }

    public List<OrComposite> getOrComposite() {
        return orComposite;
    }

    public void setOrComposite(List<OrComposite> orComposite) {
        this.orComposite = orComposite;
    }
    
    public void addOrComposite (OrComposite newOrComposite){
        this.orComposite.add(newOrComposite);
    }
}
