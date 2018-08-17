/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
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

import cognitivabrasil.obaa.General.Description;
import cognitivabrasil.obaa.General.Keyword;
import cognitivabrasil.obaa.General.Title;
import cognitivabrasil.obaa.ObaaRecursibleElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * <div class="en">
 *
 * according to TV Anytime http://www.tv-anytime.org/
 * </div>
 *
 * <div class="br">
 *
 * Conjunto de informações do grupo de segmentos (SegmentGroupInformationType do TV-Anytime).
 *
 * Adaptado de http://www.portalobaa.org
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SegmentGroupInformation {

    @Element(required = false)
    private Identifier identifier;
    @Element(required = false)
    private GroupType groupType;
    @Element(required = false)
    private Title title;
    @Element(required = false)
    private Description description;
    @ElementList(required = false, inline = true)
    private List<Keyword> keywords;
    @Element(required = false)
    private Segments segments;

    public SegmentGroupInformation() {
    }

    public void addKeyword(String newKeyword) {
        if (this.keywords == null) {
            this.keywords = new ArrayList<>();
        }
        this.keywords.add(new Keyword(newKeyword));
    }

    public void setDescription(String description) {
        this.description = new Description();
        this.description.setText(description);
    }

    public void setGroupType(String groupType) {
        this.groupType = new GroupType();
        this.groupType.setText(groupType);
    }

    public void setIdentifier(String identifier) {
        this.identifier = new Identifier();
        this.identifier.setText(identifier);
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public void setSegments(Segments segments) {
        this.segments = segments;
    }

    public void setTitle(String title) {
        this.title = new Title();
        this.title.setText(title);
    }

    public String getDescription() {
        if (description == null) {
            return null;
        }
        return description.getTranslated();
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public String getIdentifier() {
        if (identifier == null) {
            return null;
        }
        return identifier.getTranslated();
    }

    public List<Keyword> getKeywords() {
        return this.keywords;
    }

    public Segments getSegments() {
        return segments;
    }

    public String getTitle() {
        if (title == null) {
            return null;
        }
        return title.getTranslated();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.identifier);
        hash = 89 * hash + Objects.hashCode(this.groupType);
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.keywords);
        hash = 89 * hash + Objects.hashCode(this.segments);
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
        final SegmentGroupInformation other = (SegmentGroupInformation) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (!Objects.equals(this.groupType, other.groupType)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.keywords, other.keywords)) {
            return false;
        }
        return Objects.equals(this.segments, other.segments);
    }

}
