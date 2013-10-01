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

/**
 * <div class="en">
 *
 * Textual content presented in a different modality.
 *
 * Graphic Alernative: Indicates that the described resource contains graphical
 * alternatives for text in the referenced primary resource.
 *
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/ </div>
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
public class AlternativesToText {

    @Element(required = false)
    private BooleanElement graphicAlternative;
    @ElementList(inline = true, required = false)
    private List<SignLanguage> signLanguage;

    public AlternativesToText() {
        this.signLanguage = new ArrayList<SignLanguage>();
        this.graphicAlternative = new BooleanElement("false");
    }

    public BooleanElement getGraphicAlternative() {
            return graphicAlternative;
    }

    public boolean isGraphicAlternative() {
        return graphicAlternative.getBoolean();
    }

    public void setGraphicAlternative(boolean graphicAlternative) {
        this.graphicAlternative.setBoolean(graphicAlternative);
    }

    public List<SignLanguage> getSignLanguage() {
        return signLanguage;
    }

    public void setSignLanguage(List<SignLanguage> signLanguage) {
        this.signLanguage = signLanguage;
    }

    public void addSignLanguage(String signLanguage) {
        SignLanguage s = new SignLanguage();
        s.setText(signLanguage);
        this.signLanguage.add(s);
    }
}
