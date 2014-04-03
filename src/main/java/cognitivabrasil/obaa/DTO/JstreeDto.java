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
public class JstreeDto {
 
    
    String text;
    List<JstreeDto> children;
        
    public JstreeDto(String text, List<JstreeDto> children) {
        this.text = text;
        this.children = children;
    }
    
    public JstreeDto(String text, JstreeDto children) {
        this.text = text;
        this.children = new ArrayList<JstreeDto>();
        this.children.add(children);
    }
    
    public JstreeDto(String text) {
        this.text = text;
    }
    
    public JstreeDto(String text, String children) {
        this.text = text;
        this.children = new ArrayList<JstreeDto>();
        this.children.add(new JstreeDto(children));
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<JstreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<JstreeDto> children) {
        this.children = children;
    }
    
    public void addChildren(JstreeDto children){
        if(this.children ==null){
            this.children = new ArrayList<JstreeDto>();
        }
        this.children.add(children);
    }
    
}
