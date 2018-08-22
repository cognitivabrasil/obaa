/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Accessibility.Accessibility;
import cognitivabrasil.obaa.Accessibility.AlternativesToAuditory;
import cognitivabrasil.obaa.Accessibility.AudioDescription;
import cognitivabrasil.obaa.Accessibility.CaptionType;
import cognitivabrasil.obaa.Accessibility.Content;
import cognitivabrasil.obaa.Accessibility.EarlStatement;
import cognitivabrasil.obaa.Accessibility.Equivalent;
import cognitivabrasil.obaa.Accessibility.Primary;
import cognitivabrasil.obaa.Accessibility.ResourceDescription;
import cognitivabrasil.obaa.Annotation.Annotation;
import cognitivabrasil.obaa.Classification.Classification;
import cognitivabrasil.obaa.Classification.Taxon;
import cognitivabrasil.obaa.Classification.TaxonPath;
import cognitivabrasil.obaa.Educational.Context;
import cognitivabrasil.obaa.Educational.Description;
import cognitivabrasil.obaa.Educational.Educational;
import cognitivabrasil.obaa.Educational.IntendedEndUserRole;
import cognitivabrasil.obaa.Educational.Interaction;
import cognitivabrasil.obaa.Educational.InteractionType;
import cognitivabrasil.obaa.Educational.Language;
import cognitivabrasil.obaa.Educational.LearningContentType;
import cognitivabrasil.obaa.Educational.LearningResourceType;
import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.General.Structure;
import cognitivabrasil.obaa.LifeCycle.Contribute;
import cognitivabrasil.obaa.LifeCycle.Entity;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;
import cognitivabrasil.obaa.LifeCycle.Role;
import cognitivabrasil.obaa.Metametadata.Metametadata;
import cognitivabrasil.obaa.Relation.Kind;
import cognitivabrasil.obaa.Relation.Relation;
import cognitivabrasil.obaa.Relation.Resource;
import cognitivabrasil.obaa.Rights.Rights;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformation;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformationTable;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentList;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentMediaType;
import cognitivabrasil.obaa.Technical.Duration;
import cognitivabrasil.obaa.Technical.PlatformSpecificFeature;
import cognitivabrasil.obaa.Technical.SpecificOrComposite;
import cognitivabrasil.obaa.Technical.SpecificRequirement;
import cognitivabrasil.obaa.Technical.SupportedPlatform;
import cognitivabrasil.obaa.Technical.Technical;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import metadata.TextElement;
import org.apache.commons.io.FileUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
// Para gerar o arquivo do XML pelo Simple XML
//        File f = new File("TaxonPath.xml");
//
//        try {
//            s.write(tp, f);
//        } catch (Exception e) {
//            System.err.println(e);
//        }
public class OBAATest {

    static final String FILE1 = "./src/test/metadata/obaa1.xml";
    static final String FILE2 = "./src/test/metadata/obaa2.xml";
    static final String FILE3 = "./src/test/metadata/obaa3.xml";
    static final String FILE4 = "./src/test/metadata/obaa4.xml";
    static final String FILE5 = "./src/test/metadata/obaa5.xml";
    static final String FILE6 = "./src/test/metadata/obaa6.xml";
    static final String FROAC = "./src/test/metadata/froac3.xml";
    static final String FILE_EMPTY = "./src/test/metadata/obaa_empty.xml";
    static final String FULL = "./src/test/metadata/xml_obaa_full.xml";
    static final String TAXONERR = "./src/test/metadata/taxonPathError.xml";
    static final String SEGMENT = "./src/test/metadata/taxonPathError.xml";
    OBAA l, full, file2, file3;

    public OBAATest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        l = OBAA.fromFilename(FILE1);
        full = OBAA.fromFilename(FULL);
        file2 = OBAA.fromFilename(FILE2);
        file3 = OBAA.fromFilename(FILE3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTitle() {
        assertThat(l.getGeneral().getTitles(), hasItems("Título 1"));
    }

    /**
     * Test that if we serialize (toXml) and object and then deserialize it we get the same results.
     *
     * @throws Exception
     */
    @Test
    public void testSerializationDeserialization() throws Exception {
        String xml = l.toXml();
        OBAA n = OBAA.fromString(xml);

        assertEquals("Titles should be the same", l.getGeneral().getTitles(), n.getGeneral().getTitles());

    }

    @Test
    public void testTitleFromReader() throws FileNotFoundException {
        // TODO review the generated test code and remove the default call to fail.

        l = OBAA.fromReader(new FileReader(FILE1));
        assertThat(l.getGeneral().getTitles(), hasItems("Título 1"));
    }

    @Test
    public void testTitleFromString() throws IOException {
        // TODO review the generated test code and remove the default call to fail.

        String xml = FileUtils.readFileToString(new File(FILE1));
        l = OBAA.fromString(xml);
        assertThat(l.getGeneral().getTitles(), hasItems("Título 1"));
    }

    @Test
    public void testOBAA_General_AggregationLevel2() throws FileNotFoundException {
        assertThat(full.getGeneral().getAggregationLevel().toString(), equalTo("1"));

    }

    @Test
    public void testOBAA_General_Coverages() throws FileNotFoundException {
        assert (!(l.getGeneral() == null));
        assertThat(l.getGeneral().getCoverages(), hasItems("cov1", "cov2"));
    }

    @Test
    public void testOBAA_General_Descriptions() throws FileNotFoundException {
        assert (!(l.getGeneral() == null));
        assertThat(l.getGeneral().getDescriptions(), hasItems("Desc1", "Desc2"));
    }

    @Test
    public void testOBAA_General_Keywords() throws FileNotFoundException {
        assert (!(l.getGeneral() == null));
        assertThat(l.getGeneral().getKeywords(), hasItems("TCP", "segurança", "ataque Mitnick"));
    }

    @Test
    public void testOBAA_General_Language() throws FileNotFoundException {
        assert (!(l.getGeneral() == null));
        assertThat(l.getGeneral().getLanguages().get(0), equalTo("pt_BR"));
    }

    @Test
    public void testOBAA_General_Structure() throws FileNotFoundException {

        assert (!(l.getGeneral() == null));

        //se não for setado o idioma ele usa o valor canônico
        Structure s = l.getGeneral().getStructure();
        assertThat(s.getTranslated(), equalTo(Structure.ATOMIC));
    }

    @Test
    @Ignore("fazer o sistema de setar o idioma")
    //TODO:
    public void testOaiOBAALifeCycleStatus() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assertThat(l.getLifeCycle().getStatus(), equalTo("final"));
    }

