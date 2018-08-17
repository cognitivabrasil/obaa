/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
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

import cognitivabrasil.obaa.ObaaRecursibleElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.simpleframework.xml.ElementList;

/**
 * <div class="en">
 *
 * Auditory content presented in a different modality.
 *
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/
 * </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class AlternativesToAuditory {

    @ElementList(inline = true, required = false)
    private List<CaptionType> captionType;
    @ElementList(inline = true, required = false)
    private List<SignLanguage> signLanguage;

    public AlternativesToAuditory() {
        this.captionType = new ArrayList<CaptionType>();
        this.signLanguage = new ArrayList<SignLanguage>();
    }

    public List<CaptionType> getCaptionType() {
        return captionType;
    }

    public void setCaptionType(List<CaptionType> captionType) {
        this.captionType = captionType;
    }

    public void addCaptionType(CaptionType captionType) {
        this.captionType.add(captionType);
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.captionType);
        hash = 29 * hash + Objects.hashCode(this.signLanguage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlternativesToAuditory other = (AlternativesToAuditory) obj;
        if (!Objects.equals(this.captionType, other.captionType)) {
            return false;
        }
        return Objects.equals(this.signLanguage, other.signLanguage);
    }

}
