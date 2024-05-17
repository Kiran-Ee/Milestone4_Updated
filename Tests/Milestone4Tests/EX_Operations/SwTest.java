package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lw;
import Operations.Sw;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static SecConverters.DataSecConverter.data_mem;
import static org.junit.Assert.assertEquals;

public class SwTest {
    Sw sw = null;
    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();
    String bin_instr1 = "10101110010000100000000011110000"; //"sw", "$v0", "240"("$s2") - testing storing word to random location
    String bin_instr2 = "10101110010000111111111111111100"; //"sw", "$v1", "-4"("$s2") - testing negative offset ... AE43FFFC
    String bin_instr3 = "10101110011001000000000000000000"; //"sw", "$a0", "0"("$s3"): testing modifying a data label ... AE640000
    String bin_instr4 = "10101110011001010000000000000100"; //"sw", "$a1", "4"("$s3"): testing modifying a data label ... ae650004

    // Source Registers
    int v0_val = -1; //testing negative word
    int v1_val = 2147483647; //testing max int

    int a0_val = 0; //testing 0
    int a1_val = 0x99009900; //testing sending hex


    // Base (address) Registers
    int s2_val = 0x10010030; // random location
    int s3_val = 0x10010000; // 10010000 in mem


    // Expected Addresses + Their Values
    String exp_instr1_addr = "10010120";
    int exp_instr1_val = -1;

    String exp_instr2_addr = "1001002c";
    int exp_instr2_val = 2147483647;

    String exp_instr3_addr = "10010000";
    int exp_instr3_val = 0x00000000;

    String exp_instr4_addr = "10010004";
    int exp_instr4_val = 0x99009900;


    @BeforeEach
    public void setUp() {
        // Source
        CPU.v0 = v0_val;
        CPU.v1 = v1_val;
        CPU.a0 = a0_val;
        CPU.a1 = a1_val;

        // Base
        CPU.s2 = s2_val;
        CPU.s3 = s3_val;

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

        DataSecConverter.data_mem = hm1;
    }

    @Test
    public void instr1(){
        sw = new Sw(bin_instr1);
        sw.operate();

        int val_in_mem = data_mem.get(exp_instr1_addr);
        assertEquals(exp_instr1_val, val_in_mem);
    }
    @Test
    public void instr2(){
        sw = new Sw(bin_instr2);
        sw.operate();

        int val_in_mem = data_mem.get(exp_instr2_addr);
        assertEquals(exp_instr2_val, val_in_mem);
    }
    @Test
    public void instr3(){
        sw = new Sw(bin_instr3);
        sw.operate();

        int val_in_mem = data_mem.get(exp_instr3_addr);
        assertEquals(exp_instr3_val, val_in_mem);
    }
    @Test
    public void instr4(){
        sw = new Sw(bin_instr4);
        sw.operate();

        int val_in_mem = data_mem.get(exp_instr4_addr);
        assertEquals(exp_instr4_val, val_in_mem);
    }
}
