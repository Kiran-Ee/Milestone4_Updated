package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lw;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LwTest {
    Lw lw = null;
    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();

    String bin_instr1 = "10001110001110100000000000000000"; //lw k0 0x0 s1 <- testing no offset
    String bin_instr2 = "10001110001010000000000000001000"; //"lw", "$t0", "8", "$s1 <- testing offset
    String bin_instr3 = "10001110001111011111111111111100";// lw sp -4(s1) <- testing negative offset
    String bin_invalid1 = "10001110001010000000000000001010"; //"lw", "$t0", "10", "$s1 ... offset must be factor of 4 bc word addressing (4 bytes)

    // Dstination Registers
    int k0_val = 938457;
    int t0_val = 8;
    int sp_val = 0xffffffff;

    // Base Register ($s1) Value ... not exact address of the starting addresses bc not word aligned
    int s1_val1 = 268500992; //0x10010000 - use w/ instr1 and instr2
    int s1_val2 = 268501012; //0x10010014 - use w/ instr1 and instr2 and instr3
    int s1_val3 = 268501032; //0x10010028 - use w/ instr1 and instr3

    // Expected Address
    int exp_instr1_val1 = 0x65746e45; //0x10010000 0 offset
    int exp_instr2_val1 = 0x69207275; //0x10010000 8 offset

    int exp_instr1_val2 = 0x756f5900; //0x10010014 0 offset
    int exp_instr2_val2 = 0x65676574; //0x10010014 8 offset
    int exp_instr3_val2 = 0x203a7265; //0x10010014 -4 offset

    int exp_instr1_val3 = 0x5900214e; //0x10010028 0 offset
    int exp_instr3_val3 = 0x45564520; //0x10010028 -4 offset

    @BeforeEach
    public void setUp() {
        CPU.t0 = t0_val;
        CPU.k0 = k0_val;
        CPU.sp = sp_val;

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
    public void instr1_val1() {
        lw = new Lw(bin_instr1);
        CPU.s1 = s1_val1;

        lw.operate();
        assertEquals(exp_instr1_val1, CPU.k0);
    }

    @Test
    public void instr2_val1() {
        lw = new Lw(bin_instr2);
        CPU.s1 = s1_val1;

        lw.operate();
        assertEquals(exp_instr2_val1, CPU.t0);
    }

    @Test
    public void instr1_val2() {
        lw = new Lw(bin_instr1);
        CPU.s1 = s1_val2;

        lw.operate();
        assertEquals(exp_instr1_val2, CPU.k0);
    }

    @Test
    public void instr2_val2() {
        lw = new Lw(bin_instr2);
        CPU.s1 = s1_val2;

        lw.operate();
        assertEquals(exp_instr2_val2, CPU.t0);
    }

    @Test
    public void instr3_val2() {
        lw = new Lw(bin_instr3);
        CPU.s1 = s1_val2;

        lw.operate();
        assertEquals(exp_instr3_val2, CPU.sp);
    }

    @Test
    public void instr1_val3() {
        lw = new Lw(bin_instr1);
        CPU.s1 = s1_val3;

        lw.operate();
        assertEquals(exp_instr1_val3, CPU.k0);
    }

    @Test
    public void instr3_val3() {
        lw = new Lw(bin_instr3);
        CPU.s1 = s1_val3;

        lw.operate();
        assertEquals(exp_instr3_val3, CPU.sp);
    }

//    @Test <- I don't think it's worth to add this to constructor because could throw exceptions in unexpedicted situations
//    public void invalid1() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            lw = new Lw(bin_invalid1);
//        });
//    }
}
