/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Accessibility.Accessibility;
import cognitivabrasil.obaa.Annotation.Annotation;
import cognitivabrasil.obaa.Classification.Classification;
import cognitivabrasil.obaa.Educational.Educational;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.LifeCycle.Contribute;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;
import cognitivabrasil.obaa.Metametadata.Metametadata;
import cognitivabrasil.obaa.Relation.Relation;
import cognitivabrasil.obaa.Rights.Rights;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class CreateTest {

    @Test
    public void toXmlAccessibility() throws Exception {
        Accessibility t = new Accessibility();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);

    }

    @Test
    public void toXmlGeneral() throws Exception {
        General t = new General();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void toXmlAnnotation() throws Exception {
        Annotation t = new Annotation();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void toXmlClassification() throws Exception {
        Classification t = new Classification();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void toXmlEducational() throws Exception {
        Educational t = new Educational();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void toXmlMetametadata() throws Exception {
        Metametadata t = new Metametadata();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void toXmlRelation() throws Exception {
        Relation t = new Relation();
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        serializer.write(t, o);
    }

    @Test
    public void contribute() {
        OBAA o = new OBAA();

        o.setGeneral(new General());
        o.getGeneral().addTitle("Teste");

        Contribute c = new Contribute();
        c.setRole("author");
        c.setDate("17/10/1984");
        c.addEntity("Paulo");

        o.setLifeCycle(new LifeCycle());
        o.getLifeCycle().addContribute(c);

        String xml = o.toXml();
        assertThat(xml, containsString("<obaa:role>author</obaa:role>"));
        assertThat(xml, containsString("entity>Paulo</"));
        assertThat(xml, containsString("date>17/10/1984</"));

    }

    @Test
    public void translation() {
        Rights r = new Rights();
        r.setCopyright(true);
        r.setCost(false);

        assertEquals(true, r.getCopyright().getBoolean());
        assertEquals(false, r.getCost().getBoolean());
    }
}
