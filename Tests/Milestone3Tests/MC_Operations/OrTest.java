package Milestone3Tests.MC_Operations;

import Operations.Or;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrTest {
    String bin_instr1 = "00000010001001110100000000100101"; // "or", "$t0", "$s1", "$a3" - hex-02274025
    // bin 00000010001001110100000000100101
//    String expMnem1 = "or {opcode: 000000, rs: 10001, rt: 10000, rd: 10010, shamt: 00000, funct: 100101}";
    String expMnem1 = "or {opcode: 00, rs: 11, rt: 07, rd: 08, shmt: 00, funct: 25}";
    //or {opcode: %s, rs: %s, rt: %s, rd: %s, shmt: %s, funct: %s}

    String bin_instr2 = "00000001010010011011000000100101"; // "or", "$s6", "$t2", "$t1" - hex-0149B025
    // bin 00000001010010011011000000100101
    String expMnem2 = "or {opcode: 00, rs: 0a, rt: 09, rd: 16, shmt: 00, funct: 25}";

    @Test
    public void good_variable_instr1() {
        Or or = new Or(bin_instr1);
        assertEquals(expMnem1, or.getInstruction());
    }

    @Test
    public void good_variable_instr2() {
        Or or = new Or(bin_instr2);
        assertEquals(expMnem2, or.getInstruction());
    }
}
