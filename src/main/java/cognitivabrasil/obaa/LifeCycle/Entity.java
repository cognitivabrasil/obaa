/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
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
package cognitivabrasil.obaa.LifeCycle;

import cognitivabrasil.util.VCarder;
import java.io.IOException;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Entity extends TextElement {

    private VCarder name;
    private final Logger log = LoggerFactory.getLogger(Entity.class);

    public Entity() {
        name = new VCarder();
    }

    public Entity(String t) {
        super(t);
        name = new VCarder();
    }

    /**
     *
     * @param givenName
     * @param familyName
     * @param fullName
     * @deprecated deve ser usado setName (givenName, familyName)
     */
    @Deprecated
    public void setName(String givenName, String familyName, String fullName) {
        name.setName(familyName, givenName);
        this.setText(name.getVCard());
    }

    public void setName(String givenName, String familyName) {
        name.setName(givenName, familyName);
        this.setText(name.getVCard());
    }

    public String getName() {
        return name.getFullName();
    }

    @Override
    public String getTranslated() {

        if (super.getTranslated().startsWith("BEGIN:VCARD")) {
            try {
                this.name.setVcard(this.getText());

                if (this.name != null && !this.name.isEmpty()) {
                    return this.name.getFullName();
                } else {
                    log.error("Uma entidade foi entendida como um VCard por começar com \"BEGIN:VCARD\", mas nao foi possivel fazer o parse.");
                    return super.getTranslated();
                }

            } catch (IOException e) {
                log.error("Uma entidade foi entendida como um VCard por começar com \"BEGIN:VCARD\", mas nao foi possivel fazer o parse.", e);
                return super.getTranslated();
            }

        } else {
            return super.getTranslated();
        }

    }

}
