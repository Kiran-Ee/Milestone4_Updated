package Milestone3Tests.MC_Operations;

import Operations.And;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//op-code: AND rd, rs, rt
//Machine: SPECIAL, rs ,rt , rd, ZERO, AND
public class AndTest {
    String bin_instr1 = "00000010001100100100000000100100"; //"and", "$t0", "$s1", "$s2"-hex-02324024
    //bin 00000010001100100100000000100100
    String exMne = "and {opcode: 00, rs: 11, rt: 12, rd: 08, shmt: 00, funct: 24}";
    String bin_instr2 = "00000000100100010001000000100100"; //"and", "$v0", "$a0", "$s1"-hex-00911024
    //bin 00000000100100010001000000100100
    String exMne1 = "and {opcode: 00, rs: 04, rt: 11, rd: 02, shmt: 00, funct: 24}";
    String bin_instr3 = "00000011000011000110100000100100"; //""and", "$t5", "$t8", "$t4""-hex-030C6824
    //bin 00000011000011000110100000100100
    String exMne2 = "and {opcode: 00, rs: 18, rt: 0c, rd: 0d, shmt: 00, funct: 24}";

//    String[] instr = {"and", "$t0", "$s1", "$s2"}; //format and, rd, rs, rt
//    String[] instr1 = {"and", "$v0", "$a0", "$s1"};
//    String[] instr2 = {"and", "$t5", "$t8", "$t4"};
//    String[] instr3 = {"and", "$6", "$17", "$11"}; //"and", "$a2", "$s1", "$t3"



    @Test
    public void good_variable_setting1(){
        And a = new And(bin_instr1);
        assertEquals(exMne, a.getInstruction());
    }

    @Test
    public void good_variable_setting2(){
        And a = new And(bin_instr2);
        assertEquals(exMne1, a.getInstruction());
    }
    @Test
    public void good_variable_setting3(){
        And a = new And(bin_instr3);
        assertEquals(exMne2, a.getInstruction());
    }
}
