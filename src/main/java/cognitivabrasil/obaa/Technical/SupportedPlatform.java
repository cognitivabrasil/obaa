/** *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ***************************************************************************** */
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

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;

/**
 *
 * <div class="en">
 *
 * according to OBAA http://www.portalobaa.org/
 * </div>
 * <div class="br">
 *
 * Lista de plataformas digitais para as quais o Objeto de Aprendizagem está previsto. Atualmente estão previstos três
 * tipos básicos de plataformas digitais para disponibilização de OAs: Web, DTV e Mobile. Este item não é obrigatório,
 * para manter a compatibilidade com o LOM, mas é recomendado seu preenchimento.
 *
 * Adaptado de http://www.portalobaa.org/
 * </div>
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class SupportedPlatform extends TextElement {

    public static final String MOBILE = "mobile";
    public static final String DTV = "dtv";
    public static final String WEB = "web";

    public SupportedPlatform() {
        super(new ArrayList<>(Arrays.asList(MOBILE,DTV,WEB)));
    }

    /**
     * Build a SupportedPlatform object from a String.
     *
     * @param text This string must be one of constant of this class.
     * @return
     */
    @JsonCreator
    public static SupportedPlatform fromText(String text) {
        SupportedPlatform obj = new SupportedPlatform();
        obj.setText(text);
        return obj;
    }
}
