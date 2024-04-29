package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Bne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//op-code: bne, rs, rt, offset
//machine: bne, rs, rt, offset
    public class BneTest {
        Bne bne = null;
        String bne_instr1 = "00010101000010010000000000010000"; //"bne", "$t0", "$t1", "16"
        int t0_val = 8;
        int t1_val = 9;

    @BeforeEach
    public void setUp(){
        CPU.t0 = t0_val;
        CPU.t1 = t1_val;

    }

    @Test
    public void setBne1(){
        bne = new Bne(bne_instr1);
        bne.operate();

        // same here we may need multiple checks if the branch was taken correctly
        //assertTrue(someEffectOfBranchTakenOccurred());

    }
//    // helper method so we can check if some effect of the branch taken occurred
//    private boolean someEffectOfBranchTakenOccurred() {
//        // Check if the branch condition is satisfied based on the values of $t0 and $t1
//        boolean branchConditionSatisfied = (CPU.t0 != CPU.t1);
//
//        if (branchConditionSatisfied) {
//            // Perform the actions that occur when the branch is taken
//            // maybe increment the program counter (PC) by the branch offset
//            CPU.incrementProgramCounterByOffset(16); // if assumed the branch offset is 16
//        }
//
//        // Return true if the branch condition was satisfied and the branch was taken
//        return branchConditionSatisfied;
//
//        // or to check if the values of the registers or program state have changed as expected
//        return (CPU.t0Changed && CPU.t1Changed);
//    }
}
