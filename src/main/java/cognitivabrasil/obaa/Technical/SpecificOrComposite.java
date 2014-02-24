/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package cognitivabrasil.obaa.Technical;

import org.simpleframework.xml.Element;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class SpecificOrComposite {

    private static final String LOM_NAMESPACE = "http://ltsc.ieee.org/xsd/LOM";

    @Namespace(reference = LOM_NAMESPACE)
    @Element(required = false, name = "specificType")
    private Type specificType;

    @Namespace(reference = LOM_NAMESPACE)
    @Element(required = false, name = "specificName")
    private Name specificName;

    @Namespace(reference = LOM_NAMESPACE)
    @Element(required = false, name = "specificMinimumVersion")
    private String specificMinimumVersion;

    @Namespace(reference = LOM_NAMESPACE)
    @Element(required = false, name = "specificMaximumVersion")
    private String specificMaximumVersion;

    public SpecificOrComposite() {
    }

    public String getSpecificMaximumVersion() {
        return specificMaximumVersion;
    }

    public void setSpecificMaximumVersion(String specificMaximumVersion) {
        this.specificMaximumVersion = specificMaximumVersion;
    }

    public String getSpecificMinimumVersion() {
        return specificMinimumVersion;
    }

    public void setSpecificMinimumVersion(String specificMinimumVersion) {
        this.specificMinimumVersion = specificMinimumVersion;
    }

    public String getSpecificName() {
        if (specificName == null) {
            return null;
        }
        return specificName.getTranslated();
    }

    public void setSpecificName(String specificName) {
        this.specificName = new Name();
        this.specificName.setText(specificName);
    }

    public String getSpecificType() {
        if (specificType == null) {
            return null;
        }
        return specificType.getTranslated();
    }

    public void setSpecificType(String specificType) {
        this.specificType = new Type();
        this.specificType.setText(specificType);
    }

    public void validate() {

        if (this.specificType.getTranslated().equals("operatingSystem")) {
            // pcDos, msWindows, macOS, unix, multiOs, none
            if (!specificType.getTranslated().equals("pcDos")
                    || specificType.getTranslated().equals("msWindows")
                    || specificType.getTranslated().equals("macOS")
                    || specificType.getTranslated().equals("unix")
                    || specificType.getTranslated().equals("multiOs")
                    || specificType.getTranslated().equals("none")) {

                throw new IllegalArgumentException(
                        "The Name "
                        + specificType.getTranslated()
                        + "is not valid, if the type is "
                        + this.specificType.getTranslated()
                        + " the Name must be one of: pcDos, msWindows, macos, unix, multiOs or none");
            }
        } else if (this.specificType.getTranslated().equals("browser")) {
            // any, netscapeComunicator, msInternetExplorer, opera, amaya,
            // mozillaFirefox, appleSafari or googleChrome
            if (!(specificName.getTranslated().equals("any")
                    || specificName.getTranslated().equals("netscapeComunicator")
                    || specificName.getTranslated().equals("msInternetExplorer")
                    || specificName.getTranslated().equals("opera")
                    || specificName.getTranslated().equals("amaya")
                    || specificName.getTranslated().equals("mozillaFirefox")
                    || specificName.getTranslated().equals("appleSafari") || specificName.getTranslated().equals("googleChrome"))) {
                {
                    throw new IllegalArgumentException(
                            "The Name "
                            + specificName.getTranslated()
                            + "is not valid, if the type is "
                            + this.specificType.getTranslated()
                            + " the Name must be one of: pcDos, msWindows, macos, unix, multiOs or none");
                }
            }
        } else if (!this.specificType.getTranslated().equals("middleware")) {
            throw new IllegalArgumentException("Type " + this.specificType.getTranslated() + " is not valid "
                    + " must be one of middleware, operatingSystem or browser");
        }

    }

    @Override
    public String toString() {
        return ("Type: " + this.getSpecificType() + "; Name: "
                + this.getSpecificName() + " Minimum Version: "
                + this.specificMinimumVersion + " Maximum Version: " + this.specificMaximumVersion);
    }
}
