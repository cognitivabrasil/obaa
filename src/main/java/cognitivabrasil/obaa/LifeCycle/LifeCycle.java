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
package cognitivabrasil.obaa.LifeCycle;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * This category describes the history and current state of this learning object
 * and those entities that have affected this learning object during its
 * evolution.
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LifeCycle {

    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private Status status;
    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private String version;
    @ElementList(required = false, inline = true)
    private List<Contribute> contribute;

    public LifeCycle() {

        contribute = new ArrayList<>();

        //Status should not be initialized to avoid create a blank element in the XML
    }

    /**
     * @return the status
     */
    public String getStatus() {
        if (status == null) {
            return null;
        } else {
            return status.getTranslated();
        }
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = new Status();
        this.status.validate(status);
        this.status.setText(status);
    }

    /**
     * @return the version
     */
    public String getVersion() {
        if (version == null) {
            return null;
        } else {
            return version;
        }
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public void setContribute(List<Contribute> l) {
    	contribute = l;
    }

    public void addContribute(Contribute c) {
    	if(contribute == null) {
    		contribute = new ArrayList<Contribute>();
    	}
    	contribute.add(c);
    }

    public List<Contribute> getContribute() {
        return contribute;
    }
}

