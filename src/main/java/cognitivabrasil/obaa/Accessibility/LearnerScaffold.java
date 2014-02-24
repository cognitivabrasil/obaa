/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
/*
 * OBAA - Agent Based Leanring Objetcs
 *
 * This file is part of Obaa.
 * Obaa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Obaa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Obaa. If not, see <http://www.gnu.org/licenses/>.
 */
package cognitivabrasil.obaa.Accessibility;

import metadata.TextElement;

/**
 * <div class="en">
 *
 * Indicates that the described resource is or contains one or more of the
 * learnerScaffold tools.
 *
 * Value Space: dictionary, calculator, noteTaking, peerInteraction, abacus
 * thesaurus, spellChecker, homophoneChecker, mindMappingSoftware or outlineTool
 *
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/
 * </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class LearnerScaffold extends TextElement {

    public static final String DICTIONARY = "dictionary";
    public static final String CALCULATOR = "calculator";
    public static final String NOTE_TAKING = "note taking";
    public static final String PEER_INTERACTION = "peer interaction";
    public static final String ABACUS = "abacus";
    public static final String THESAURUS = "thesaurus";
    public static final String SPELL_CHECKER = "spell checker";
    public static final String HOMOPHONE_CHECKER = "homophone checker";
    public static final String MIND_MAPPING_SOFTWARE = "mind mapping software";
    public static final String OUTLINE_TOOL = "outline tool";

    public LearnerScaffold() {
        super();
        this.addTerms(DICTIONARY);
        this.addTerms(CALCULATOR);
        this.addTerms(NOTE_TAKING);
        this.addTerms(PEER_INTERACTION);
        this.addTerms(ABACUS);
        this.addTerms(THESAURUS);
        this.addTerms(SPELL_CHECKER);
        this.addTerms(HOMOPHONE_CHECKER);
        this.addTerms(MIND_MAPPING_SOFTWARE);
        this.addTerms(OUTLINE_TOOL);
    }
}
