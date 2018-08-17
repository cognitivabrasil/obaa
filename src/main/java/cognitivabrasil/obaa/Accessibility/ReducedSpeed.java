/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
package cognitivabrasil.obaa.Accessibility;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.ObaaRecursibleElement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import org.simpleframework.xml.Element;

/**
 *
 * <div class="en">
 *
 * Indicates that the caption is a reduced rate level caption.
 *
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/ </div> <div
 * class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class ReducedSpeed {

    @Element(required = false)
    private BooleanElement reducedSpeed;
    @Element(required = false)
    private String captionRate;

    private static final int MINVALUE = 1;
    private static final int MAXVALUE = 300;

    public ReducedSpeed() {
    }

    public ReducedSpeed(boolean reducedSpeed, int captionRate) {
        this.reducedSpeed = BooleanElement.fromBoolean(reducedSpeed);
        this.captionRate = Integer.toString(captionRate);
    }

    public void validate(String captionRate) {
        String errorMsg = "Caption rate must be an integer beetween " + MINVALUE + " and " + MAXVALUE;
        int captionRateInt = -1;
        try {
            captionRateInt = Integer.parseInt(captionRate);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(errorMsg, ex);
        }
        if (captionRateInt < MINVALUE || captionRateInt > MAXVALUE) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public void setCaptionRate(String captionRate) {
        if (this.reducedSpeed == null) {
            this.reducedSpeed = new BooleanElement();
        }
        validate(captionRate);

        this.captionRate = captionRate;
        this.reducedSpeed.setBoolean(true);
    }

    @JsonIgnore
    public String getReducedSpeedRate() {
        return (this.captionRate);
    }

    @JsonIgnore
    public String getReducedSpeedTxt() {
        if (reducedSpeed == null) {
            return null;
        } else {
            return reducedSpeed.getTranslated();
        }
    }

    public void setReducedSpeed(boolean reducedSpeed) {
        this.reducedSpeed = BooleanElement.fromBoolean(reducedSpeed);
    }

    public boolean isReducedSpeed() {
        return reducedSpeed.getBoolean();
    }

    public String getCaptionRate() {
        return captionRate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.captionRate);
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
        final ReducedSpeed other = (ReducedSpeed) obj;
        if (!Objects.equals(this.captionRate, other.captionRate)) {
            return false;
        }
        return true;
    }

}
