/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
package cognitivabrasil.obaa.General;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * Underlying organizational structure of this learning object.
 *
 * atomic: an object that is indivisible (in this context). collection: a set of objects with no specified relationship
 * between them. networked: a set of objects with relationships that are unspecified. hierarchical: a set of objects
 * whose relationships can be represented by a tree structure. linear: a set of objects that are fully ordered. Example:
 * A set of objects that are connected by "previous" and "next" relationships
 *
 * NOTE:A learning object with Structure="atomic" will typically have General.AggregationLevel=1. A learning object with
 * Structure="collection", "linear", "hierarchical" or "networked" will typically have General.AggregationLevel=2, 3 or
 * 4.
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Structure extends TextElement {

    public static final String ATOMIC = "atomic";
    public static final String COLLECTION = "collection";
    public static final String NETWORKED = "networked";
    public static final String HIERARCHICAL = "hierarchical";
    public static final String LINEAR = "linear";

    public Structure() {
        super(new ArrayList<>(Arrays.asList(ATOMIC, COLLECTION, NETWORKED, HIERARCHICAL, LINEAR)));
    }

    @JsonCreator
    public static Structure fromText(String text) {
        Structure obj = new Structure();
        obj.setText(text);
        return obj;
    }
}
