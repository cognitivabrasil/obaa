/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.Educational;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * Predominant mode of learning supported by this learning object.
 *
 * "Active" learning (e.g., learning by doing) is supported by content that
 * directly induces productive action by the learner. An active learning object
 * prompts the learner for semantically meaningful input or for some other kind
 * of productive action or decision, not necessarily performed within the
 * learning object's framework. Active documents include simulations,
 * questionnaires, and exercises.
 *
 * "Expositive" learning (e.g., passive learning) occurs when the learner's job
 * mainly consists of absorbing the content exposed to him (generally through
 * text, images or sound). An expositive learning object displays information
 * but does not prompt the learner for any semantically meaningful input.
 * Expositive documents include essays, video clips, all kinds of graphical
 * material, and hypertext documents. When a learning object blends the active
 * and expositive interactivity types, then its interactivity type is "mixed".
 *
 * NOTE:--Activating links to navigate in hypertext documents is not considered
 * to be a productive action.
 *
 * Value Space: active, expositive or mixed
 *
 * Example: active documents (with learner's action): - simulation (manipulates,
 * controls or enters data or parameters); - questionnaire (chooses or writes
 * answers); - exercise (finds solution); - problem statement (writes solution).
 *
 * expositive documents (with learner's action): - hypertext document (reads,
 * navigates); - video (views, rewinds, starts, stops); - graphical material
 * (views); - audio material (listens, rewinds, starts, stops).
 *
 * mixed document: - hypermedia document with embedded simulation applet.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 *
 * </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class InteractivityType extends TextElement {

    public InteractivityType() {
        super();
        this.addTerms("active");
        this.addTerms("expositive");
        this.addTerms("mixed");
    }
}
