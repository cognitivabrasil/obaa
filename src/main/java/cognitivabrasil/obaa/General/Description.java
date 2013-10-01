/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.General;

import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;


/**
 *
 * <div class="en">
 * A textual description of the content of this learning object.
 *
 * NOTE:--This description need not be in language
 * and terms appropriate for the users of the learning
 * object being described. The description should be
 * in language and terms appropriate for those that
 * decide whether or not the learning object being
 * described is appropriate and relevant for the users.
 *
 * There is no language treatment implemented in this metadata.
 *
 * </div>
 *
 * <div class="br">
 *
 * </div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root
@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
public class Description extends TextElement {
	public Description() {}
	public Description(String t) {super(t);}
	
}


