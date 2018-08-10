/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.obaa.General.Language;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class TechnicalTest {

    private String json;
    private Technical technical;

    @Test
    public void testGetHttpLocation() {
        Technical tec = new Technical();
        List<Location> locs = new ArrayList<>();
        locs.add(new Location("http://marcos.com.br"));
        locs.add(new Location("https://marcos.com.br"));
        tec.setLocation(locs);
        Map<String, Boolean> map = tec.getLocationHttp();
        map.entrySet().forEach((entry) -> {
            assertThat(entry.getValue(), equalTo(true));
        });
    }

    @Test
    public void testGetHttpLocationError() {
        Technical tec = new Technical();
        List<Location> locs = new ArrayList<>();
        locs.add(new Location("marcos.com.br"));
        locs.add(new Location("tt://marcos.com.br"));
        tec.setLocation(locs);
        Map<String, Boolean> map = tec.getLocationHttp();
        map.entrySet().forEach((entry) -> {
            assertThat(entry.getValue(), equalTo(false));
        });
    }

    private void initJsonTest() {
        technical = new Technical();
        technical.setDuration(Duration.fromText("PT1H10M"));
        technical.setInstallationRemarks(new InstallationRemarks("remarks"));
        technical.addFormat("pdf");
       technical.addLocation("http://fff");

       PlatformSpecificFeature platSF = new PlatformSpecificFeature();
        platSF.setSpecificInstallationRemarks("Executar o index2.html");
        platSF.setSpecificLocation("http://www.cognitivabrasil.com.br");
        platSF.addSpecificFormat(new SpecificFormat("specific pdf"));
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
        platSF.setPlatformType(SupportedPlatform.fromText(SupportedPlatform.MOBILE));
        technical.addPlatformSpecificFeature(platSF);
        Requirement requirement = new Requirement();
        OrComposite orComposite = new OrComposite();
        orComposite.setMaximumVersion("10.0");
        orComposite.setMinimumVersion("0.1");
        orComposite.setName(Name.MACOS);
        orComposite.setType("editor");
        requirement.addOrComposite(orComposite);
        technical.addRequirement(requirement);
        technical.addSupportedPlatforms("Ubuntu");
        technical.setOtherPlatformRequirements("Other platreq");
        Service service = new Service();
        service.setDetails(Arrays.asList(new Details("servie detail", "Service location")));
        service.setEssential(false);
        service.addLanguage(new Language("PT-BR"));
        service.setName(Name.fromText(Name.OPERA));
        service.setProvides(true);
        service.setType(Type.fromText(Type.BROWSER));
        Ontology ontology = new Ontology();
        ontology.setLanguage(new OntologyLanguage("owl"));
        ontology.setLocation(new OntologyLocation("http://ontologia.owl"));
        ontology.setName(new OntologyName("ontoObaa"));
        service.addOntology(ontology);
        service.addProtocol(new Protocol("http"));
//        service.addDetail();

        technical.addService(service);
    }

    @Test
    public void serializeJson() throws Exception {
        initJsonTest();

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(technical);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        initJsonTest();
        ObjectMapper mapper = new ObjectMapper();
        Technical e = mapper.readValue(json, Technical.class);

//        assertThat(e.getInteractivityType(), equalTo(InteractivityType.EXPOSITIVE));
    }
}
