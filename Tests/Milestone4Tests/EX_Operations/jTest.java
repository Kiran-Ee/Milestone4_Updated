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
    String bin_instr1 = "00001000010000000000000000000000"; //j 0x00400000 ... 1st instruction index 0
    String bin_instr2 = "00001000010000000000000000000100"; //j 0x00400004 ... 2nd instruction index 1
    String bin_instr3 = "00001000010000000000000000010000"; //j 0x00400010 ... 5th instruction index 4
    String bin_instr4 = "00001000010000000000000001100100"; // j 0x00400064 ... 26th instruction index 25
    // 0x00400000, 0x00400004, 0x00400008, 0x0040000c, 0x00400010

    int pc = 2; //chosen to test going forwards and backwards

    String exp_j = "jump";

    // Jump should return address in BYTE! not WORD!
    int exp_addr1 = 4194304;//0x00400000
    int exp_addr2 = 4194308;//0x00400004
    int exp_addr3 = 4194320;//0x00400010
    int exp_addr4 = 4194404;//0x00400064

    // Expected PC: "-1" to the expected index because loop (in run_program()) adds one immediately after
    int exp_pc1 = 0-1; // 1st, going backward
    int exp_pc2 = 1-1; // 2nd, staying same
    int exp_pc3 = 4-1; // 5th, increasing
    int exp_pc4 = 25-1; // 26th, increasing

    // Testing their constructor (all unconditionally return "jump")
    @Test
    public void setJ1() {
        j = new j(bin_instr1);
        assertEquals(exp_j, j.operate());
        int actual_address = Integer.parseInt(j.getInstruction()[0]);
        assertEquals(exp_addr1, actual_address);
    }

    @Test
    public void setJ2() {
        j = new j(bin_instr2);
        assertEquals(exp_j, j.operate());
        int actual_address = Integer.parseInt(j.getInstruction()[0]);
        assertEquals(exp_addr2, actual_address);
    }

    @Test
    public void setJ3() {
        j = new j(bin_instr3);
        assertEquals(exp_j, j.operate());
        int actual_address = Integer.parseInt(j.getInstruction()[0]);
        assertEquals(exp_addr3, actual_address);
    }

    @Test
    public void setJ4() {
        j = new j(bin_instr4);
        assertEquals(exp_j, j.operate());
        int actual_address = Integer.parseInt(j.getInstruction()[0]);
        assertEquals(exp_addr4, actual_address);
    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_1() {
        j = new j(bin_instr1);
        int actual_pc = branch_handler(j, pc);
        assertEquals(exp_pc1, actual_pc);
    }
    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_2() {
        j = new j(bin_instr2);
        int actual_pc = branch_handler(j, pc);
        assertEquals(exp_pc2, actual_pc);
    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_3() {
        j = new j(bin_instr3);
        int actual_pc = branch_handler(j, pc);
        assertEquals(exp_pc3, actual_pc);
    }

    @Test // all jump's operate hardcoded to unconditionally jump for branch handler
    public void branchHandler_4() {
        j = new j(bin_instr4);
        int actual_pc = branch_handler(j, pc);
        assertEquals(exp_pc4, actual_pc);
    }
}
