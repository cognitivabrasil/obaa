/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package metadata;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a basic implementation of {@link MetadataConversorInterface} using XSLT as the transformation engine. A
 * new conversor receives a XSLT string as input.
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
public class XsltConversor implements MetadataConversorInterface {

    private static Logger log = LoggerFactory.getLogger(TextElement.class);
    private Transformer t;

    /**
     * Instantiates a new xslt conversor.
     *
     * @param xsl The XSLT (as a String) to be used in this conversor. Should be able to convert from the input format
     * to OBAA.
     */
    public XsltConversor(String xsl) {
        // Create a transform factory instance.
        TransformerFactory tfactory = new net.sf.saxon.TransformerFactoryImpl();

        // Create a transformer for the stylesheet.
        try {
            t = tfactory.newTransformer(new StreamSource(new StringReader(xsl)));
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("Erro ao configurar conversor XSLT", e);
        }

    }

    /* (non-Javadoc)
     * @see metadata.MetadataConversorInterface#toObaa(java.lang.String)
     */
    @Override
    public final String toObaa(final String s) {
        // Transform the source XML to System.out.
        StringWriter sw = new StringWriter();
        try {
            t.transform(new StreamSource(new StringReader(s)),
                    new StreamResult(sw));
        } catch (TransformerException e) {
            String msg = "Erro ao realizar a conversão com XSLT";
            log.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        return sw.toString();
    }

    /**
     * Transform the source XML to String.
     *
     * @param inputXmlFile
     * @return
     */
    public String toObaaFromFile(File inputXmlFile) {

        StringWriter sw = new StringWriter();
        StreamSource a = new StreamSource(inputXmlFile);
        StreamResult b = new StreamResult(sw);
        String output;

        try {
            t.transform(a, b);
        } catch (TransformerException e) {
            String msg = "Erro ao realizar a conversão com XSLT";
            log.error(msg, e);
            throw new RuntimeException(msg, e);
        } finally {
            try {
                if (a.getInputStream() != null) {
                    a.getInputStream().close();
                    log.warn("Input Stream não estava sendo fechado");
                }
                
                if (b.getOutputStream() != null) {
                    b.getOutputStream().close();
                    log.warn("Output Stream não estava sendo fechado");
                }
                sw.close();
            } catch (IOException e) {
                log.error("Não foi possível fechar o arquivo XML.", e);
            }
        }
        output = sw.toString();

        return output;
    }
}
