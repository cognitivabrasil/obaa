/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa;

public class OaiParseErrorException extends OaiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617149715766730997L;

	public OaiParseErrorException(String description, String url) {
		super("parseErrorException", description, url);
	}
	
	public OaiParseErrorException(String description, String url, Throwable cause) {
		super("parseErrorException", description, url, cause);
	}
}
