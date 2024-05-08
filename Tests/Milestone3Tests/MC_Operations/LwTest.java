package Milestone3Tests.MC_Operations;

import Operations.Lw;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LwTest {

    String bin_instr = "10001110001010000000000000001010"; //"lw", "$t0", "10", "$s1"-hex-8E28000A
    //bin"10001110001010000000000000001010";
    String exMem = "lw {opcode: 23, rs(base): 11, rt: 08, immediate(offset): 000a}";

    String bin_instr1 = "10001100100000100000000000001010"; //"lw", "$v0", "10", "$a0"-hex-8C82000A
    //bin"10001100100000100000000000001010";
    String exMem1 = "lw {opcode: 23, rs(base): 04, rt: 02, immediate(offset): 000a}";

    @Test
    public void good_variable_setting1(){
        Lw l = new Lw(bin_instr);
        assertEquals(exMem, l.getInstruction());
    }
    @Test
    public void good_variable_setting2(){
        Lw l = new Lw(bin_instr1);
        assertEquals(exMem1, l.getInstruction());
    }
}
