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
package cognitivabrasil.obaa.Educational;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.ObaaRecursibleElement;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

/**
 * <div class="en"> Specify the educational interaction proposed by this
 * learning object
 *
 * Adapted from http://www.portalobaa.org </div>
 *
 * <div class="br"> Especifica a interação educacional proposta por este objeto
 * de aprendizagem e seu(s) usuários.
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Interaction {

    @Element(required = false)
    private InteractionType interactionType;
    @Element(required = false)
    private Perception perception;
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private BooleanElement synchronism;
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private BooleanElement coPresence;
    @Element(required = false)
    private Reciprocity reciprocity;

    public Interaction() {
    }

    public BooleanElement getCoPresence() {
        return coPresence;
    }

    public void setCoPresence(boolean coPresence) {
        if (this.coPresence == null) {
            this.coPresence = new BooleanElement();
        }
        this.coPresence.setBoolean(coPresence);
    }

    public BooleanElement getSynchronism() {
        return synchronism;
    }

    public void setSynchronism(boolean synchronism) {
        if (this.synchronism == null) {
            this.synchronism = new BooleanElement();
        }
        this.synchronism.setBoolean(synchronism);
    }

    public Perception getPerception() {
        return perception;
    }

    public void setPerception(String perception) {
        Perception p = new Perception();
        p.setText(perception);
        this.perception = p;
    }
    
    public void setPerception(Perception perception) {        
        this.perception = perception;
    }

    public Reciprocity getReciprocity() {
        return reciprocity;
    }

    public void setReciprocity(String reciprocity) {
        Reciprocity r = new Reciprocity();
        r.setText(reciprocity);
        this.reciprocity = r;
    }
    
    public void setReciprocity(Reciprocity reciprocity) {        
        this.reciprocity = reciprocity;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(String interactionType) {
        InteractionType i = new InteractionType(interactionType);
        this.interactionType = i;
    }
}
