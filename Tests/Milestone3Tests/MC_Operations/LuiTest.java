package Milestone3Tests.MC_Operations;

import Operations.Lui;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LuiTest {
    String bin_instr = "00111100000010000000000000000101"; //lui", "$t0", "5" - hex-3C080005
    String exMem = "lui {opcode: 0f, rs(base): 00, rt: 08, immediate(offset): 0005}";
    String bin_instr1 = "00111100000100010000000000000000"; //lui", "$s1", "0" - hex-3C110000
    String exMem1 = "lui {opcode: 0f, rs(base): 00, rt: 11, immediate(offset): 0000}";
    String bin_instr2 = "00111100000110010000000000001010"; //lui", "$t9", "10" - hex-3C19000A
    String exMem2 = "lui {opcode: 0f, rs(base): 00, rt: 19, immediate(offset): 000a}";

    @Test
    public void good_variable_setting1(){
        Lui lui = new Lui(bin_instr);
        assertEquals(exMem, lui.getInstruction());
    }
    @Test
    public void good_variable_setting2(){
        Lui lui = new Lui(bin_instr1);
        assertEquals(exMem1, lui.getInstruction());
    }
    @Test
    public void good_variable_setting3(){
        Lui lui = new Lui(bin_instr2);
        assertEquals(exMem2, lui.getInstruction());
    }
}
