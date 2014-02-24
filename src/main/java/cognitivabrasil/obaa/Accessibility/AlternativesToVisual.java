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

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import cognitivabrasil.obaa.ObaaRecursibleElement;

/**
 * <div class="en">
 *
 * Visual content presented in a different modality.
 * 
 * 
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/
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
public class AlternativesToVisual {

    @ElementList (inline=true, required=false)
    private List<AudioDescription> audioDescription;
    @Element (required=false)
    private String altTextLang;
    @Element (required=false)
    private String longDescriptionLang;
    @ElementList (inline=true, required=false)
    private List<ColorAvoidance> colorAvoidance;

    public AlternativesToVisual() {
        this.audioDescription = new ArrayList<AudioDescription>();
        this.colorAvoidance = new ArrayList<ColorAvoidance>();
    }

    public String getAltTextLang() {
        return altTextLang;
    }

    public void setAltTextLang(String altTextLang) {
        this.altTextLang = altTextLang;
    }

    public List<AudioDescription> getAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(List<AudioDescription> audioDescription) {
        this.audioDescription = audioDescription;
    }

    public void addAudioDescription(String audioDescription){
        AudioDescription ad = new AudioDescription();
        ad.setText(audioDescription);
        this.audioDescription.add(ad);
    }

    public List<ColorAvoidance> getColorAvoidance() {
        return colorAvoidance;
    }

    public void setColorAvoidance(List<ColorAvoidance> colorAvoidance) {
        this.colorAvoidance = colorAvoidance;
    }

    public void addColorAvoidance(String colorAvoidance) {
        ColorAvoidance c = new ColorAvoidance();
        c.setText(colorAvoidance);
        this.colorAvoidance.add(c);
    }  

    public String getLongDescriptionLang() {
        return longDescriptionLang;
    }

    public void setLongDescriptionLang(String longDescriptionLang) {
        this.longDescriptionLang = longDescriptionLang;
    }    
}
