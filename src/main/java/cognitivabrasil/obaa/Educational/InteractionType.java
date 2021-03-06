/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.Educational;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class InteractionType extends TextElement {

    public static final String OBJECT_INDIVIDUAL = "object-individual";
    public static final String INDIVIDUAL1_INDIVIDUAL2_OBJECT = "individual1-individual2-object";

    public InteractionType() {
        super(new ArrayList<>(Arrays.asList(OBJECT_INDIVIDUAL, INDIVIDUAL1_INDIVIDUAL2_OBJECT)));
    }

    @JsonCreator
    public static InteractionType fromText(String text) {
        InteractionType obj = new InteractionType();
        obj.setText(text);
        return obj;
    }

}
