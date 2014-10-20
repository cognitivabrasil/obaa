/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class Translate {

    private static final Logger log = LoggerFactory.getLogger(Translate.class);

    public static final String LANG_PT = "pt";
    public static final String LANG_EN = "en";
    public static final String COUNTRY_BR = "br";
    public static final String COUNTRY_US = "us";
    public static final String PT_BR = "pt-BR";
    public static final String EN_US = "en-US";

    public static String translateToPtBR(String text) {
        return translateText(text, LANG_PT, COUNTRY_BR);
    }

    public static String translateText(String text, String locale){
        String language = "";
        String country = "";
        
        if (locale.contains("-")) {
            String[] parts = locale.split("-");

            language = parts[0];
            country = parts[1];
        }
        if (language.isEmpty() || locale.isEmpty()) {
            throw new IllegalArgumentException("Locale must be passed in the format Language-Country Like: pt-BR, en-US. And was got: '"+locale+"'.");
        }
        return translateText(text, language, country);
    }

    public static String translateText(String text, String language, String country) {
        if (text == null) {
            return "";
        } else {

            try {
                Locale currentLocale;
                ResourceBundle messages;

                currentLocale = new Locale(language, country);

                messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

                return (messages.getString(text));
            } catch (MissingResourceException e) {
                log.info("Can not translate " + text + " " + e);
                return (text);
            }

        }
    }

}
