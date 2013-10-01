/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.Accessibility;

import cognitivabrasil.obaa.BooleanElement;
import cognitivabrasil.obaa.ObaaRecursibleElement;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 *
 * <div class="en">
 *
 * according to IMS
 * </div>
 * <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class Equivalent {
    
    @Element (required=false)
    private PrimaryResource primaryResource;
    @ElementList (inline=true,required=false)
    private List<PrimaryFile> primaryFile;
    @Element (required=false)
    private BooleanElement supplementary;
    @Element (required=false)
    private Content content;
    
    public Equivalent() {
        primaryResource = new PrimaryResource();
        primaryFile = new ArrayList<PrimaryFile>();
        content = new Content();
        
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setPrimaryFile(List<PrimaryFile> primaryFile) {
        this.primaryFile = primaryFile;
    }

    public void setSupplementary(boolean supplementaty) {
        if (this.supplementary == null) {
            this.supplementary = new BooleanElement();
        }
        this.supplementary.setBoolean(supplementaty);
    }

    public Content getContent() {
        return content;
    }

    public List<PrimaryFile> getPrimaryFile() {
        return primaryFile;
    }

    public void addPrimaryFile(PrimaryFile primaryFile){
        this.primaryFile.add(primaryFile);
    }

    public String getSupplementaryTxt(){
        if(supplementary == null) {
            return null;
        }
        else {
            return supplementary.getTranslated();
        }
    }
    
    public boolean isSupplementary(){
        return supplementary.getBoolean();
    }

    public String getPrimaryResource() {
        return primaryResource.getTranslated();
    }

    public void setPrimaryResource(PrimaryResource primaryResource) {
        this.primaryResource = primaryResource;
    }
    
}
