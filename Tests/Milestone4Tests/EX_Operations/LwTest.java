package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LwTest {
    Lw lw = null;
    String bin_instr1 = "10001110001010000000000000001010"; //"lw", "$t0", "10", "$s1
    int t0_val = 8;
    int s1_val = 17;
    int mem_add = 10;
    int exp_lui1 = 42;

    @BeforeEach
    public void setUp(){
        CPU.t0 = t0_val;
        CPU.s1 = s1_val;


    }

    @Test
    public void setLui1(){
        // Set the expected value directly in memory
        int expectedValue = 42;
       //do we need to set a word

        // Read the value from memory
       //get word

        lw = new Lw(bin_instr1 );
        lw.operate();
        //assertEquals(valFromMem(setWord), CPU.t0);

    }
}
