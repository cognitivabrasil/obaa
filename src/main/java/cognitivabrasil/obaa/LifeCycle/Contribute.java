/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
package cognitivabrasil.obaa.LifeCycle;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import static cognitivabrasil.util.HelperFunctions.toStringList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

/**
 *
 * <div class="en">
 *
 * Those entities (i.e., people, organizations)that have contributed to the state of this learning object during its
 * life cycle (e.g.,creation, edits, publication).
 *
 * NOTE 1:--This data element is different from Meta-Metadata.Contribute.
 *
 * NOTE 2:--Contributions should be considered in a very broad sense here, as all actions that affect the state of the
 * learning object.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
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
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Contribute {

    @Element
    private Role role;

    @ElementList(inline = true, required = false)
    private List<Entity> entity;

    @Namespace(reference = "http://ltsc.ieee.org/xsd/LOM")
    @Element(required = false)
    private LifeCycleDate date;

    public Contribute() {
        entity = new ArrayList<>();
        role = new Role();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(String role) {
        this.role = new Role();
        this.role.validate(role);
        this.role.setText(role);
    }

    public Role getRole() {
        return role;
    }

    public void setDate(String date) {
        this.date = new LifeCycleDate();
        this.date.setText(date);
    }

    public void setDate(LifeCycleDate date) {
        this.date = date;
    }

    /**
     *
     * <div class="en">
     * The identification of and information about entities (i.e., people, organizations) contributing to this learning
     * object. The entities shall be ordered as most relevant first
     *
     * according to IEEE LOM http://ltsc.ieee.org/
     * </div>
     * <div class="br">
     *
     * Adaptado de http://www.portalobaa.org/
     * </div>
     *
     * @param entity
     */
    public void addEntity(Entity entity) {
        this.entity.add(entity);
    }

    public void addEntity(String entity) {
        Entity e = new Entity();
        e.setText(entity);
        this.entity.add(e);
    }

    public LifeCycleDate getDate() {
        return date;
    }

    @JsonIgnore
    public String getFirstEntity() {
        return entity.get(0).toString();

    }

    public void setEntities(List<Entity> entity) {
        this.entity = entity;
    }

    public List<String> getEntities() {
        return toStringList(entity);
    }

    @JsonIgnore
    public List<Entity> getEntitiesReal() {
        return entity;
    }

    @JsonIgnore
    @Deprecated
    /**
     * Should be used getEntities()
     */
    public List<Entity> getEntity() {
        return entity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.role);
        hash = 23 * hash + Objects.hashCode(this.entity);
        hash = 23 * hash + Objects.hashCode(this.date);
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
        final Contribute other = (Contribute) obj;
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

}
