package Milestone3Tests.MC_Operations;

import Operations.Add;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

// op-code: add, rd, rs, rt
// machine-code: sp, rs, rt, rd, 0, add
public class AddTest {
    String bin_instr1 = "00000010001011111000000000100000"; // "add", "$s0", "$s1", "$t7"  --at least 3 of each- random -test $a0 or $5 022F802
    // String bin = "00000010001011111000000000100000";
//    String expMnem = "add{opcode: ," + "rs: " + "rt "+ "rd" +"}";
    String expMnem = "add {opcode: 00, rs: 11, rt: 0f, rd: 10, shmt: 00, funct: 20}";
    //String expMnem = "add{opcode: 000000 "+ "rs(base): 10000" + "rt: 10001" + "rd: 11111" + "shamt: 00000" + "funct: 100000}";
    String bin_instr2 = "00000001000010000100000000100000"; //"add", "$t0", "$t0", "$t0" hex-01084020
    //bin-00000001000010000100000000100000
    String expMnem1 = "add {opcode: 00, rs: 08, rt: 08, rd: 08, shmt: 00, funct: 20}";
    //String expMnem1 = "add{opcode: 000000 + rs(base): 10000" + "rt: 10000" + "rd: 10000" + "shamt: 00000" + "funct: 100000}";

    String hex_instr3 = "00000001001000111001100000100000"; //"add", "$s3", "$t1", "$v1" -01239820... 1] add, $1, $2, $5 2] use image to converter add, $at, $v0, $v1 3] use the calculator on "2]"
    //bin-00000001001000111001100000100000
    String expMnem2 = "add {opcode: 00, rs: 09, rt: 03, rd: 13, shmt: 00, funct: 20}";
    //String expMnem2 = "add{opcode: 000000 "+ "rs(base): 01001" + "rt: 10000" + "rd: 01110" + "shamt: 00000" + "funct: 100000}";
//
//    String[] instr4 = {"add", "$3", "$2", "$1"};

    // Testing the variables set up correctly
    @Test
    public void good_variable_setting1() { // "add", "$s0", "$s1", "t7"
        Add a = new Add(bin_instr1);
        assertEquals(expMnem, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting2() { //"add", "$t0", "$t0", "$t0"
        Add a = new Add(bin_instr2);
        assertEquals(expMnem1, a.get_mnenomic());
    }
    @Test
    public void good_variable_setting3() { //"add", "$s3", "$t1", "$v1"
        Add a = new Add(hex_instr3);
        assertEquals(expMnem2, a.get_mnenomic());
    }
} //end: class addTest