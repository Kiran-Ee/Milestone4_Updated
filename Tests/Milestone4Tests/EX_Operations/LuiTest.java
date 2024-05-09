package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lui;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LuiTest {
    Lui lui = null;
    String bin_instr1 = "00111100000100010000000000000000"; //lui", "$s1", "0"
    String bin_instr2 = "00111100000110010000000000001010"; //lui", "$t9", "10"
    String bin_instr3 = "00111100000110101111111111111111"; //lui, "k0", "0xFFFF"


    int s1_val = 1000;

    int t9_val = -1;

    int k0_val = 0;

    int exp_bin1 = 0x00000000; //0
    int exp_bin2 = 0x000a0000; //10
    int exp_bin3 = 0xffff0000; //FFFF0000 - Java is turning this negative for some reason


    @BeforeEach
    public void setUp() {
        CPU.s1 = s1_val;
        CPU.t9 = t9_val;
        CPU.k0 = k0_val;
    }

    @Test
    public void setLui1() {
        lui = new Lui(bin_instr1);
        lui.operate();
        assertEquals(exp_bin1, CPU.s1);
    }

    @Test
    public void setLui2() {
        lui = new Lui(bin_instr2);
        lui.operate();
        assertEquals(exp_bin2, CPU.t9);
    }

    @Test
    void setLui3() {
        lui = new Lui(bin_instr3);
        lui.operate();
        assertEquals(exp_bin3, CPU.k0);
    }

}

