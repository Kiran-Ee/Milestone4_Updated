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
    String bin_instr3 = "00000010010000001000100000101010"; //slt $s1, $s2, zero - hex-0x0240882A
    int s1_val = 17;
    int s2_val = 18;
    int exp_val3 = 1;
    String bin_instr4 = "00000000000000000000000000101010"; //slt "zero", "zero", "zero" - hex-0x0000002A
    int exp_val4 = 0;
    String bin_instr5 = "00000011011000110000000000101010"; //slt "zero", "$k1", $v1" - hex-0x0363002A
    int k1_val = 27;
    int v1_val = 3;
    int exp_val5 = 0;

    @BeforeEach
    public void setUp() {
        CPU.t9 = t9_val;
        CPU.s7 = s7_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
        CPU.t5 = t5_val;
        CPU.s1 = s1_val;
        CPU.s2 = s2_val;
        CPU.k1 = k1_val;
        CPU.v1 = v1_val;
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
    @Test
    public void setSlt3(){
        slt = new Slt(bin_instr3);
        slt.operate();
        assertEquals(exp_val3, CPU.s1);
    }
    @Test
    public void setSlt4(){
        slt = new Slt(bin_instr4);
        slt.operate();
        assertEquals(exp_val4, CPU.zero);
    }
    @Test
    public void setSlt5(){
        slt = new Slt(bin_instr5);
        slt.operate();
        assertEquals(exp_val5, CPU.zero);
    }
}
