/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/* Copyright Cognitiva Brasil Tecnologias Educacionais, para
mais informaões, entrar em contato em <contato@cognitivabrasil.com.br> */

/**
 * 
 */
package cognitivabrasil.obaa;
import java.lang.annotation.*; 


/**
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 *
 * This annotation serves as a marker for classes that correspond to intermiediate OBAA
 * nodes, i.e., non-value nodes.
 * 
 * For exemple, class obaa.General should be marked, class obaa.General.Coverage should not.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface ObaaRecursibleElement {

}
