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
package cognitivabrasil.obaa.Accessibility;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.ObaaRecursibleElement;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

/**
 * <div class="en">
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
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Primary {

    @Element(required = false)
    private BooleanElement hasVisual;
    @Element(required = false)
    private BooleanElement hasAuditory;
    @Element(required = false)
    private BooleanElement hasText;
    @Element(required = false)
    private BooleanElement hasTactile;
    @ElementList(inline = true, required = false)
    private List<EarlStatement> earlStatement;
    @ElementList(inline = true, required = false)
    private List<EquivalentResource> equivalentResource;

    public Primary() {
        earlStatement = new ArrayList<EarlStatement>();
        equivalentResource = new ArrayList<EquivalentResource>();
    }

    public void addEarlStatement(EarlStatement earlStatement) {
        this.earlStatement.add(earlStatement);
    }

    public List<EarlStatement> getEarlStatement() {
        return earlStatement;
    }

    public void setEarlStatement(List<EarlStatement> earlStatement) {
        this.earlStatement = earlStatement;
    }

    public List<EquivalentResource> getEquivalentResource() {
        return equivalentResource;
    }

    public void setEquivalentResource(List<EquivalentResource> equivalentResource) {
        this.equivalentResource = equivalentResource;
    }

    public void addEquivalentResource(String equivalentResource) {
        this.equivalentResource.add(new EquivalentResource(equivalentResource));
    }

    public void setAuditory(boolean hasAuditory) {
        if (this.hasAuditory == null) {
            this.hasAuditory = new BooleanElement();
        }
        this.hasAuditory.setBoolean(hasAuditory);
    }

    public void setTactile(boolean hasTacticle) {
        if (this.hasTactile == null) {
            this.hasTactile = new BooleanElement();
        }
        this.hasTactile.setBoolean(hasTacticle);
    }

    public void setText(boolean hasText) {
        if (this.hasText == null) {
            this.hasText = new BooleanElement();
        }
        this.hasText.setBoolean(hasText);
    }

    public void setVisual(boolean hasVisual) {
        if (this.hasVisual == null) {
            this.hasVisual = new BooleanElement();
        }
        this.hasVisual.setBoolean(hasVisual);
    }

    public boolean isAuditory() {
        return hasAuditory.getBoolean();
    }

    public boolean isTactile() {
        return hasTactile.getBoolean();
    }

    public boolean isText() {
        return hasText.getBoolean();
    }

    public boolean isVisual() {
        return hasVisual.getBoolean();
    }

    public String getHasAuditory() {
        if (hasAuditory == null) {
            return null;
        } else {
            return hasAuditory.getTranslated();
        }
    }

    public String getHasTactile() {
        if (hasTactile == null) {
            return null;
        } else {
            return hasTactile.getTranslated();
        }
    }

    public String getHasText() {
        if (hasText == null) {
            return null;
        } else {
            return hasText.getTranslated();
        }
    }

    public String getHasVisual() {
        if (hasVisual == null) {
            return null;
        } else {
            return hasVisual.getTranslated();
        }
    }
}
