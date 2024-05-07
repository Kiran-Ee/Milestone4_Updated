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
    LinkedHashMap<String, String> hm1 = new LinkedHashMap<>();

    String dataSec2 =
            "73696854\n" +
                    "20736920\n" +
                    "20202061\n" +
                    "74614409\n" +
                    "614c2061\n" +
                    "2d6c6562\n" +
                    "212f2423\n" +
                    "00000000";
    LinkedHashMap<String, String> hm2 = new LinkedHashMap<>();

    String dataSec3 = "";
    LinkedHashMap<String, String> hm3 = new LinkedHashMap<>();

    @Test
    void setDataSec1() {
        hm1.put("10010000", "Enter your integer: ");
        hm1.put("10010015", "Your integer is EVEN!");
        hm1.put("1001002b", "Your integer is ODD!");

        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec1);

        LinkedHashMap<String, String> actual_hm = DataSecConverter.data_mem;

        Set<Map.Entry<String, String>> hm_entrySet = hm1.entrySet();
        assertEquals(hm1.keySet(), actual_hm.keySet()); // checking keys

        for (Map.Entry<String, String> e : hm_entrySet) { // checking values
            String key = e.getKey();
            String v1 = e.getValue();
            String v2 = actual_hm.get(key);
            assertEquals(v1, v2);  // checking vals
        }
    }

    @Test
    void setDataSec2() {
        hm2.put("10010000", "This is a   \tData Label-#$/!");
        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec2);

        LinkedHashMap<String, String> actual_hm = DataSecConverter.data_mem;

        Set<Map.Entry<String, String>> hm_entrySet = hm2.entrySet();
        assertEquals(hm2.keySet(), actual_hm.keySet()); // checking keys

        for (Map.Entry<String, String> e : hm_entrySet) { // checking values
            String key = e.getKey();
            String v1 = e.getValue();
            String v2 = actual_hm.get(key);
            assertEquals(v1, v2);  // checking vals
        }
    }


    @Test
    void setDataSec3() {
        DataSecConverter.data_mem = new LinkedHashMap<>(); // restarting variable

        DataSecConverter.dataSec_Converter(dataSec3);

        LinkedHashMap<String, String> actual_hm = DataSecConverter.data_mem;
        assertEquals(new LinkedHashMap<>(), actual_hm);
    }

}