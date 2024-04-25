package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexToMnenomicTest {
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

    String instr1 = "sub {opcode: 00, rs: 15, rt: 14, rd: 1d, shmt: 00, funct: 22}";
    String instr2 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr3 = "sub {opcode: 00, rs: 13, rt: 1b, rd: 09, shmt: 00, funct: 22}";
    String instr4 = "ori {opcode: 0d, rs(base): 00, rt: 13, immediate(offset): ff20}";
    String instr5 = "beq {opcode: 04, rs(base): 0b, rt: 1e, immediate(offset): 00df}";
    String instr6 = "add {opcode: 00, rs: 18, rt: 0a, rd: 01, shmt: 00, funct: 20}";
    String instr7 = "beq {opcode: 04, rs(base): 1b, rt: 0a, immediate(offset): ffae}";
    String instr8 = "beq {opcode: 04, rs(base): 02, rt: 04, immediate(offset): 0017}";
    String instr9 = "j {opcode: 02, index: 00000cd}";
    String instr10 = "sw {opcode: 2b, rs(base): 14, rt: 14, immediate(offset): 0000}";
    String instr11 = "ori {opcode: 0d, rs(base): 1a, rt: 13, immediate(offset): 00ae}";
    String instr12 = "syscall {opcode: 00, code: 000000, funct: 0c}";
    String instr13 = "slt {opcode: 00, rs: 06, rt: 1f, rd: 1c, shmt: 00, funct: 2a}";

    @Test
    void setHex1() {
        assertEquals(instr1, gmc.hex_to_mnenomic(hex1));
    }

    @Test
    void setHex2() {
        assertEquals(instr2, gmc.hex_to_mnenomic(hex2));
    }

    @Test
    void setHex3() {
        assertEquals(instr3, gmc.hex_to_mnenomic(hex3));
    }

    @Test
    void setHex4() {
        assertEquals(instr4, gmc.hex_to_mnenomic(hex4));
    }

    @Test
    void setHex5() {
        assertEquals(instr5, gmc.hex_to_mnenomic(hex5));
    }

    @Test
    void setHex6() {
        assertEquals(instr6, gmc.hex_to_mnenomic(hex6));
    }

    @Test
    void setHex7() {
        assertEquals(instr7, gmc.hex_to_mnenomic(hex7));
    }

    @Test
    void setHex8() {
        assertEquals(instr8, gmc.hex_to_mnenomic(hex8));
    }

    @Test
    void setHex9() {
        assertEquals(instr9, gmc.hex_to_mnenomic(hex9));
    }

    @Test
    void setHex10() {
        assertEquals(instr10, gmc.hex_to_mnenomic(hex10));
    }

    @Test
    void setHex11() {
        assertEquals(instr11, gmc.hex_to_mnenomic(hex11));
    }

    @Test
    void setHex12() {
        assertEquals(instr12, gmc.hex_to_mnenomic(hex12));
    }

    @Test
    void setHex13() {
        assertEquals(instr13, gmc.hex_to_mnenomic(hex13));
    }


}