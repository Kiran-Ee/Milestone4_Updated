package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTest {
    Or or = null;
    String bin_instr1 = "00000010001001110100000000100101"; // "or", "$t0", "$s1", "$a3" - hex-02274025
    int t0_val = 8;
    int s1_val = 17;
    int a3_val = 7;
    int exp_val1 = 17;
    String bin_instr2 = "00000001010010011011000000100101"; // "or", "$s6", "$t2", "$t1" - hex-0149B025
    int s6_val = 22;
    int t2_val = 10;
    int t1_val = 9;
    int exp_val2 = 11;

    @BeforeEach
    public void setUp(){
        CPU.t0 = t0_val;
        CPU.s1 = s1_val;
        CPU.a3 = a3_val;
        CPU.s6 = s6_val;
        CPU.t2 = t2_val;
        CPU.t1 = t1_val;
    }
    @Test
    public void setOr1(){
        or = new Or(bin_instr1);
        or.operate();
        assertEquals(exp_val1, CPU.t0);
    }
    @Test
    public void setOr2(){
        or = new Or(bin_instr2);
        or.operate();
        assertEquals(exp_val2, CPU.s6);
    }
}
