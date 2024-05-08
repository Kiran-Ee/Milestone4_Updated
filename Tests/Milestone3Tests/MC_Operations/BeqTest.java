package Milestone3Tests.MC_Operations;

import Operations.Beq;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//op-code-BEQ, rs, rt, offset
//Machine-BEQ, rs, rt, offset
public class BeqTest {
    String bin_instr = "00010010001100010000000000100000"; //"beq", "$s0", "$s1", "32" -hex-"12310020
    String exMnem = "beq {opcode: 04, rs(base): 11, rt: 11, immediate(offset): 0020}";
    String bin_instr1 = "00010001101000100000000000000000"; //beq t5 v0 0x0000 hex-0x11A20000
    String exMnem1 = "beq {opcode: 04, rs(base): 0d, rt: 02, immediate(offset): 0000}";
    String bin_instr2 = "00010010000001110000000100000000"; //beq $s0 $a3 "4" hex-12070100
    String exMnem2 = "beq {opcode: 04, rs(base): 10, rt: 07, immediate(offset): 0100}";
    @Test
    public void good_variable_settings1() {
        Beq beq = new Beq(bin_instr);
        assertEquals(exMnem, beq.getInstruction());
    }
    @Test
    public void good_variable_settings2() {
        Beq beq = new Beq(bin_instr1);
        assertEquals(exMnem1, beq.getInstruction());
    }
    @Test
    public void good_variable_settings3() {
        Beq beq = new Beq(bin_instr2);
        assertEquals(exMnem2, beq.getInstruction());
    }
}
