package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexToBinaryTest {
    GeneralMachineCode gmc = new GeneralMachineCode();

    String hex1 = "02b4e822";
    String hex2 = "0000000c";
    String hex3 = "027b4822";
    String hex4 = "3413ff20";
    String hex5 = "117e00df";
    String hex6 = "030a0820";
    String hex7 = "136affae";
    String hex8 = "10440017";
    String hex9 = "080000cd";
    String hex10 = "ae940000";
    String hex11 = "375300ae";
    String hex12 = "0000000c";
    String hex13 = "00dfe02a";

    String bin1 = "00000010101101001110100000100010";
    String bin2 = "00000000000000000000000000001100";
    String bin3 = "00000010011110110100100000100010";
    String bin4 = "00110100000100111111111100100000";
    String bin5 = "00010001011111100000000011011111";
    String bin6 = "00000011000010100000100000100000";
    String bin7 = "00010011011010101111111110101110";
    String bin8 = "00010000010001000000000000010111";
    String bin9 = "00001000000000000000000011001101";
    String bin10 = "10101110100101000000000000000000";
    String bin11 = "00110111010100110000000010101110";
    String bin12 = "00000000000000000000000000001100";
    String bin13 = "00000000110111111110000000101010";

    @Test
    void setHex1() {
        assertEquals(bin1, gmc.hex_to_binary(hex1));
    }
    @Test
    void setHex2() {
        assertEquals(bin2, gmc.hex_to_binary(hex2));
    }
    @Test
    void setHex3() {
        assertEquals(bin3, gmc.hex_to_binary(hex3));
    }
    @Test
    void setHex4() {
        assertEquals(bin4, gmc.hex_to_binary(hex4));
    }
    @Test
    void setHex5() {
        assertEquals(bin5, gmc.hex_to_binary(hex5));
    }
    @Test
    void setHex6() {
        assertEquals(bin6, gmc.hex_to_binary(hex6));
    }
    @Test
    void setHex7() {
        assertEquals(bin7, gmc.hex_to_binary(hex7));
    }
    @Test
    void setHex8() {
        assertEquals(bin8, gmc.hex_to_binary(hex8));
    }
    @Test
    void setHex9() {
        assertEquals(bin9, gmc.hex_to_binary(hex9));
    }
    @Test
    void setHex10() {
        assertEquals(bin10, gmc.hex_to_binary(hex10));
    }
    @Test
    void setHex11() {
        assertEquals(bin11, gmc.hex_to_binary(hex11));
    }
    @Test
    void setHex12() {
        assertEquals(bin12, gmc.hex_to_binary(hex12));
    }
    @Test
    void setHex13() {
        assertEquals(bin13, gmc.hex_to_binary(hex13));
    }
}