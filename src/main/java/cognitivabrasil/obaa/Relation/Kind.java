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
package cognitivabrasil.obaa.Relation;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * Nature of the relationship between this learning object and the target
 * learning object, identified by 7.2:Relation.Resource.
 *
 * Based on Dublin Core: ispartof: is part of haspart: has part isversionof: is
 * version of hasversion: has version isformatof: is format of hasformat: has
 * format references: references isreferencedby: is referenced by isbasedon: is
 * based on isbasisfor: is basis for requires: requires isrequiredby: is
 * required by
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Kind extends TextElement {
    public static final String IS_PART_OF = "ispartof";
    public static final String HAS_PART = "haspart";
    public static final String IS_VERSION_OF = "isversionof";
    public static final String HAS_VERSION = "hasversion";
    public static final String IS_FORMAT_OF = "isformatOf";
    public static final String HAS_FORMAT = "hasformat";
    public static final String REFERENCES = "references";
    public static final String IS_REFERENCED_BY = "isreferencedby";
    public static final String IS_BASED_ON = "isbasedon";
    public static final String IS_BASIS_FOR = "isbasisfor";
    public static final String REQUIRES = "requires";
    public static final String IS_REQUIRED_BY = "isrequiredby";

    public Kind(){
        super();
        this.addTerms(IS_PART_OF);
        this.addTerms(HAS_PART);
        this.addTerms(IS_VERSION_OF);
        this.addTerms(HAS_VERSION);
        this.addTerms(IS_FORMAT_OF);
        this.addTerms(HAS_FORMAT);
        this.addTerms(REFERENCES);
        this.addTerms(IS_REFERENCED_BY);
        this.addTerms(IS_BASED_ON);
        this.addTerms(IS_BASIS_FOR);
        this.addTerms(REQUIRES);
        this.addTerms(IS_REQUIRED_BY);        
    }
}
