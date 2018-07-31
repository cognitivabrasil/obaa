/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TreeMap;
import org.simpleframework.xml.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class TextElement {

    @Text(required = false)
    private String text;
    private String language;
    private String country;
    @JsonIgnore
    private List<String> listOfTerms;
    private static final Logger log = LoggerFactory.getLogger(TextElement.class);

    public TextElement() {
        language = "";
        country = "";
        listOfTerms = new ArrayList<String>();
    }

    public TextElement(String t) {
        text = t;
        language = "";
        country = "";
        listOfTerms = new ArrayList<String>();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if(language.contains("-")) {
            setLocale(language);
        }
        else {
            this.language = language;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @param locale must be passed in the format Language-Country Like: pt-BR,
     * en-US,
     *
     * or just the language like: pt, en
     */
    public void setLocale(String locale) {

        if (locale.contains("-")) {
            String[] parts = locale.split("-");

            this.setLanguage(parts[0]);
            this.setCountry(parts[1]);
        } else {
            this.setLanguage(locale);
        }
    }

    public void setText(String t) {
        text = t;
    }

    public String getTranslated() {

        if (text == null) {
            return "";
        } else {

            if (language.equals("") && country.equals("")) {
                log.debug("Language not set " + this.getText());
                return (this.getText());
            }

            try {
                Locale currentLocale;
                ResourceBundle messages;

                currentLocale = new Locale(language, country);

                messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

                return (messages.getString(getCanonicalTextForTranslation()));
            } catch (MissingResourceException e) {
                log.debug("Can not translate " + this.getText() + " " + e);
                return (this.getText());
            }

        }
    }

    /**
     * Override this to process text before it is translated.
     *
     * @return the text
     */
    protected String getCanonicalTextForTranslation() {
        return getText();
    }

    public String getText() {
        if (text == null) {
            return "";
        } else {
            return text.trim();
        }
    }


    @JsonValue
    @Override
    public String toString() {
        return getTranslated();
    }

    /**
     * @param t the string that is being passed to the element
     * @param objectClass the name of the class that is calling the method
     * @return true if it is a valid element of the type, false otherwise.
     * @throws IllegalArgumentException if the argument is illegal;
     */
    public void validate(String t) throws IllegalArgumentException{
        if (!getListOfTerms().contains(t)) {

            StringBuilder message = new StringBuilder();
            for (String value : this.listOfTerms) {
                message.append(value);
                message.append(" ");
            }

            throw new IllegalArgumentException(this.className() + " must be one of: " + message);
        }
    }

    /**
     * Use this on the constructor of the subclasses to define the resctrict
     * vocabulary.
     *
     * @param term
     */
    protected void addTerms(String term) {
        this.listOfTerms.add(term);
    }

    public List getListOfTerms() {
        return this.listOfTerms;
    }

    /**
     * Get the map of the canonical value and the translation value in alphabetical order
     * @return
     */
    public Map<String, String> getMapOfTerms() {

        Map<String, String> relation = new TreeMap<String, String>();

        TextElement translation = new TextElement();

        translation.setLanguage(this.getLanguage());
        translation.setCountry(this.getCountry());

        for (String x : this.listOfTerms) {
            translation.setText(x);
            relation.put(x, translation.getTranslated());
        }

        return (TextElement.sortByValues(relation));
    }

    /**
     * Get the map of the canonical value and the translation value in a chosen order
     * like Difficult: 1- very low, 2- low, 3- medium, 4- high and 5- very high
     * @return
     */
    public Map<String, String> getMapOfTermsLevelOrdered() {

        Map<String, String> relation = new LinkedHashMap<String, String>();

        TextElement translation = new TextElement();

        translation.setLanguage(this.getLanguage());
        translation.setCountry(this.getCountry());

        for (String x : this.listOfTerms) {
            translation.setText(x);
            relation.put(x, translation.getTranslated());
        }

        return (relation);
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof TextElement)) {
            return false;
        }

        TextElement other = (TextElement) o;

        if (!this.country.equals(other.getCountry())) {
            return false;
        }

        if (!this.language.equals(other.getLanguage())) {
            return false;
        }

        if (!this.listOfTerms.equals(other.getListOfTerms())) {
            return false;
        }

        if (!this.text.equals(other.getText())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 29 * hash + (this.language != null ? this.language.hashCode() : 0);
        hash = 29 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 29 * hash + (this.listOfTerms != null ? this.listOfTerms.hashCode() : 0);
        return hash;
    }

    public String whoAmI() {

        try {
                Locale currentLocale = new Locale(language, country);
                ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

                return (messages.getString(this.className()+".whoAmI"));

            } catch (MissingResourceException e) {
                log.info("WhoAmI method is not defined for " + this.className() + ": " + e);
                return "";
            }
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {

        Comparator<K> valueComparator;
        valueComparator = new Comparator<K>() {

            @Override
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) {
                    return 1;
                } else {
                    return -compare;
                }
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    private String className (){
        return this.getClass().toString().substring(this.getClass().toString().lastIndexOf(".")+1);
    }

    public String classFullName (){
        //remove a parte: class cognitivabrasil. do nome do método
        String res = this.getClass().toString().substring(22,this.getClass().toString().length());
        res = res.toLowerCase();
        return res;
    }
}
