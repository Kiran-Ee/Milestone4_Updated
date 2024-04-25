package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadBinaryTest {
    GeneralMachineCode gmc = new GeneralMachineCode();

    int i1 = 10;
    int i2 = 11;
    int i3 = 12;
    int i4 = 13;

    String bin1 = "100100";
    String bin2 = "00000";
    String bin3 = "";
    String bin4 = "011111";

    String exp_bin1 = "0000100100"; //for i1
    String exp_bin2 = "00000000000"; //for i2
    String exp_bin3 = "000000000000"; //for i3
    String exp_bin4 = "0000000011111"; //for i4


    @Test
    void setBin1() {
        assertEquals(exp_bin1, gmc.pad_binary(bin1, i1-bin1.length()));
    }
    @Test
    void setBin2() {
        assertEquals(exp_bin2, gmc.pad_binary(bin2, i2-bin2.length()));
    }
    @Test
    void setBin3() {
        assertEquals(exp_bin3, gmc.pad_binary(bin3, i3-bin3.length()));
    }
    @Test
    void setBin4() {
        assertEquals(exp_bin4, gmc.pad_binary(bin4, i4-bin4.length()));
    }
}