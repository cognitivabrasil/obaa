/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Attribute;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(name="request", strict=false)
public class Request {
	
	@Text(required=false)
	private String uri;

	@Attribute(required=false)
	private String metadataPrefix;

	@Attribute(required=false)
	private String verb;

	
	Request() {
		super();
	}

	/**
	 * @return the uri
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * @return the metadataPrefix
	 */
	public String getMetadataPrefix() {
		return metadataPrefix;
	}

	/**
	 * @return the verb
	 */
	public String getVerb() {
		return verb;
	}

}
