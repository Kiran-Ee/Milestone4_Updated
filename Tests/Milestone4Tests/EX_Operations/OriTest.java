package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Ori;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OriTest {
    Ori ori = null;
    String bin_instr1 = "00110110011100100000000011111111"; //ori "a3", "t9", 9
    int a3_val = 7;
    int t9_val = 25;
    int exp_val1 = 25;

    @BeforeEach
    public void setUp(){
        CPU.a3 = a3_val;
        CPU.t9 = t9_val;
    }
    @Test
    public void setOri1(){
        ori = new Ori(bin_instr1);
        ori.operate();
        assertEquals(exp_val1, CPU.a3);
    }

}
