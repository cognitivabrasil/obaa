/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cognitivabrasil.obaa.Technical;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcos Freitas Nunes <marcos@cognitivabrasil.com.br>
 */
public class TechicalTest {
 
    @Test
    public void testGetHttpLocation(){
        Technical tec = new Technical();
        List<Location> locs = new ArrayList<Location>();
        locs.add(new Location("http://marcos.com.br"));
        locs.add(new Location("https://marcos.com.br"));
        tec.setLocation(locs);
        Map<String, Boolean> map = tec.getLocationHttp();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            assertThat(entry.getValue(), equalTo(true));
        }
    }
    @Test
    public void testGetHttpLocationError(){
        Technical tec = new Technical();
        List<Location> locs = new ArrayList<Location>();
        locs.add(new Location("marcos.com.br"));
        locs.add(new Location("tt://marcos.com.br"));
        tec.setLocation(locs);
        Map<String, Boolean> map = tec.getLocationHttp();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            assertThat(entry.getValue(), equalTo(false));
        }
    }
}
