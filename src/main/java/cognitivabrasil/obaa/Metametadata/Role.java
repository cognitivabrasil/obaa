/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
package cognitivabrasil.obaa.Metametadata;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * <div class="en">
 *
 * Kind of contribution. NOTE 1:--Minimally, the Author(s) of the learning object should be described.
 *
 * Value Space:
 *
 * unknown, creator, validator
 *
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

    public static final String UNKNOWN = "unknown";
    public static final String CREATOR = "creator";
    public static final String VALIDATOR = "validator";

    public Role() {
        super(new ArrayList<>(Arrays.asList(UNKNOWN, CREATOR, VALIDATOR)));
    }

    @JsonCreator
    public static Role fromText(String text) {
        Role obj = new Role();
        obj.setText(text);
        return obj;
    }

}
