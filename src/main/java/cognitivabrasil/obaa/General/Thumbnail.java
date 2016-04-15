/*
 * Copyright (c) 2016 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.General;

import cognitivabrasil.obaa.ObaaRecursibleElement;
import cognitivabrasil.obaa.Technical.Location;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Thumbnail {

    @Element(required = false)
    private Location location;
    @Element(required = false)
    private Height height;
    @Element(required = false)
    private Width width;

    public Thumbnail() {
    }

    public Thumbnail(Location location, Height height, Width width) {
        this.location = location;
        this.height = height;
        this.width = width;
    }

    public Thumbnail(String location, String height, String width) {
        this.location = new Location(location);
        this.height = new Height(height);
        this.width = new Width(width);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Define a altura do thumbnail, esta altura deve ser em pixels.
     *
     * @return
     */
    public Height getHeight() {
        return height;
    }

    /**
     * Define a altura do thumbnail, esta altura deve ser em pixels.
     *
     * @param height Altura do thumbnail. Se for 800px definir 800.
     */
    public void setHeight(Height height) {
        this.height = height;
    }

    /**
     * Retorna a largura em pixel do thumbnail.
     * @return número de pixels
     */
    public Width getWidth() {
        return width;
    }

    /**
     * Define a largura do thumbnail, este valor deve ser um pixels.
     *
     * @param width Largura do thumbnail, inserir apenas o número referente ao número de pixels. Ex: Se for 600px
     * colocar 600.
     */
    public void setWidth(Width width) {
        this.width = width;
    }

}
