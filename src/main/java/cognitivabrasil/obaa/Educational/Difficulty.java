/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package cognitivabrasil.obaa.Educational;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Difficulty extends TextElement {

    public static final String VERY_EASY = "very easy";
    public static final String EASY = "easy";
    public static final String MEDIUM = "medium";
    public static final String DIFFICULT = "difficult";
    public static final String VERY_DIFFICULT = "very difficult";

    public Difficulty() {
        super();
        this.addTerms(VERY_EASY);
        this.addTerms(EASY);
        this.addTerms(MEDIUM);
        this.addTerms(DIFFICULT);
        this.addTerms(VERY_DIFFICULT);
    }
}
