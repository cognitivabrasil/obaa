/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
package cognitivabrasil.obaa.SegmentInformationTable;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class SegmentMediaType extends TextElement {

    public static final String DOCUMENT = "document";
    public static final String HYPERDOCUMENT = "hyperdocument";
    public static final String AUDIO = "audio";
    public static final String VIDEO = "video";
    public static final String OTHER = "other";

    public SegmentMediaType() {
        super(new ArrayList<>(Arrays.asList(DOCUMENT, HYPERDOCUMENT, AUDIO, VIDEO, OTHER)));
    }

    @JsonCreator
    public static SegmentMediaType fromText(String text) {
        SegmentMediaType obj = new SegmentMediaType();
        obj.setText(text);
        return obj;
    }
}
