package Milestone3Tests.MC_Operations;

import Operations.j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Format: J target
//Machine: J, instr_index(26)
public class jTest {

    String bin_instr1 = "00001000000000000000000111110100"; //"j", "0x1F4, hex-080001F4
    int exp_addr1 = 0x1f4; //500
    String exMnem = "j {opcode: 02, index: 00001f4}";

    String bin_instr2 = "00001000000100000000000000010101"; // J 0x0100015 08100015 <- FROM CPU_test
    int exp_addr2 = 0x0100015; //1048597

    @Test
    public void good_variable_setting1(){
        j ju = new j(bin_instr1);
        int addr = Integer.parseInt(ju.getInstruction()[0], 10);
        assertEquals(exp_addr1, addr);
    }

    @Test
    public void good_variable_setting2(){
        j ju = new j(bin_instr2);
        int addr = Integer.parseInt(ju.getInstruction()[0], 10);
        assertEquals(exp_addr2, addr);
    }
}
