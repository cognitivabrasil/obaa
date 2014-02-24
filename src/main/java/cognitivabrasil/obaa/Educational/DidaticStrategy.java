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
package cognitivabrasil.obaa.Educational;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;

/**
 * <div class="en">
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br"> Especifica a forma sensorial pela qual o aluno receberá as
 * informações do objeto de aprendizagem.
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class DidaticStrategy extends TextElement {

    public static final String MODEL_CONSTRUCTION = "model construction";
    public static final String CHALLENGE = "challenge";
    public static final String HYPOTHESIS_AND_TEST_DEVELOPMENT = "hypothesis and test development";
    public static final String CASE_STUDY = "case study";
    public static final String QUESTION_AND_ANSWERING = "question and answering";
    public static final String PROBLEM_SOLVING = "problem solving";

    public DidaticStrategy() {
        super();
        this.addTerms(MODEL_CONSTRUCTION);
        this.addTerms(CHALLENGE);
        this.addTerms(HYPOTHESIS_AND_TEST_DEVELOPMENT);
        this.addTerms(CASE_STUDY);
        this.addTerms(QUESTION_AND_ANSWERING);
        this.addTerms(PROBLEM_SOLVING);
    }
}