    @Test
    public void testOaiOBAALifeCycleStatusException() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        try {
            l.getLifeCycle().setStatus("bla");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            // thats what we expected
        }
    }

    @Test
    public void testOBAALifeCycleVersion() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assertThat(l.getLifeCycle().getVersion(), equalTo("1"));
    }

    @Test
    public void testOaiOBAALifeCycleContributeEntity() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assert (!(l.getLifeCycle().getContribute() == null));
        assertThat(l.getLifeCycle().getContribute().get(0).getFirstEntity(), equalTo("Tarouco, Liane"));
    }

    @Test
    public void testOBAA_LifeCycle_Contribute_Date() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assert (!(l.getLifeCycle().getContribute() == null));
        assertThat(l.getLifeCycle().getContribute().get(0).getDate().getText(), equalTo("2011-09-09T21:08:38Z"));
    }

    @Test
    public void testOBAA_LifeCycle_Contribute_Role() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assert (!(l.getLifeCycle().getContribute() == null));
        assertThat(l.getLifeCycle().getContribute().get(0).getRole().getTranslated(), equalTo("author"));
    }

    @Test
    public void testOBAA_LifeCycle_Contribute_RoleException() throws FileNotFoundException {
        assert (!(l.getLifeCycle() == null));
        assert (!(l.getLifeCycle().getContribute() == null));
        try {
            l.getLifeCycle().getContribute().get(0).setRole("other");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            // thats what we expected
        }

    }

    @Test
    public void testOBAA_Rights_Cost() throws FileNotFoundException {
        assert (!(l.getRights() == null));
        assertThat(l.getRights().getCost().getBoolean(), equalTo(false));
    }

    @Test
    public void testOBAA_Rights_Copyright() throws FileNotFoundException {
        assert (!(l.getRights() == null));
        assertThat(l.getRights().getCopyright().getBoolean(), equalTo(false));
    }

    @Test
    public void testOBAA_Rights_Description() throws FileNotFoundException {
        assert (!(l.getRights() == null));
        assertThat(l.getRights().getDescription(), equalTo("http://creativecommons.org/licenses/by-sa/3.0/br/"));
    }

    @Test
    public void testOBAA_Educational_InteractivityType() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assertThat(l.getEducational().getInteractivityType(), equalTo("expositive"));

    }

    @Test
    public void testOBAA_Educational_InteractivityLevel() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        OBAA a = l.clone();
        a.setLocale("pt-BR");
        assertThat(a.getEducational().getInteractivityLevel().getTranslated(), equalTo("Muito baixo"));
    }

    @Test
    public void testOBAA_Educational_SemanticDensity() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assertThat(l.getEducational().getSemanticDensity().getText(), equalTo("low"));
    }

    @Test
    public void testOBAA_Educational_Difficulty() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assertThat(l.getEducational().getDifficulty().getText(), equalTo("easy"));
    }

    @Test
    public void testOBAA_Educational_TypicalLearningTime() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        Duration tlm = l.getEducational().getTypicalLearningTime();

        assertThat(tlm.getText(), equalTo("PT15M"));
    }

    @Test
    public void testOBAA_Educational_TypicalAgeRange() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assertThat(l.getEducational().getTypicalAgeRanges().get(0).toString(), equalTo("adult"));
    }

    @Test
    public void testOBAA_Educational_IntendedEndUserRoles_Role() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assert (!(l.getEducational().getIntendedEndUserRoles() == null));
        assertThat(l.getEducational().getIntendedEndUserRoleAsStrings().get(0), equalTo("teacher"));
        assertThat(l.getEducational().getIntendedEndUserRoleAsStrings().get(1), equalTo("manager"));
    }

    @Test
    public void testOBAA_Educational_LearningResourceTypes() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assert (!(l.getEducational().getLearningResourceTypesString() == null));
        assertThat(l.getEducational().getLearningResourceTypesString(), hasItems("simulation", "experiment"));
    }

    @Test
    public void testOBAA_Educational_Descriptions() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assert (!(l.getEducational().getDescriptions() == null));
        assertThat(l.getEducational().getDescriptions(), hasItems(new Description("demonstração"), new Description("bla bla bla")));
    }

    @Test
    public void testOBAA_Educational_Languages() throws FileNotFoundException {
        assert (!(l.getEducational() == null));
        assert (!(l.getEducational().getLanguages() == null));
        assertThat(l.getEducational().getLanguages(), hasItems(new Language("pt_BR"), new Language("en")));
    }

    @Test
    public void testOBAA_Educational_Contexts() throws FileNotFoundException {

        assert (!(l.getEducational() == null));
        assert (!(l.getEducational().getContexts() == null));

        assertThat(l.getEducational().getContexts(), hasItems(Context.fromString("Educacao superior"), Context.fromString("Profissionalizante")));
    }

    /**
     * Test obaa technical location.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test
    public void testOBAATechnicalLocation() throws FileNotFoundException {
        assert (!(l.getTechnical() == null));
        assert (!(l.getTechnical().getLocation() == null));
        assertEquals("http://cesta2.cinted.ufrgs.br/xmlui/handle/123456789/57", l.getTechnical().getFirstHttpLocation());
    }

    @Ignore("ignorar o teste pois ele gera um arquivo")
    @Test
    public void testCreateLocation() {

        try {
            Serializer serializer = new Persister();
            Technical t = new Technical();
            t.addLocation("teste");

            OBAA obaa = new OBAA();
            obaa.setTechnical(t);

            File result = new File("techtest.xml");
            serializer.write(obaa, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRelation() {
        assert (!(l.getRelations() == null));

        Identifier i = new Identifier();
        i.setCatalog("teste");
        i.setEntry("xx1");

        Resource re = new Resource();
        re.addIdentifier(i);

        Relation r = new Relation();
        r.setKind("ispartof");
        r.setResource(re);

        assertEquals(l.getRelations().get(0).getKind(), r.getKind());
        assertEquals(l.getRelations().get(0).getResource().getIdentifier().get(0).getEntry(), r.getResource().getIdentifier().get(0).getEntry());
    }

    @Test
    public void supportedPlatformsTest() throws FileNotFoundException {

        OBAA metadata = full;

        assertEquals("DTV", metadata.getTechnical().getSupportedPlatforms().get(0));

    }

    @Test
    @Ignore("Tem que fazer o esquema para setar o idioma no OBAA todo")
    public void booleanElementTest() throws FileNotFoundException {

        //TODO:
        OBAA metadata = full;

        String sim = "Sim";

        assertEquals(sim, metadata.getTechnical().getService().get(0).getProvides());

    }

    @Test
    @Ignore("Tem que fazer o esquema para setar o idioma no OBAA todo")
    public void booleanElementTranslationTest() throws FileNotFoundException {

        OBAA metadata = l;

        String sim = "Sim";
        String nao = "Não";

        assertEquals(sim, metadata.getAccessibility().getResourceDescription().getPrimary().getHasVisual());
        assertEquals(sim, metadata.getAccessibility().getResourceDescription().getPrimary().getHasAuditory());
        assertEquals(nao, metadata.getAccessibility().getResourceDescription().getPrimary().getHasText());
        assertEquals(nao, metadata.getAccessibility().getResourceDescription().getPrimary().getHasTactile());

    }

    @Test
    public void platformSpecificFeatureTest() throws FileNotFoundException {
        OBAA metadata = full;

        PlatformSpecificFeature platSF = new PlatformSpecificFeature();

        platSF.setSpecificInstallationRemarks("Executar o index2.html");

        platSF.setSpecificLocation("http://www.cognitivabrasil.com.br");

        SpecificRequirement req = new SpecificRequirement();

        SpecificOrComposite or = new SpecificOrComposite();
        or.setSpecificType("browser");
        or.setSpecificName("mozillaFirefox");
        or.setSpecificMinimumVersion("1.0");
        or.setSpecificMaximumVersion("3.0");

        req.addOrComposite(or);

        platSF.addSpecificRequirement(req);

        platSF.setSpecificOtherPlatformRequirements("requirement");
        platSF.setSpecificSize("grande, muito grande!");

        Serializer s = new Persister();

        File f = new File("PlatformSpecificFeature.xml");

        try {
            s.write(platSF, f);
        } catch (Exception e) {
            System.err.println(e);
        }

        metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().get(0);

        assertEquals(platSF.getSpecificInstallationRemarks(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificInstallationRemarks());
        assertEquals(platSF.getSpecificLocation(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificLocation());
        assertEquals(platSF.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificName(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificName());
        assertEquals(platSF.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificType(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificType());
        assertEquals(platSF.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMinimumVersion(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMinimumVersion());
        assertEquals(platSF.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMaximumVersion(), metadata.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMaximumVersion());
    }

    @Test
    public void taxonPathTest() {

        Classification cft = new Classification();
        TaxonPath tp = new TaxonPath();

        tp.setSource("source");

        Taxon t = new Taxon();
        t.setId("id");
        t.setEntry("entry");

        tp.addTaxons(t);

        Taxon t2 = new Taxon();
        t2.setId("id");
        t2.setEntry("entry");

        tp.addTaxons(t2);

        cft.addTaxonPath(tp);

        Serializer s = new Persister();

        File f = new File("TaxonPath.xml");

        try {
            s.write(cft, f);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Test
    public void accessibilityTest() {

        Accessibility a = new Accessibility();

        ResourceDescription rd = new ResourceDescription();
        Primary p = new Primary();
        p.setAuditory(true);

        EarlStatement es = new EarlStatement();
        es.setControlFlexibility("flexibility");
        es.setDisplayTransformability("tranformability");
        p.addEarlStatement(es);

        p.addEquivalentResource("equivalent");

        p.setTactile(true);
        p.setText(true);
        p.setVisual(true);

        Equivalent e = new Equivalent();

        a.setResourceDescription(null);
    }

    @Test
    public void simpleTest() {

        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"catalog1"};
        myMap.put("obaa.general.identifiers[0].catalog", a);

        String[] b = {"entry1"};
        myMap.put("obaa.general.identifiers[0].entry", b);

        OBAA obaa = OBAA.fromHashMap(myMap);

        assertEquals("catalog1", obaa.getGeneral().getIdentifiers().get(0).getCatalog());
        assertEquals("entry1", obaa.getGeneral().getIdentifiers().get(0).getEntry());

    }

    @Test
    public void testPlataformSpecificFeatures() {

        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"specificInstallationRemarks"};
        myMap.put("obaa.technical.platformSpecificFeatures[0].specificInstallationRemarks", a);

        String[] b = {"specificOtherPlatformRequirement"};
        myMap.put("obaa.technical.platformSpecificFeatures[0].specificOtherPlatformRequirements", b);

        OBAA obaa = OBAA.fromHashMap(myMap);

        assertEquals("specificInstallationRemarks", obaa.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificInstallationRemarks());
        assertEquals("specificOtherPlatformRequirement", obaa.getTechnical().getPlatformSpecificFeatures().get(0).getSpecificOtherPlatformRequirements());

    }

    @Test
    public void testTwoIdentifiers() {

        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"catalog1"};
        myMap.put("obaa.general.identifiers[0].catalog", a);

        String[] b = {"entry1"};
        myMap.put("obaa.general.identifiers[0].entry", b);
        String[] c = {"catalog2"};
        myMap.put("obaa.general.identifiers[1].catalog", c);

        String[] d = {"entry2"};
        myMap.put("obaa.general.identifiers[1].entry", d);

        OBAA obaa = OBAA.fromHashMap(myMap);

        assertEquals("catalog2", obaa.getGeneral().getIdentifiers().get(1).getCatalog());
        assertEquals("entry2", obaa.getGeneral().getIdentifiers().get(1).getEntry());

    }

    @Test
    @Ignore
    public void testSpaceBetween() {

        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"catalog1"};
        myMap.put("obaa.general.identifiers[1].catalog", a);

        String[] b = {"entry1"};
        myMap.put("obaa.general.identifiers[1].entry", b);
        String[] c = {"catalog2"};
        myMap.put("obaa.general.identifiers[3].catalog", c);

        String[] d = {"entry2"};
        myMap.put("obaa.general.identifiers[3].entry", d);

        OBAA obaa = OBAA.fromHashMap(myMap);
        assertEquals("catalog1", obaa.getGeneral().getIdentifiers().get(0).getCatalog());
        assertEquals("entry1", obaa.getGeneral().getIdentifiers().get(0).getEntry());
        assertEquals("catalog2", obaa.getGeneral().getIdentifiers().get(1).getCatalog());
        assertEquals("entry2", obaa.getGeneral().getIdentifiers().get(1).getEntry());

    }

    @Test
    public void testTitles() {

        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"catalog1"};
        myMap.put("obaa.general.titles[0]", a);
        String[] b = {"entry1"};
        myMap.put("obaa.general.titles[1]", b);
        String[] c = {"catalog2"};
        myMap.put("obaa.general.titles[2]", c);

        OBAA obaa = OBAA.fromHashMap(myMap);

        assertEquals("catalog1", obaa.getGeneral().getTitles().get(0));
        assertEquals("entry1", obaa.getGeneral().getTitles().get(1));
        assertEquals("catalog2", obaa.getGeneral().getTitles().get(2));

    }

    @Test
    public void testGeneral() {
        HashMap<String, String[]> myMap = new HashMap<String, String[]>();

        String[] a = {"title1"};
        myMap.put("obaa.general.titles[0]", a);
        String[] b = {"title2"};
        myMap.put("obaa.general.titles[1]", b);
        String[] c = {"catalog1"};
        myMap.put("obaa.general.identifiers[0].catalog", c);
        String[] d = {"entry1"};
        myMap.put("obaa.general.identifiers[0].entry", d);
        String[] e = {"pt_BR"};
        myMap.put("obaa.general.languages[0]", e);
        String[] f = {"description1"};
        myMap.put("obaa.general.descriptions[0]", f);
        String[] g = {"description2"};
        myMap.put("obaa.general.descriptions[1]", g);

        OBAA obaa = OBAA.fromHashMap(myMap);

        assertEquals("title2", obaa.getGeneral().getTitles().get(1));
        assertEquals("pt_BR", obaa.getGeneral().getLanguages().get(0));
        assertEquals("description1", obaa.getGeneral().getDescriptions().get(0));

    }

    @Test
    public void testInteractivityLevel() throws FileNotFoundException {
        OBAA obaa = file2;
        assertEquals("low", obaa.getEducational().getInteractivityLevel().getText());
    }

    @Test
    public void testTypicalAgeRange() throws FileNotFoundException {
        OBAA obaa = file2;
        assertThat(obaa.getEducational().getTypicalAgeRanges().get(0).toString(), equalTo("100"));
    }

    @Test
    public void testStatus() throws FileNotFoundException {
        OBAA obaa = file2;
        assertThat(obaa.getLifeCycle().getStatus(), nullValue());
    }

    @Test
    public void testVersion() throws FileNotFoundException {
        OBAA obaa = file2;
        assertEquals("1", obaa.getLifeCycle().getVersion());
    }

    @Test
    public void testSegmentInformationTable() throws FileNotFoundException {

        OBAA obaa = file3;

        SegmentInformationTable st = obaa.getSegmentInformationTable();
        List<SegmentList> sl = st.getSegmentList();
        SegmentInformation s1 = sl.get(0).getSegmentInformation().get(0);
        SegmentInformation s2 = sl.get(0).getSegmentInformation().get(1);

        assertEquals("Tubarão", s1.getTitle());
        assertEquals("Aparece o tubarão na cena", s1.getDescription());

        assertEquals("Jacaré", s2.getTitle());
        assertEquals("1 min", s2.getStart());

    }

    @Test
    public void testInteraction() throws FileNotFoundException {

        OBAA obaa = file3;
        Interaction i1 = obaa.getEducational().getInteraction();
        assertThat(i1.getInteractionType().getText(), equalTo(InteractionType.OBJECT_INDIVIDUAL));

        i1.getInteractionType().setLocale("en");
        assertThat(i1.getInteractionType().getTranslated(), equalTo("Object - Individual"));

        i1.getInteractionType().setLocale("pt-BR");
        assertThat(i1.getInteractionType().getTranslated(), equalTo("Objeto - Sujeito"));

        OBAA obaa2 = file2;
        InteractionType i2 = obaa2.getEducational().getInteraction().getInteractionType();
        assertThat(i2.getText(), equalTo(InteractionType.INDIVIDUAL1_INDIVIDUAL2_OBJECT));

        i2.setLocale("en");
        assertThat(i2.getTranslated(), equalTo("Individual1 - Individual2 - Object"));

        i2.setLocale("pt-BR");
        assertThat(i2.getTranslated(), equalTo("Sujeito1 - Sujeito2 - Objeto"));

    }

    @Ignore("Ignorar teste pois ele gera um arquivo")
    @Test
    public void generateTest() {
        try {
            Serializer serializer = new Persister();
            General g = new General();
            //g.addIdentifiers("Catalog");
            g.addTitle("Objeto");
            g.addLanguage("pt");
            g.addLanguage("pt-br");
            Structure s = new Structure();
            s.setText(Structure.ATOMIC);
            g.setStructure(s);
            g.setAggregationLevel("1");
            g.addDescription("descri");
            g.addKeyword("chaves");
            g.addCoverage("cover");

            Identifier i = new Identifier();
            i.setCatalog("catalog");
            i.setEntry("entry");

            Identifier id = new Identifier("catalogo", "entry");
            g.addIdentifier(id);

            File result = new File("general.xml");
            serializer.write(g, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        {

            try {
                Serializer serializer = new Persister();
                LifeCycle lc = new LifeCycle();
                lc.setVersion("versão");
                lc.setStatus("draft");

                Contribute c = new Contribute();
                Role r = new Role();
                r.setText("author");

                c.addEntity("abcd");
                c.setDate("date");
                c.setRole(r);

                lc.addContribute(c);

                File result = new File("lifeCycle.xml");
                serializer.write(lc, result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //@Ignore("ignorar o teste pois ele gera um arquivo")
    @Test
    public void generateEducationalTest() throws Exception {

        Serializer serializer = new Persister();
        Educational e = new Educational();

        Duration d = new Duration();
//        d.set(1, Calendar.HOUR);
//        d.set(40, Calendar.MINUTE);
//        d.set(40, Calendar.SECOND);

        d.validate("PT1H2M");
        e.setTypicalLearningTime(d);

        File result = new File("educational.xml");
        serializer.write(e, result);

    }

    @Test
    public void durationTest() throws Exception {

        Duration d = new Duration();
//        d.set(1, Calendar.HOUR);
//        d.set(40, Calendar.MINUTE);
//        d.set(40, Calendar.SECOND);

        final String ASSERTION = "PT1H2M";

        d.validate(ASSERTION);
        d.setText("PT1H2M");

        assertThat(d.getText(), equalTo(ASSERTION));
    }

    @Test
    public void testErrorTranslation() throws FileNotFoundException {
        OBAA obaa = OBAA.fromFilename(FILE4);
        obaa.getEducational().getContexts();
        obaa.getEducational().getIntendedEndUserRoleAsStrings().get(0);
        obaa.getEducational().getInteractivityType();
        obaa.getEducational().getLearningResourceTypesString();
        obaa.getLifeCycle().getContribute().get(0).getRole();
        obaa.getLifeCycle().getStatus();
        obaa.getGeneral().getStructure();
    }

    @Test
    public void testEmptyEntityTag() throws FileNotFoundException {
        OBAA obaa = OBAA.fromFilename(FILE5);
        assertThat(obaa.getLifeCycle().getVersion(), nullValue());

        assertThat(obaa.getLifeCycle().getContribute().get(0).getEntities().size(), is(1));
        assertThat(obaa.getLifeCycle().getContribute().get(0).getEntities().get(0), equalTo(""));

    }

    @Test
    public void froacErrorTest() throws FileNotFoundException {
        OBAA metadata = OBAA.fromFilename(FROAC);
        assertEquals(metadata.getTechnical().getFormats().get(0).toString(), "pdf");
    }

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        OBAA obj1 = new OBAA();

        General g = new General();
        g.addTitle("Titulo1");
        obj1.setGeneral(g);

        OBAA obj2 = obj1.clone();

        assertEquals(obj2.getGeneral().getTitles().get(0), obj1.getGeneral().getTitles().get(0));

        List titles = obj2.getGeneral().getTitles();
        titles.clear();
        titles.add("Titulo2");
        obj2.getGeneral().setTitles(titles);

        assertEquals(obj1.getGeneral().getTitles().get(0), "Titulo1");
        assertEquals(obj2.getGeneral().getTitles().get(0), "Titulo2");

        Accessibility a = new Accessibility();
        ResourceDescription rd = new ResourceDescription();
        Equivalent e = new Equivalent();
        Content c = new Content();

        AlternativesToAuditory ata = new AlternativesToAuditory();
        CaptionType ct = new CaptionType();
        ct.setLanguage("libras");

        ata.addCaptionType(ct);
        c.setAlternativesToAuditory(ata);
        e.setContent(c);
        rd.addEquivalent(e);
        a.setResourceDescription(rd);

        obj1.setAccessibility(a);

        obj2 = obj1.clone();

        List ct2l = obj2.getAccessibility().getResourceDescription().
                getEquivalent().get(0).getContent().getAlternativesToAuditory().
                getCaptionType();

        ct2l.clear();

        CaptionType ct2 = new CaptionType();
        ct2.setLanguage("seila");
        ct2l.add(ct2);

        obj2.getAccessibility().getResourceDescription().getEquivalent().
                get(0).getContent().getAlternativesToAuditory().
                setCaptionType(ct2l);

        assertEquals(obj1.getAccessibility().getResourceDescription()
                .getEquivalent().get(0).getContent().getAlternativesToAuditory()
                .getCaptionType().get(0).getLanguage(), "libras");

        assertEquals(obj2.getAccessibility().getResourceDescription()
                .getEquivalent().get(0).getContent().getAlternativesToAuditory()
                .getCaptionType().get(0).getLanguage(), "seila");

    }

    @Test
    public void transaltionTest() {
        Structure s = new Structure();
        s.validate(Structure.ATOMIC);
        s.setText(Structure.ATOMIC);
        s.setLanguage("en");

        assertThat(s.getTranslated(), equalTo("Atomic"));
        assertThat(s.getLanguage(), equalTo("en"));

        s.setLanguage("pt");
        s.setCountry("BR");

        assertThat(s.getTranslated(), equalTo("Atômico"));
        assertThat(s.getLanguage(), equalTo("pt"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void structureErrorTest() {
        Structure s = new Structure();

        s.validate("teste mensagem");
    }

//    @Test
//    public void setOfTermsStructureTest(){
//        Structure s = new Structure();
//
//        Map m = s.getMapOfTerms();
//
//        Set key = m.keySet();
//
//        for(m.){
//
//        }
//        List<String> terms = s.getSetOfTerms();
//
//        assertThat(terms, hasItem("atomic"));
//        assertThat(terms, hasItem("collection"));
//        assertThat(terms, hasItem("networked"));
//        assertThat(terms, hasItem("hierarchical"));
//        assertThat(terms, hasItem("linear"));
//
//        assertThat(terms, not(hasItem("not atomic")));
//
//        List<String> titles = s.getSetOfTitulos();
//
//        assertThat(titles, hasItem("Atômico"));
//        assertThat(titles, hasItem("Coleção"));
//        assertThat(titles, hasItem("Em rede"));
//        assertThat(titles, hasItem("Hierárquico"));
//        assertThat(titles, hasItem("Linear"));
//
//    }
    @Ignore("Ignorar teste pois ele gera um arquivo")
    @Test
    public void generateObaa() {
        try {
            Serializer serializer = new Persister();
            OBAA o = new OBAA();
            General g = new General();
            Educational e = new Educational();
            Technical t = new Technical();
            List<Annotation> a = new ArrayList<>();
            Accessibility ac = new Accessibility();
            LifeCycle l = new LifeCycle();
            List<Classification> c = new ArrayList<>();
            Metametadata m = new Metametadata();
            SegmentInformationTable s = new SegmentInformationTable();

            o.setGeneral(g);
            o.setEducational(e);
            o.setTechnical(t);
            o.setAnnotations(a);
            o.setAccessibility(ac);
            o.setLifeCycle(l);
            o.setClassifications(c);
            o.setMetametadata(m);
            o.setSegmentInformationTable(s);

            File result = new File("empty.xml");
            serializer.write(o, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateSegmentInformationTable() {
        try {
            Serializer serializer = new Persister();
            OBAA o = new OBAA();
            General g = new General();

            g.addTitle("Título 1");

            SegmentInformation si = new SegmentInformation();

            si.setIdentifier("1");
            si.setTitle("tubarão");
            si.setDescription("aparece um tubarão na cena");
            si.addKeyword("cena");
            si.addKeyword("tubarão");

            SegmentMediaType smt = new SegmentMediaType();
            smt.setText("video");
            si.setSegmentMediaType(smt);

            SegmentList sl = new SegmentList();

            sl.addSegmentList(si);

            SegmentInformationTable st = new SegmentInformationTable();

            st.addSegmentList(sl);

            o.setGeneral(g);
            o.setSegmentInformationTable(st);

            File result = new File("./src/test/metadata/segment.xml");
            serializer.write(o, result);

            OBAA novo = OBAA.fromFilename(SEGMENT);

            assertThat(o.getGeneral().getTitles().get(0), equalTo(novo.getGeneral().getTitles().get(0)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setLocaleTest() {
        TextElement t = new TextElement();

        t.setLocale("pt-BR");
        assertThat(t.getLanguage(), equalTo("pt"));
        assertThat(t.getCountry(), equalTo("BR"));

    }

    @Test
    public void orderMapTest() {
        Structure s = new Structure();
        s.setLocale("pt-BR");
//        System.out.println(s.getMapOfTerms());

        //TODO: FAzer teste de comprovação de ordem
    }

    //@Ignore("Ignorar teste pois ele gera um arquivo")
    @Test
    public void setAggregationLevelTest() throws Exception {
        OBAA o = new OBAA();
        General g = new General();
        g.setAggregationLevel(1);
        o.setGeneral(g);

        Serializer serializer = new Persister();
        File result = new File("aggregationTest.xml");
        serializer.write(o, result);

    }

    @Test
    public void rightsTest() {
        Rights r = new Rights();
        r.getCopyright();
    }

    @Test
    public void formatNullTest() {

        Technical t = file2.getTechnical();
        List<String> format = cognitivabrasil.util.HelperFunctions.toStringList(t.getFormats());
        assertThat(format.size(), equalTo(0));

    }

    @Ignore("Ignorar teste pois ele gera um arquivo")
    @Test
    public void platformSpecificTest() throws Exception {
        OBAA o = new OBAA();
        Technical t = new Technical();
        PlatformSpecificFeature psf = new PlatformSpecificFeature();
        SpecificRequirement sr = new SpecificRequirement();

        SpecificOrComposite oc = new SpecificOrComposite();
        oc.setSpecificMaximumVersion("1.0");
        sr.addOrComposite(oc);

        psf.addSpecificRequirement(sr);
        t.addPlatformSpecificFeature(psf);

        o.setTechnical(t);

        Serializer serializer = new Persister();
        File result = new File("platformSpecificTest.xml");
        serializer.write(o, result);
    }

    @Test
    public void whoAmITest() {

        Structure s = new Structure();
        s.setLocale("en");

        assertThat(s.whoAmI(), equalTo("Underlying organizational structure of this learning object."));

    }

    @Test
    public void validateTest() {
        //the error trown test already exists

        Structure s = new Structure();
        s.validate(Structure.ATOMIC);
    }

//    @Test
//    public void taxonPath() throws IOException{
//        OBAA o1;
//        o1 = OBAA.fromFilename(TAXONERR);
//
////        List<Classification> classi =  o1.getClassifications();
////        TaxonPath tp = classi.get(0).getTaxonPath().get(0);
////
////        System.out.println(tp);
//    }
    @Test
    public void getFullNameTest() {

        Structure s = new Structure();

        assertThat(s.classFullName(), equalTo("obaa.general.structure"));

        IntendedEndUserRole i = new IntendedEndUserRole();

        //  assertThat(i.classFullName(), equalTo("obaa.educational.intendedEndUserRole"));
    }

    @Test
    public void vCardGetNameTest() {

        Entity e = new Entity();

        e.setName("Luiz Henrique", "Rossi");

        assertThat(e.getName(), equalTo("Luiz Henrique Rossi"));

        Contribute c = new Contribute();

        c.addEntity(e);

        assertThat(c.getEntitiesReal().get(0).getName(), equalTo("Luiz Henrique Rossi"));
    }

    @Test
    public void testVCard() {
        OBAA obaa = new OBAA();
        obaa.setLifeCycle(new LifeCycle());
        cognitivabrasil.obaa.LifeCycle.Contribute contribute = new cognitivabrasil.obaa.LifeCycle.Contribute();

        Entity e = new Entity();
        e.setName("Ministério da Educação", "do Brasil");
        contribute.addEntity(e);
        obaa.getLifeCycle().addContribute(contribute);

        obaa.getLifeCycle().getContribute().get(0).getEntitiesReal().get(0).getName();

        assertThat(obaa.getLifeCycle().getContribute().get(0).getEntitiesReal().get(0).getName(), equalTo("Ministério da Educação do Brasil"));

    }

    @Test
    public void testVCardTransated() {
        OBAA obaa = new OBAA();
        obaa.setLifeCycle(new LifeCycle());
        cognitivabrasil.obaa.LifeCycle.Contribute contribute = new cognitivabrasil.obaa.LifeCycle.Contribute();

        Entity e = new Entity();
        e.setName("Ministério da Educação", "do Brasil");
        contribute.addEntity(e);
        obaa.getLifeCycle().addContribute(contribute);

        obaa.getLifeCycle().getContribute().get(0).getEntitiesReal().get(0).getName();

        assertThat(obaa.getLifeCycle().getContribute().get(0).getEntitiesReal().get(0).getTranslated(), equalTo("Ministério da Educação do Brasil"));

        String Vcard = e.getText();

        Entity e2 = new Entity();
        e2.setText("José da Silva");

        assertThat(e2.getTranslated(), equalTo("José da Silva"));

        Entity e3 = new Entity();
        e3.setText("BEGIN:VCARD\nVERSION:3.0\nN:do Brasil;Ministério da Educação;;;\nFN:Ministério da Educação do Brasil\nEND:VCARD");

        assertThat(e3.getTranslated(), equalTo("Ministério da Educação do Brasil"));

        Entity e4 = new Entity();
        e4.setText("BEGIN:VCARDVERSION:3.0N:do Brasil;Ministério da Educação;;;FN:Ministério da Educação do BrasilEND:VCARD");

        assertThat(e4.getTranslated(), equalTo("BEGIN:VCARDVERSION:3.0N:do Brasil;Ministério da Educação;;;FN:Ministério da Educação do BrasilEND:VCARD"));

    }

    @Test
    public void testOBAA_Duration() throws FileNotFoundException {

        Duration d = new Duration();
        d.setDuration("23");
        assertThat(d.getDuration(), equalTo("PT23H"));

        d.setDuration("2");
        assertThat(d.getDuration(), equalTo("PT2H"));

        d.setDuration("21h");
        assertThat(d.getDuration(), equalTo("PT21H"));

        d.setDuration("21h22");
        assertThat(d.getDuration(), equalTo("PT21H22M"));

        d.setDuration("2h2");
        assertThat(d.getDuration(), equalTo("PT2H2M"));

        d.setDuration("21h24min");
        assertThat(d.getDuration(), equalTo("PT21H24M"));

        d.setDuration("21h24min12");
        assertThat(d.getDuration(), equalTo("PT21H24M12S"));

        d.setDuration("21h24min32s");
        assertThat(d.getDuration(), equalTo("PT21H24M32S"));

    }

    @Test
    public void testIsEmpty() {
        OBAA obaa = new OBAA();
        assertThat(obaa.isEmpty(), equalTo(true));

        obaa = new OBAA();
        obaa.setAccessibility(new Accessibility());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.getAnnotations().add(new Annotation());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.getClassifications().add(new Classification());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setEducational(new Educational());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setGeneral(new General());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setLifeCycle(new LifeCycle());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setMetametadata(new Metametadata());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.getRelations().add(new Relation());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setRights(new Rights());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setSegmentInformationTable(new SegmentInformationTable());
        assertThat(obaa.isEmpty(), equalTo(false));

        obaa = new OBAA();
        obaa.setTechnical(new Technical());
        assertThat(obaa.isEmpty(), equalTo(false));
    }

    @Test
    public void testRelationIsVersionOf() {
        assertThat(l.hasRelationWith(Kind.IS_VERSION_OF, "xx2"), equalTo(true));

        assertThat(l.hasRelationWith(Kind.HAS_VERSION, "xx1"), equalTo(false));
    }

    @Test
    public void testAnyRelationWithKind() {
        List<Identifier> ids = l.getRelationsWithKind(Kind.IS_VERSION_OF);
        assertThat(ids.size(), equalTo(1));
        assertThat(ids.get(0).equals(new Identifier("URI", "xx2")), equalTo(true));

    }

    @Test
    public void capesErrorTest() throws FileNotFoundException {
        OBAA capesEl = OBAA.fromFilename("./src/test/metadata/capes.xml");

        assertThat(capesEl.getGeneral().getTitles().get(0), equalTo("Fundamentos de Matemática"));
    }

    @Test
    public void testCamelCaseGeneralLifeCycle() throws FileNotFoundException {
        OBAA o = OBAA.fromFilename("./src/test/metadata/xml_obaa_full.xml");
        assertThat(o.getGeneral().getIdentifiers().get(0).getCatalog(), equalTo("teste"));
        assertThat(o.getGeneral().getIdentifiers().get(0).getEntry(), equalTo("123"));
        assertThat(o.getGeneral().getAggregationLevel().getText(), equalTo("1"));
        assertThat(o.getLifeCycle().getVersion(), equalTo("1"));
    }

    @Test
    public void testCamelCaseTechnical() throws FileNotFoundException {
        OBAA o = OBAA.fromFilename("./src/test/metadata/xml_obaa_full.xml");

        assertThat(o.getTechnical().getRequirement().get(0).getOrComposite().get(0).getMinimumVersion(),
                equalTo("11.0.1"));
        assertThat(o.getTechnical().getRequirement().get(0).getOrComposite().get(0).getMaximumVersion(),
                equalTo("12.x"));
        assertThat(o.getTechnical().getInstallationRemarks(), equalTo("Descompactar.."));
        assertThat(o.getTechnical().getOtherPlatformRequirements(), equalTo("Flash player"));
        assertThat(o.getTechnical().getSupportedPlatforms().get(0), equalTo("DTV"));
        PlatformSpecificFeature psf = o.getTechnical().getPlatformSpecificFeatures().get(0);
        assertThat(psf.getPlatformType().getText(), equalTo("Web"));
        assertThat(psf.getSpecificFormats().get(0).getText(), equalTo("text/htm"));
        assertThat(psf.getSpecificSize(), equalTo("242"));
        assertThat(psf.getSpecificLocation(), equalTo("http://www.cognitivabrasil.com.br"));
        assertThat(psf.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificType(),
                equalTo("browser"));
        assertThat(psf.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificName(),
                equalTo("mozillaFirefox"));
        assertThat(psf.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMinimumVersion(),
                equalTo("1.0"));
        assertThat(psf.getSpecificRequirements().get(0).getSpecificOrComposites().get(0).getSpecificMaximumVersion(),
                equalTo("3.0"));
        assertThat(psf.getSpecificInstallationRemarks(), equalTo("Executar o index2.html"));
        assertThat(psf.getSpecificOtherPlatformRequirements(), equalTo("(\"en,\" \"sound card\")"));
    }

    @Test
    public void testCamelCase() throws FileNotFoundException {
        OBAA o = OBAA.fromFilename("./src/test/metadata/xml_obaa_full.xml");

        assertThat(o.getEducational().getLearningResourceTypes().get(0).getText(), equalTo("simulation"));
        assertThat(o.getEducational().getInteractivityLevel().getText(), equalTo("Muito baixo"));
        assertThat(o.getEducational().getInteractivityType(), equalTo("expositive"));
        assertThat(o.getEducational().getSemanticDensity().getText(), equalTo("low"));
        assertThat(o.getEducational().getLearningContentType(), equalTo("factual"));
        assertThat(o.getEducational().getTypicalAgeRanges().get(0).toString(), equalTo("adult"));
        assertThat(o.getEducational().getTypicalLearningTime().getText(), equalTo("PT15M"));
        assertThat(o.getEducational().getIntendedEndUserRoles().get(0).toString(), equalTo("teacher"));
        assertThat(o.getEducational().getInteraction().getInteractionType().getText(), equalTo("object-individual"));
        assertThat(o.getEducational().getInteraction().getCoPresence().getBoolean(), equalTo(false));
        assertThat(o.getEducational().getDidaticStrategy().get(0).getText(), equalTo("Problem Solving"));

        assertThat(o.getRights().getCopyright().getText(), equalTo("Nao"));

        assertThat(o.getClassifications().get(0).getTaxonPath().get(0).getSource(), equalTo("ACM"));

        ResourceDescription rd = o.getAccessibility().getResourceDescription();
        assertThat(rd.getPrimary().getHasVisual(), equalTo("true"));
        assertThat(rd.getPrimary().getHasAuditory(), equalTo("true"));
        assertThat(rd.getPrimary().getHasText(), equalTo("false"));
        assertThat(rd.getPrimary().getHasTactile(), equalTo("false"));
        assertThat(rd.getPrimary().getEarlStatement().get(0).getDisplayTransformability(),
                equalTo("transformabilidade dos recursos referenciados"));
        assertThat(rd.getPrimary().getEarlStatement().get(0).getControlFlexibility(),
                equalTo("controle e flexibilidade dos recursos referenciados"));
        assertThat(rd.getPrimary().getEquivalentResource().get(0).getText(), equalTo("Aponta para..."));
        Equivalent equivalent = rd.getEquivalent().get(0);
        assertThat(equivalent.getPrimaryResource(), equalTo("452"));
        assertThat(equivalent.getPrimaryFile().get(0).getText(), equalTo("34232"));
        assertThat(equivalent.getContent().getAlternativesToVisual().getAudioDescription().get(0).getText(),
                equalTo(AudioDescription.STANDARD));
        assertThat(equivalent.getContent().getAlternativesToVisual().getAltTextLang(), equalTo("pt-BR"));
        assertThat(equivalent.getContent().getAlternativesToVisual().getColorAvoidance().get(0).getText(),
                equalTo("avoidRed"));
        assertThat(equivalent.getContent().getAlternativesToText().isGraphicAlternative(), equalTo(true));
        assertThat(equivalent.getContent().getAlternativesToText().getSignLanguage().get(0).getText(),
                equalTo("Brazilian-BRA"));
        CaptionType captionType = equivalent.getContent().getAlternativesToAuditory().getCaptionType().get(0);
        assertThat(captionType.getReducedReadingLevelTxt(), equalTo("false"));
        assertThat(captionType.getReducedSpeed().isReducedSpeed(), equalTo(false));
        assertThat(captionType.getReducedSpeed().getReducedSpeedRate(), equalTo("120"));
        assertThat(captionType.getEnhancedCaptionTxt(), equalTo("false"));
        assertThat(equivalent.getContent().getAlternativesToAuditory().getSignLanguage().get(0).getText(),
                equalTo("BrasilianLIBRAS"));
        assertThat(equivalent.getContent().getLearnerScaffold().get(0).getText(), equalTo("calculator"));

        assertThat(o.getSegmentInformationTable().getSegmentList().get(0).getSegmentInformation().get(0)
                .getSegmentMediaType(), equalTo("video"));
        assertThat(o.getSegmentInformationTable().getSegmentGroupList().getSegmentGroupInformation().get(0)
                .getGroupType().getText(), equalTo("Higlights"));
    }

    @Test
    public void testDeserializeXml() throws Exception {
        OBAA obaa = OBAA.fromFilename(FILE6);
        assertThat(obaa.getGeneral().getTitles().get(0), equalTo("Exemplo de triedro em canto do quarto na trama principal"));
        assertThat(obaa.getGeneral().getKeywords(), hasSize(2));
        assertThat(obaa.getGeneral().getKeywords().get(0), equalTo("História em quadrinhos"));
        assertThat(obaa.getGeneral().getKeywords().get(1), equalTo("Projeção cilíndrica ortogonal"));
        assertThat(obaa.getGeneral().getDescriptions().get(0), equalTo("Esta história é composta por 09 quadros, onde o "
                + "personagem Zeca exemplifica projeção cilíndrica ortogonal utilizando uma cadeira como sólido e o "
                + "canto do seu quarto como triedro."));
        assertThat(obaa.getGeneral().getAggregationLevel().toString(), equalTo("2"));
        assertThat(obaa.getGeneral().getIdentifiers().get(0).getCatalog(), equalTo("URI"));
        assertThat(obaa.getGeneral().getIdentifiers().get(0).getEntry(),
                equalTo("http://cognitivabrasil.com.br/repositorio/documents/1"));
        assertThat(obaa.getGeneral().getLanguages().get(0), equalTo("pt-BR"));
        assertThat(obaa.getGeneral().getStructure().getText(), equalTo("networked"));

        assertThat(obaa.getLifeCycle().getStatus(), equalTo("finalized"));
        assertThat(obaa.getLifeCycle().getVersion(), equalTo("1.1"));
        assertThat(obaa.getLifeCycle().getContribute(), hasSize(2));
        assertThat(obaa.getLifeCycle().getContribute().get(0).getRole().getText(), equalTo("author"));
        assertThat(obaa.getLifeCycle().getContribute().get(0).getEntities().get(0), equalTo("Raul Inácio Busarello"));
        assertThat(obaa.getLifeCycle().getContribute().get(1).getRole().getText(), equalTo("validator"));
        assertThat(obaa.getLifeCycle().getContribute().get(1).getEntities().get(0), equalTo("Vania R. Ulbricht"));

        assertThat(obaa.getRights().getCost().getBoolean(), equalTo(false));
        assertThat(obaa.getRights().getCopyright().getBoolean(), equalTo(true));
        assertThat(obaa.getRights().getDescription(), equalTo("Este trabalho está licenciado.."));

        assertThat(obaa.getEducational().getInteractivityType(), equalTo("active"));
        assertThat(obaa.getEducational().getIntendedEndUserRoleAsStrings().get(0), equalTo("learner"));
        assertThat(obaa.getEducational().getLearningResourceTypesString().get(0), equalTo(LearningResourceType.FIGURE));
        assertThat(obaa.getEducational().getLearningResourceTypesString().get(1), equalTo(LearningResourceType.NARRATIVE_TEXT));
        assertThat(obaa.getEducational().getTypicalAgeRanges().get(0).getText(), equalTo("10 - 15 anos"));
        assertThat(obaa.getEducational().getLanguages().get(0).getText(), equalTo("pt-BR"));
        assertThat(obaa.getEducational().getContexts().get(0).getText(), equalTo(Context.SCHOOL));
        assertThat(obaa.getEducational().getLearningContentType(), equalTo(LearningContentType.CONCEITUAL));

        assertThat(obaa.getTechnical().getLocation().get(0).getText(), equalTo("http://cognix-repo.inf.ufrgs.br/resources/1/"));
        assertThat(obaa.getTechnical().getSize(), equalTo("10"));
        assertThat(obaa.getTechnical().getOtherPlatformRequirements(), equalTo("Navegador compatível com HTML5"));
        assertThat(obaa.getTechnical().getSupportedPlatforms().get(0), equalTo(SupportedPlatform.MOBILE));
        assertThat(obaa.getTechnical().getSupportedPlatforms().get(1), equalTo(SupportedPlatform.DTV));
        assertThat(obaa.getTechnical().getSupportedPlatforms().get(2), equalTo(SupportedPlatform.WEB));

        assertThat(obaa.getMetametadata().getIdentifier().get(0).getCatalog(), equalTo("URI"));
        assertThat(obaa.getMetametadata().getIdentifier().get(0).getEntry(), equalTo("http://www.w3.org/2001/XMLSchema-instance"));
        assertThat(obaa.getMetametadata().getContribute().get(0).getRole(), equalTo(Role.AUTHOR));
        assertThat(obaa.getMetametadata().getContribute().get(0).getEntity().get(0).getText(), equalTo("alan"));
        assertThat(obaa.getMetametadata().getContribute().get(0).getDate().getText(), equalTo("2016-07-05"));
        assertThat(obaa.getMetametadata().getMetadataSchema().get(0).getText(), equalTo("OBAAv1.0"));
        assertThat(obaa.getMetametadata().getLanguage().getText(), equalTo("pt-BR"));

        assertThat(obaa.getAccessibility().getResourceDescription().getPrimary().isHasVisual(), equalTo(true));
        assertThat(obaa.getAccessibility().getResourceDescription().getPrimary().isHasAuditory(), equalTo(false));
        assertThat(obaa.getAccessibility().getResourceDescription().getPrimary().isHasText(), equalTo(true));
        assertThat(obaa.getAccessibility().getResourceDescription().getPrimary().isHasTactile(), equalTo(false));
    }

}
