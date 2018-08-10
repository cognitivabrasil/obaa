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

import cognitivabrasil.obaa.Educational.Context;
import cognitivabrasil.obaa.Educational.Difficulty;
import cognitivabrasil.obaa.Educational.Educational;
import cognitivabrasil.obaa.Educational.InteractivityLevel;
import cognitivabrasil.obaa.Educational.InteractivityType;
import cognitivabrasil.obaa.Educational.LearningResourceType;
import cognitivabrasil.obaa.General.Structure;
import java.io.FileNotFoundException;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import static org.junit.Assert.*;

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
        assertThat(full.getEducational().getIntendedEndUserRoles().get(0).toString(), equalTo("Professor"));

	}

        @Test
	public void testDifficult()  {

        OBAA o = new OBAA();

    	Educational educational = new Educational();
        educational.setInteractivityType(InteractivityType.EXPOSITIVE);
        educational.addLearningResourceType(LearningResourceType.NARRATIVE_TEXT);
        educational.setInteractivityLevel(InteractivityLevel.VERY_LOW);
        educational.addLanguage("pt-BR");
        educational.addContext(Context.SCHOOL);
        educational.setDifficulty(Difficulty.VERY_DIFFICULT);

        try {
            educational.getDifficulty().validate("very difficult");
                    }
        catch (IllegalArgumentException e){
            System.out.println("VALOR INVÀLIDO");
            assert(false);
        }

        o.setEducational(educational);
        o.setLocale("pt-BR");

        assertThat(o.getEducational().getDifficulty().toString(), equalTo("Muito Difícil"));
        assertThat(o.getEducational().getDifficulty().getTranslated(), equalTo("Muito Difícil"));
        assertThat(o.getEducational().getDifficulty().getText(), equalTo("very difficult"));

	}

        @Test
        public void testOrderTerms(){

            OBAA o = new OBAA();

            Educational edu = new Educational();
            Difficulty diff = new Difficulty();

            edu.setDifficulty(diff);
            o.setEducational(edu);
            o.setLocale("pt_BR");

            assertThat(diff.getListOfTerms(), equalTo(o.getEducational().getDifficulty().getListOfTerms()));

            System.out.println(diff.getMapOfTerms());
            System.out.println(diff.getMapOfTermsLevelOrdered());

        }
}
