/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.General;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * <div class="en">
 * A globally unique label that identifies this
 * learning object.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 *
 * <div class="br">
 * Identificador único do objeto de aprendizagem.
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */

@Root(strict=false)
@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
@ObaaRecursibleElement
public class Identifier {
    @Namespace (reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required=false)
    private String catalog;

    @Namespace (reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required=false)
    private String entry;

    public Identifier() {
    }

    public Identifier(String catalog, String entry) {
        this.catalog = catalog;
        this.entry = entry;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getEntry() {
        return entry;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.catalog != null ? this.catalog.hashCode() : 0);
        hash = 37 * hash + (this.entry != null ? this.entry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Identifier other = (Identifier) obj;
        if ((this.catalog == null) ? (other.catalog != null) : !this.catalog.equals(other.catalog)) {
            return false;
        }
        return !((this.entry == null) ? (other.entry != null) : !this.entry.equals(other.entry));
    }

}
