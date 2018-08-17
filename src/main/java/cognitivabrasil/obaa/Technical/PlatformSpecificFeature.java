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
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * <div class="en">
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 *
 *
 * <div class="br">
 *
 * Conjunto de características técnicas das mídias específicas desenvolvidas
 * para cada plataforma para a qual o Objeto de Aprendizagem foi previsto.
 * Deverá ser criado um registro deste conjunto de metadados para cada plataforma
 * suportada pelo OA e cujas informações técnicas diferem das informações
 * técnicas já descritas no item (Technical), ou seja, apenas quando mídias
 * diferentes forem disponibilizadas para cada plataforma.
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
public class PlatformSpecificFeature {

    @Element (required=false, name="platformType")
    private SupportedPlatform platformType;
    @ElementList (required=false, inline = true)
    private List<SpecificFormat> specificFormats;
    @Element (required=false)
    private String specificSize;
    @Element (required=false)
    private String specificLocation;
    @ElementList (required=false, inline = true)
    private List<SpecificRequirement> specificRequirements;
    @Element (required=false)
    private String specificInstallationRemarks;
    @Element (required=false)
    private String specificOtherPlatformRequirements;


    public PlatformSpecificFeature() {
        specificFormats = new ArrayList<>();
        specificRequirements = new ArrayList<>();
    }

/**
 *
 * <div class="en">
 *
 * A string that is used to access this learning object. It may be a location
 * (e.g., Universal Resource Locator), or a method that resolves to a location
 * (e.g., Universal Resource Identifier). The first element of this list shall
 * be the preferable location.
 *
 * NOTE:--This is where the learning object described by this metadata instance
 * is physically located.
 *
 * Example: "http://host/id"
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 * <div class="br">
 *
 * Uma sequência de caracteres utilizada para acessar a mídia criada
 * especialmente para utilização na plataforma especificada no item 4.9.1. Segue
 * as mesmas definições e regras do item 4.3, porém aplicadas à mídia específica.
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 */
    public void setSpecificLocation(String specificLocation) {
        this.specificLocation = specificLocation;
    }

    public void setPlatformType(SupportedPlatform platformType) {
        this.platformType = platformType;
    }

    public void setSpecificInstallationRemarks(String specificInstallationRemarks) {
        this.specificInstallationRemarks = specificInstallationRemarks;
    }

    public void setSpecificOtherPlatformRequirements(String specificOtherPlatformRequirements) {
        this.specificOtherPlatformRequirements = specificOtherPlatformRequirements;
    }

    public void setSpecificSize(String specificSize) {
        this.specificSize = specificSize;
    }

    public void addSpecificFormat(SpecificFormat specificFormat) {
        this.specificFormats.add(specificFormat);
    }


    public void addSpecificRequirement(SpecificRequirement newSpecificRequirement) {
        this.specificRequirements.add(newSpecificRequirement);
    }

    public SupportedPlatform getPlatformType() {
        return platformType;
    }

    public List<SpecificFormat> getSpecificFormats() {
        return specificFormats;
    }

    public String getSpecificInstallationRemarks() {
        return specificInstallationRemarks;
    }

    public String getSpecificLocation() {
        return specificLocation;
    }

    public String getSpecificOtherPlatformRequirements() {
        return specificOtherPlatformRequirements;
    }

    public List<SpecificRequirement> getSpecificRequirements() {
        return specificRequirements;
    }

    public String getSpecificSize() {
        return specificSize;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.platformType);
        hash = 37 * hash + Objects.hashCode(this.specificFormats);
        hash = 37 * hash + Objects.hashCode(this.specificSize);
        hash = 37 * hash + Objects.hashCode(this.specificLocation);
        hash = 37 * hash + Objects.hashCode(this.specificRequirements);
        hash = 37 * hash + Objects.hashCode(this.specificInstallationRemarks);
        hash = 37 * hash + Objects.hashCode(this.specificOtherPlatformRequirements);
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
        final PlatformSpecificFeature other = (PlatformSpecificFeature) obj;
        if (!Objects.equals(this.specificSize, other.specificSize)) {
            return false;
        }
        if (!Objects.equals(this.specificLocation, other.specificLocation)) {
            return false;
        }
        if (!Objects.equals(this.specificInstallationRemarks, other.specificInstallationRemarks)) {
            return false;
        }
        if (!Objects.equals(this.specificOtherPlatformRequirements, other.specificOtherPlatformRequirements)) {
            return false;
        }
        if (!Objects.equals(this.platformType, other.platformType)) {
            return false;
        }
        if (!Objects.equals(this.specificFormats, other.specificFormats)) {
            return false;
        }
        return Objects.equals(this.specificRequirements, other.specificRequirements);
    }

}

