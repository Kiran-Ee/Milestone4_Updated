package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Sub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTest {
    Sub sub = null;
    String bin_instr1= "00000010111001111011000000100010"; //"sub", "$s6", "$s7", "$a3"
    int s6_val = 22;
    int s7_val = 23;
    int a3_val = 7;
    int exp_val1 = 16; //s7_val - a3_val
    String bin_instr2 = "00000001001010100100000000100010";//"sub", "$t0", "$t1", "$t2" - hex-012A4022
    int t0_val = 8;
    int t1_val = 9;
    int t2_val = 10;
    int exp_val2 = -1; //t0 - t1
    String bin_instr3 = "00000000010100110011000000100010"; //sub $a2 $v0 $s3
    int a2_val = 6;
    int v0_val = 2;
    int s3_val = 19;
    int exp_val3 = 4; //a2 - v0;
    String bin_instr4 = "00000000010100110011000000100010"; //sub zero zero zero hex-0x0000002
    int exp_val4 = 0;

    @BeforeEach
    public void setUp(){
        CPU.s6 = s6_val;
        CPU.s7 = s7_val;
        CPU.a3 = a3_val;
        CPU.t0 = t0_val;
        CPU.t1 = t1_val;
        CPU.t2 = t2_val;
        CPU.a2 = a2_val;
        CPU.v0 = v0_val;
        CPU.s3 = s3_val;
        CPU.zero = 0;
    }
    @Test
    public void setSub1(){
        sub = new Sub(bin_instr1);
        sub.operate();
        assertEquals(CPU.s6, exp_val1);
    }
    @Test
    public void setSub2(){
        sub = new Sub(bin_instr2);
        sub.operate();
        assertEquals(CPU.t2, exp_val2);
    }
    @Test
    public void setSub3() {
        sub = new Sub(bin_instr3);
        sub.operate();
        assertEquals(exp_val3, CPU.s3);
    }

    @Test
    public void setSub4() {
        sub = new Sub(bin_instr4);
        sub.operate();
        assertEquals(exp_val4, CPU.zero);
    }

}
