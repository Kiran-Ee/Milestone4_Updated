package Milestone4Tests.SecConverters;

import SecConverters.DataSecConverter;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class LnInterpreterDtaHexTest {
    DataSecConverter dsc = new DataSecConverter();
    String line1 = "65746e45";
    String line2 = "6f792072";
    String line3 = "69207275";
    String line4 = "6765746e";
    String line5 = "203a7265";
    String line6 = "756f5900"; //   "u o y /0"
    String line7 = "6e692072";
    String line8 = "65676574";
    String line9 = "73692072";
    String line10 = "45564520";
    String line11 = "5900214e";
    String line12 = "2072756f";
    String line13 = "65746e69";
    String line14 = "20726567";
    String line15 = "4f207369";
    String line16 = "00214444";

    String[] l1 = {"Ente", "empty"};
    String[] l2 = {"r yo", "empty"};
    String[] l3 = {"ur i", "empty"};
    String[] l4 = {"nteg", "empty"};
    String[] l5 = {"er: ", "empty"};
    String[] l6 = {"", "You"};
    String[] l7 = {"r in", "empty"};
    String[] l8 = {"tege", "empty"};
    String[] l9 = {"r is", "empty"};
    String[] l10 = {" EVE", "empty"};
    String[] l11 = {"N!","Y"};
    String[] l12 = {"our ", "empty"};
    String[] l13 = {"inte", "empty"};
    String[] l14 = {"ger ", "empty"};
    String[] l15 = {"is O", "empty"};
    String[] l16 = {"DD!", ""};


    @Test
    void setLine1() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line1), l1);
    }
    @Test
    void setLine2() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line2), l2);
    }
    @Test
    void setLine3() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line3), l3);
    }
    @Test
    void setLine4() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line4), l4);
    }
    @Test
    void setLine5() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line5), l5);
    }
    @Test
    void setLine6() {
        String[] s = dsc.lnInterpreter_dtaHex(line6);
        assertArrayEquals(s, l6);
    }
    @Test
    void setLine7() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line7), l7);
    }
    @Test
    void setLine8() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line8), l8);
    }
    @Test
    void setLine9() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line9), l9);
    }
    @Test
    void setLine10() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line10), l10);
    }
    @Test
    void setLine11() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line11), l11);
    }
    @Test
    void setLine12() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line12), l12);
    }
    @Test
    void setLine13() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line13), l13);
    }
    @Test
    void setLine14() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line14), l14);
    }
    @Test
    void setLine15() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line15), l15);
    }
    @Test
    void setLine16() {
        assertArrayEquals(dsc.lnInterpreter_dtaHex(line16), l16);
    }
}