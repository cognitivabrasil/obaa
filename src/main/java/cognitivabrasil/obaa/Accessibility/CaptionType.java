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

import org.simpleframework.xml.Element;

/**
 * <div class="en">
 *
 * Indicates that the described resource contains a text caption for the
 * referenced primary resource.
 *
 * Verbatim: Indicates that the caption is a verbatim caption. Mutually
 * exclusive with reducedReadingLevel
 *
 * Enhanced Caption: Indicates that the caption is an enhanced caption.
 *
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/
 *
 * </div>
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
@ObaaRecursibleElement
public class CaptionType {

    @Element(required = false)
    private String language;
    @Element(required = false)
    private BooleanElement verbatim;
    @Element(required = false)
    private BooleanElement reducedReadingLevel;
    @Element(required = false)
    private ReducedSpeed reducedSpeed;
    @Element(required = false)
    private BooleanElement enhancedCaption;

    public CaptionType() {
        this.reducedSpeed = new ReducedSpeed();
    }

    /**
     * If is set verbatim true, the reducedReadingLevel is set false and
     * viceverse, due to the muttualy exclusion of these two params;
     *
     * @param verbatim
     */
    public void setVerbatim(boolean verbatim) {
        if (this.verbatim == null) {
            this.verbatim = new BooleanElement();
            this.reducedReadingLevel = new BooleanElement();
        }
        this.reducedReadingLevel.setBoolean(!verbatim);
        this.verbatim.setBoolean(verbatim);
    }

    /**
     * If is set Reduced Reading Level true, the verbatim is set false and
     * viceverse, due to the muttualy exclusion of these two params;
     *
     * @param reducedReadingLevel
     */
    public void setReducedReadingLevel(boolean reducedReadingLevel) {
        if (this.reducedReadingLevel == null) {
            this.reducedReadingLevel = new BooleanElement();
            this.verbatim = new BooleanElement();
        }
        this.verbatim.setBoolean(!reducedReadingLevel);
        this.reducedReadingLevel.setBoolean(reducedReadingLevel);
    }

    public void setEnhancedCaption(boolean enhancedCaption) {
        if (this.enhancedCaption == null) {
            this.enhancedCaption = new BooleanElement();
        }
        this.enhancedCaption.setBoolean(enhancedCaption);
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setReducedSpeed(ReducedSpeed reducedSpeed) {
        this.reducedSpeed = reducedSpeed;
    }

    public String getLanguage() {
        return language;
    }

    public ReducedSpeed getReducedSpeed() {
        return reducedSpeed;
    }

    public String getVerbatimTxt() {
        if (verbatim == null) {
            return null;
        } else {
            return verbatim.getTranslated();
        }
    }

    public boolean isVerbatim() {
        return this.verbatim.getBoolean();
    }

    public String getReducedReadingLevelTxt() {
        if (reducedReadingLevel == null) {
            return null;
        } else {
            return this.reducedReadingLevel.getTranslated();
        }
    }

    public boolean isReducedReadingLevel() {
        return this.reducedReadingLevel.getBoolean();
    }

    public String getEnhancedCaptionTxt() {
        if (enhancedCaption == null) {
            return null;
        } else {
            return this.enhancedCaption.getTranslated();
        }
    }

    public boolean isEnhancedCaption() {
        return this.enhancedCaption.getBoolean();
    }
}
