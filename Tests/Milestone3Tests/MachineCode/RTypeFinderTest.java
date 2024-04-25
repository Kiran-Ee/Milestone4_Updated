package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* instructions using the same "op-code"
add x
and x
or x
slt x
sub x
 */
class RTypeFinderTest {
    GeneralMachineCode gmc = new GeneralMachineCode();
    String bin1 = "00000010101101001110100000100010";
    String bin2 = "00000010111110110100100000100010";
    String bin3 = "00000011000010101000000100100000";
    String bin4 = "00000000110111111111000000101010";
    String bin5 = "00000011110111000000000000100101";
    String bin6 = "00000001000000111011100000100100";

    String instr1 = "sub";
    String instr3 = "add";
    String instr2 = "sub";
    String instr4 = "slt";
    String instr5 = "or";
    String instr6 = "and";

    @Test
    void setHex1() {
        assertEquals(instr1, gmc.rType_finder(bin1));
    }
    @Test
    void setHex2() {
        assertEquals(instr2, gmc.rType_finder(bin2));
    }
    @Test
    void setHex3() {
        assertEquals(instr3, gmc.rType_finder(bin3));
    }
    @Test
    void setHex4() {
        assertEquals(instr4, gmc.rType_finder(bin4));
    }
    @Test
    void setHex5() {
        assertEquals(instr5, gmc.rType_finder(bin5));
    }
    @Test
    void setHex6() {
        assertEquals(instr6, gmc.rType_finder(bin6));
    }
}