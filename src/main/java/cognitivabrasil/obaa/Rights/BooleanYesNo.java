/**
 * *****************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the GNU Lesser Public License v3 which accompanies this
 * distribution, and is available at http://www.gnu.org/licenses/lgpl.html
 * ****************************************************************************
 */
package cognitivabrasil.obaa.Rights;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class BooleanYesNo extends TextElement {

    private static final Logger LOG = LoggerFactory.getLogger(BooleanYesNo.class);
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public BooleanYesNo() {
        super(new ArrayList<>(Arrays.asList(YES, NO)));
    }

    @JsonCreator
    public static BooleanYesNo fromText(String text) {
        BooleanYesNo obj = new BooleanYesNo();
        obj.setText(text);
        return obj;
    }

    public void setBoolean(String val) {

        this.validate(val);
        if (val.equals(YES) || val.equals(TRUE)) {
            setText("yes");
        } else if (val.equals(NO) || val.equals(FALSE)) {
            setText("no");
        }
    }

    public void setBoolean(boolean b) {
        setText(String.valueOf(b));
    }

    public boolean getBoolean() {

        if (this.getText().equals(YES) || this.getText().equals(TRUE)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void validate(String trueorfalse) {
        if (trueorfalse == null) {
            throw new IllegalArgumentException("Null is not a valid value for BooleanYesNo");
        }
        if (!(trueorfalse.equals(YES) || trueorfalse.equals(NO) || trueorfalse.equals(TRUE) || trueorfalse.equals(FALSE))) {
            throw new IllegalArgumentException(
                    "BooleanYesNo must be \"yes\" , \"no\", \"true\" or \"false\". and got: " + trueorfalse);
        }
    }

    @Override
    public String toString() {
        if (!(this.getText().equals(NO)
                || this.getText().equals(YES)
                || this.getText().equals(TRUE)
                || this.getText().equals(FALSE))) {
            LOG.warn("The value must be one of: yes, no, true or false; And got: " + this.getText());
            return this.getText();
        } else {
            return this.getTranslated();
        }
    }
}
