/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.Technical;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;

/**
 *
 * <div class="en">
 *
 * Name of the required technology to use this learning object.
 *
 * NOTE 1:--The value for this data element may be derived from 4.1:Technical.
 * Format automatically, e.g., "video/mpeg" implies "multi-os". NOTE 2:--This
 * vocabulary includes most values in common use at the time that this Standard
 * was approved.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div> <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Name extends TextElement {

    public static final String PC_DOS = "pc-dos";
    public static final String MS_WINDOWS = "ms-windows";
    public static final String MACOS = "macos";
    public static final String UNIX = "unix";
    public static final String MULTI_OS = "multi-os";
    public static final String NONE = "none";
    public static final String ANY = "any";
    public static final String NETSCAPE_COMUNICATOR = "netscape comunicator";
    public static final String MS_INTERNET_EXPLORER = "ms-internet explorer";
    public static final String AMAYA = "amaya";
    public static final String MOZILLA_FIREFOX = "mozilla firefox";
    public static final String APPLE_SAFARI = "apple safari";
    public static final String GOOGLE_CHROME = "google chrome";
    public static final String OPERA = "opera";
    public static final String GINGA = "ginga";
    public static final String MHP = "mhp";
    public static final String ARIB = "arib";
    public static final String DAVIC = "savic";
    public static final String DASE = "dase";
    public static final String GEM = "gem";

    public Name() {
        super();
        this.addTerms(PC_DOS);
        this.addTerms(MS_WINDOWS);
        this.addTerms(MACOS);
        this.addTerms(UNIX);
        this.addTerms(MULTI_OS);
        this.addTerms(NONE);
        this.addTerms(ANY);
        this.addTerms(NETSCAPE_COMUNICATOR);
        this.addTerms(MS_INTERNET_EXPLORER);
        this.addTerms(AMAYA);
        this.addTerms(MOZILLA_FIREFOX);
        this.addTerms(APPLE_SAFARI);
        this.addTerms(GOOGLE_CHROME);
        this.addTerms(OPERA);
        this.addTerms(GINGA);
        this.addTerms(MHP);
        this.addTerms(ARIB);
        this.addTerms(DAVIC);
        this.addTerms(DASE);
        this.addTerms(GEM);
    }
}
