/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Accessibility.Accessibility;
import cognitivabrasil.obaa.Annotation.Annotation;
import cognitivabrasil.obaa.Classification.Classification;
import cognitivabrasil.obaa.Educational.Educational;
import cognitivabrasil.obaa.General.General;
import cognitivabrasil.obaa.General.Identifier;
import cognitivabrasil.obaa.LifeCycle.LifeCycle;
import cognitivabrasil.obaa.Metametadata.Metametadata;
import cognitivabrasil.obaa.Relation.Relation;
import cognitivabrasil.obaa.Rights.Rights;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformationTable;
import cognitivabrasil.obaa.Technical.Technical;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rits.cloning.Cloner;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import metadata.TextElement;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
/*
 * TODO: Usar um gerador de código
 */
@Root(name = "obaa:obaa", strict = false)
@NamespaceList({
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa"),
    @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi")})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OBAA implements Cloneable {

    private static final Logger LOG = LoggerFactory.getLogger(OBAA.class);

    @Attribute(name = "xsi:schemaLocation", empty = "http://ltsc.ieee.org/xsd/LOM http://ltsc.ieee.org/xsd/obaav1.0/lom.xsd", required = false)

    // não é muito elegante, mas funciona.
    private String xsiSchema;
    private String locale;
    @Element(required = false)
    private General general;
    @Element(required = false)
    private LifeCycle lifeCycle;
    @Element(required = false)
    private Rights rights;
    @Element(required = false)
    private Educational educational;
    @Element(required = false)
    private Technical technical;
    @Element(required = false)
    private Metametadata metametadata;
    @ElementList(required = false, inline = true)
    private List<Relation> relations;
    @ElementList(required = false, inline = true)
    private List<Annotation> annotations;
    @ElementList(required = false, inline = true)
    private List<Classification> classifications;
    @Element(required = false)
    private Accessibility accessibility;
    @Element(required = false, name = "segmentInformationTable")
    private SegmentInformationTable segmentInformationTable;

    public OBAA() {
        relations = new ArrayList<>();
        annotations = new ArrayList<>();
        classifications = new ArrayList<>();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return general == null && lifeCycle == null && rights == null
                && educational == null && technical == null
                && metametadata == null && relations.isEmpty()
                && annotations.isEmpty() && classifications.isEmpty()
                && accessibility == null && segmentInformationTable == null;
    }

    /**
     * @param filename OBAA XML file
     * @return {@link OBAAA} object generated by unserializing filename.
     */
    public static OBAA fromFilename(String filename)
            throws FileNotFoundException {
        return fromReader(new InputStreamReader(new FileInputStream(filename),
                Charset.forName("UTF-8")));
    }

    public static OBAA fromString(String s) {
        return fromReader(new StringReader(s));
    }

    public static OBAA fromReader(Reader s) {
        OBAA dc;
        Serializer serializer = new Persister();

        try {
            dc = serializer.read(OBAA.class, s);
        } catch (java.lang.Exception e) {
            throw new ObaaParseException("Error while deserializing OBAA", e);
        }
        return dc;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General g) {
        general = g;
    }

    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    /**
     * @return the rights
     */
    public Rights getRights() {
        return rights;
    }

    /**
     * @param rights the rights to set
     */
    public void setRights(Rights rights) {
        this.rights = rights;
    }

    /**
     * @return the educational
     */
    public Educational getEducational() {
        return educational;
    }

    /**
     * @param educational the educational to set
     */
    public void setEducational(Educational educational) {
        this.educational = educational;
    }

    /**
     * @return the technical
     */
    public Technical getTechnical() {
        if (this.technical == null) {
            return new Technical();
        } else {
            return technical;
        }
    }

    /**
     * @param technical the technical to set
     */
    public void setTechnical(Technical technical) {
        this.technical = technical;
    }

    public Metametadata getMetametadata() {
        return metametadata;
    }

    public void setMetametadata(Metametadata metametadata) {
        this.metametadata = metametadata;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public void addRelation(Relation relation){
        this.relations.add(relation);
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public void addAnnotation(Annotation annotations){
        this.annotations.add(annotations);
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public void addClassification(Classification classification){
        this.classifications.add(classification);
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    public SegmentInformationTable getSegmentInformationTable() {
        return segmentInformationTable;
    }

    public void setSegmentInformationTable(
            SegmentInformationTable segmentsInformationTable) {
        this.segmentInformationTable = segmentsInformationTable;
    }

    @JsonIgnore
    @Deprecated
    public List<String> getTitles() {
        return getGeneral().getTitles();
    }

    @JsonIgnore
    @Deprecated
    public List<String> getKeywords() {
        return getGeneral().getKeywords();
    }

    /**
     *
     * @return {@link String} containing the XML correspondin to the current
     * object.
     * @throws Exception In case a serializing error occurs
     */
    @JsonIgnore
    public String toXml() {
        OutputStream o = new ByteArrayOutputStream();
        Serializer serializer = new Persister();
        // TODO: Better exceptions
        try {
            serializer.write(this, o);
        } catch (Exception e) {
            throw new ObaaParseException("Error while serializing OBAA", e);
        }

        return o.toString();
    }

    /**
     * The metadata that not starts with obaa will be ignored
     *
     * @param myMap
     * @return
     */
    public static OBAA fromHashMap(Map<String, String[]> myMap) {
        OBAA o = new OBAA();
        Object current = o;
        Class currentClass;

        for (String k : myMap.keySet()) {
            LOG.debug("Got key:" + k);

            if (!k.startsWith("obaa")) {
                continue;
            }

            if (myMap.get(k)[0].isEmpty()) {
                LOG.info("Got blank input for key " + k
                        + ", will not create empty field");
                continue;
            }
            String nk = k.replaceAll("obaa.", "");
            currentClass = OBAA.class;

            current = o;

            String fields[] = nk.split("\\.");
            for (String f : fields) {
                String base = f.replaceAll("\\[.+\\]", "");
                String index = f.replaceAll("^[^\\[]*\\[*", "").replaceAll(
                        "\\]*", "");
                Integer i = index.isEmpty() ? null : Integer.parseInt(index);
                LOG.debug("Field name: " + base + " index: " + i
                        + " currentClass:" + currentClass.getName());

                Object fieldValue = null;
                try {
                    if (i == null) {
                        LOG.trace("Checking to see if field is null...");

                        Field field = currentClass.getDeclaredField(base);
                        field.setAccessible(true);

                        Class fieldClass = field.getType();

                        if (fieldClass == String.class) {
                            LOG.debug("Got a string value, setting it to:"
                                    + myMap.get(k)[0]);
                            fieldValue = myMap.get(k)[0];
                            field.set(current, fieldValue);
                        } else {
                            LOG.trace("Field type = " + fieldClass.getName());

                            fieldValue = field.get(current);
                            if (fieldValue == null) {
                                LOG.trace("Is null, creating..");
                                fieldValue = fieldClass.newInstance();
                                field.set(current, fieldValue);
                            }
                            if (fieldValue instanceof TextElement) {
                                String value = myMap.get(k)[0];
                                LOG.trace("Is TextElement, setting value = "
                                        + value);
                                ((TextElement) fieldValue).setText(value);
                            }

                            current = fieldValue;
                            currentClass = fieldClass;
                        }
                    } else {
                        LOG.trace("We got a list ("
                                + base
                                + "), checking if the specific index is null...");
                        Field field = currentClass.getDeclaredField(base);
                        field.setAccessible(true);
                        LOG.trace("Field should now be acessible");
                        assert (current != null);
                        LOG.trace("Current class:"
                                + current.getClass().getName());
                        List l = (List) field.get(current);
                        if (l == null) {
                            l = new ArrayList();
                            field.set(current, l);
                        }

                        LOG.trace("1");
                        fieldValue = null;
                        try {
                            LOG.trace("1");
                            fieldValue = l.get(i);
                            LOG.trace("1");

                        } catch (IndexOutOfBoundsException e) {
                            LOG.trace("No such index, have to create");
                            for (int j = l.size() - 1; j < i; j++) {
                                l.add(null);
                            }
                        }
                        if (fieldValue == null) {
                            Type genericFieldType = field.getGenericType();

                            if (genericFieldType instanceof ParameterizedType) {
                                ParameterizedType aType = (ParameterizedType) genericFieldType;
                                Type[] fieldArgTypes = aType
                                        .getActualTypeArguments();
                                Class fieldClass = (Class) fieldArgTypes[0];
                                LOG.trace("Got class " + fieldClass.getName());
                                fieldValue = fieldClass.newInstance();
                                if (fieldValue instanceof TextElement) {
                                    String value = myMap.get(k)[0];
                                    LOG.trace("Is TextElement, setting value = "
                                            + value);
                                    ((TextElement) fieldValue).setText(value);
                                }
                                currentClass = fieldClass;
                                l.set(i, fieldValue);

                            }

                        }
                        current = fieldValue;
                        currentClass = fieldValue.getClass();
                        LOG.trace("Finished got list...");
                    }

                } catch (SecurityException e) {
                    LOG.error("Erro na reflexão", e);
                } catch (NoSuchFieldException e) {
                    LOG.error("BUG! No such field: " + base + " on class "
                            + currentClass.getName());
                } catch (IllegalAccessException e) {
                    LOG.error("Erro na reflexão", e);
                } catch (InstantiationException e) {
                    LOG.error("Erro na reflexão", e);
                }
            }

        }

        return o;
    }

    @Override
    public OBAA clone() {
        Cloner cloner = new Cloner();
        OBAA clone = cloner.deepClone(this);

        return (clone);
    }

    /**
     * This function will recurse through Obaa objects, calling setLocale on
     * those are a subclass of TextElement
     *
     * @param o
     * @param locale
     */
    private static void setLocaleRecurse(Object o, String locale) {
        Field[] fields = o.getClass().getDeclaredFields();

        // go through all the fields of the object...
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(o);

                if (fieldValue == null) {
                    // if field is null, ignore
                    LOG.debug(field.getName() + " is null...");

                } else if (fieldValue.getClass().isAnnotationPresent(ObaaRecursibleElement.class)) {
                    // if field is some sort of ObaaRecursibleElement, we will call this method recursively

                    LOG.debug(field.getName()
                            + " é ObaaRecursible, fazendo recursão...");
                    setLocaleRecurse(fieldValue, locale);

                } else if (fieldValue instanceof Collection) {
                    /* if its a collection, we have 3 possibilities:
                     1. Its a collection of ObaaRecursible elements -
                     we call this method recursively for each element of the collection
                     2. Its a collection of TextElements -
                     we call setLocale on each element
                     3. Its some other sort of Collection
                     we do nothing */
                    LOG.debug(o + " é Collection");

                    for (Object element : (Collection) fieldValue) {
                        if (element.getClass().isAnnotationPresent(
                                ObaaRecursibleElement.class)) {
                            LOG.debug(field.getName()
                                    + " é ObaaRecursible, fazendo recursão...");
                            setLocaleRecurse(element, locale);
                        } else if (element instanceof TextElement) {
                            LOG.debug(o + " é textelement");
                            ((TextElement) element).setLocale(locale);
                        }
                    }

                } else if (fieldValue instanceof TextElement) {
                    LOG.debug(o + " é textelement");
                    ((TextElement) fieldValue).setLocale(locale);
                } else {
                    LOG.debug(o + " não é TextElement: " + fieldValue.getClass());
                }

            } catch (IllegalArgumentException e) {
                LOG.error("Erro na reflexão", e);

            } catch (IllegalAccessException e) {
                LOG.error("Erro na reflexão", e);
            } catch (SecurityException e) {
                LOG.error("Erro na reflexão", e);
            }
        }
    }

    /**
     * This method sets the language of the object.
     *
     * This will not alter the corresponding XML or internal representation in
     * any way, but will return localized text when the user calls
     * getTranslated() on any element.
     *
     * @param the locale
     */
    public void setLocale(String locale) {
        this.locale=locale;
        setLocaleRecurse(this, locale);
    }

    /**
     * Tests if the document (this) has relation with informed entry.
     *
     * @param entry The entry of document to be compared.
     * @param kind Kind of relation. Use constant of Kind class, i.e:
     * Kind.IS_VERSION_OF
     * @return true if has relation
     */
    public boolean hasRelationWith(String kind, String entry) {
        boolean result = false;
        for (Relation rel : getRelations()) {
            if (rel.getKind().getText().equals(kind)) {
                result = rel.getResource().getIdentifier().contains(new Identifier("URI", entry));
            }
        }
        return result;
    }

    @JsonIgnore
    public List<Identifier> getRelationsWithKind(String Kind){
        List<Identifier> ids = new ArrayList<>();
        for (Relation rel : getRelations()) {
            if (rel.getKind().getText().equals(Kind)) {
                ids.addAll(rel.getResource().getIdentifier());
            }
        }
        return ids;
    }

    /**
     * Generates a JSON from obaa object. To translate the json content, the obaa locale must be set.
     * The JSON is generated in this format:
     * [{"label":"Node name","children":[{"label":"Node name","children":[{"label":"Grê
     *
     * @return String in json format.
     */
    @JsonIgnore
    public String getJson() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
//        JsonGenerator generator = new JsonGenerator(locale);
//        return generator.getJson(this);
    }
}
