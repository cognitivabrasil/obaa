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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@JsonInclude(Include.NON_NULL)
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
    @ElementList(inline = true, required = false)
    private List<Thumbnail> thumbnails;

    public General() {
        titles = new ArrayList<>();
        keywords = new ArrayList<>();
        descriptions = new ArrayList<>();
        coverages = new ArrayList<>();
        identifiers = new ArrayList<>();
        languages = new ArrayList<>();
        thumbnails = new ArrayList<>();
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
     * @return the language
     */
    public List<String> getLanguages() {
        return HelperFunctions.toStringList(languages);
    }

    /**
     * @param languages the languages to set
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
        return structure;
    }

    /**
     * @param coverage the coverage to set
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

    public void setTitle(List<Title> title) {
        this.titles = title;
    }

    public List<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public void addThumbnail(Thumbnail thumbnail){
        this.thumbnails.add(thumbnail);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.titles);
        hash = 29 * hash + Objects.hashCode(this.keywords);
        hash = 29 * hash + Objects.hashCode(this.descriptions);
        hash = 29 * hash + Objects.hashCode(this.coverages);
        hash = 29 * hash + Objects.hashCode(this.aggregationLevel);
        hash = 29 * hash + Objects.hashCode(this.identifiers);
        hash = 29 * hash + Objects.hashCode(this.languages);
        hash = 29 * hash + Objects.hashCode(this.structure);
        hash = 29 * hash + Objects.hashCode(this.thumbnails);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final General other = (General) obj;
        if (!Objects.equals(this.titles, other.titles)) {
            return false;
        }
        if (!Objects.equals(this.keywords, other.keywords)) {
            return false;
        }
        if (!Objects.equals(this.descriptions, other.descriptions)) {
            return false;
        }
        if (!Objects.equals(this.coverages, other.coverages)) {
            return false;
        }
        if (!Objects.equals(this.aggregationLevel, other.aggregationLevel)) {
            return false;
        }
        if (!Objects.equals(this.identifiers, other.identifiers)) {
            return false;
        }
        if (!Objects.equals(this.languages, other.languages)) {
            return false;
        }
        if (!Objects.equals(this.structure, other.structure)) {
            return false;
        }
        return Objects.equals(this.thumbnails, other.thumbnails);
    }

}
