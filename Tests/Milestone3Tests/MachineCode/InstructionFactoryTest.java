package Milestone3Tests.MachineCode;

import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFactoryTest {
    GeneralMachineCode gmc = new GeneralMachineCode();
    String[] bin1 = new String[]{"00000010101101001110100000100010", "sub"}; // "02b4e822"
    String[] bin2 = new String[]{"00000000000000000000000000001100", "syscall"}; // "0000000c"
    String[] bin3 = new String[]{"00000010011110110100100000100010", "sub"}; // "027b4822"
    String[] bin4 = new String[]{"00110100000100111111111100100000", "ori"}; // "3413ff20"
    String[] bin5 = new String[]{"00010001011111100000000011011111", "beq"}; // "117e00df"
    String[] bin6 = new String[]{"00000011000010100000100000100000", "add"}; // "030a0820"
    String[] bin7 = new String[]{"00010011011010101111111110101110", "beq"}; // "136affae"
    String[] bin8 = new String[]{"00010000010001000000000000010111", "beq"}; // "10440017"
    String[] bin9 = new String[]{"00001000000000000000000011001101", "j"}; // "080000cd"
    String[] bin10 = new String[]{"10101110100101000000000000000000", "sw"}; // "ae940000"
    String[] bin11 = new String[]{"00110111010100110000000010101110", "ori"}; // "375300ae"
    String[] bin12 = new String[]{"00000000000000000000000000001100", "syscall"}; // "0000000c"
    String[] bin13 = new String[]{"00000000110111111110000000101010", "slt"}; // "00dfe02a"
    String[] bin14 = {"00100100111010100000000000000001", "addiu"}; // "24ea0001"
    String[] bin15 = {"00010101010101010101010000010000", "bne"}; // "15555410"
    String[] bin16 = {"00111100000110000000100110010011", "lui"}; // "3c180993"
    String[] bin17 = {"10001100011001110000000000000001", "lw"}; // "8c670001"
    String[] bin18 = {"00000001001010010100000000100100", "and"}; // "01294024"
    String[] bin19 = {"00000000001101001000000100100101", "or"}; // "00348125"
    String[] bin20 = {"10111111110111110101101110011001", "random"}; // "bfdf5b99"
    String[] bin21 = {"00110010011110011111111100010010", "andi"}; // "3279ff12"


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
    String instr14 = "addiu {opcode: 09, rs(base): 07, rt: 0a, immediate(offset): 0001}"; //24ea0001
    String instr15 = "bne {opcode: 05, rs(base): 0a, rt: 15, immediate(offset): 5410}"; //15555410
    String instr16 = "lui {opcode: 0f, rs(base): 00, rt: 18, immediate(offset): 0993}"; //3c180993
    String instr17 = "lw {opcode: 23, rs(base): 03, rt: 07, immediate(offset): 0001}"; //8c670001
    String instr18 = "and {opcode: 00, rs: 09, rt: 09, rd: 08, shmt: 00, funct: 24}"; //01294024
    String instr19 = "or {opcode: 00, rs: 01, rt: 14, rd: 10, shmt: 00, funct: 25}"; //00348125
    String instr20 = "Unknown instruction"; // not used.
    String instr21 = "andi {opcode: 0c, rs(base): 13, rt: 19, immediate(offset): ff12}"; //bfdf5b99
//
//    String[] bin14 = {"24ea0001", "addiu"}; // addiu t2, a3, 0x1
//    String[] bin15 = {"15555410", "bne"}; // bne t1, t2, 0xAF10
//    String[] bin16 = {"3c180993", "lui"}; // lui v1, 0x999
//    String[] bin17 = {"8c670001", "lw"}; // lw a2, 0x1(v1)
//    String[] bin18 = {"01294024", "and"}; // and t1, t1, t2
//    String[] bin19 = {"00348125", "or"}; // or a1, a2, v0
//    String[] bin20 = {"bfdf5b99", "random"}; // random


    @Test
    void setBin1() {
        assertEquals(instr1, gmc.instruction_factory(bin1[0], bin1[1]));
    }

    @Test
    void setBin2() {
        assertEquals(instr2, gmc.instruction_factory(bin2[0], bin2[1]));
    }

    @Test
    void setBin3() {
        assertEquals(instr3, gmc.instruction_factory(bin3[0], bin3[1]));
    }

    @Test
    void setBin4() {
        assertEquals(instr4, gmc.instruction_factory(bin4[0], bin4[1]));
    }

    @Test
    void setBin5() {
        assertEquals(instr5, gmc.instruction_factory(bin5[0], bin5[1]));
    }

    @Test
    void setBin6() {
        assertEquals(instr6, gmc.instruction_factory(bin6[0], bin6[1]));
    }

    @Test
    void setBin7() {
        assertEquals(instr7, gmc.instruction_factory(bin7[0], bin7[1]));
    }

    @Test
    void setBin8() {
        assertEquals(instr8, gmc.instruction_factory(bin8[0], bin8[1]));
    }

    @Test
    void setBin9() {
        assertEquals(instr9, gmc.instruction_factory(bin9[0], bin9[1]));
    }

    @Test
    void setBin10() {
        assertEquals(instr10, gmc.instruction_factory(bin10[0], bin10[1]));
    }

    @Test
    void setBin11() {
        assertEquals(instr11, gmc.instruction_factory(bin11[0], bin11[1]));
    }

    @Test
    void setBin12() {
        assertEquals(instr12, gmc.instruction_factory(bin12[0], bin12[1]));
    }

    @Test
    void setBin13() {
        assertEquals(instr13, gmc.instruction_factory(bin13[0], bin13[1]));
    }

    @Test
    void setBin14() {
        assertEquals(instr14, gmc.instruction_factory(bin14[0], bin14[1]));
    }

    @Test
    void setBin15() {
        assertEquals(instr15, gmc.instruction_factory(bin15[0], bin15[1]));
    }

    @Test
    void setBin16() {
        assertEquals(instr16, gmc.instruction_factory(bin16[0], bin16[1]));
    }

    @Test
    void setBin17() {
        assertEquals(instr17, gmc.instruction_factory(bin17[0], bin17[1]));
    }

    @Test
    void setBin18() {
        assertEquals(instr18, gmc.instruction_factory(bin18[0], bin18[1]));
    }

    @Test
    void setBin19() {
        assertEquals(instr19, gmc.instruction_factory(bin19[0], bin19[1]));
    }

    @Test
    void setBin20() {
        assertThrows(IllegalArgumentException.class, () -> gmc.instruction_factory(bin20[0], bin20[1]));
    }

    @Test
    void setBin21() {
        assertEquals(instr21, gmc.instruction_factory(bin21[0], bin21[1]));
    }
}

