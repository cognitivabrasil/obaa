/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
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

package cognitivabrasil.obaa.Classification;

import metadata.TextElement;

/**
 * <div class="en">
 *
 * The purpose of classifying this learning object.
 * 
 * Value Space: discipline, idea, prerequisite, educational objective,
 * accessibility, restrictions, educational level, skill level, security level
 * or competency.
 * 
 * according to IEEE LOM http://ltsc.ieee.org/
 *</div>
 *
 * <div class="br">
 * 
 *
 * Adaptado de http://www.portalobaa.org
 *</div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class Purpose extends TextElement{

    public Purpose() {
        this.addTerms("discipline");
        this.addTerms("idea");
        this.addTerms("prerequisite");
        this.addTerms("educationalObjective");
        this.addTerms("accessibility");
        this.addTerms("restrictions");
        this.addTerms("educationalLevel");
        this.addTerms("skillLevel");
        this.addTerms("securityLevel");
        this.addTerms("competency");        
    }
}
