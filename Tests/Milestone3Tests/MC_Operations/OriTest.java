package Milestone3Tests.MC_Operations;

import Operations.Ori;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Format: ORI rt, rs, immediate
//machine: ORI rs rt immediate
public class OriTest {
    // Binary instruction for "ori", "$t1", "$s1", "0x12" - hex-36290012
    String bin_instr1 = "00110110001010010000000000010010";
//    String expMnem1 ="ori {opcode: 001101, rs: 10010, rt: 10001, immediate: 00000000000000010010";
    // Binary instruction for "ori", "$s2", "$s3", "0xFF" - hex-367200FF
    String expMnem1 ="ori {opcode: 0d, rs(base): 11, rt: 09, immediate(offset): 0012}";
    String bin_instr2 = "00110110011100100000000011111111";
    String expMnem2 = "ori {opcode: 0d, rs(base): 13, rt: 12, immediate(offset): 00ff}";
    // Binary instruction for "ori", "$a3", "$t9", "9" - hex-37270009
    String bin_instr3 = "00110111001001110000000000001001";
    String expMnem3 = "ori {opcode: 0d, rs(base): 19, rt: 07, immediate(offset): 0009}";

    @Test
    public void good_variable_setting1(){
        Ori o = new Ori(bin_instr1);
        assertEquals(expMnem1, o.get_mnenomic());
    }
    @Test
    public void good_variable_setting2(){
        Ori o = new Ori(bin_instr2);
        assertEquals(expMnem2, o.get_mnenomic());
    }
    @Test
    public void good_variable_setting3(){
        Ori o = new Ori(bin_instr3);
        assertEquals(expMnem3, o.get_mnenomic());
    }
}
