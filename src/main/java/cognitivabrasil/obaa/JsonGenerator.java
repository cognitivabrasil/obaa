/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.DTO.JstreeDto;
import cognitivabrasil.util.Translate;
import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.util.List;
import metadata.TextElement;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * Generates a JSON from a OBAA object.
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class JsonGenerator {

    private static final Logger log = Logger.getLogger(JsonGenerator.class);
    private final String locale;

    public JsonGenerator(String locale) {
        if (locale == null) {
            this.locale = "";
        } else {
            this.locale = locale;
        }
    }

    public JsonGenerator() {
        this.locale = "";
    }

    /**
     * Walk thru the object OBAA turning it into a JSON
     * @param obj The OBAA object
     * @return String JSON
     */
    public String getJson(OBAA obj) {
        JstreeDto jsTree = new JstreeDto("root");
        createTree(obj, jsTree);
        Gson gson = new Gson();
        return gson.toJson(jsTree.getChildren());
    }

    private void createTree(Object obj, JstreeDto jsRoot) {
        if (obj != null) {

            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Element.class)) {
                    field.setAccessible(true);
                    try {
                        Object fieldObj = field.get(obj);
                        createChildren(fieldObj, field.getName(), jsRoot);
                    } catch (IllegalAccessException i) {
                        log.error("Error getting a object from obaa class", i);
                    }

                } else if (field.isAnnotationPresent(ElementList.class)) {
                    try {
                        field.setAccessible(true);
                        List lista = (List) field.get(obj);
                        for (Object elem : lista) {
                            createChildren(elem, field.getName(), jsRoot);
                        }
                    } catch (IllegalAccessException i) {
                        log.error("Error getting a object from obaa class", i);
                    }
                }
            }
        }
    }

    private void createChildren(Object obj, String fieldName, JstreeDto jsRoot) {
        if (obj != null) {

            //only translate if the locale was informed.
            if (!locale.isEmpty()) {
                fieldName = Translate.translateText(fieldName, locale);
            }

            if (TextElement.class.isAssignableFrom(obj.getClass())) {
                TextElement text = (TextElement) obj;
                jsRoot.addChildren(new JstreeDto(fieldName, text.getTranslated()));
            } else if (String.class.isAssignableFrom(obj.getClass())) {
                String s = (String) obj;
                jsRoot.addChildren(new JstreeDto(fieldName, s));
            } else {
                JstreeDto jsNodo = new JstreeDto(fieldName);
                createTree(obj, jsNodo);
                jsRoot.addChildren(jsNodo);
            }
        }
    }
}
