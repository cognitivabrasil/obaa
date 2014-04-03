/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/*
 * OBAA - Agent Based Leanring Objetcs
 *
 * This file is part of Obaa.
 * Obaa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Obaa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Obaa. If not, see <http://www.gnu.org/licenses/>.
 */

package cognitivabrasil.obaa.Classification;

import org.simpleframework.xml.Element;

import cognitivabrasil.obaa.ObaaRecursibleElement;

/**
 * <div class="en">
 *
 * A particular term within a taxonomy. A taxon is a node that has a defined 
 * label or term. A taxon may also have an alphanumeric designation or 
 * identifier for standardized reference. Either or both the label and the entry 
 * may be used to designate a particular taxon. 
 * An ordered list of taxons creates a taxonomic path, i.e., 
 * "taxonomic stairway": this is a path from a more general to more specific 
 * entry in a classification.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 *</div>
 *
 * <div class="br">
 * 
 *
 * Adaptado de http://www.portalobaa.org
 *</div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class Taxon {
    @Element(required=false)
    private String id;
    @Element(required=false,name="entry")
    private String label;

    public Taxon() {
    }

    public void setEntry(String entry) {
        this.label = entry;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntry() {
        return label;
    }

    public String getId() {
        return id;
    }
}
