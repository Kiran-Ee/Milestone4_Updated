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
    String bin_instr1 = "00000010001100100100000000100100"; //"and", "$t0", "$s1", "$s2"
    int t0_val = 0; //initialize to 0 expected to update later
    int s1_val = 17;
    int s2_val = 18;
    int exp_val1 = 16;//(s1_val & s2_val)
    String bin_instr2 = "00000011000011000110100000100100"; //""and", "$t5", "$t8", "$t4"
    int t5_val = 13;
    int t8_val = 24;
    int t4_val = 12;
    int exp_val2 = 8 ;//()

    @BeforeEach
    public void setUp(){
        CPU.t0 = t0_val;
        CPU.s1 = s1_val;
        CPU.s2 = s2_val;
        CPU.t5 = t5_val;
        CPU.t8 = t8_val;
        CPU.t4 = t4_val;
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

}
