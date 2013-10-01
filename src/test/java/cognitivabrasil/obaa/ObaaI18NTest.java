/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/* Copyright Cognitiva Brasil Tecnologias Educacionais, para
mais informaões, entrar em contato em <contato@cognitivabrasil.com.br> */

package cognitivabrasil.obaa;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.*;

import cognitivabrasil.obaa.General.Structure;

public class ObaaI18NTest {
    static final String FULL = "./src/test/metadata/xml_obaa_full.xml";
    
  	@Test
	public void testStandard() throws FileNotFoundException {
    	OBAA full;
        full = OBAA.fromFilename(FULL);
		assertThat(full.getGeneral().getStructure().getTranslated(), equalTo("atomic"));
	}
	
	@Test
	public void testTranslation() throws FileNotFoundException {
    	OBAA full;
        full = OBAA.fromFilename(FULL);
        full.setLocale("pt-BR");
        
        Structure s = full.getGeneral().getStructure();
		assertThat(s.getTranslated(), equalTo("Atômico"));
	}
	
	@Test
	public void testTranslationCollection() throws FileNotFoundException {
    	OBAA full;
        full = OBAA.fromFilename(FULL);
        
        assertThat(full.getEducational().getLearningResourceTypes().get(0).getTranslated(), equalTo("simulation"));
        
        full.setLocale("pt-BR");
        assertThat(full.getEducational().getLearningResourceTypes().get(0).getTranslated(), equalTo("Simulação"));

		
	}

}
