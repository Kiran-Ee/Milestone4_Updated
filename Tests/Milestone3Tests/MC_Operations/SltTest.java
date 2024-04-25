package Milestone3Tests.MC_Operations;

import Operations.Slt;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SltTest {
    String bin_instr1 = "00000001010010110100100000101010"; // "slt", "$t1", "$t2", "$t3" - hex-014B482A
    String expMnem1 = "slt {opcode: 00, rs: 0a, rt: 0b, rd: 09, shmt: 00, funct: 2a}";

    String bin_instr2 = "00000010111001011100100000101010"; // "slt", "$t9", "$s7", "$a1" - hex-02E5C82A
    String expMnem2 = "slt {opcode: 00, rs: 17, rt: 05, rd: 19, shmt: 00, funct: 2a}";

    @Test
    public void good_variable_instr1() {
        Slt slt = new Slt(bin_instr1);
        assertEquals(expMnem1, slt.get_mnenomic());
    }

    @Test
    public void good_variable_instr2() {
        Slt slt = new Slt(bin_instr2);
        assertEquals(expMnem2, slt.get_mnenomic());
    }
}
