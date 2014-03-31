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

package cognitivabrasil.obaa.Annotation;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.obaa.General.Description;
import cognitivabrasil.obaa.LifeCycle.Entity;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * This category provides comments on the educational use of this learning 
 * object, and information on when and by whom the comments were created.
 * This category enables educators to share their assessments of learning 
 * objects, suggestions for use, etc.
 * 
 * according to IEEE LOM http://ltsc.ieee.org/
 *</div>
 *
 * <div class="br">
 * Grupo de metadados com comentários sobre o uso educacional do objeto.
 *
 * Adaptado de http://www.portalobaa.org
 *</div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Annotation {
    @Element(required = false)
    private Entity entity;
    @Element(required = false)
    private String date;
    @Element(required = false)
    private Description description;

    public Annotation() {       
       this.entity = new Entity();
       this.description = new Description();
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setEntity(String entity) {
        this.entity.setText(entity);
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description.getTranslated();
    }

    public String getEntity() {
        return entity.getTranslated();
    }
}
