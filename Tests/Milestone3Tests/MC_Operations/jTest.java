package Milestone3Tests.MC_Operations;

import Operations.j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Format: J target
//Machine: J, instr_index(26)
public class jTest {

    String bin_instr = "00001000000000000000000111110100"; //"j", "0x1F4, hex-080001F4
    String exMnem = "j {opcode: 02, index: 00001f4}";

    @Test
    public void good_variable_setting1(){
        j ju = new j(bin_instr);
        assertEquals(exMnem, ju.get_mnenomic());
    }
}
