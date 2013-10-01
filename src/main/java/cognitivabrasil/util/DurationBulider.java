/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.util;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class DurationBulider {
    
    private int years, months, days, hours, minutes, seconds;

    public DurationBulider() {
        years = -1;
        months = -1;
        days = -1;
        hours = -1;
        minutes = -1;
        seconds = -1;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
    public String bulid(){
        StringBuilder buf = new StringBuilder();

        buf.append('P');

        if (years != -1) {
            buf.append(years).append('Y');
        }
        if (months != -1) {
            buf.append(months).append('M');
        }
        if (days != -1) {
            buf.append(days).append('D');
        }

        if (hours != -1 || minutes != -1 || seconds != -1) {
            buf.append('T');
            if (hours != -1) {
                buf.append(hours).append('H');
            }
            if (minutes != -1) {
                buf.append(minutes).append('M');
            }
            if (seconds != -1) {
                buf.append(seconds).append('S');
            }
        }
        return buf.toString();        
    }
    
    
}
