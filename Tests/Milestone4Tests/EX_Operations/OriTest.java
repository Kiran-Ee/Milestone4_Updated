package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Ori;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OriTest {
    Ori ori = null;
    String bin_instr1 = "00110111001001110000000000001001"; //ori "a3", "t9", 9
    int a3_val = 7;
    int t9_val = 25;
    int exp_val1 = 25;

    String bin_instr2 = "00110111000011100000000000000001"; // ori $t6, $t8, 1; Hex: 0x370E0001
    int t8_val = 24;
    int t6_val = -5;
    int exp_val2 = 25;

    String bin_instr3 = "00110101110011111111111111111111"; // ori $t7, $t6, -1 -signed -1(hex:0x35CFFFFF)  unsigned:00111001111111111111111111111111(hex0x39FFFFFF)
    int t7_val = 15;
    int exp_val3 = -1;

    String bin_instr4 = "00110111010100110111111111111111"; //ori $s3, $k0, 7FFF
    int s3_val = 19;
    int k0_val = 0;
    int exp_val4 = 32767;

    @BeforeEach
    public void setUp(){
        CPU.a3 = a3_val;
        CPU.t9 = t9_val;
        CPU.t8 = t8_val;
        CPU.t6 = t6_val;
        CPU.t7 = t7_val;
        CPU.s3 = s3_val;
        CPU.k0 = k0_val;
    }
    @Test
    public void setOri1(){
        ori = new Ori(bin_instr1);
        ori.operate();
        assertEquals(exp_val1, CPU.a3);
    }
    @Test
    public void setOri2(){
        ori = new Ori(bin_instr2);
        ori.operate();
        assertEquals(exp_val2, CPU.t6);
    }
    @Test
    public void setOri3(){
        ori = new Ori(bin_instr3);
        ori.operate();
        assertEquals(exp_val3, CPU.t7);
    }
    @Test
    public void setOri4(){
        ori = new Ori(bin_instr4);
        ori.operate();
        assertEquals(exp_val4, CPU.s3);
    }

}
