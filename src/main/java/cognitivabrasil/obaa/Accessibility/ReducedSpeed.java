/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.Accessibility;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.ObaaRecursibleElement;

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
    
    private static final int MINVALUE=1;
    private static final int MAXVALUE=300;
    

    public ReducedSpeed() {
    }

    public void validate(int captionRate) {
        if (captionRate < MINVALUE || captionRate > MAXVALUE) {
            throw new IllegalArgumentException("Caption rate must be an integer beetween "+MINVALUE+" and "+MAXVALUE);
        }
    }

    public void setCaptionRate(String captionRate) {
        if (this.reducedSpeed == null) {
            this.reducedSpeed = new BooleanElement();
        }
        int c = Integer.parseInt(captionRate);
        validate(c);

        this.captionRate = captionRate;
        this.reducedSpeed.setBoolean(true);
    }

    public String getReducedSpeedRate() {
        return (this.captionRate);
    }

    public String getReducedSpeedTxt() {
        if (reducedSpeed == null) {
            return null;
        } else {
            return reducedSpeed.getTranslated();
        }
    }

    public boolean isReducedSpeed() {
        return reducedSpeed.getBoolean();
    }

    public String getCaptionRate() {
        return captionRate;
    }
}
