package Milestone4Tests.EX_Operations;

import Operations.j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static CPU.CPU.branch_handler;
import static org.junit.Assert.assertEquals;

//Format: J target
//Machine: J, instr_index(26)
public class jTest {
    j j = null;
    String bin_instr1 = "00001000010000000000000000000000"; //j 0x00400000 ... 1st instruction
    String bin_instr2 = "00001000010000000000000000000100"; //j 0x00400004 ... 2nd instruction
    String bin_instr3 = "00001000010000000000000000010000"; //j 0x00400010 ... 5th instruction
    // 0x00400000, 0x00400004, 0x00400008, 0x0040000c, 0x00400010

    String exp_j = "jump";

    int pc1 = 10;
    int pc2 = 120934;
    int pc3 = 0;

    int exp_pc1 = 0;
    int exp_pc2 = 1;
    int exp_pc3 = 4;

    @BeforeEach
    public void setUp() {

    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void setJ1() {
        j = new j(bin_instr1);
        assertEquals(exp_j, j.operate());
    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_1() {
        j = new j(bin_instr1);
        int actual_pc = branch_handler(j, pc1);
        assertEquals(exp_pc1, actual_pc);
    }
    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_2() {
        j = new j(bin_instr2);
        int actual_pc = branch_handler(j, pc2);
        assertEquals(exp_pc2, actual_pc);
    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_3() {
        j = new j(bin_instr3);
        int actual_pc = branch_handler(j, pc3);
        assertEquals(exp_pc3, actual_pc);
    }
}
