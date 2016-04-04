/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
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

package cognitivabrasil.obaa.Classification;

import cognitivabrasil.obaa.Educational.Description;
import cognitivabrasil.obaa.General.Keyword;
import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.util.HelperFunctions;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 *
 * This category describes where this learning object falls within a particular
 * classification system. To define multiple classifications, there may be
 * multiple instances of this category.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 *</div>
 *
 * <div class="br">
 *
 *
 * Adaptado de http://www.portalobaa.org
 *</div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root
@ObaaRecursibleElement
public class Classification {
    @Element (required = false)
    private Purpose purpose;

    @ElementList (inline = true, required = false)
    private List <TaxonPath> taxonPath;

    @Element (required = false)
    private Description description;

    @ElementList (inline = true, required = false)
    private List<Keyword> keywords;

    public Classification() {
        this.description = new Description();
        purpose = new Purpose();
        keywords = new ArrayList<Keyword>();
        taxonPath = new ArrayList<TaxonPath>();

    }

    public void setPurpose(Purpose purpose) {
      this.purpose = purpose;
    }
    public void setPurpose(String purpose) {
        this.purpose.setText(purpose);
    }
    public String getPurpose() {
        return purpose.getTranslated();
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = new Description(description);
    }

    public String getDescription() {
        return description.getTranslated();
    }


    public void setTaxonPath(List<TaxonPath> taxonPath) {
        this.taxonPath = taxonPath;
    }
    public List<TaxonPath> getTaxonPath(){
        return taxonPath;

    }
    public void addTaxonPath (TaxonPath newTaxonPath){
        this.taxonPath.add(newTaxonPath);
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return HelperFunctions.toStringList(this.keywords);
    }

    public void addKeyword(String keyword) {
        this.keywords.add(new Keyword(keyword));
    }

}
