/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
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

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * Specific kind of learning object. The most dominant kind shall be first.
 *
 * NOTE:--The vocabulary terms are defined as in the OED:1989 and as used by educational communities of practice.
 *
 * Value Space: exercise, simulation, questionnaire, diagram, figure, graph, index, slide, table, narrative text, exam,
 * experiment, problem statement self assessment, lecture
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 *
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class LearningResourceType extends TextElement {

    public static final String EXERCISE = "exercise";
    public static final String SIMULATION = "simulation";
    public static final String QUESTIONNAIRE = "questionnaire";
    public static final String DIAGRAM = "diagram";
    public static final String FIGURE = "figure";
    public static final String GRAPH = "graph";
    public static final String INDEX = "index";
    public static final String SLIDE = "slide";
    public static final String TABLE = "table";
    public static final String NARRATIVE_TEXT = "narrative text";
    public static final String EXAM = "exam";
    public static final String EXPERIMENT = "experiment";
    public static final String PROBLEM_STATEMENT = "problem statement";
    public static final String SELF_ASSESSMENT = "self assessment";
    public static final String LECTURE = "lecture";

    public LearningResourceType() {
        super(new ArrayList<>(Arrays.asList(EXERCISE,SIMULATION,QUESTIONNAIRE,DIAGRAM,FIGURE,GRAPH,INDEX,SLIDE,TABLE,NARRATIVE_TEXT,EXAM,EXPERIMENT,PROBLEM_STATEMENT,SELF_ASSESSMENT,LECTURE)));
    }

    @JsonCreator
    public static LearningResourceType fromText(String text) {
        LearningResourceType obj = new LearningResourceType();
        obj.setText(text);
        return obj;
    }
}
