/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package cognitivabrasil.obaa.General;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.util.HelperFunctions;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en"> This category groups the general information that describes
 * this learning object as a whole.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 * <div class="br"> Conjunto de metadados gerais.
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
public class General {

    @ElementList(inline = true, required = false)
    private List<Title> titles;
    @ElementList(inline = true, required = false)
    private List<Keyword> keywords;
    @ElementList(inline = true, required = false)
    private List<Description> descriptions;
    @ElementList(inline = true, required = false)
    private List<Coverage> coverages;
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private AggregationLevel aggregationLevel;
    @ElementList(inline = true, required = false)
    private List<Identifier> identifiers;
    @ElementList(inline = true, required = false)
    private List<Language> languages;
    @Element(required = false)
    private Structure structure;

    public General() {
        titles = new ArrayList<Title>();
        keywords = new ArrayList<Keyword>();
        descriptions = new ArrayList<Description>();
        coverages = new ArrayList<Coverage>();
        identifiers = new ArrayList<Identifier>();
        languages = new ArrayList<Language>();
        //Strutcure should not be initialized to avoid create a blank element in the XML 
    }

    //Titles
    @SuppressWarnings("unchecked")
    public void setTitles(List<String> titles) {
        this.titles = (List<Title>) cognitivabrasil.util.HelperFunctions.fromStringList(titles, Title.class);

    }

    public List<String> getTitles() {
        return HelperFunctions.toStringList(titles);
    }

    public void addTitle(String title) {
        this.titles.add(new Title(title));
    }

    public List<String> getDescriptions() {
        return HelperFunctions.toStringList(descriptions);
    }

    public void addDescription(String newDescription) {
        this.descriptions.add(new Description(newDescription));
    }

    public List<String> getCoverages() {
        return HelperFunctions.toStringList(coverages);
    }

    //Keywords
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return HelperFunctions.toStringList(keywords);
    }

    public void addKeyword(String keyword) {
        this.keywords.add(new Keyword(keyword));
    }

    /**
     * @return the aggregationLevel
     */
    public AggregationLevel getAggregationLevel() {
        if (aggregationLevel == null) {
            return null;
        }
        return (aggregationLevel);
    }

    /**
     * @param aggregationLevel the aggregationLevel to set
     */
    public void setAggregationLevel(String aggregationLevel) {
        if (this.aggregationLevel == null) {
            this.aggregationLevel = new AggregationLevel();
        }
        int a = Integer.valueOf(aggregationLevel);
        this.aggregationLevel.set(a);
    }

    /**
     * @param aggregationLevel the aggregationLevel to set
     */
    public void setAggregationLevel(int aggregationLevel) {
        if (this.aggregationLevel == null) {
            this.aggregationLevel = new AggregationLevel();
        }
        this.aggregationLevel.set(aggregationLevel);
    }

    /**
     * @return the identifier
     */
    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> l) {
        identifiers = l;
    }

    public void addIdentifier(Identifier i) {
        this.identifiers.add(i);
    }

    /**
     * Returns the FIRST identifier
     */
    @Deprecated
    public Identifier getIdentifier() {
        return identifiers.get(0);
    }

    /**
     * @return the language
     */
    public List<String> getLanguages() {
        return HelperFunctions.toStringList(languages);
    }

    /**
     * @param language the language to set
     */
    @SuppressWarnings("unchecked")
    public void setLanguage(List<String> languages) {
        this.languages = (List<Language>) HelperFunctions.fromStringList(languages, Language.class);
    }

    public void addLanguage(String language) {
        Language l = new Language(language);
        this.languages.add(l);
    }

    /**
     * @return the structure
     */
    public Structure getStructure() {
        if (structure == null) {
            return null;
        }
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setCoverage(List<Coverage> coverage) {
        this.coverages = coverage;
    }

    public void addCoverage(String coverage) {
        Coverage c = new Coverage(coverage);
        this.coverages.add(c);
    }

    public void setDescription(List<Description> description) {
        this.descriptions = description;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    /**
     * @param structure
     * @deprecated Strcuture deve receber uma strucutre e não um String
     */
    @Deprecated
    public void setStructure(String structure) {
        this.structure.setText(structure);
    }

    public void setTitle(List<Title> title) {
        this.titles = title;
    }
}
