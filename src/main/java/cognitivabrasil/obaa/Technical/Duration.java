/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.Technical;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import metadata.TextElement;

/**
 *
 * <div class="en">
 *
 * Time a continuous learning object takes when played at intended speed.
 *
 * NOTE:--This data element is especially useful for sounds, movies or
 * animations.
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
public class Duration extends TextElement {

    private int seconds;
    private int minutes;
    private int hours;
    private final static String ERRORMESSAGE = "The Data format must be PThHmMsS where 'h' is the hours, 'm' is the minues and 's' is the seconds.";

    public Duration() {
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    /**
     *
     * @param value The value of the field
     * @param field The Java Calendar constant that reprensents the field, need
     * to be Calendar.HOUR, Calendar.MINUTE or Calendar.SECOND
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

        this.setText(builder.toString());
    }

    public String getDuration() {

        return this.getText();
    }
    
    public void setDuration(String durationFormated){
        this.validate(durationFormated);
        this.setText(durationFormated);
    }

    @Override
    public void validate(String value) {
        String regEx = "P(\\d+Y)?(\\d+M)?(\\d+D)?(T((\\d+H)?(\\d+M)?(\\d+S)?))?";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;

        matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }
    }
}
