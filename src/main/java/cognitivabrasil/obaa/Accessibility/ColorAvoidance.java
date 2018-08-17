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

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;

/**
 * The use of color in the described resource.
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class ColorAvoidance extends TextElement {

    public static final String AVOID_RED_GREEN = "avoid red green";
    public static final String AVOID_BLUE_YELLOW = "avoid blue yellow";
    public static final String AVOID_ORANGE = "avoid orange";
    public static final String AVOID_RED_BLACK = "avoid red black";
    public static final String AVOID_PURPLE_GRAY = "avoid purple gray";
    public static final String AVOID_RED = "avoid red";
    public static final String USE_MAXIMUM_CONTRAST = "use maximum contrast";
    public static final String MONOCHROME = "monochrome";

    public ColorAvoidance() {
        super(new ArrayList<>(Arrays.asList(AVOID_RED_GREEN, AVOID_BLUE_YELLOW, AVOID_ORANGE, AVOID_RED_BLACK,
                AVOID_PURPLE_GRAY, AVOID_RED, USE_MAXIMUM_CONTRAST, MONOCHROME)));
    }

    @JsonCreator
    public static ColorAvoidance fromText(String text) {
        ColorAvoidance obj = new ColorAvoidance();
        obj.setText(text);
        return obj;
    }
}
