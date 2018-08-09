/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.educational;

import cognitivabrasil.obaa.Educational.Context;
import cognitivabrasil.obaa.Educational.DidaticStrategy;
import cognitivabrasil.obaa.Educational.Difficulty;
import cognitivabrasil.obaa.Educational.Educational;
import cognitivabrasil.obaa.Educational.IntendedEndUserRole;
import cognitivabrasil.obaa.Educational.Interaction;
import cognitivabrasil.obaa.Educational.InteractionType;
import cognitivabrasil.obaa.Educational.InteractivityLevel;
import cognitivabrasil.obaa.Educational.InteractivityType;
import cognitivabrasil.obaa.Educational.LearningContentType;
import cognitivabrasil.obaa.Educational.LearningResourceType;
import cognitivabrasil.obaa.Educational.Perception;
import cognitivabrasil.obaa.Educational.Reciprocity;
import cognitivabrasil.obaa.Educational.SemanticDensity;
import cognitivabrasil.obaa.Technical.Duration;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class EducationalTest {

    private String json;
    private Educational educational;

    @Before
    public void init() {
        json = "{\"interactivityType\":\"expositive\",\"learningResourceTypes\":[\"index\",\"figure\"], "
                + "\"interactivityLevel\":\"low\", \"contexts\":[\"school\"], "
                + "\"difficulty\":\"easy\",\"semanticDensity\":\"medium\", \"typicalLearningTime\":\"PT23H\", "
                + "\"intendedEndUserRoles\":[\"author\"],\"typicalAgeRanges\":[\"14-17\"],"
                + "\"didaticStrategy\":[\"challenge\"], \"interaction\": {\"interactionType\":\"object-individual\","
                + "\"coPresence\":\"true\",\"perception\":\"visual\",\"reciprocity\":\"1-n\",\"synchronism\":\"false\"},"
                + "\"descriptions\":[\"Descr Educ\"], \"languages\":[\"pt-BR\"], \"learningContentType\":\"factual\"}";

        educational = new Educational();
        educational.setInteractivityType(InteractivityType.EXPOSITIVE);
        educational.addLearningResourceType(LearningResourceType.INDEX);
        educational.addLearningResourceType(LearningResourceType.FIGURE);
        educational.setInteractivityLevel(InteractivityLevel.LOW);
        educational.addLanguage("pt-BR");
        educational.addContext(Context.SCHOOL);
        educational.setDifficulty(Difficulty.EASY);
        educational.setSemanticDensity(SemanticDensity.MEDIUM);
        Duration duration = new Duration();
        duration.setDuration("23");
        educational.setTypicalLearningTime(duration);
        educational.addIntendedEndUserRole(IntendedEndUserRole.AUTHOR);
        educational.addTypicalAgeRange("14-17");
        educational.addDescription("Descr Educ");
        educational.addDidaticStrategy(DidaticStrategy.CHALLENGE);
        Interaction interaction = new Interaction();
        interaction.setCoPresence(true);
        interaction.setInteractionType(InteractionType.OBJECT_INDIVIDUAL);
        interaction.setPerception(Perception.VISUAL);
        interaction.setReciprocity(Reciprocity.ONE_N);
        interaction.setSynchronism(false);
        educational.setInteraction(interaction);
        educational.setLearningContentType(LearningContentType.FACTUAL);

    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(educational);

        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
//        json = "{\"interactivityType\":\"expositive\",\"learningResourceTypes\":[\"index\",\"figure\"], "
//                + "\"interactivityLevel\":\"low\", \"contexts\":[\"school\"], "
//                + "\"difficulty\":\"easy\",\"semanticDensity\":\"medium\", \"typicalLearningTime\":\"PT23H\", "
//                + "\"intendedEndUserRoles\":[\"author\"],\"typicalAgeRanges\":[\"14-17\"],"
//                + "\"didaticStrategy\":[\"challenge\"], \"interaction\": {\"interactionType\":\"object-individual\","
//                + "\"coPresence\":\"true\",\"perception\":\"visual\",\"reciprocity\":\"1-n\",\"synchronism\":\"false\"},"
//                + "\"descriptions\":[\"Descr Educ\"] }";

        ObjectMapper mapper = new ObjectMapper();
        Educational e = mapper.readValue(json, Educational.class);

        assertThat(e.getInteractivityType(), equalTo(InteractivityType.EXPOSITIVE));
        assertThat(e.getLearningResourceTypes(),
                equalTo(educational.getLearningResourceTypes()));
        assertThat(e.getInteractivityLevel(), equalTo(educational.getInteractivityLevel()));
        assertThat(e.getContexts(), equalTo(educational.getContexts()));
        assertThat(e.getDifficulty(), equalTo(educational.getDifficulty()));
        assertThat(e.getSemanticDensity(), equalTo(educational.getSemanticDensity()));
        assertThat(e.getTypicalLearningTime(), equalTo(educational.getTypicalLearningTime()));
        assertThat(e.getIntendedEndUserRoles(), equalTo(educational.getIntendedEndUserRoles()));
        assertThat(e.getTypicalAgeRanges(), equalTo(educational.getTypicalAgeRanges()));
        assertThat(e.getDidaticStrategy(), equalTo(educational.getDidaticStrategy()));
        assertThat(e.getInteraction().getCoPresence(), equalTo(educational.getInteraction().getCoPresence()));
        assertThat(e.getInteraction().getInteractionType(), equalTo(educational.getInteraction().getInteractionType()));
        assertThat(e.getInteraction().getPerception(), equalTo(educational.getInteraction().getPerception()));
        assertThat(e.getInteraction().getReciprocity(), equalTo(educational.getInteraction().getReciprocity()));
        assertThat(e.getInteraction().getSynchronism(), equalTo(educational.getInteraction().getSynchronism()));
        assertThat(e.getDescriptions(), equalTo(educational.getDescriptions()));
//        assertThat(e.addLanguage("pt-BR");
//        assertThat(e.addContext(Context.SCHOOL);
//        assertThat(e.getDifficulty(Difficulty.EASY);
//        assertThat(e.getSemanticDensity(SemanticDensity.MEDIUM);
//        Duration duration = new Duration();
//        duration.getDuration("23");
//        assertThat(e.getTypicalLearningTime(duration);
//        assertThat(e.addIntendedEndUserRole(IntendedEndUserRolassertThat(e.AUTHOR);
//        assertThat(e.addTypicalAgeRange("14-17");
//        assertThat(e.addDescription("Descr Educ");
//        assertThat(e.addDidaticStrategy(DidaticStrategy.CHALLENGE);
//        Interaction interaction = new Interaction();
//        interaction.getCoPresence(true);
//        interaction.getInteractionType(InteractionTypassertThat(e.OBJECT_INDIVIDUAL);
//        interaction.getPerception(Perception.VISUAL);
//        interaction.getReciprocity(Reciprocity.ONE_N);
//        interaction.getSynchronism(false);
//        assertThat(e.getInteraction(interaction);
//        assertThat(e.getLearningContentType(LearningContentTypassertThat(e.FACTUAL);
    }
}
