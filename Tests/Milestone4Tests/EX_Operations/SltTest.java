package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Slt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SltTest {
    Slt slt = null;
    String bin_instr1 = "00000010111001011100100000101010"; // "slt", "$t9", "$s7", "$a1"
    int t9_val = 25;
    int s7_val = 23;
    int a1_val = 5;
    int exp_val1 = 0;
    String bin_instr2 = "00000000101011010011000000101010"; //slt $a2 $a1 $t5
    int a2_val = 6;
    int t5_val = 15;
    int exp_val2 = 1;

    @BeforeEach
    public void setUp() {
        CPU.t9 = t9_val;
        CPU.s7 = s7_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
        CPU.t5 = t5_val;
    }
    @Test
    public void setSlt1(){
        slt = new Slt(bin_instr1);
        slt.operate();
        assertEquals(exp_val1, CPU.t9);
    }
    @Test
    public void setSlt2(){
        slt = new Slt(bin_instr2);
        slt.operate();
        assertEquals(exp_val2, CPU.a2);
    }
}
