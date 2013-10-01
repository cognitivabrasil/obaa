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

package cognitivabrasil.obaa.Accessibility;

import metadata.TextElement;

/**
 * <div class="en">
 * Sign Language: Indicates that the described resource contains sign language 
 * alternatives, in the specified language, for text in the referenced primary 
 * resource.
 * 
 * Value Space: AmericanASL, AustralianAuslan, AustrianASQ, BrasilianLIBRAS, 
    BritishBSL,DanishDSL, FrenchLSF, GermanDGS, IrishISL, ItalianLIS, JapaneseJSL,
MalaysianMSL, MexicanLSM, NativeAmerican, NetherlandsNGT, NorwegianNSL, QuebecLSQ,
RussianRSL, SingaporeSLS, SpanishLSE, SwedishSWL or other
 *      
 * according to IMS GLOBAL v1.0 http://www.imsglobal.org/
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
public class SignLanguage extends TextElement{
    

    public SignLanguage() {
        super();
        this.addTerms("American-ASL");
        this.addTerms("Australian-Auslan");
        this.addTerms("Austrian-ASQ");
        this.addTerms("Brasilian-LIBRAS");
        this.addTerms("British-BSL");
        this.addTerms("Danish-DSL");
        this.addTerms("French-LSF");
        this.addTerms("German-DGS");
        this.addTerms("Irish-ISL");
        this.addTerms("Italian-LIS");
        this.addTerms("Japanese-JSL");
        this.addTerms("Malaysian-MSL");
        this.addTerms("Mexican-LSM");
        this.addTerms("NativeAmerican");
        this.addTerms("Netherlands-NGT");
        this.addTerms("Norwegian-NSL");
        this.addTerms("Quebec-LSQ");
        this.addTerms("Russian-RSL");
        this.addTerms("Singapore-SLS");
        this.addTerms("Spanish-LSE");
        this.addTerms("Swedish-SWL");
        this.addTerms("other");
    }
}
