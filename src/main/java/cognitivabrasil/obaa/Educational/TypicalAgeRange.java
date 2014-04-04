/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import metadata.TextElement;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * Specific kind of learning object. The most dominant kind shall be first.
 *
 * NOTE:--The vocabulary terms are defined as in the OED:1989 and as used by
 * educational communities of practice.
 *
 * Value Space: exercise, simulation, questionnaire, diagram, figure, graph,
 * index, slide, table, narrative text, exam, experiment, problem statement self
 * assessment, lecture
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class TypicalAgeRange extends TextElement {

    private static Logger log = Logger.getLogger(TypicalAgeRange.class);

    public TypicalAgeRange() {
    }

    public TypicalAgeRange(String typicalAgeRange) {
        setText(typicalAgeRange);
    }

    public void setTypicalAgeRange(String typicalAgeRange) {
        setText(this.parse(typicalAgeRange));
    }

    public String getTypicalAgeRange() {
        return getTranslated();
    }

    /**
     * This method parse the tokens[i], and convert it to an inverval standard.
     * If the tokens[i] could not be parsed a warning is fired and the output is
     * the unparsed data.
     *
     * This method use the Brazilian student ages stablished in 2014 (explained
     * in portugese)
     *
     * Pré-escolar: 0-4 Idade escolar: 4-18 Alfabetização: 4-7 Ensino Infantil:
     * 0-6 Fundamental: 6-15 1ª série: 6-7 2ª série: 7-8 3ª série: 8-9 4ª série:
     * 9-10 5ª série: 10-11 6ª série: 11-12 7ª série: 12-13 8ª série: 13-14 9ª
     * série: 14-15
     *
     * Médio:15-18 1º ano: 15-16 2º ano: 16-17 3º ano: 17-18
     *
     * Superior:18-100
     *
     *
     * The top limit used is 100, but is not neceserly true.
     *
     *
     * font: http://pt.wikipedia.org/wiki/Idade_escolar
     *
     * @param parsed
     * @return
     */
    public String parse(String unparsed) {

        //Textual Parsing
        String parsed = unparsed.replaceAll(" ", "");
        parsed = parsed.toLowerCase();
        parsed = parsed.replaceAll("á|à|â|ã", "a");
        parsed = parsed.replaceAll("é|ê", "e");
        parsed = parsed.replaceAll("ú", "u");
        parsed = parsed.replaceAll("í", "i");
        parsed = parsed.replaceAll("ç", "c");

        //dados que significam XX ou mais
        parsed = parsed.replaceAll("-u", "-100");
        parsed = parsed.replaceAll("acimade", "+");
        parsed = parsed.replaceAll("emdiante", "+");
        parsed = parsed.replaceAll("apartirde", "+");
        parsed = parsed.replaceAll("apartirdos", "+");
        parsed = parsed.replaceAll("apartirdo", "+");
        parsed = parsed.replaceAll("-mais", "+");
        parsed = parsed.replaceAll("oumais", "+");
        parsed = parsed.replaceAll("anosoumais", "+");
        parsed = parsed.replaceAll(">", "+");

        if (parsed.contains("todas") || parsed.contains("todos")
                || parsed.contains("qualquer") || parsed.contains("independedefaixaetaria")
                || parsed.contains("divers") || parsed.contains("naoharestricao")
                || parsed.contains("indefinida")) {
            parsed = "0-100";
        }

        if (parsed.contains("adulto")) {
            parsed = "18-100";
        }

        if (parsed.contains("jovem")) {
            parsed = "15-24";
        }

        if (parsed.contains("pre-escola")) {
            parsed = "0-4";
        }
        if (parsed.contains("escola") && !parsed.contains("pre")) {
            parsed = "4-18";
        }
        if (parsed.contains("alfabetizacao")) {
            parsed = "4-7";
        }
        if (parsed.contains("alfabetizado")) {
            parsed = "7-100";
        }

        if (parsed.contains("infantil")) {
            parsed = "0-6";
        }
        if (parsed.contains("fundamental")) {

            if (parsed.contains("1ano") || parsed.contains("1ºano") || parsed.contains("1ªsérie")|| parsed.contains("1série")) {
                parsed = "6-7";
            } else if (parsed.contains("2ano") || parsed.contains("2ºano") || parsed.contains("2ªsérie")|| parsed.contains("2série")) {
                parsed = "7-8";
            } else if (parsed.contains("3ano") || parsed.contains("3ºano") || parsed.contains("3ªsérie")|| parsed.contains("3série")) {
                parsed = "8-9";
            } else if (parsed.contains("4ano") || parsed.contains("4ºano") || parsed.contains("4ªsérie")|| parsed.contains("4série")) {
                parsed = "9-10";
            } else if (parsed.contains("5ano") || parsed.contains("5ºano") || parsed.contains("5ªsérie")|| parsed.contains("5série")) {
                parsed = "10-11";
            } else if (parsed.contains("6ano") || parsed.contains("6ºano") || parsed.contains("6ªsérie")|| parsed.contains("6série")) {
                parsed = "11-12";
            } else if (parsed.contains("7ano") || parsed.contains("7ºano") || parsed.contains("7ªsérie")|| parsed.contains("7série")) {
                parsed = "12-13";
            } else if (parsed.contains("8ano") || parsed.contains("8ºano") || parsed.contains("8ªsérie")|| parsed.contains("8série")) {
                parsed = "13-14";
            } else if (parsed.contains("9ano") || parsed.contains("9ºano") || parsed.contains("9ªsérie")|| parsed.contains("9série")) {
                parsed = "14-15";
            } else {
                parsed = "6-15";
            }

        }
        if (parsed.contains("medio") || parsed.contains("tecnico")) {

            if (parsed.contains("1ano") || parsed.contains("1ºano") || parsed.contains("1ªsérie")|| parsed.contains("1série")) {
                parsed = "15-16";

            } else if (parsed.contains("2ano") || parsed.contains("2ºano") || parsed.contains("2ªsérie")|| parsed.contains("2série")) {
                parsed = "16-17";
            } else if (parsed.contains("3ano") || parsed.contains("3ºano") || parsed.contains("3ªsérie")|| parsed.contains("3série")) {
                parsed = "17-18";
            } else {
                parsed = "15-18";
            }
        }
        if (parsed.contains("superior") || parsed.contains("universitario") || parsed.contains("graduacao")) {
            parsed = "18-100";
            //verficiar anos
        }


        //Numeric Parsing  

//        System.out.println(parsed);
//        if (parsed.equals("16+")){
//                System.out.println(unparsed);
//            }
        List<String> numbers = getNumbers(parsed);
        
        if (parsed.matches(".*meno.*\\d.*")) {
            parsed = "0-"+numbers.get(0);
        } else if (parsed.matches("\\+\\s*\\d+.*") || parsed.matches("\\d+\\+.*")) {
            parsed = numbers.get(0) + "-100";
        } else if (parsed.matches(".*\\d+\\s*(anos)?\\s*-\\s*\\d+.*") || parsed.matches(".*\\d+\\s*(anos)?\\s*a\\s*\\d+.*")) {
            parsed = numbers.get(0) + "-" + numbers.get(1);
        } else if (parsed.matches("\\d+(anos)?")) {
            parsed = numbers.get(0) + "-" + numbers.get(0);
        } else 
            //teste caso tenha identificado um número mas não entendido a frase e não tenha a palavra série
        if (!numbers.isEmpty() && !parsed.contains("serie")) {
            parsed = numbers.get(0) + "-100";
        }
        //teste caso tenha identificado um número mas não entendido a frase e tenha a palavra série
        if (!numbers.isEmpty() && parsed.contains("serie")) {
            parsed = Integer.parseInt(numbers.get(0)+5) + "-" + Integer.parseInt(numbers.get(0)+6);
        }

         if (!parsed.matches("\\d+-\\d+")){
             log.warn("Could not be possible parse: "+unparsed);
         }
        return parsed;
    }

    private List<String> getNumbers(String unparsed) {

        String[] data = unparsed.split("\\D");
        List<String> list = new ArrayList<String>(Arrays.asList(data));
        list.removeAll(Arrays.asList("", null));

        return list;

    }
}
