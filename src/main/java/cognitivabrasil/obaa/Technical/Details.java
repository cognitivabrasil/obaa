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
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import org.simpleframework.xml.Element;

/**
 *
 * <div class="en">
 *
 * according to IEEE LOM http://ltsc.ieee.org/ </div> <div class="br">
 *
 * Adaptado de http://www.portalobaa.org/ </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@ObaaRecursibleElement
public class Details {

    //Especificação de detalhes do serviço fora do escopo de metadados (ex.: parâmetros).
    @Element(required=false)
    private String details;

    //A URL, URI ou qualquer outra especificação para acessar o serviço. (relacionado ao item 4.3 do IEEE-LOM).
    @Element(required=false)
    private String serviceLocation;

    public Details() {
    }

    public Details(String details, String serviceLocation) {
        this.details = details;
        this.serviceLocation = serviceLocation;
    }

    public void setDetails(String description) {
        this.details=description;
    }

    public String getDetails() {
        return this.details;
    }

    public void setServiceLocation(String serviceLocation) {
        this.serviceLocation= serviceLocation;
    }

    public String getServiceLocation() {
       return serviceLocation;
    }
}
