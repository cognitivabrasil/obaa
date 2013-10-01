/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa;

import java.io.FileNotFoundException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

public class OaiOBAATest {
	
        static final String FROAC = "./src/test/metadata/froac2.xml";
        static final String CESTA = "./src/test/metadata/cesta2.xml";
        
        
	@Test 
	public void getSize() throws FileNotFoundException {
		OaiOBAA l = OaiOBAA
				.fromFilename("./src/test/resources/oai_obaa.xml");
		
		assertThat(l.getSize(), is(3));
		l = OaiOBAA
				.fromFilename("./src/test/resources/oai_obaa_no_resumption.xml");
		
		assertThat(l.getSize(), is(3));
	}
        
        @Ignore
        @Test
        public void testObaaFromFile() throws FileNotFoundException {
            OaiOBAA listRecords = OaiOBAA.fromFilename(FROAC);
}
}
