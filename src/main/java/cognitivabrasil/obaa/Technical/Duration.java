/**
 * *****************************************************************************
 * Copyright (c) 2014 Cognitiva Brasil - Tecnologias educacionais. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
package cognitivabrasil.obaa.Technical;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import metadata.TextElement;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <div class="en">
 *
 * Time a continuous learning object takes when played at intended speed.
 *
 * NOTE:--This data element is especially useful for sounds, movies or animations.
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div>
 *
 *
 * <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Duration extends TextElement {

    private static final Logger log = LoggerFactory.getLogger(Duration.class);

    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    private static final String ERRORMESSAGE = "The Data format must be PThHmMsS where 'h' is the hours, 'm' is the minues and 's' is the seconds.";

    public Duration() {
    }

    /**
     * Create a Duration object from text like: "PT3H15M"
     *
     * @param text Duraction formated
     * @return new Duraction
     */
    @JsonCreator
    public static Duration fromText(String text) {
        Duration d = new Duration();
        d.setText(text);
        return d;
    }

    /**
     *
     * @param value The value of the field
     * @param field The Java Calendar constant that reprensents the field, need to be Calendar.HOUR, Calendar.MINUTE or
     * Calendar.SECOND
     */
    public void set(int value, int field) {
        if (field == Calendar.HOUR) {
            hours = value;
        }
        if (field == Calendar.MINUTE) {
            minutes = value;
        }
        if (field == Calendar.SECOND) {
            seconds = value;
        }

        StringBuilder builder = new StringBuilder("PT");

        if (hours != 0) {
            builder.append(hours);
            builder.append("H");
        }

        if (minutes != 0) {
            builder.append(minutes);
            builder.append("M");
        }

        if (seconds != 0) {
            builder.append(seconds);
            builder.append("S");
        }

        super.setText(builder.toString());
    }

    /**
     * Retorna hora traduzida.
     *
     */
    @Override
    public String getTranslated() {
        if (super.getLanguage().equals("") && super.getCountry().equals("")) {
            return (this.getText());
        }

        if (hours == 0 && minutes == 0 && seconds == 0) {
            setText(super.getText());
        }

        String hourString = "";
        String joinHourMinute = "";
        String minuteString = "";

        if (hours == 1) {
            hourString = "1 hora";
        } else if (hours > 1) {
            hourString = hours + " horas";
        }

        if (minutes > 1) {
            minuteString = minutes + " minutos";
        } else if (minutes == 1) {
            minuteString = "1 minuto";
        }

        if (hours > 0 && minutes > 0) {
            joinHourMinute = " e ";
        }

        return hourString + joinHourMinute + minuteString;
    }

    public String getDuration() {

        return this.getText();
    }

    @Override
    public void setText(String value) {
        String regEx = "P(\\d+Y)?(\\d+M)?(\\d+D)?(T(((\\d+)H)?((\\d+)M)?((\\d+)S)?))?";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;

        matcher = pattern.matcher(value);

        if (matcher.find()) {
            String hourString = matcher.group(7);
            String minuteString = matcher.group(9);
            String secondString = matcher.group(10);

            if (hourString != null) {
                this.set(Integer.valueOf(hourString), Calendar.HOUR);
            }
            if (minuteString != null) {
                this.set(Integer.valueOf(minuteString), Calendar.MINUTE);
            }
//            if(secondString != null) {
//                this.set(Integer.valueOf(secondString), Calendar.SECOND);
//            }
        } else {
            if (!StringUtils.isBlank(value)) {
                log.warn("Não conseguiu fazer parsing da data: {}", value);
            }
        }

    }

    /*
     * Duration aceita no formato:
     * HH: dois digitos para hora;
     * HHh: dois digitos para hora seguidos do caractere h;
     * HHhMM: dois digitos para hora seguidos do caractere h seguidos de minutos;
     * HHhMMmin: dois digitos para hora seguidos do caractere h seguidos de minutos e caracteres 'min';
     * HHhMMminSS: dois digitos para hora seguidos do caractere h seguidos de minutos e caracteres 'min' e dois dígitos de segundos;
     * HHhMMminSSs: o mesmo do anterior, seguido de 's';
     */
    public void setDuration(String durationFormated) {

        if (durationFormated.matches("\\d\\d?")) {
            this.set(Integer.parseInt(durationFormated), Calendar.HOUR);
        }

        if (durationFormated.matches("\\d\\dh")) {
            String h = durationFormated.substring(0, durationFormated.length() - 1);
            this.set(Integer.parseInt(h), Calendar.HOUR);
        }

        if (durationFormated.matches("\\d\\d?h\\d\\d?")) {
            String h = durationFormated.substring(0, durationFormated.indexOf('h'));
            String min = durationFormated.substring(durationFormated.indexOf('h') + 1);

            this.set(Integer.parseInt(h), Calendar.HOUR);
            this.set(Integer.parseInt(min), Calendar.MINUTE);
        }

        if (durationFormated.matches("\\d\\d?h\\d\\d?min")) {
            String h = durationFormated.substring(0, durationFormated.indexOf('h'));
            String min = durationFormated.substring(durationFormated.indexOf('h') + 1, durationFormated.length() - 3);

            this.set(Integer.parseInt(h), Calendar.HOUR);
            this.set(Integer.parseInt(min), Calendar.MINUTE);
        }

        if (durationFormated.matches("\\d\\d?h\\d\\d?min\\d\\d?")) {
            String h = durationFormated.substring(0, durationFormated.indexOf('h'));
            String min = durationFormated.substring(durationFormated.indexOf('h') + 1, durationFormated.indexOf('m'));
            String s = durationFormated.substring(durationFormated.indexOf('n') + 1);
            this.set(Integer.parseInt(h), Calendar.HOUR);
            this.set(Integer.parseInt(min), Calendar.MINUTE);
            this.set(Integer.parseInt(s), Calendar.SECOND);
        }

        if (durationFormated.matches("\\d\\d?h\\d\\d?min\\d\\d?s")) {
            String h = durationFormated.substring(0, durationFormated.indexOf('h'));
            String min = durationFormated.substring(durationFormated.indexOf('h') + 1, durationFormated.indexOf('m'));
            String s = durationFormated.substring(durationFormated.indexOf('n') + 1, durationFormated.length() - 1);
            this.set(Integer.parseInt(h), Calendar.HOUR);
            this.set(Integer.parseInt(min), Calendar.MINUTE);
            this.set(Integer.parseInt(s), Calendar.SECOND);
        }
    }

    @Override
    public void validate(String value) {
        String regEx = "P(\\d+Y)?(\\d+M)?(\\d+D)?(T((\\d+H)?(\\d+M)?(\\d+S)?))?";
        //PT2H4M5S -> is valid, for exemple

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;

        matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + hours;
        result = prime * result + minutes;
        result = prime * result + seconds;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Duration other = (Duration) obj;
        if (hours != other.hours) {
            return false;
        }
        if (minutes != other.minutes) {
            return false;
        }
        if (seconds != other.seconds) {
            return false;
        }
        return true;
    }
}
