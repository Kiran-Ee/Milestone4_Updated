package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinToHexImmediateTest {
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
        assertEquals(gmc.bin_toHexImmediate(bin1), (hex1));
    }
    @Test
    void setHex2() {
        assertEquals(gmc.bin_toHexImmediate(bin2), (hex2));
    }
    @Test
    void setHex3() {
        assertEquals(gmc.bin_toHexImmediate(bin3), (hex3));
    }
    @Test
    void setHex4() {
        assertEquals(gmc.bin_toHexImmediate(bin4), (hex4));
    }
    @Test
    void setHex5() {
        assertEquals(gmc.bin_toHexImmediate(bin5), (hex5));
    }
    @Test
    void setHex6() {
        assertEquals(gmc.bin_toHexImmediate(bin6), (hex6));
    }
    @Test
    void setHex7() {
        assertEquals(gmc.bin_toHexImmediate(bin7), (hex7));
    }
    @Test
    void setHex8() {
        assertEquals(gmc.bin_toHexImmediate(bin8), (hex8));
    }
    @Test
    void setHex9() {
        assertEquals(gmc.bin_toHexImmediate(bin9), (hex9));
    }
    @Test
    void setHex10() {
        assertEquals(gmc.bin_toHexImmediate(bin10), (hex10));
    }
    @Test
    void setHex11() {
        assertEquals(gmc.bin_toHexImmediate(bin11), (hex11));
    }
    @Test
    void setHex12() {
        assertEquals(gmc.bin_toHexImmediate(bin12), (hex12));
    }
    @Test
    void setHex13() {
        assertEquals(gmc.bin_toHexImmediate(bin13), (hex13));
    }
}