package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Add;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTest {
    Add add = null;
//    String a0 = "$a0";  // we're not sending in "registers" to OpObjs anymore ... we're sending 32 bit Bin (so we don't have to change MLST3)
//    String a1 = "$a1";
//    String a2 = "$a2";

    int a0_val = 4;
    int a1_val = 10;
    int a2_val = 15;

    int exp_add1 = 14;

    @BeforeEach
    public void setUp() { // setting the CPU ... I would test for a few more random registers (it's up to you if you want to test all of them)
        CPU.a0 = a0_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
    }

    @Test
    public void setAdd1(){
        add = new Add("00000000101001100010000000100000");
        add.operate();
        assertEquals(CPU.a2 , exp_add1);
    }

}