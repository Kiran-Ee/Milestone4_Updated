package Milestone3Tests.MC_Operations;

import Operations.Syscall;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SyscallTest {
    String expMnem = "syscall {opcode: 00, code: 000000, funct: 0c}";
//    String expInst = "000000001100";
//    String bin_inst = "000000XXXXXXXXXXXXXXXXXXXX001100"; //hex-0XXXXXXC

    @Test
    public void good_variable_instr(){
        Syscall s = new Syscall();
        assertEquals(expMnem, s.getInstruction());
    }

}
