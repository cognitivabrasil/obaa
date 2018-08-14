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
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.General.Language;
import cognitivabrasil.obaa.ObaaRecursibleElement;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 *
 * <div class="en">
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 * Container para a especificação de serviços relacionados a este objeto.
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class Service {

    //O nome do serviço. Pode ser um conceito definido pela ontologia associada (metadado número 4.10.6).
    @Element(required = false)
    private Name name;

    //O tipo do serviço. Também pode ser um conceito definido pela ontologia associada (metadado número 4.10.6).
    @Element(required = false)
    private Type type;

    //Define se o objeto fornece ou solicita o serviço. Este metadado define o uso do metadado location (4.10.8.1). True: o serviço é fornecido pelo objeto False: o serviço é solicitado pelo objeto
    @Element(required = false)
    private BooleanElement provides;

    //Define se o serviço é obrigatório (essencial) ou opcional em relação à correta execução do objeto. True: o serviço é obrigatório para que o objeto funcione corretamente False: o serviço é opcional e o objeto funcionará mesmo sem sua disponibilidade
    @Element(required = false)
    private BooleanElement essential;

    //O nome do protocolo utilizado para comunicação com o serviço. É uma informação dependente de cada serviço. O valor também pode ser associado a um conceito ou indivíduo presente na ontologia (4.10.6).
    @ElementList(required = false, inline = true)
    private List<Protocol> protocol;

    //Ontologias associadas a este serviço. Geralmente este tipo de ontologia fornece uma especificação formal do contexto do serviço.
    @ElementList(required = false, inline = true)
    private List<Ontology> ontology;

    //A linguagem utilizada para a comunicação com o serviço.
    @ElementList(required = false, inline = true)
    private List<Language> language;

    @ElementList(required = false, inline = true)
    private List<Details> details;

    public Service() {
        protocol = new ArrayList<>();
        ontology = new ArrayList<>();
        language = new ArrayList<>();
        details = new ArrayList<>();
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

    public void addDetail(Details detail){
        this.details.add(detail);
    }

    public String getEssential() {
        if (essential == null) {
            return null;
        } else {
            return essential.getTranslated();
        }
    }

    /**
     * Define se o serviço é obrigatório (essencial) ou opcional em relação à correta execução do objeto. True: o
     * serviço é obrigatório para que o objeto funcione corretamente False: o serviço é opcional e o objeto funcionará
     * mesmo sem sua disponibilidade
     *
     * @param essential
     */
    public void setEssential(boolean essential) {
        if (this.essential == null) {
            this.essential = new BooleanElement();
        }
        this.essential.setBoolean(essential);
    }

    public List<Language> getLanguage() {
        return language;
    }

    /**
     * A linguagem utilizada para a comunicação com o serviço.
     *
     * @param language
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public void addLanguage(Language language){
        this.language.add(language);
    }

    public String getName() {
        if (name == null) {
            return null;
        } else {
            return name.getTranslated();
        }
    }

    /**
     * O nome do serviço. Pode ser um conceito definido pela ontologia associada (metadado número 4.10.6).
     *
     * @param name
     */
    public void setName(Name name) {
        this.name = name;
    }

    public List<Ontology> getOntology() {
        return ontology;
    }

    /**
     * O nome do protocolo utilizado para comunicação com o serviço. É uma informação dependente de cada serviço. O
     * valor também pode ser associado a um conceito ou indivíduo presente na ontologia (4.10.6).
     *
     * @param ontology
     */
    public void setOntology(List<Ontology> ontology) {
        this.ontology = ontology;
    }

    public void addOntology(Ontology ontology){
        this.ontology.add(ontology);
    }

    public List<Protocol> getProtocol() {
        return protocol;
    }

    /**
     * O nome do protocolo utilizado para comunicação com o serviço. É uma informação dependente de cada serviço. O
     * valor também pode ser associado a um conceito ou indivíduo presente na ontologia (4.10.6).
     *
     * @param protocol
     */
    public void setProtocol(List<Protocol> protocol) {
        this.protocol = protocol;
    }

    public void addProtocol(Protocol protocol){
        this.protocol.add(protocol);
    }

    public String getProvides() {
        if (provides == null) {
            return null;
        } else {
            return provides.getTranslated();
        }
    }

    /**
     * Define se o objeto fornece ou solicita o serviço. Este metadado define o uso do metadado location (4.10.8.1).
     * True: o serviço é fornecido pelo objeto False: o serviço é solicitado pelo objeto
     *
     * @param provides
     */
    public void setProvides(boolean provides) {
        if (this.provides == null) {
            this.provides = new BooleanElement();
        }
        this.provides.setBoolean(provides);
    }

    public String getType() {
        if (type == null) {
            return null;
        } else {
            return type.getTranslated();
        }
    }

    /**
     * O tipo do serviço. Também pode ser um conceito definido pela ontologia associada (metadado número 4.10.6).
     *
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }
}
