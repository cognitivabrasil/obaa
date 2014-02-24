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
    public static final String AMERICAN_ASL= "American-ASL";
        public static final String AUSTRALIAN_AUSLAN= "Australian-Auslan";
        public static final String AUSTRIAN_ASQ= "Austrian-ASQ";
        public static final String BRASILIAN_LIBRAS= "Brasilian-LIBRAS";
        public static final String BRITISH_BSL= "British-BSL";
        public static final String DANISH_DSL= "Danish-DSL";
        public static final String FRENCH_LSF= "French-LSF";
        public static final String GERMAN_DGS= "German-DGS";
        public static final String IRISH_ISL= "Irish-ISL";
        public static final String ITALIAN_LIS= "Italian-LIS";
        public static final String JAPANESE_JSL= "Japanese-JSL";
        public static final String MALAYSIAN_MSL= "Malaysian-MSL";
        public static final String MEXICAN_LSM= "Mexican-LSM";
        public static final String NATIVE_AMERICAN= "Native-American";
        public static final String NETHERLANDS_NGT= "Netherlands-NGT";
        public static final String NORWEGIAN_NSL= "Norwegian-NSL";
        public static final String QUEBEC_LSQ= "Quebec-LSQ";
        public static final String RUSSIAN_RSL= "Russian-RSL";
        public static final String SINGAPORE_SLS= "Singapore-SLS";
        public static final String SPANISH_LSE= "Spanish-LSE";
        public static final String SWEDISH_SWL= "Swedish-SWL";
        public static final String OTHER= "other";
        
//        TODO: ver qual é o correto para guarani.
//        http://enflibras.blogspot.com.br/2009/03/urubu-kaapor-lskb.html
//        public static final String GUARANI_KAAPOR= "Guarani-KAAPOR";
        

    public SignLanguage() {
        super();

        this.addTerms(AMERICAN_ASL);
        this.addTerms(AUSTRALIAN_AUSLAN);
        this.addTerms(AUSTRIAN_ASQ);
        this.addTerms(BRASILIAN_LIBRAS);
        this.addTerms(BRITISH_BSL);
        this.addTerms(DANISH_DSL);
        this.addTerms(FRENCH_LSF);
        this.addTerms(GERMAN_DGS);
        this.addTerms(IRISH_ISL);
        this.addTerms(ITALIAN_LIS);
        this.addTerms(JAPANESE_JSL);
        this.addTerms(MALAYSIAN_MSL);
        this.addTerms(MEXICAN_LSM);
        this.addTerms(NATIVE_AMERICAN);
        this.addTerms(NETHERLANDS_NGT);
        this.addTerms(NORWEGIAN_NSL);
        this.addTerms(QUEBEC_LSQ);
        this.addTerms(RUSSIAN_RSL);
        this.addTerms(SINGAPORE_SLS);
        this.addTerms(SPANISH_LSE);
        this.addTerms(SWEDISH_SWL);
        this.addTerms(OTHER);
    }
}
