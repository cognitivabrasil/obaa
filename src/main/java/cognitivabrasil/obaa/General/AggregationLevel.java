/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
package cognitivabrasil.obaa.General;

import java.util.Map;
import java.util.TreeMap;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Text;

/*
 * <div class="en">
 * The functional granularity of this learning object.
 *
 * 1: the smallest level of aggregation, e.g., raw media data or fragments.
 * 2: a collection of level 1 learning objects, e.g., a lesson.
 * 3: a collection of level 2 learning objects, e.g., a course.
 * 4: the largest level of granularity, e.g., a set of courses that lead to a certificate.
 *
 * NOTE 1:--Level 4 objects can contain level 3 objects, or can recursively contain other level 4 objects.
 *
 * according to IEEE LOM http://ltsc.ieee.org/
 * </div>
 *
 * <div class="br">
 *
 *
 * </div>
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Namespace(reference="http://ltsc.ieee.org/xsd/LOM", prefix="obaa")
public class AggregationLevel extends TextElement {

    //@Text(required = false)
    //private int aggregationLevel;
    private static final int MINIMUMVALUE = 1;
    private static final int MAXIMUMVALUE = 4;

    public AggregationLevel() {
    }
  
    /**
     *
     * @param aggregationLevel must be beetween 1 and 4
     * @throws IllegalArgumentException
     */
    public void set(int intVal) {

        if (intVal > MAXIMUMVALUE || intVal < MINIMUMVALUE){
            throw new IllegalArgumentException("Aggregation level must be beetween "+MINIMUMVALUE+" and "+MAXIMUMVALUE+" got value "+intVal);
        }  else{
            this.setText(String.valueOf(intVal));        
        }
    }
    
    @Override
    public Map<String, String> getMapOfTerms() {

        Map<String, String> relation = new TreeMap<String, String>();
        for (int i=MINIMUMVALUE;i<=MAXIMUMVALUE;i++) {
            String a = String.valueOf(i);
            relation.put(a, a);
        }

        return relation;
    }
    
//    public String getAggregationLevel(){        
//        return (String.valueOf(aggregationLevel));
//    }
    
    //needed to be override to not validate de value
    @Override
    public String toString(){
        return (this.getText());
    }
}
