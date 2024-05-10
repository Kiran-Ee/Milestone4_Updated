package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Beq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static CPU.CPU.branch_handler;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//op-code-BEQ, rs, rt, offset
//Machine-BEQ, rs, rt, offset
public class BeqTest {
    Beq beq = null;
    String bin_instr1 = "00010001101000100000000000000000"; //beq t5 v0 0x0000
    String bin_instr2 = "00010001101011010000000011111111"; //BEQ $t5 $t5 0x00FF
    String bin_instr3 = "00010000000100111111111111111011"; //beq zero s3 -5

    int t5_val = 13;
    int v0_val = 2;

    int zero_val = 0;
    int s3_val = 0;

    String exp_val1 = "no branch";
    String exp_val2 = "branch";
    String exp_val3 = "branch";

    @BeforeEach
    public void setUp() {
        CPU.t5 = t5_val;
        CPU.v0 = v0_val;
        CPU.zero = zero_val;
        CPU.s3 = s3_val;
    }

    @Test
    public void setBeq1() {
        beq = new Beq(bin_instr1);
        assertEquals(exp_val1, beq.operate());
    }

    @Test
    public void setBeq2() {
        beq = new Beq(bin_instr2);
        assertEquals(exp_val2, beq.operate());
    }

    @Test
    public void setBeq3() {
        beq = new Beq(bin_instr3);
        assertEquals(exp_val3, beq.operate());
    }

    // Testing branch_hanlder
    @Test
    public void branchHandler_Beq1() {
        beq = new Beq(bin_instr1);
        int pc1 = 2;
        int exp_pc1 = 2;
        assertEquals(exp_pc1, branch_handler(beq,pc1));
    }

    @Test
    public void branchHandler_Beq2() {
        beq = new Beq(bin_instr2);
        int pc2 = 2;
        int exp_pc2 = pc2 + 1 + 255;
        assertEquals(exp_pc2, branch_handler(beq,pc2));
    }

    @Test
    public void branchHandler_Beq3() {
        beq = new Beq(bin_instr3);
        int pc3 = 2;
        int exp_pc3 = pc3 + 1 + -5;
        assertEquals(exp_pc3, branch_handler(beq,pc3));
    }
}
