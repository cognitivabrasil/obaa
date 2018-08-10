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
import org.simpleframework.xml.Root;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class SpecificRequirement {

    @ElementList(required = false, inline = true)
    private List<SpecificOrComposite> specificOrComposites;

    public SpecificRequirement() {
        specificOrComposites = new ArrayList<>();

    }

    public List<SpecificOrComposite> getSpecificOrComposites() {
        return specificOrComposites;
    }

    public void setSpecificOrComposite(List<SpecificOrComposite> specificOrComposite) {
        this.specificOrComposites = specificOrComposite;
    }

    public void addOrComposite (SpecificOrComposite newOrComposite){
        this.specificOrComposites.add(newOrComposite);
    }
}
