/*******************************************************************************
 * Copyright (c) 2013 Cognitiva Brasil - Tecnologias educacionais.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 ******************************************************************************/
/**
 *
 */
package cognitivabrasil.obaa.Technical;

import static cognitivabrasil.util.HelperFunctions.toStringList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import cognitivabrasil.obaa.ObaaRecursibleElement;

/**
 * @author Luiz Rossi <lh.rossi@cognitivabrasil.com.br>
 * @author Marcos Nunes <marcos@cognitivabrasil.com.br>
 * @author Paulo Schreiner <paulo@cognitivabrasil.com.br>
 *
 * Stub implementation, only implemented the location subfield.
 *
 *
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
@ObaaRecursibleElement
public class Technical {

    @ElementList(required = false, inline = true)
    private List<Location> location;
    @ElementList(required = false, inline = true)
    private List<Format> format;
    @Element(required = false)
    private Size size;
    @ElementList(required = false, inline = true)
    private List<Requirement> requirement;
    @Element(required = false)
    private InstallationRemarks installationRemarks;
    @Element(required = false)
    private OtherPlatformRequirements otherPlatformRequirements;
    @Element(required = false)
    private Duration duration;
    @ElementList(required = false, inline = true)
    private List<SupportedPlatform> supportedPlatforms;
    @ElementList(required = false, inline = true)
    private List<PlatformSpecificFeature> platformSpecificFeatures;
    @ElementList(required = false, inline = true)
    private List<Service> service;

    public Technical() {
        location = new ArrayList<Location>();
        format = new ArrayList<Format>();
        requirement = new ArrayList<Requirement>();
        supportedPlatforms = new ArrayList<SupportedPlatform>();
        platformSpecificFeatures = new ArrayList<PlatformSpecificFeature>();
        service = new ArrayList<Service>();
        //Duration não deve ser iniciailizado, pois assim geraria um elemento no XML, mesmo que ele não exista
        // duration = new Duration();
    }

    /**
     * @return the first location that starts with http://, null otherwise
     */
    public String getFirstHttpLocation() {
        for (Location l : location) {
            if (l.getText().startsWith("http://")) {
                return l.getText();
            }
        }
        return null;
    }

    /**
     * Convenience method to add a new location
     *
     * @param location to add
     */
    public void addLocation(String location) {
        if (this.location == null) {
            this.location = new ArrayList<Location>();
        }
        this.location.add(new Location(location));
    }

    /**
     * @param location the location to set
     */
    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<String> getLocation() {
        return toStringList(location);
    }

    /**
     * Test if the location is a link, and returns a Map<String,Boolean>, where
     * the boolean tells whether or not a link.
     *
     * @return locations in the key and in value true if a link and false
     * otherwise
     */
    public Map<String, Boolean> getLocationHttp() {
        Map<String, Boolean> locationhttp = new HashMap<String, Boolean>();
        for (String loc : getLocation()) {
            locationhttp.put(loc, loc.startsWith("http:"));
        }
        return locationhttp;
    }

    public List<String> getFormat() {
        if (format == null) {
            return null;
        } else {
            return toStringList(format);
        }
    }

    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public void addFormat(String format) {
        Format f = new Format(format);
        this.format.add(f);
    }

    public String getInstallationRemarks() {
        if (installationRemarks == null) {
            return null;
        } else {
            return installationRemarks.getTranslated();
        }
    }

    public void setInstallationRemarks(InstallationRemarks installationRemarks) {
        this.installationRemarks = installationRemarks;
    }

    public String getOtherPlatformRequirements() {
        if (otherPlatformRequirements == null) {
            return null;
        } else {
            return otherPlatformRequirements.getTranslated();
        }
    }

    public void setOtherPlatformRequirements(OtherPlatformRequirements otherPlatformRequirements) {
        this.otherPlatformRequirements = otherPlatformRequirements;
    }

    public void setOtherPlatformRequirements(String otherPlatformRequirements) {
        this.otherPlatformRequirements = new OtherPlatformRequirements(otherPlatformRequirements);
    }

    public String getSize() {
        if (size == null) {
            return null;
        } else {
            return size.getTranslated();
        }
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSize(int size) {
        this.size = new Size(Integer.toString(size));
    }

    public String getDuration() {
        if (duration == null) {
            return null;
        } else {
            return duration.getTranslated();
        }
    }

    public void setDuration(String duration) {
        this.duration.setText(duration);
    }

    public List<PlatformSpecificFeature> getPlatformSpecificFeatures() {
        return platformSpecificFeatures;
    }

    public void setPlatformSpecificFeature(List<PlatformSpecificFeature> platformSpecificFeatures) {
        this.platformSpecificFeatures = platformSpecificFeatures;
    }

    public void addPlatformSpecificFeature(PlatformSpecificFeature platformSpecificFeatures) {
        this.platformSpecificFeatures.add(platformSpecificFeatures);
    }

    public List<Requirement> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<Requirement> requirement) {
        this.requirement = requirement;
    }

    public void addRequirement(Requirement requirement) {
        this.requirement.add(requirement);
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public void addSupportedPlatforms(String supportedPlatform) {
        SupportedPlatform s = new SupportedPlatform();
        s.setText(supportedPlatform);
        this.supportedPlatforms.add(s);

    }

    Map<String, String> getSupportedPlatformValues() {
        SupportedPlatform s = new SupportedPlatform();
        return (s.getMapOfTerms());
    }

    public List<String> getSupportedPlatforms() {

        return toStringList(supportedPlatforms);
    }

    public void setSupportedPlatforms(List<SupportedPlatform> supportedPlatforms) {
        this.supportedPlatforms = supportedPlatforms;
    }
}
