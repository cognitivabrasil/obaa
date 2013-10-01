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

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

import cognitivabrasil.obaa.ObaaRecursibleElement;

/**
 *
 * <div class="en">
 *
 * Grouping of multiple requirements. The composite requirement is satisfied
 * when one of the component requirements is satisfied, i.e., the logical
 * connector is OR.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 *
 * <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class OrComposite {

    @Element(required = false)
    private Type type;
    @Element(required = false)
    private Name name;
    @Element(required = false)
    private MinimumVersion minimumVersion;
    @Element(required = false)
    private MaximumVersion maximumVersion;

    public OrComposite() {
        this.type = new Type();
        this.name = new Name();
        this.minimumVersion = new MinimumVersion();
        this.maximumVersion = new MaximumVersion();
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public void setType(String type){
        this.type = new Type();
        this.type.setText(type);
    }
    
    public void setName(String name){
        this.name = new Name();
        this.name.setText(name);
    }

    public void validate() {

        if (!this.type.getTranslated().equals("operatingSystem")) {
            // pcDos, msWindows, macOS, unix, multiOs, none
            if (name.getTranslated().equals("pcDos")
                    || name.getTranslated().equals("msWindows")
                    || name.getTranslated().equals("macOS")
                    || name.getTranslated().equals("unix")
                    || name.getTranslated().equals("multiOs")
                    || name.getTranslated().equals("none")) {
                throw new IllegalArgumentException(
                        "The Name "
                        + name.getTranslated()
                        + "is not valid, if the type is "
                        + this.type.getTranslated()
                        + " the Name must be one of: pcDos, msWindows, macos, unix, multiOs or none");

            }
        } else if (this.type.getTranslated().equals("browser")) {
            // any, netscapeComunicator, msInternetExplorer, opera, amaya,
            // mozillaFirefox, appleSafari or googleChrome
            if (!(name.getTranslated().equals("any")
                    || name.getTranslated().equals("netscapeComunicator")
                    || name.getTranslated().equals("msInternetExplorer")
                    || name.getTranslated().equals("opera")
                    || name.getTranslated().equals("amaya")
                    || name.getTranslated().equals("mozillaFirefox")
                    || name.getTranslated().equals("appleSafari") || name.getTranslated().equals("googleChrome"))) {
                {
                    throw new IllegalArgumentException(
                            "The Name "
                            + name.getTranslated()
                            + "is not valid, if the type is "
                            + this.type.getTranslated()
                            + " the Name must be one of: pcDos, msWindows, macos, unix, multiOs or none");
                }
            }
        } else if (!this.type.getTranslated().equals("middleware")) {
            throw new IllegalArgumentException("Type " + this.type.getTranslated() + " is not valid "
                    + " must be one of middleware, operatingSystem or browser");
        }

    }

    public void setMaximumVersion(String maximumVersion) {
        this.maximumVersion.setText(maximumVersion);
    }

    public void setMinimumVersion(String minimumVersion) {
        this.minimumVersion.setText(minimumVersion);
    }

    public String getMaximumVersion() {
        return maximumVersion.getTranslated();
    }

    public String getMinimumVersion() {
        return minimumVersion.getTranslated();
    }

    public String getName() {
        return name.getTranslated();
    }

    public String getType() {
        return type.getTranslated();
    }

    @Override
    public String toString() {
        return ("Type: " + this.getType() +
                "; Name: " + this.getName() +
                " Minimum Version: " + this.minimumVersion +
                " Maximum Version: " + this.maximumVersion);
    }
}
