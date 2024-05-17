package Milestone4Tests.SecConverters;

import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AddressToLabelTest {

    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();
    String hm1_exp_lbl1 = "Enter your integer: ";
    String hm1_exp_lbl2 = "Your integer is EVEN!";
    String hm1_exp_lbl3 = "Your integer is ODD!";

    String hm1_start_addr_1 = "10010000";
    String hm1_start_addr_2 = "10010015";
    String hm1_start_addr_3 = "1001002b";


    LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>();
    String hm2_exp_lbl1 = "This is a   	Data Label-#$/!";

    String hm2_starting_addr_1 = "10010000";


    LinkedHashMap<String, Integer> hm3 = new LinkedHashMap<>();
    String hm3_exp_lbl1 = "";

    String hm3_starting_addr_1 = "10010000";

    @BeforeEach
    public void setUp() {
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

        hm2.put("10010000", 0x73696854);
        hm2.put("10010004", 0x20736920);
        hm2.put("10010008", 0x20202061);
        hm2.put("1001000c", 0x74614409);
        hm2.put("10010010", 0x614c2061);
        hm2.put("10010014", 0x2d6c6562);
        hm2.put("10010018", 0x212f2423);
        hm2.put("1001001c", 0x00000000);

        // hm3 empty
    }

    @Test
    void hm1_label1() {
        DataSecConverter.data_mem = hm1;
        String lbl = DataSecConverter.address_to_label(hm1_start_addr_1);
        assertEquals(hm1_exp_lbl1 , lbl);
    }

    @Test
    void hm1_label2() {
        DataSecConverter.data_mem = hm1;
        String lbl = DataSecConverter.address_to_label(hm1_start_addr_2);
        assertEquals(hm1_exp_lbl2 , lbl);
    }

    @Test
    void hm1_label3() {
        DataSecConverter.data_mem = hm1;
        String lbl = DataSecConverter.address_to_label(hm1_start_addr_3);
        assertEquals(hm1_exp_lbl3 , lbl);
    }
    @Test
    void hm2_label1() {
        DataSecConverter.data_mem = hm2;
        String lbl = DataSecConverter.address_to_label(hm2_starting_addr_1);
        assertEquals(hm2_exp_lbl1 , lbl);
    }

    @Test
    void hm3_label1() {
        DataSecConverter.data_mem = hm3;
        assertThrows(IllegalArgumentException.class, () -> DataSecConverter.address_to_label(hm3_starting_addr_1));
    }
}