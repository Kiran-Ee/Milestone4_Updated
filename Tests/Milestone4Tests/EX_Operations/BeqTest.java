package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Beq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//op-code-BEQ, rs, rt, offset
//Machine-BEQ, rs, rt, offset
public class BeqTest {
    Beq beq = null;
    String bin_instr1 = "00010001101000100000000000000000"; //beq t5 v0 (0)-0x0000
    int t5_val = 13 ;
    int v0_val = 2;
    //int exp_val1 = 0; //Expected PC value if branch is taken
    //136affae beq {opcode: 04, rs(base): 1b, rt: 0a, immediate(offset): ffae}
    @BeforeEach
    public void setUp(){
        CPU.t5 = t5_val;
        CPU.v0 = v0_val;

    }

    @Test
    public void setBeq(){
        beq = new Beq(bin_instr1);
        beq.operate(); //opereate need to se if registers are equal
        // Check if the PC has changed indirectly by the effect of the branch - if == adjust program counter -->
        //assertTrue(someEffectOfBranchTakenOccurred());

    }
    //may need multiple Helper method to check some effect of branch taken or not taken
//    private boolean someEffectOfBranchTakenOccurred() {
//        // maybe to check if a specific register or variable has changed as a result of the branch or overall program changed
//        return (variableChange || registerChange);
//    }
}
