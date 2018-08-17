/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cognitivabrasil.obaa.SegmentInformationTable;

import java.util.ArrayList;
import java.util.Arrays;
import metadata.TextElement;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
@Root(strict = false)
@Namespace(reference = "http://ltsc.ieee.org/xsd/LOM", prefix = "obaa")
public class GroupType extends TextElement {

    public static final String HIGHLIGHTS = "highlights";
    public static final String BOOKMARKS = "bookmarks";
    public static final String THEME_GROUP = "theme group";
    public static final String PREVIEW = "preview";
    public static final String ACTIVITIES = "activities";
    public static final String OTHER = "other";

    public GroupType() {
        super(new ArrayList<>(Arrays.asList(HIGHLIGHTS, BOOKMARKS, THEME_GROUP, PREVIEW, ACTIVITIES, OTHER)));
    }

}
