/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package cognitivabrasil.obaa.LifeCycle;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * <div class="en">
 *
 * Kind of contribution. NOTE 1:--Minimally, the Author(s) of the learning
 * object should be described.
 *
 * Value Space:
 *
 * author, publisher, unknown, initiator, terminator, validator, editor,
 * graphical_designer, technical, implementer, content_provider,
 * technical_validator, educational_validator, script_writer,
 * instructional_designer, subject_matter_expert
 *
 * NOTE 2:--"terminator" is the entity that made the learning object
 * unavailable.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Role extends TextElement {

    public static final String UNKNOWN = "unknown";
    public static final String AUTHOR = "author";
    public static final String PUBLISHER = "publisher";
    public static final String INITIATOR = "initiator";
    public static final String TERMINATOR = "terminator";
    public static final String VALIDATOR = "validator";
    public static final String EDITOR = "editor";
    public static final String GRAPHICAL_DESIGNER = "graphical designer";
    public static final String TECHNICAL_IMPLEMENTER = "technical implementer";
    public static final String CONTENT_PROVIDER = "content provider";
    public static final String TECHNICAL_VALIDATOR = "technical validator";
    public static final String EDUCATIONAL_VALIDATOR = "educational validator";
    public static final String SCRIPT_WRITER = "script writer";
    public static final String INSTRUCTIONAL_DESIGNER = "instructional designer";
    public static final String SUBJECT_MATTER_EXPERT = "subject matter expert";

    public Role() {
        super();
        this.addTerms(UNKNOWN);
        this.addTerms(AUTHOR);
        this.addTerms(PUBLISHER);
        this.addTerms(INITIATOR);
        this.addTerms(TERMINATOR);
        this.addTerms(VALIDATOR);
        this.addTerms(EDITOR);
        this.addTerms(GRAPHICAL_DESIGNER);
        this.addTerms(TECHNICAL_IMPLEMENTER);
        this.addTerms(CONTENT_PROVIDER);
        this.addTerms(TECHNICAL_VALIDATOR);
        this.addTerms(EDUCATIONAL_VALIDATOR);
        this.addTerms(SCRIPT_WRITER);
        this.addTerms(INSTRUCTIONAL_DESIGNER);
        this.addTerms(SUBJECT_MATTER_EXPERT);
    }
}
