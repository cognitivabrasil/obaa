/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
package cognitivabrasil.obaa.Technical;

import cognitivabrasil.util.MimeType;
import metadata.TextElement;

import org.simpleframework.xml.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class Format extends TextElement {

    MimeType mimeType;
    private static final Logger log = LoggerFactory.getLogger(Format.class);
    String category;

    public Format() {
        super();
        mimeType = new MimeType();
    }

    public Format(String t) {
        super(t);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public void setText(String format) {

//        if (format.equals("jpg")) {
//            System.out.println("!!!!!");
//        }

        format = format.toLowerCase();
        format = format.replaceAll("imagem", "image");
        
        String mime = mimeType.getMimeType(format);
        if (mime == null) {
            log.warn("Mime Type não identificado.");

            if (format.matches(".*\\[?\\d+\\]?\\s*(f|p|v)\\.\\s*.*")) {
                this.setCategory("text");
                super.setText("application/pdf");                
                
            } else if (format.contains("flash")){
                this.setCategory("application");
                super.setText("application/x-shockwave-flash");                
            }
            else {                
                super.setText(format);
                log.warn("Não foi possível interpretar o mime type.");
                
                if (format.contains("video")){
                    this.setCategory("video");
                } 
                else if (format.contains("image")||format.contains("imagem")) {
                    this.setCategory("image");
                }
                  else if (format.contains("text")||format.contains("texto")||format.contains("descritivo")) {
                    this.setCategory("text");
                }
                  else if (format.contains("application")||format.contains("aplicação")||format.contains("swf")
                          ||format.contains("fla")||format.contains("scorm")||format.contains("javascript")) {
                    this.setCategory("application");
                }  
                  else if (format.contains("audio")) {
                    this.setCategory("audio");
                }   
            }

        } else {
            this.setCategory(mime.substring(0, mime.indexOf("/")));
            super.setText(mime);
        }
        
    }
}
