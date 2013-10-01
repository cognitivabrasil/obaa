/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import cognitivabrasil.util.HelperFunctions;
import java.util.ArrayList;

/**
 *
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 */
@Root(name="header", strict=false)
public class Header {
        @Attribute(required=false)
        private String status;
	
	@Element
	private String identifier;

	@Element
	private String datestamp;

	@ElementList(inline=true,required=false)
	private List<SetSpec> setSpec;
	

	Header() {
		super();
                setSpec = new ArrayList<SetSpec>();
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
        
        public boolean isDeleted() {
            if(status == null) {
                return false;
            }
            return status.equals("deleted");
        }

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the datestamp
	 */
	public String getDatestamp() {
		return datestamp;
	}

	/**
	 * @param datestamp the datestamp to set
	 */
	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}
        
        public java.util.Date getTimestamp() {
            	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                 return formatter.parse(datestamp, new ParsePosition(0));

        }
        
	/**
	 * @return the setSpec
	 */
	public List<String> getSetSpec() {
		return HelperFunctions.toStringList(this.setSpec);
	}

	/**
	 * @param setSpec the setSpec to set
	 */
	public void setSetSpec(List<SetSpec> setSpec) {
		this.setSpec = setSpec;
	}

	public void setDatestamp(Date date) {
		setDatestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(date));
	}

}