/* keeping this bc asked GPT to convert all hex's in binary and it may have done it wrong ...
 String[] bin1 = new String[]{"02b4e822","sub"};
    String[] bin2 = new String[]{"0000000c","syscall"};
    String[] bin3 = new String[]{"027b4822","sub"};
    String[] bin4 = new String[]{"3413ff20","ori"};
    String[] bin5 = new String[]{"117e00df","beq"};
    String[] bin6 = new String[]{"030a0820","add"};
    String[] bin7 = new String[]{"136affae","beq"};
    String[] bin8 = new String[]{"10440017","beq"};
    String[] bin9 = new String[]{"080000cd","j"};
    String[] bin10 = new String[]{"ae940000","sw"};
    String[] bin11 = new String[]{"375300ae","ori"};
    String[] bin12 = new String[]{"0000000c","syscall"};
    String[] bin13 = new String[]{"00dfe02a","slt"};
    String[] bin14 = {"24ea0001", "addiu"}; // addiu t2, a3, 0x1
    String[] bin15 = {"15555410", "bne"}; // bne t1, t2, 0xAF10
    String[] bin16 = {"3c180993", "lui"}; // lui v1, 0x999
    String[] bin17 = {"8c670001", "lw"}; // lw a2, 0x1(v1)
    String[] bin18 = {"01294024", "and"}; // and t1, t1, t2
    String[] bin19 = {"00348125", "or"}; // or a1, a2, v0
    String[] bin20 = {"bfdf5b99", "random"}; // random
 */