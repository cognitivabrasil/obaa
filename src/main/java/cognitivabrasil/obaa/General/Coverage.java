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
/**
 * <div class="en">
 * The time, culture, geography or region to which this learning object applies.
 * The extent or scope of the content of the learning object. Coverage will typically
 * include spatial location (a place name or geographic coordinates), temporal period (a
 * period label, date, or date range) or jurisdiction (such as a named administrative
 * entity). Recommended best practice is to select a value from a controlled vocabulary
 * (for example, the Thesaurus of Geographic Names [TGN]) and that, where appropriate,
 * named places or time periods be used in preference to numeric identifiers such as sets
 * of coordinates or date ranges.
 * NOTE 1:--This is the definition from the Dublin Core Metadata Element Set, version 1.1
 *
 * Example:
 * ("16th century France")
 * NOTE 2:--A learning object could be about farming
 * in 16th century France: in that case, its subject can be described with
 * 1.5:General.Keyword=("farming") and its
 * 1.6:General.Coverage can be ("16th century France").
 *
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */

@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
public class Coverage extends TextElement {
	public Coverage() {}
	public Coverage(String t) {super(t);}
	
}
