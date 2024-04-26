package Milestone4Tests.SecConverters;

import Operations.*;
import SecConverters.TextSecConverter;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class LnInterpreterTxtHexTest {
    String hex1 = "240100c8";
    String hex2 = "2402012c";
    String hex3 = "24030190";
    String hex4 = "240401f4";
    String hex5 = "24050258";
    String hex6 = "240602bc";
    String hex7 = "24070320";
    String hex8 = "24080384";
    String hex9 = "240903e8";
    String hex10 = "240a044c";
    String hex11 = "240b04b0";
    String hex12 = "240c0514";
    String hex13 = "240d0578";
    String hex14 = "240e05dc";
    String hex15 = "240f0640";
    String hex16 = "241006a4";
    String hex17 = "24110708";
    String hex18 = "2412076c";
    String hex19 = "241307d0";
    String hex20 = "24140834";
    String hex21 = "24150898";
    String hex22 = "241608fc";
    String hex23 = "24170960";
    String hex24 = "241809c4";
    String hex25 = "24190a28";
    String hex26 = "241a0a8c";
    String hex27 = "241b0af0";
    String hex28 = "241c0b54";
    String hex29 = "241d0bb8";
    String hex30 = "241e0c1c";
    String hex31 = "241f0c80";
    String hex32 = "022f4020";
    String hex33 = "27620064";
    String hex34 = "012a2024";
    String hex35 = "3130000a";
    String hex36 = "1109000a";
    String hex37 = "15090009";
    String hex38 = "3c0c0064";
    String hex39 = "8d320000";
    String hex40 = "012ac825";
    String hex41 = "3523000a";
    String hex42 = "012a082a";
    String hex43 = "012ab822";
    String hex44 = "ad280000";
    String hex45 = "0810002e";
    String hex46 = "0000000c";
    String hex47 = "3c011001";
    String hex48 = "34240000";
    String hex49 = "24020004";
    String hex50 = "0000000c";

    Addiu hexObj1 = new Addiu("00100100000000010000000011001000");
    Addiu hexObj2 = new Addiu("00100100000000100000000100101100");
    Addiu hexObj3 = new Addiu("00100100000000110000000110010000");
    Addiu hexObj4 = new Addiu("00100100000001000000000111110100");
    Addiu hexObj5 = new Addiu("00100100000001010000001001011000");
    Addiu hexObj6 = new Addiu("00100100000001100000001010111100");
    Addiu hexObj7 = new Addiu("00100100000001110000001100100000");
    Addiu hexObj8 = new Addiu("00100100000010000000001110000100");
    Addiu hexObj9 = new Addiu("00100100000010010000001111101000");
    Addiu hexObj10 = new Addiu("00100100000010100000010001001100");
    Addiu hexObj11 = new Addiu("00100100000010110000010010110000");
    Addiu hexObj12 = new Addiu("00100100000011000000010100010100");
    Addiu hexObj13 = new Addiu("00100100000011010000010101111000");
    Addiu hexObj14 = new Addiu("00100100000011100000010111011100");
    Addiu hexObj15 = new Addiu("00100100000011110000011001000000");
    Addiu hexObj16 = new Addiu("00100100000100000000011010100100");
    Addiu hexObj17 = new Addiu("00100100000100010000011100001000");
    Addiu hexObj18 = new Addiu("00100100000100100000011101101100");
    Addiu hexObj19 = new Addiu("00100100000100110000011111010000");
    Addiu hexObj20 = new Addiu("00100100000101000000100000110100");
    Addiu hexObj21 = new Addiu("00100100000101010000100010011000");
    Addiu hexObj22 = new Addiu("00100100000101100000100011111100");
    Addiu hexObj23 = new Addiu("00100100000101110000100101100000");
    Addiu hexObj24 = new Addiu("00100100000101110000100101100000");
    Addiu hexObj25 = new Addiu("00100100000110010000101000101000");
    Addiu hexObj26 = new Addiu("00100100000110100000101010001100");
    Addiu hexObj27 = new Addiu("00100100000110110000101011110000");
    Addiu hexObj28 = new Addiu("00100100000111000000101101010100");
    Addiu hexObj29 = new Addiu("00100100000111010000101110111000");
    Addiu hexObj30 = new Addiu("00100100000111100000110000011100");
    Addiu hexObj31 = new Addiu("00100100000111110000110010000000");
    Add hexObj32 = new Add("00000010001011110100000000100000");
    Addiu hexObj33 = new Addiu("00100111011000100000000001100100");
    Add hexObj34 = new Add("00000001001010100010000000100100");
    AndI hexObj35 = new AndI("00110001001100000000000000001010");
    Beq hexObj36 = new Beq("00010001000010010000000000001010");
    Bne hexObj37 = new Bne("00010101000010010000000000001001");
    Lui hexObj38 = new Lui("00111100000011000000000001100100");
    Lw hexObj39 = new Lw("10001101001100100000000000000000");
    Or hexObj40 = new Or("00000001001010101100100000100101");
    Ori hexObj41 = new Ori("00110101001000110000000000001010");
    Slt hexObj42 = new Slt("00000001001010100000100000101010");
    Sub hexObj43 = new Sub("00000001001010101011100000100010");
    Sw hexObj44 = new Sw("10101101001010000000000000000000");
    j hexObj45 = new j("00001000000100000000000000101110");
    Syscall hexObj46 = new Syscall();
    Lui hexObj47 = new Lui("00111100000000010001000000000001");
    Ori hexObj48 = new Ori("00110100001001000000000000000000");
    Addiu hexObj49 = new Addiu("00100100000000100000000000000100");
    Syscall hexObj50 = new Syscall();

    TextSecConverter tsc = new TextSecConverter();

    @Test
    public void setHex1() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex1);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj1.getInstruction());
    }

    @Test
    public void setHex2() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex2);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj2.getInstruction());
    }

    @Test
    public void setHex3() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex3);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj3.getInstruction());
    }

    @Test
    public void setHex4() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex4);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj4.getInstruction());
    }

    @Test
    public void setHex5() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex5);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj5.getInstruction());
    }

    @Test
    public void setHex6() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex6);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj6.getInstruction());
    }

    @Test
    public void setHex7() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex7);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj7.getInstruction());
    }

    @Test
    public void setHex8() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex8);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj8.getInstruction());
    }

    @Test
    public void setHex9() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex9);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj9.getInstruction());
    }

    @Test
    public void setHex10() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex10);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj10.getInstruction());
    }
    @Test
    public void setHex11() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex11);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj11.getInstruction());
    }

    @Test
    public void setHex12() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex12);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj12.getInstruction());
    }

    @Test
    public void setHex13() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex13);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj13.getInstruction());
    }

    @Test
    public void setHex14() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex14);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj14.getInstruction());
    }

    @Test
    public void setHex15() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex15);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj15.getInstruction());
    }

    @Test
    public void setHex16() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex16);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj16.getInstruction());
    }

    @Test
    public void setHex17() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex17);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj17.getInstruction());
    }

    @Test
    public void setHex18() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex18);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj18.getInstruction());
    }

    @Test
    public void setHex19() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex19);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj19.getInstruction());
    }

    @Test
    public void setHex20() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex20);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj20.getInstruction());
    }

    @Test
    public void setHex21() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex21);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj21.getInstruction());
    }

    @Test
    public void setHex22() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex22);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj22.getInstruction());
    }

    @Test
    public void setHex23() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex23);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj23.getInstruction());
    }

    @Test
    public void setHex24() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex24);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj24.getInstruction());
    }

    @Test
    public void setHex25() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex25);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj25.getInstruction());
    }

    @Test
    public void setHex26() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex26);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj26.getInstruction());
    }

    @Test
    public void setHex27() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex27);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj27.getInstruction());
    }

    @Test
    public void setHex28() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex28);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj28.getInstruction());
    }

    @Test
    public void setHex29() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex29);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj29.getInstruction());
    }

    @Test
    public void setHex30() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex30);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj30.getInstruction());
    }
    @Test
    public void setHex31() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex31);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj31.getInstruction());
    }

    @Test
    public void setHex32() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex32);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj32.getInstruction());
    }

    @Test
    public void setHex33() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex33);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj33.getInstruction());
    }

    @Test
    public void setHex34() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex34);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj34.getInstruction());
    }

    @Test
    public void setHex35() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex35);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj35.getInstruction());
    }

    @Test
    public void setHex36() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex36);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj36.getInstruction());
    }

    @Test
    public void setHex37() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex37);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj37.getInstruction());
    }

    @Test
    public void setHex38() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex38);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj38.getInstruction());
    }

    @Test
    public void setHex39() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex39);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj39.getInstruction());
    }

    @Test
    public void setHex40() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex40);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj40.getInstruction());
    }

    @Test
    public void setHex41() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex41);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj41.getInstruction());
    }

    @Test
    public void setHex42() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex42);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj42.getInstruction());
    }

    @Test
    public void setHex43() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex43);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj43.getInstruction());
    }

    @Test
    public void setHex44() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex44);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj44.getInstruction());
    }

    @Test
    public void setHex45() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex45);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj45.getInstruction());
    }

    @Test
    public void setHex46() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex46);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj46.getInstruction());
    }

    @Test
    public void setHex47() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex47);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj47.getInstruction());
    }

    @Test
    public void setHex48() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex48);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj48.getInstruction());
    }

    @Test
    public void setHex49() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex49);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj49.getInstruction());
    }

    @Test
    public void setHex50() {
        Operation tempOpObj = tsc.lnInterpreter_txtHex(hex50);
        assertArrayEquals(tempOpObj.getInstruction(), hexObj50.getInstruction());
    }
}