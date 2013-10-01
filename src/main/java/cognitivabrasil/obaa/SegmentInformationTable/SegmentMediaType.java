/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.SegmentInformationTable;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * Underlying organizational structure of this learning object.
 *
 * atomic: an object that is indivisible (in this context). collection: a set of
 * objects with no specified relationship between them. networked: a set of
 * objects with relationships that are unspecified. hierarchical: a set of
 * objects whose relationships can be represented by a tree structure. linear: a
 * set of objects that are fully ordered. Example: A set of objects that are
 * connected by "previous" and "next" relationships
 *
 * NOTE:A learning object with Structure="atomic" will typically have
 * 1.8:General.AggregationLevel=1. A learning object with
 * Structure="collection", "linear", "hierarchical" or "networked" will
 * typically have 1.8:General.AggregationLevel=2, 3 or 4.
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class SegmentMediaType extends TextElement {

    private enum SetOfTerms {

        document, hyperdocument, audio, video, other
    };

    public SegmentMediaType() {
        super();
        this.addTerms("document");
        this.addTerms("hyperdocument");
        this.addTerms("audio");
        this.addTerms("video");
        this.addTerms("other");
    }
}
