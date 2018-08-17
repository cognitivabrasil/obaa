/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.accessibility;

import cognitivabrasil.obaa.Accessibility.Accessibility;
import cognitivabrasil.obaa.Accessibility.AlternativesToAuditory;
import cognitivabrasil.obaa.Accessibility.AlternativesToText;
import cognitivabrasil.obaa.Accessibility.AlternativesToVisual;
import cognitivabrasil.obaa.Accessibility.AudioDescription;
import cognitivabrasil.obaa.Accessibility.CaptionType;
import cognitivabrasil.obaa.Accessibility.ColorAvoidance;
import cognitivabrasil.obaa.Accessibility.Content;
import cognitivabrasil.obaa.Accessibility.EarlStatement;
import cognitivabrasil.obaa.Accessibility.Equivalent;
import cognitivabrasil.obaa.Accessibility.LearnerScaffold;
import cognitivabrasil.obaa.Accessibility.Primary;
import cognitivabrasil.obaa.Accessibility.PrimaryFile;
import cognitivabrasil.obaa.Accessibility.PrimaryResource;
import cognitivabrasil.obaa.Accessibility.ReducedSpeed;
import cognitivabrasil.obaa.Accessibility.ResourceDescription;
import cognitivabrasil.obaa.Accessibility.SignLanguage;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class AccessibilityTest {

    private String json;
    private Accessibility acc;

    @Before
    public void init() {
        json = "{\"resourceDescription\":{\"primary\":{\"hasVisual\":true,\"hasAuditory\":false, \"hasText\":true,\"hasTactile\":false,  "
                + "\"earlStatement\":[{\"displayTransformability\":\"seilah\", \"controlFlexibility\":\"controlseilah\"}],"
                + "\"equivalentResource\":[\"eqResource\"]}, \"equivalent\":[{\"primaryFile\":[\"primaryf\"], "
                + "\"content\":{\"alternativesToVisual\":{\"audioDescription\":[\"standard\"],"
                + "\"colorAvoidance\":[\"avoid orange\"], \"altTextLang\":\"alttextlang\",\"longDescriptionLang\":\"longdeclang\"},"
                + "\"alternativesToAuditory\":{\"captionType\":[{\"language\":\"libras\",\"verbatim\":true,"
                + "\"enhancedCaption\":false,\"reducedReadingLevel\":false, \"reducedSpeed\":{\"reducedSpeed\":true,"
                + "\"captionRate\":\"2\"}}], \"signLanguage\":[\"Brasilian-LIBRAS\"]}, "
                + "\"learnerScaffold\":[\"abacus\"], "
                + "\"alternativesToText\":{\"graphicAlternative\":true, \"signLanguage\":[\"Brasilian-LIBRAS\"]}"
                + "}, \"primaryResource\":\"presource\",\"supplementary\":true }]"
                + "}}";
        acc = new Accessibility();
        ResourceDescription rd = new ResourceDescription();
        Primary primary = new Primary();
        primary.setVisual(true);
        primary.setAuditory(false);
        primary.setText(true);
        primary.setTactile(false);
        EarlStatement earlStatement = new EarlStatement();
        earlStatement.setControlFlexibility("controlseilah");
        earlStatement.setDisplayTransformability("seilah");
        primary.addEarlStatement(earlStatement);
        primary.addEquivalentResource("eqResource");
        rd.setPrimary(primary);
        Equivalent equivalent = new Equivalent();
        equivalent.addPrimaryFile(new PrimaryFile("primaryf"));
        Content content = new Content();
        AlternativesToVisual atv = new AlternativesToVisual();
        atv.addAudioDescription(AudioDescription.STANDARD);
        atv.addColorAvoidance(ColorAvoidance.AVOID_ORANGE);
        atv.setAltTextLang("alttextlang");
        atv.setLongDescriptionLang("longdeclang");
        content.setAlternativesToVisual(atv);

        AlternativesToAuditory ata = new AlternativesToAuditory();
        CaptionType ct = new CaptionType();
        ct.setLanguage("libras");
        ct.setVerbatim(true);
        ct.setEnhancedCaption(false);
        ct.setReducedReadingLevel(false);
        ct.setReducedSpeed(new ReducedSpeed(true, 2));
        ata.addCaptionType(ct);
        ata.addSignLanguage(SignLanguage.BRASILIAN_LIBRAS);
        content.setAlternativesToAuditory(ata);
        content.addLearnerScaffold(LearnerScaffold.ABACUS);
        AlternativesToText alternativesToText = new AlternativesToText();
        alternativesToText.setGraphicAlternative(true);
        alternativesToText.addSignLanguage(SignLanguage.BRASILIAN_LIBRAS);
        content.setAlternativesToText(alternativesToText);

        equivalent.setContent(content);
        equivalent.setPrimaryResource(new PrimaryResource("presource"));
        equivalent.setSupplementary(true);
        rd.addEquivalent(equivalent);
        acc.setResourceDescription(rd);

    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(acc);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Accessibility result = mapper.readValue(json, Accessibility.class);
        assertThat(result, equalTo(acc));
    }
}
