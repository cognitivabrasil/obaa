/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/**
 * 
 */
package cognitivabrasil.obaa;

/**
 * This class is the base class for Oai-PMH exceptions.
 * 
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 *
 */
public class OaiException extends RuntimeException {
	private String name;
	private String description;
	private String url;
	
	/**
	 * Instantiates a new oai exception.
	 *
	 * @param name the name of the exception
	 * @param message the message
	 * @param url the url that caused the exception
	 */
	public OaiException(String name, String message, String url) {
		super("OaiException " + name + " while trying to access OAI-PMH url: "
				+ url
				+ ": " + message);
		this.name = name;
		this.description = message;
		this.url = url;
	}
	
	/**
	 * Instantiates a new oai exception.
	 *
	 * @param name the name of the exception
	 * @param message the message
	 * @param url the url that caused the exception
	 * @param cause Cause of the exception
	 */
	public OaiException(String name, String message, String url, Throwable cause) {
		super("OaiException " + name + " while trying to access OAI-PMH url: "
				+ url
				+ ": " + message, cause);
		this.name = name;
		this.description = message;
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
