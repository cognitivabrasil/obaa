/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 *****************************************************************************
 */
package cognitivabrasil.obaa.LifeCycle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class LifeCycleDate extends TextElement {

    public LifeCycleDate() {
        super();
    }

    public LifeCycleDate(String t) {
        super(t);
    }

    @Override
    public String getTranslated() {
        SimpleDateFormat invertido = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat ptBr = new SimpleDateFormat("dd/MM/yyyy");

        Date d = null;

        try {
            d = invertido.parse(getText());
        } catch (ParseException e) {

        }

        if (d == null) {
            return getText();
        } else {
            return ptBr.format(d);
        }
    }
}
