package Milestone3Tests.MC_Operations;

import Operations.Sub;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubTest {
    // Binary instruction for "sub", "$s1", "$s2", "$s3" - hex-02538822
    String bin_instr1 = "00000010010100111000100000100010";
    String expMnem1 = "sub {opcode: 00, rs: 12, rt: 13, rd: 11, shmt: 00, funct: 22}";

    // Binary instruction for "sub", "$t0", "$t1", "$t2" - hex-012A4022
    String bin_instr2 = "00000001001010100100000000100010";
    String expMnem2 = "sub {opcode: 00, rs: 09, rt: 0a, rd: 08, shmt: 00, funct: 22}";

    // Binary instruction for "sub", "$s6", "$s7", "$a3" - hex-02E7B022
    String bin_instr3 = "00000010111001111011000000100010";
    String expMnem3 = "sub {opcode: 00, rs: 17, rt: 07, rd: 16, shmt: 00, funct: 22}";

    @Test
    public void good_variable_instr1() {
        Sub sub = new Sub(bin_instr1);
        assertEquals(expMnem1, sub.get_mnenomic());
    }

    @Test
    public void good_variable_instr2() {
        Sub sub = new Sub(bin_instr2);
        assertEquals(expMnem2, sub.get_mnenomic());
    }

    @Test
    public void good_variable_instr13() {
        Sub sub = new Sub(bin_instr3);
        assertEquals(expMnem3, sub.get_mnenomic());
    }
}
