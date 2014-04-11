/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cognitivabrasil.obaa.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class JsonDto {
 
    
    String label;
    List<JsonDto> children;
    String value;
        
    public JsonDto(String label, List<JsonDto> children) {
        this.label = label;
        this.children = children;
    }
    
    public JsonDto(String label, JsonDto children) {
        this.label = label;
        this.children = new ArrayList<JsonDto>();
        this.children.add(children);
    }

    public JsonDto(String label, String value) {
        this.label = label;
        this.value = value;
    }
        
    public JsonDto(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String text) {
        this.label = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<JsonDto> getChildren() {
        return children;
    }

    public void setChildren(List<JsonDto> children) {
        this.children = children;
    }
    
    public void addChildren(JsonDto children){
        if(this.children ==null){
            this.children = new ArrayList<JsonDto>();
        }
        this.children.add(children);
    }      
}