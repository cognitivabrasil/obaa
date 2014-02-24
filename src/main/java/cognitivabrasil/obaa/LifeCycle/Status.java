/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.LifeCycle;

import metadata.TextElement;


/**
 *
 * <div class="en">
 *
 * The completion status or condition of this learning object.
 *
 * Types: draft final or finalized revised unavailable NOTE:--When the status is
 * "unavailable" it means that the learning object itself is not available.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div> <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class Status extends TextElement {
    public static final String DRAFT = "draft";
    public static final String FINALIZED = "finalized";
    public static final String REVISED = "revised";
    public static final String UNAVAILABLE = "unavailable";

    public Status() {
        super();
        this.addTerms(DRAFT);
        this.addTerms(FINALIZED);
        this.addTerms(REVISED);
        this.addTerms(UNAVAILABLE);
    }
}
