package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lui;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuiTest {
    Lui lui = null;
    String bin_instr1 = "00111100000100010000000000000000"; //lui", "$s1", "0"
    int s1_val = 17;
    String bin_instr2 = "00111100000110010000000000001010"; //lui", "$t9", "10"
    String bin_instr3 = "00111100000110100000000000000101"; //lui, "k0", 5
    int k0_val = 26;
    int t9_val = 25;

    @BeforeEach
    public void setUp(){
        CPU.s1 = s1_val;
        CPU.t9 = t9_val;
        CPU.k0 = k0_val;

    }

    @Test
    public void setLui1(){
        lui = new Lui(bin_instr1);
        lui.operate();
        // Assert the expected result after the LUI operation
        assertEquals(0, CPU.s1); // Check if $s1 was updated correctly by LUI to contain the upper immediate value (0)
    }
    @Test
    public void setLui2() {
        lui = new Lui(bin_instr2);
        lui.operate();
        //may need adjustment
        assertEquals(10 << 16, CPU.t9); // check if $t9 was updated correctly by LUI to contain the upper immediate value (10 shifted left by 16 bits)
    }

    @Test void setLui3(){
        lui = new Lui(bin_instr3);
        lui.operate();
        assertEquals(5 << 16, CPU.k0);
    }

}
