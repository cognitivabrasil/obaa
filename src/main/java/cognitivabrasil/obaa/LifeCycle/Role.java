/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
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

    public Role() {
        super();
        this.addTerms("unknown");
        this.addTerms("author");
        this.addTerms("publisher");
        this.addTerms("initiator");
        this.addTerms("terminator");
        this.addTerms("validator");
        this.addTerms("editor");
        this.addTerms("graphical_designer");
        this.addTerms("technical");
        this.addTerms("implementer");
        this.addTerms("content_provider");
        this.addTerms("technical_validator");
        this.addTerms("educational_validator");
        this.addTerms("script_writer");
        this.addTerms("instructional_designer");
        this.addTerms("subject_matter_expert");        
    }
}
