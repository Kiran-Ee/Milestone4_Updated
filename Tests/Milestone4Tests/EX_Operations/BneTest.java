package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Bne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static CPU.CPU.branch_handler;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//op-code: bne, rs, rt, offset
//machine: bne, rs, rt, offset
public class BneTest {
    Bne bne = null;
    String bin_instr1 = "00010101000010010000000000010000"; //bne $t0 $t1 16
    String bin_instr2 = "00010101101000100000000000000000"; //bne t5 v0 0x0000
    String bin_instr3 = "00010101101011010000000011111111"; //bne t5 t5 0xff
    String bin_instr4 = "00010100000100111111111111111011"; //bne zero s3 -5
    String bin_instr5 = "00010100000100111111111111111111"; //bne zero s3 -1

    int pc = 10;

    // Register Values
    int t0_val = 9;
    int t1_val = 9;
    int t5_val = -9;
    int v0_val = -10;
    int s3_val = -11;

    // Expected Operate
    String exp_val1 = "no branch"; //9 == 9
    String exp_val2 = "branch"; //-9 != -10
    String exp_val3 = "no branch"; //-9 == -9
    String exp_val4 = "branch"; //0 != -11
    String exp_val5 = "branch"; //0 != -11

    // Expected PC
    int exp_pc1 = 10;
    int exp_pc2 = 10;
    int exp_pc3 = 10;
    int exp_pc4 = 5;
    int exp_pc5 = 9;

    @BeforeEach
    public void setUp() {
        CPU.t0 = t0_val;
        CPU.t1 = t1_val;
        CPU.v0 = v0_val;
        CPU.t5 = t5_val;
        CPU.s3 = s3_val;
    }

    @Test
    public void setBne1() {
        bne = new Bne(bin_instr1);
        assertEquals(exp_val1, bne.operate());
    }

    @Test
    public void setBne2() {
        bne = new Bne(bin_instr2);
        assertEquals(exp_val2, bne.operate());
    }

    @Test
    public void setBne3() {
        bne = new Bne(bin_instr3);
        assertEquals(exp_val3, bne.operate());
    }
    
    @Test
    public void setBne4() {
        bne = new Bne(bin_instr4);
        assertEquals(exp_val4, bne.operate());
    }

    @Test
    public void setBne5() {
        bne = new Bne(bin_instr5);
        assertEquals(exp_val5, bne.operate());
    }

    // Testing branch_hanlder
    @Test
    public void branchHandler_bne1() {
        bne = new Bne(bin_instr1);
        assertEquals(exp_pc1, branch_handler(bne,pc));
    }

    @Test
    public void branchHandler_bne2() {
        bne = new Bne(bin_instr2);
        assertEquals(exp_pc2, branch_handler(bne,pc));
    }

    @Test
    public void branchHandler_bne3() {
        bne = new Bne(bin_instr3);
        assertEquals(exp_pc3, branch_handler(bne,pc));
    }

    @Test
    public void branchHandler_bne4() {
        bne = new Bne(bin_instr4);
        assertEquals(exp_pc4, branch_handler(bne,pc));
    }

    @Test
    public void branchHandler_bne5() {
        bne = new Bne(bin_instr5);
        assertEquals(exp_pc5, branch_handler(bne,pc));
    }
}
