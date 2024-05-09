package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Add;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// op-code: add, rd, rs, rt
// machine-code: sp, rs, rt, rd, 0, add
public class AddTest {
    Add add = null; // used to instantiate new OperationObj every test ...
    String bin_instr1 = "00000000101001100010000000100000"; //ADD $a0 $a1 $a2
    String bin_inst_2 = "00000010001011111000000000100000"; //ADD $s0 $s1 $t7
    String bin_inst_3 = "00000000000000000000000000100000"; //add zero zero zero
    String bin_inst_4 = "00000011000000101001100000100000"; //add s3 t8 v0


    int a0_val = 4; // used to perform operation ...
    int a1_val = 10;
    int a2_val = 15;
    int s0_val = 16;
    int s1_val = 17;
    int t7_val = 15;
    int zero_val = 0;
    int v0_val = 65535; //max unsigned
    int t8_val = -1;


    int exp_add1 = 15;
    int exp_add2 = 32;
    int exp_add3 = 0;
    int exp_add4 = 65534;

    @BeforeEach
    public void setUp() { // setting the CPU:
        CPU.a0 = a0_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
        CPU.s0 = s0_val;
        CPU.s1 = s1_val;
        CPU.t7 = t7_val;
        CPU.zero = zero_val;
        CPU.v0 = v0_val;
        CPU.t8 = t8_val;
    }
    @Test
    public void setAdd1(){
        add = new Add(bin_instr1); // we're not sending in "registers" to OpObjs ... we're sending 32 bit Bin (so we don't have to change MLST3)
        add.operate();
        assertEquals(CPU.a2 , exp_add1);
    }
    @Test
    public void setAdd2(){
        add = new Add(bin_inst_2);
        add.operate();
        assertEquals(CPU.s0, exp_add2);
    }
    @Test
    public void setAdd3(){
        add = new Add(bin_inst_3);
        add.operate();
        assertEquals(CPU.zero, exp_add3);
    }

    @Test
    public void setAdd4(){
        add = new Add(bin_inst_4);
        add.operate();
        assertEquals(exp_add4, CPU.s3); // Expected result for the new test case should be the initial value?
    }
}