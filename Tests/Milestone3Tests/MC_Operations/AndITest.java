package Milestone3Tests.MC_Operations;

import Operations.AndI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndITest {
    String bin_instr1 = "00110001010010010000000100000001"; // andi t1 t2 0x101
    String expMnem = "andi {opcode: 0c, rs(base): 0a, rt: 09, immediate(offset): 0101}";

    String bin_instr2 = "00110000100001000000000000000000"; //andi a0 a0 0x0
    String expMnem1 = "andi {opcode: 0c, rs(base): 04, rt: 04, immediate(offset): 0000}";

    String hex_instr3 = "00110010010100000000100110011001"; //andi s0 s2 0x999
    String expMnem2 = "andi {opcode: 0c, rs(base): 12, rt: 10, immediate(offset): 0999}";

    @Test
    public void good_variable_setting1() { 
        AndI a = new AndI(bin_instr1);
        assertEquals(expMnem, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting2() { 
        AndI a = new AndI(bin_instr2);
        assertEquals(expMnem1, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting3() { //"AndI", "$s3", "$t1", "$v1"
        AndI a = new AndI(hex_instr3);
        assertEquals(expMnem2, a.get_mnenomic());
    }
}