/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
/*
 * OBAA - Agent Based Leanring Objetcs
 *
 * This file is part of Obaa.
 * Obaa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Obaa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Obaa. If not, see <http://www.gnu.org/licenses/>.
 */
package cognitivabrasil.obaa.Educational;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.obaa.Technical.Duration;
import static cognitivabrasil.util.HelperFunctions.toStringList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * This category describes the key educational or pedagogic characteristics of
 * this learning object.
 *
 *
 * NOTE:--This is the pedagogical information essential to those involved in
 * achieving a quality learning experience. The audience for this metadata
 * includes teachers, managers, authors, and learners.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br">
 *
 * Descrição das características educacionais do objeto de aprendizagem.
 *
 * Adaptado de http://www.portalobaa.org </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Educational {

    private static final String NAMESPACE = "http://ltsc.ieee.org/xsd/LOM";

    @Element(required = false)
    private InteractivityType interactivityType;
    /**
     * <div class="en">
     *
     * The degree of interactivity characterizing this learning object.
     * Interactivity in this context refers to the degree to which the learner
     * can influence the aspect or behavior of the learning object.
     *
     * NOTE 1:--Inherently, this scale is meaningful within the context of a
     * community of practice.
     *
     * NOTE 2:--Learning objects with 5.1:Educational.InteractivityType="active"
     * may have a high interactivity level (e.g., a simulation environment
     * endowed with many controls) or a low interactivity level (e.g., a written
     * set of instructions that solicit an activity). Learning objects with
     * 5.1:Educational.InteractivityType="expositive" may have a low
     * interactivity level (e.g., a piece of linear, narrative text produced
     * with a standard word processor) or a medium to high interactivity level
     * (e.g., a sophisticated hyperdocument, with many internal links and
     * views).
     *
     *
     * Value Space: very low, low, medium, high, very high
     *
     * according to IEEE LOM http://ltsc.ieee.org/ </div>
     *
     * <div class="br">
     *
     *
     * Adaptado de http://www.portalobaa.org </div>
     *
     * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
     * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
     * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
     */
    @Namespace(reference = NAMESPACE)
    @Element(required = false)
    private InteractivityLevel interactivityLevel;
    /**
     * <div class="en">
     *
     * The degree of conciseness of a learning object. The semantic density of a
     * learning object may be estimated in terms of its size, span, or --in the
     * case of self-timed resources such as audio or video-- duration. The
     * semantic density of a learning object is independent of its difficulty.
     * It is best illustrated with examples of expositive material, although it
     * can be used with active resources as well.
     *
     * NOTE 1:--Inherently, this scale is meaningful within the context of a
     * community of practice.
     *
     * Value Space: very low, low, medium, high, very high
     *
     * according to IEEE LOM http://ltsc.ieee.org/ </div>
     *
     * <div class="br">
     *
     *
     * Adaptado de http://www.portalobaa.org </div>
     *
     * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
     * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
     * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
     */
    @Namespace(reference = NAMESPACE)
    @Element(required = false)
    private SemanticDensity semanticDensity;
    /**
     * <div class="en">
     *
     * How hard it is to work with or through this learning object for the
     * typical intended target audience.
     *
     * NOTE:--The " typical target audience" can be characterized by data
     * elements 5.6:Educational.Context and 5.7:Educational.TypicalAgeRange.
     *
     * Value Space: very easy, easy, medium, difficult, very difficult
     *
     * according to IEEE LOM http://ltsc.ieee.org/ </div>
     *
     * <div class="br">
     *
     *
     * Adaptado de http://www.portalobaa.org </div>
     *
     * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
     * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
     * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
     */
    @Namespace(reference = NAMESPACE)
    @Element(required = false)
    private Difficulty difficulty;
    /**
     * <div class="en">
     *
     * Approximate or typical time it takes to work with or through this
     * learning object for the typical intended target audience.
     *
     * NOTE:--The " typical target audience" can be characterized by data
     * elements 5.6:Educational.Context and 5.7:Educational.TypicalAgeRange.
     *
     *
     * according to IEEE LOM http://ltsc.ieee.org/ </div>
     *
     * <div class="br">
     *
     *
     * Adaptado de http://www.portalobaa.org </div>
     *
     * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
     * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
     * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
     *
     * não foi feita a verificação de consistência was not made any consistence
     * verification
     */
    @Namespace(reference = NAMESPACE)
    @Element(required = false)
    private Duration typicalLearningTime;
    /**
     * <div class="en">
     *
     * Age of the typical intended user. This data element shall refer to
     * developmental age, if that would be different from chronological age.
     *
     * NOTE 1:--The age of the learner is important for finding learning
     * objects, especially for school age learners and their teachers. When
     * applicable, the string should be formatted as minimum age-maximum age or
     * minimum age-. (NOTE:--This is a compromise between adding three component
     * elements (minimum age, maximum age, and description) and having just a
     * free text field.)
     *
     * NOTE 2:--Alternative schemes for what this data element tries to cover
     * (such as various reading age or reading level schemes, IQ's or
     * developmental age measures) should be represented through the
     * 9:Classification category.
     *
     * Examples: "7-9", "0-5", "15", "18-", ("suitable for children over 7"),
     * ("en","adults only")
     *
     * according to IEEE LOM http://ltsc.ieee.org/ </div>
     *
     * <div class="br">
     *
     *
     * Adaptado de http://www.portalobaa.org </div>
     *
     * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
     * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
     * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
     */
    @ElementList(inline = true, required = false)
    private List<IntendedEndUserRole> intendedEndUserRole;
    @ElementList(inline = true, required = false)
    private List<LearningResourceType> learningResourceType;
    @ElementList(inline = true, required = false)
    private List<TypicalAgeRange> typicalAgeRanges;
    @ElementList(inline = true, required = false)
    private List<Description> description;
    @ElementList(inline = true, required = false)
    private List<Language> language;
    @ElementList(inline = true, required = false)
    private List<Context> contexts;
    @Element(required = false)
    private LearningContentType learningContentType;
    @Element(required = false)
    private Interaction interaction;
    @ElementList(inline = true, required = false)
    private List<DidaticStrategy> didaticStrategy;

    public Educational() {
        this.intendedEndUserRole = new ArrayList<IntendedEndUserRole>();
        this.learningResourceType = new ArrayList<LearningResourceType>();
        this.typicalAgeRanges = new ArrayList<TypicalAgeRange>();
        this.description = new ArrayList<Description>();
        this.language = new ArrayList<Language>();
        this.contexts = new ArrayList<Context>();
        this.didaticStrategy = new ArrayList<DidaticStrategy>();
        //TipicalLearningTime should not be initialized to avoid create a blank element in the XML
    }

    public List<DidaticStrategy> getDidaticStrategy() {
        return didaticStrategy;
    }

    public void addDidaticStrategy(String didaticStrategy) {
        DidaticStrategy ds = new DidaticStrategy();
        ds.setText(didaticStrategy);
        this.didaticStrategy.add(ds);
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public void addContext(String context) {
        Context c = new Context();
        c.setText(context);
        this.contexts.add(c);
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public void addDescription(String description) {
        Description d = new Description(description);
        this.description.add(d);
    }

    public Map<String, String> getIntendedEndUserRoleValues() {
        IntendedEndUserRole i = new IntendedEndUserRole();
        return (i.getMapOfTerms());
    }

    public List<String> getIntendedEndUserRoleAsStrings() {
        return toStringList(intendedEndUserRole);
    }

    public void setIntendedEndUserRole(List<IntendedEndUserRole> intendedEndUserRole) {
        this.intendedEndUserRole = intendedEndUserRole;
    }

    public void addIntendedEndUserRole(String intendedEndUserRole) {
        IntendedEndUserRole i = new IntendedEndUserRole();
        i.setText(intendedEndUserRole);
        this.intendedEndUserRole.add(i);
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public void addLanguage(String language) {
        Language l = new Language(language);
        this.language.add(l);
    }

    public String getLearningContentType() {
        if (learningContentType == null) {
            return null;
        } else {
            return learningContentType.getTranslated();
        }
    }

    public void setLearningContentType(LearningContentType learningContentType) {
        this.learningContentType = learningContentType;
    }

    public void setLearningContentType(String learningContentType) {
        this.learningContentType = new LearningContentType();
        this.learningContentType.setText(learningContentType);
    }

    public List<LearningResourceType> getLearningResourceTypes() {
        return learningResourceType;
    }

    public void addLearningResourceType(String learningResourceType) {
        LearningResourceType l = new LearningResourceType();
        l.setText(learningResourceType);
        this.learningResourceType.add(l);
    }

    public List<String> getIntendedEndUserRoles() {
        return toStringList(intendedEndUserRole);
    }

    public List<String> getDescriptions() {
        return toStringList(description);
    }

    public List<String> getLanguages() {
        return toStringList(language);
    }

    public Map<String, String> getContextValues() {
        Context c = new Context();
        return (c.getMapOfTerms());
    }

    public List<String> getContexts() {
        return toStringList(contexts);
    }

    /**
     * @return the interactivityType
     */
    public String getInteractivityType() {
        if (interactivityType == null) {
            return null;
        }
        return interactivityType.getTranslated();
    }

    /**
     * @param interactivityType the interactivityType to set
     */
    public void setInteractivityType(String interactivityType) {
        this.interactivityType = new InteractivityType();
        this.interactivityType.setText(interactivityType);
    }

    /**
     * @return the interactivityLevel
     */
    public InteractivityLevel getInteractivityLevel() {
        return interactivityLevel;
    }

    /**
     * @param interactivityLevel the interactivityLevel to set
     */
    public void setInteractivityLevel(String interactivityLevel) {
        this.interactivityLevel = new InteractivityLevel();
        this.interactivityLevel.setText(interactivityLevel);
    }

    /**
     * @return the semanticDensity
     */
    public SemanticDensity getSemanticDensity() {
        return semanticDensity;
    }

    /**
     * @param semanticDensity the semanticDensity to set
     */
    public void setSemanticDensity(String semanticDensity) {
        this.semanticDensity = new SemanticDensity();
        this.semanticDensity.setText(semanticDensity);
    }

    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = new Difficulty();
        this.difficulty.setText(difficulty);
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = (difficulty);
    }

    /**
     * @return the typicalLearningTime
     */
    public Duration getTypicalLearningTime() {
        return typicalLearningTime;
    }

    /**
     * @param typicalLearningTime the typicalLearningTime to set
     */
    public void setTypicalLearningTime(Duration typicalLearningTime) {
        this.typicalLearningTime = typicalLearningTime;
    }

    /**
     * @return the typicalAgeRange
     */
    public List<String> getTypicalAgeRanges() {
        return toStringList(typicalAgeRanges);
    }

    /**
     * @param typicalAgeRange the typicalAgeRange to set
     */
    public void setTypicalAgeRanges(List<TypicalAgeRange> typicalAgeRange) {
        this.typicalAgeRanges = typicalAgeRange;
    }

    /**
     * Add a typicalAgeRange in the list.
     * @param typicalAgeRange 
     */
    public void addTypicalAgeRange(String typicalAgeRange){
        typicalAgeRanges.add(new TypicalAgeRange(typicalAgeRange));
    }

    /**
     * @return the learningResourceType
     */
    public List<String> getLearningResourceTypesString() {
        return toStringList(learningResourceType);
    }

    /**
     * @param learningResourceType the learningResourceType to set
     */
    public void setLearningResourceTypes(List<LearningResourceType> learningResourceType) {
        this.learningResourceType = learningResourceType;
    }
}
