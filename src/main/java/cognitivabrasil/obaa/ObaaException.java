/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa;

public class ObaaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1939195409267589523L;
	
	public ObaaException(String s, Exception e) {
		super(s, e);
	}
	
	public ObaaException(String s) {
		super(s);
	}
	
	
}
