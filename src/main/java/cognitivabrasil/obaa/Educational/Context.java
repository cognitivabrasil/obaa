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
package cognitivabrasil.obaa.Educational;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en"> The principal environment within which the learning and use
 * of this learning object is intended to take place.
 *
 * NOTE:--Suggested good practice is to use one of the values of the value space
 * and to use an additional instance of this data element for further
 * refinement, as in ("LOMv1.0","higher education") and
 * ("http://www.ond.vlaanderen.be/onderwijsinvlaanderen/Default.htm",
 * "kandidatuursonderwijs")
 *
 * Value Space: school, higher education, training, other
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
public class Context extends TextElement {
        
    public static final String SCHOOL = "school";
    public static final String HIGHER_EDUCATION = "higher education";
    public static final String TRAINING = "training";
    public static final String OTHER = "other";
    
    public Context() {
        super();
        this.addTerms(SCHOOL);
        this.addTerms(HIGHER_EDUCATION);
        this.addTerms(TRAINING);
        this.addTerms(OTHER);
    }
  

    public void setContext(String context) {
        setText(context);
    }
}
