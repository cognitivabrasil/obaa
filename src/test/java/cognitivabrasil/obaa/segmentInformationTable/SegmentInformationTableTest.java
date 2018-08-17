/*
 * Copyright (c) 2018 Cognitiva Brasil Tecnologias Educacionais
 * http://www.cognitivabrasil.com.br - contato@cognitivabrasil.com.br
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 * In no event shall the author be liable for any claim or damages.
 *
 * Todos os direitos reservados.
 */
package cognitivabrasil.obaa.segmentInformationTable;

import cognitivabrasil.obaa.SegmentInformationTable.SegmentGroupInformation;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentGroupList;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformation;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentInformationTable;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentList;
import cognitivabrasil.obaa.SegmentInformationTable.SegmentMediaType;
import cognitivabrasil.obaa.SegmentInformationTable.Segments;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class SegmentInformationTableTest {

    private String json;
    private SegmentInformationTable sit;

    @Before
    public void init() {
        json = "{\"segmentList\":[{"
                + "\"segmentInformation\":[{\"identifier\":\"1\",\"title\":\"tubarão\",\"description\":\"aparece um tubarão na cena\", \"keywords\":[\"cena\",\"tubarão\"], \"end\":\"00:15\", \"start\":\"00:10\", \"segmentMediaType\":\"document\"}] }],"
                + "\"segmentGroupList\":{\"segmentGroupInformation\":[{\"keywords\":[\"sgiKey\"],\"description\":\"sgiDesc\",\"groupType\":\"sgiGrpt\",\"identifier\":\"sgiId\",\"title\":\"sgiTitle\",\"segments\":{\"identifier\": [\"SegmentsID\"]} }]}"
                + "}";
        sit = new SegmentInformationTable();
        SegmentList segmentList = new SegmentList();
        SegmentInformation si = new SegmentInformation();

        si.setIdentifier("1");
        si.setTitle("tubarão");
        si.setDescription("aparece um tubarão na cena");
        si.addKeyword("cena");
        si.addKeyword("tubarão");
        si.setEnd("00:15");
        si.setStart("00:10");
        si.setSegmentMediaType(SegmentMediaType.fromText(SegmentMediaType.DOCUMENT));
        segmentList.addSegmentList(si);
        sit.addSegmentList(segmentList);
        SegmentGroupList segmentGroupList = new SegmentGroupList();
        SegmentGroupInformation sgi = new SegmentGroupInformation();
        sgi.addKeyword("sgiKey");
        sgi.setDescription("sgiDesc");
        sgi.setGroupType("sgiGrpt");
        sgi.setIdentifier("sgiId");
        sgi.setTitle("sgiTitle");
        Segments segments = new Segments();
        segments.addIdentifier("SegmentsID");
        sgi.setSegments(segments);
        segmentGroupList.addSegmentGroupInformation(sgi);
        sit.setSegmentGroupList(segmentGroupList);
    }

    @Test
    public void serializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(sit);
        JSONAssert.assertEquals(json, jsonResult, JSONCompareMode.STRICT);
    }

    @Test
    public void deserializeJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SegmentInformationTable result = mapper.readValue(json, SegmentInformationTable.class);
        assertThat(result, equalTo(sit));
    }
}
