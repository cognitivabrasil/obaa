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

package cognitivabrasil.obaa.Metametadata;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.obaa.General.Identifier;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
     
/**
 *
 * <div class="en">
 * This category describes this metadata record itself (rather than the learning 
 * object that this record describes). 
 * 
 * This category describes how the metadata instance can be identified, 
 * who created this metadata instance, how, when, and with what references.
 * 
 * NOTE:--This is not the information that describes the learning object itself.
 * 
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
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Metametadata {
    
    @ElementList(inline = true, required = false)
    private List <Identifier> identifier;
    @ElementList(required = false, inline = true)
    private List <Contribute> contribute;
    @ElementList(required = false, inline = true)
    private List <MetadataSchema> metadataSchema;
    @Element (required = false)
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    private Language language;
    
    public Metametadata() {
        
        this.identifier = new ArrayList<Identifier>();
        this.contribute = new ArrayList<Contribute>();
        this.metadataSchema = new ArrayList<MetadataSchema>();        
    }

    
    public void addIdentifier (Identifier identifier) {
        this.identifier.add(identifier);
    }

    public void addContribute(Contribute contribute) {
        this.contribute.add(contribute);
    }

    public void addSchema(MetadataSchema schema) {
        this.metadataSchema.add(schema);
    }

    public void setLanguage(Language l) {
        this.language = l;
    }

    public List<Contribute> getContribute() {
        return contribute;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }
    public void setMetadataSchema(List<MetadataSchema> schema) {
        this.metadataSchema = schema;
    }
    public List<MetadataSchema> getSchema() {
        return metadataSchema;
    }
    public void addMetadataSchema (MetadataSchema newMetadataSchema){        
        this.metadataSchema.add(newMetadataSchema);
    }
          
    public Language getLanguage() {
        return language;
    }
}
