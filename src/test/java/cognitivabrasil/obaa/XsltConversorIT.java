/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa;

import java.io.File;
import metadata.XsltConversor;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author preto
 */
public class XsltConversorIT {

    @Test
    public void toObaaFromFile() throws Exception {

        File lomXml = new File("./src/test/metadata/metadatalom.xml");
        
        final String xsl = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<xsl:stylesheet version=\"2.0\"\n"
                + "xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"\n"
                + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
                + "xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n"
                + "xmlns:lom=\"http://ltsc.ieee.org/xsd/LOM\"\n"
                + "xmlns:obaa=\"http://ltsc.ieee.org/xsd/LOM\"\n"
                + "xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\"\n"
                + "xmlns:oai_pmh=\"http://www.openarchives.org/OAI/2.0/\"\n"
                + "exclude-result-prefixes=\"dc\"\n"
                + "xpath-default-namespace=\"http://www.openarchives.org/OAI/2.0/\">\n"
                + " \n"
                + "<xsl:output method=\"xml\" encoding=\"UTF-8\"/>\n"
                + "<xsl:template match=\"/\">\n"
                + "        <xsl:apply-templates/>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"OAI-PMH\">\n"
                + "    <xsl:copy>\n"
                + "        <xsl:apply-templates/>\n"
                + "    </xsl:copy>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"ListRecords\">\n"
                + "    <xsl:copy>\n"
                + "        <xsl:apply-templates/>\n"
                + "    </xsl:copy>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"responseDate\">\n"
                + "    <xsl:copy-of select=\".\"/>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"request\">\n"
                + "    <xsl:copy-of select=\".\"/>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"record\">\n"
                + "    <xsl:copy>\n"
                + "        <xsl:apply-templates/>\n"
                + "    </xsl:copy>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"header\">\n"
                + "    <xsl:copy-of select=\".\"/>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"metadata\">\n"
                + "    <xsl:copy>\n"
                + "        <xsl:apply-templates/>\n"
                + "    </xsl:copy>\n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"lom:lom\">\n"
                + "<obaa:obaa xmlns:obaa=\"http://ltsc.ieee.org/xsd/LOM\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://ltsc.ieee.org/xsd/LOM http://ltsc.ieee.org/xsd/obaav1.0/obaa.xsd\">\n"
                + "    <xsl:apply-templates/>\n"
                + "</obaa:obaa>\n"
                + " \n"
                + "</xsl:template>\n"
                + " \n"
                + "<xsl:template match=\"@*|node()\">\n"
                + "  <xsl:copy>\n"
                + "    <xsl:apply-templates select=\"@*|node()\"/>\n"
                + "  </xsl:copy>\n"
                + "</xsl:template>\n"
                + " \n"
                + "</xsl:stylesheet>";
        
        XsltConversor conversor = new XsltConversor(xsl);
        
        String obaaXml = conversor.toObaaFromFile(lomXml);
        Long lenght = (long) obaaXml.length();
        
        Assert.assertThat(lenght, greaterThan(100L));
    }
}
