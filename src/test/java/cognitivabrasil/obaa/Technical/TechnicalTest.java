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

        json = "{\"location\":[\"http://fff\"],\"size\":\"9876\",\"requirement\":[{\"orComposite\":[{\"type\":\"editor\",\"name\":\"macos\",\"minimumVersion\":\"0.1\",\"maximumVersion\":\"10.0\"}]}],\"installationRemarks\":\"remarks\",\"otherPlatformRequirements\":\"Other platreq\",\"duration\":\"PT1H10M\",\"supportedPlatforms\":[\"Ubuntu\"],\"platformSpecificFeatures\":[{\"platformType\":\"mobile\",\"specificFormats\":[\"specific pdf\"],\"specificSize\":\"grande, muito grande!\",\"specificLocation\":\"http://www.cognitivabrasil.com.br\",\"specificRequirements\":[{\"specificOrComposites\":[{\"specificType\":\"browser\",\"specificName\":\"mozillaFirefox\",\"specificMinimumVersion\":\"1.0\",\"specificMaximumVersion\":\"3.0\"}]}],\"specificInstallationRemarks\":\"Executar o index2.html\",\"specificOtherPlatformRequirements\":\"requirement\"}],\"service\":[{\"name\":\"opera\",\"type\":\"browser\",\"provides\":\"true\",\"essential\":\"false\",\"protocol\":[\"http\"],\"ontology\":[{\"name\":\"ontoObaa\",\"language\":\"owl\",\"location\":\"http://ontologia.owl\"}],\"language\":[\"PT-BR\"],\"details\":[{\"details\":\"servie detail\",\"serviceLocation\":\"Service location\"},{\"details\":\"novo detalhe\",\"serviceLocation\":\"sala\"}]}],\"formats\":[\"pdf\"]}";

        technical = new Technical();
        technical.setDuration(Duration.fromText("PT1H10M"));
        technical.setInstallationRemarks(new InstallationRemarks("remarks"));
        technical.addFormat("pdf");
        technical.addLocation("http://fff");
        technical.setSize(new Size("9876"));

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
        service.setDetails(new ArrayList<>(Arrays.asList(new Details("servie detail", "Service location"))));
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
        service.addDetail(new Details("novo detalhe", "sala"));

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

        assertThat(e.getDuration(), equalTo(technical.getDuration()));
        assertThat(e.getInstallationRemarks(), equalTo(technical.getInstallationRemarks()));
        assertThat(e.getOtherPlatformRequirements(), equalTo(technical.getOtherPlatformRequirements()));
        assertThat(e.getSize(), equalTo(technical.getSize()));
        assertThat(e.getFormats(), equalTo(technical.getFormats()));
        assertThat(e.getLocation(), equalTo(technical.getLocation()));
        assertThat(e.getPlatformSpecificFeatures().size(), equalTo(technical.getPlatformSpecificFeatures().size()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificInstallationRemarks(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificInstallationRemarks()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificLocation(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificLocation()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificOtherPlatformRequirements(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificOtherPlatformRequirements()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificSize(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificSize()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getPlatformType(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getPlatformType()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificFormats(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificFormats()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificRequirements().size(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificRequirements().size()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().size(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites().size()));
        assertThat(e.getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites(),
                equalTo(technical.getPlatformSpecificFeatures().get(0).getSpecificRequirements().get(0).getSpecificOrComposites()));

        assertThat(e.getRequirement().get(0).getOrComposite(), equalTo(technical.getRequirement().get(0).getOrComposite()));
        assertThat(e.getService().size(), equalTo(technical.getService().size()));
        assertThat(e.getService().get(0).getEssential(), equalTo(technical.getService().get(0).getEssential()));
        assertThat(e.getService().get(0).getName(), equalTo(technical.getService().get(0).getName()));
        assertThat(e.getService().get(0).getProvides(), equalTo(technical.getService().get(0).getProvides()));
        assertThat(e.getService().get(0).getType(), equalTo(technical.getService().get(0).getType()));
        assertThat(e.getService().get(0).getDetails(), equalTo(technical.getService().get(0).getDetails()));
        assertThat(e.getService().get(0).getLanguage(), equalTo(technical.getService().get(0).getLanguage()));
        assertThat(e.getService().get(0).getOntology(), equalTo(technical.getService().get(0).getOntology()));
        assertThat(e.getService().get(0).getProtocol(), equalTo(technical.getService().get(0).getProtocol()));
        assertThat(e.getSupportedPlatforms(), equalTo(technical.getSupportedPlatforms()));
    }
}
