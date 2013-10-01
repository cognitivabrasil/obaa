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

package cognitivabrasil.obaa.SegmentInformationTable;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.obaa.General.Description;
import cognitivabrasil.obaa.General.Keyword;
import cognitivabrasil.obaa.General.Title;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * <div class="en">
 *
 * according to TV Anytime http://www.tv-anytime.org/
 *</div>
 *
 * <div class="br">
 * 
 * Conjunto de informações do grupo de segmentos (SegmentGroupInformationType do TV-Anytime).
 *
 * Adaptado de http://www.portalobaa.org
 *</div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class SegmentGroupInformation {
    
    @Element (required=false)
    private Identifier identifier;
    @Element (required=false)
    private String groupType;
    @Element (required=false)
    private Title title;
    @Element (required=false)
    private Description description;
    @ElementList (required=false, inline = true)
    private List<Keyword> keywords;
    @Element (required=false)
    private Segments segments;

    public SegmentGroupInformation() {       
        segments = new Segments();
        keywords = new ArrayList<Keyword>();
        this.identifier = new Identifier();
        this.title = new Title();
        this.description = new Description();
    }

    public void addKeyword(String newKeyword) {
        Keyword k;
        k = new Keyword();
        k.setText(newKeyword);
        this.keywords.add(k);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public void setIdentifier(String identifier) {
        this.identifier.setText(identifier);
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public void setSegments(Segments segments) {
        this.segments = segments;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getDescription() {
        return description.getTranslated();
    }

    public String getGroupType() {
        return groupType;
    }

    public String getIdentifier() {
        return identifier.getTranslated();
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public Segments getSegments() {
        return segments;
    }

    public String getTitle() {
        return title.getTranslated();
    }
}
