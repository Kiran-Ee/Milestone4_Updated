package Milestone3Tests.MC_Operations;

import Operations.Sw;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwTest {
    // Binary instruction for "sw", "$at", "0x0010"("$s1") - hex-AE210010
    String bin_instr1 = "10101110001000010000000000010000";
    String expMnem1 = "sw {opcode: 2b, rs(base): 11, rt: 01, immediate(offset): 0010}";

    // Binary instruction for "sw", "$s2", "240"("$s2") - hex-AE5200f0
    String bin_instr2 = "10101110010100100000000011110000";
    String expMnem2 = "sw {opcode: 2b, rs(base): 12, rt: 12, immediate(offset): 00f0}";

    // Binary instruction for "sw", "$a3", "0x0023"("$t7") - hex-ADE70023
    String bin_instr3 = "10101101111001110000000000100011";
    String expMnem3 = "sw {opcode: 2b, rs(base): 0f, rt: 07, immediate(offset): 0023}";

    @Test
    public void good_variable_instr1() {
        Sw s = new Sw(bin_instr1);
        assertEquals(expMnem1, s.getInstruction());
    }

    @Test
    public void good_variable_instr2() {
        Sw s = new Sw(bin_instr2);
        assertEquals(expMnem2, s.getInstruction());
    }

    @Test
    public void good_variable_instr13() {
        Sw s = new Sw(bin_instr3);
        assertEquals(expMnem3, s.getInstruction());
    }

}
