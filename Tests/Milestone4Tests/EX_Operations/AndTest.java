package Milestone4Tests.EX_Operations;
import CPU.CPU;
import Operations.And;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//op-code: AND rd, rs, rt
//Machine: SPECIAL, rs ,rt , rd, ZERO, AND
public class AndTest {
    And and = null;
    String bin_instr2 = "00000011000011000110100000100100"; //""and", "$t5", "$t8", "$t4"
    String bin_instr1 = "00000010001100100100000000100100"; //"and", "$t0", "$s1", "$s2"
    String bin_instr3 = "00000000011011100011000000100100"; //and a2 v1 t6
    String bin_instr4 = "00000000010010110010000000100100"; //and a0 v0 t3
    String bin_instr5 = "00000001111000000010000000100100"; //and a0 t7 zero

    int t0_val = 0; //initialize to 0 expected to update later
    int s1_val = 17;
    int s2_val = 18;
    int exp_val1 = 16; //(s1_val & s2_val)

    int t5_val = 13;
    int t8_val = 24;
    int t4_val = 12;
    int exp_val2 = 8 ;

    int a2_val = 9999;
    int v1_val = -9999;
    int t6_val = 1;
    int exp_val3 = -9999 & 1; //v1 t6

    int a0_val = 13;
    int v0_val = 65535;
    int t3_val = 32767;
    int exp_val4 = 65535&32767; //v0 t3


//    int a0_val = 13; // already declared
    int t7_val = 0xe;
    int zero_val = 0;
    int exp_val5 = 0xe & 0; //t7 zero

    @BeforeEach
    public void setUp(){
        CPU.t0 = t0_val;
        CPU.s1 = s1_val;
        CPU.s2 = s2_val;

        CPU.t5 = t5_val;
        CPU.t8 = t8_val;
        CPU.t4 = t4_val;

        CPU.a2 = a2_val;
        CPU.v1 = v1_val;
        CPU.t6 = t6_val;

        CPU.a0 = a0_val;
        CPU.v0 = v0_val;
        CPU.t3 = t3_val;

        CPU.t7 = t7_val;
    }

    @Test
    public void setAnd1(){
        and = new And(bin_instr1);
        and.operate();
        Assertions.assertEquals(CPU.t0, exp_val1);
    }
    @Test
    public void setAnd2(){
        and = new And(bin_instr2);
        and.operate();
        Assertions.assertEquals(CPU.t5, exp_val2);
    }

    @Test
    public void setAnd3(){
        and = new And(bin_instr3);
        and.operate();
        Assertions.assertEquals(CPU.a2, exp_val3);
    }
    @Test
    public void setAnd4(){
        and = new And(bin_instr4);
        and.operate();
        Assertions.assertEquals(CPU.a0, exp_val4);
    }


    @Test
    public void setAnd5(){
        and = new And(bin_instr5);
        and.operate();
        Assertions.assertEquals(CPU.a0, exp_val5);
    }

}
