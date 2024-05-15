package Milestone4Tests.SecConverters;

import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DtaSecConverterTest {
    String dataSec1 =
            "65746e45\n" +
                    "6f792072\n" +
                    "69207275\n" +
                    "6765746e\n" +
                    "203a7265\n" +
                    "756f5900\n" +
                    "6e692072\n" +
                    "65676574\n" +
                    "73692072\n" +
                    "45564520\n" +
                    "5900214e\n" +
                    "2072756f\n" +
                    "65746e69\n" +
                    "20726567\n" +
                    "4f207369\n" +
                    "00214444";
    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();

    String dataSec2 =
            "73696854\n" +
                    "20736920\n" +
                    "20202061\n" +
                    "74614409\n" +
                    "614c2061\n" +
                    "2d6c6562\n" +
                    "212f2423\n" +
                    "00000000";
    LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>();

    String dataSec3 = "";
    LinkedHashMap<String, Integer> hm3 = new LinkedHashMap<>();

    @Test
    void setDataSec1() {
        hm1.put("10010000", 0x65746e45);
        hm1.put("10010004", 0x6f792072);
        hm1.put("10010008", 0x69207275);
        hm1.put("1001000c", 0x6765746e);
        hm1.put("10010010", 0x203a7265);
        hm1.put("10010014", 0x756f5900);
        hm1.put("10010018", 0x6e692072);
        hm1.put("1001001c", 0x65676574);
        hm1.put("10010020", 0x73692072);
        hm1.put("10010024", 0x45564520);
        hm1.put("10010028", 0x5900214e);
        hm1.put("1001002c", 0x2072756f);
        hm1.put("10010030", 0x65746e69);
        hm1.put("10010034", 0x20726567);
        hm1.put("10010038", 0x4f207369);
        hm1.put("1001003c", 0x00214444);

        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec1);

        LinkedHashMap<String, Integer> actual_hm = DataSecConverter.data_mem;

        Set<Map.Entry<String, Integer>> hm_entrySet = hm1.entrySet();
        assertEquals(hm1.keySet(), actual_hm.keySet()); // checking keys

        for (Map.Entry<String, Integer> e : hm_entrySet) { // checking values
            String key = e.getKey();
            int v1 = e.getValue();
            int v2 = actual_hm.get(key);
            assertEquals(v1, v2);  // checking vals
        }
    }

    @Test
    void setDataSec2() {
        hm2.put("10010000", 0x73696854);
        hm2.put("10010004", 0x20736920);
        hm2.put("10010008", 0x20202061);
        hm2.put("1001000c", 0x74614409);
        hm2.put("10010010", 0x614c2061);
        hm2.put("10010014", 0x2d6c6562);
        hm2.put("10010018", 0x212f2423);
        hm2.put("1001001c", 0x00000000);


        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec2);

        LinkedHashMap<String, Integer> actual_hm = DataSecConverter.data_mem;

        Set<Map.Entry<String, Integer>> hm_entrySet = hm2.entrySet();
        assertEquals(hm2.keySet(), actual_hm.keySet()); // checking keys

        for (Map.Entry<String, Integer> e : hm_entrySet) { // checking values
            String key = e.getKey();
            int v1 = e.getValue();
            int v2 = actual_hm.get(key);
            assertEquals(v1, v2);  // checking vals
        }
    }


    @Test
    void setDataSec3() {
        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec3);

        LinkedHashMap<String, Integer> actual_hm = DataSecConverter.data_mem;
        assertEquals(new LinkedHashMap<>(), actual_hm);
    }

}