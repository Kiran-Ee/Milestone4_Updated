package Milestone4Tests.CPU;

import CPU.CPU;
import MachineCode.GeneralMachineCode;
import Operations.*;
import SecConverters.DataSecConverter;
import SecConverters.TextSecConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static SecConverters.DataSecConverter.data_mem;
import static SecConverters.TextSecConverter.text_mem;
import static org.junit.Assert.assertEquals;

//import static org.testng.AssertJUnit.assertEquals;

// taken from CpuTest
// THE SCANNER INPUT MUST BE HARDCODED SO AT LEAST 1 WILL PASS BUT THE OTHERS WILL FAIL.
// data_mem set in each method bc static variable
// text_mem set in each method bc static variable
class RunProgramTest {
    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>(); //EvenOrOdd(1).asm
    LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>(); //RunProgramTest

    // EvenOrOdd(1).asm
    Lui lui1_EOO = new Lui("00111100000000010001000000000001");
    Ori ori1_EOO = new Ori("00110100001001000000000000000000");
    Lui lui2_EOO = new Lui("00111100000000010001000000000001");
    Ori ori2_EOO = new Ori("00110100001001000000000000010101");
    Lui lui3_EOO = new Lui("00111100000000010001000000000001");
    Ori ori3_EOO = new Ori("00110100001001000000000000101011");
    Addiu addiu1_EOO = new Addiu("00100100000000100000000000000100");
    Lui lui4_EOO = new Lui("00111100000000010001000000000001");
    Ori ori4_EOO = new Ori("00110100001001000000000000000000");
    Syscall syscall1 = new Syscall();
    Addiu addiu2_EOO = new Addiu("00100100000000100000000000000101");
    Syscall syscall2 = new Syscall();
    Add add1_EOO = new Add("00000000000000100110000000100000");
    AndI andi1_EOO = new AndI("00110001100010000000000000000001");
    Beq beq_EOO = new Beq("00010001000000000000000000000001");
    j j1_EOO = new j("00001000010000000000000001010100");
    Addiu addiu3_EOO = new Addiu("00100100000000100000000000000100");
    Lui lui5_EOO = new Lui("00111100000000010001000000000001");
    Ori ori5_EOO = new Ori("00110100001001000000000000010101");
    Syscall syscall3 = new Syscall();
    j j2_EOO = new j("00001000010000000000000001100100");
    Addiu addiu4_EOO = new Addiu("00100100000000100000000000000100");
    Lui lui6_EOO = new Lui("00111100000000010001000000000001");
    Ori ori6_EOO = new Ori("00110100001001000000000000101011");
    Syscall syscall4 = new Syscall();
    Addiu addiu5_EOO = new Addiu("00100100000000100000000000001010");
    Syscall syscall5 = new Syscall();

    //RunProgramTest
    Addiu addiu1_rpt = new Addiu("00100100000000010000000011001000");
    Addiu addiu2_rpt = new Addiu("00100100000000100000000100101100");
    Addiu addiu3_rpt = new Addiu("00100100000000110000000110010000");
    Addiu addiu4_rpt = new Addiu("00100100000001000000000111110100");
    Addiu addiu5_rpt = new Addiu("00100100000001010000001001011000");
    Addiu addiu6_rpt = new Addiu("00100100000001100000001010111100");
    Addiu addiu7_rpt = new Addiu("00100100000001110000001100100000");
    Addiu addiu8_rpt = new Addiu("00100100000010000000001110000100");
    Addiu addiu9_rpt = new Addiu("00100100000010010000001111101000");
    Addiu addiu10_rpt = new Addiu("00100100000010100000010001001100");
    Addiu addiu11_rpt = new Addiu("00100100000010110000010010110000");
    Addiu addiu12_rpt = new Addiu("00100100000011000000010100010100");
    Addiu addiu13_rpt = new Addiu("00100100000011010000010101111000");
    Addiu addiu14_rpt = new Addiu("00100100000011100000010111011100");
    Addiu addiu15_rpt = new Addiu("00100100000011110000011001000000");
    Addiu addiu16_rpt = new Addiu("00100100000100000000011010100100");
    Addiu addiu17_rpt = new Addiu("00100100000100010000011100001000");
    Addiu addiu18_rpt = new Addiu("00100100000100100000011101101100");
    Addiu addiu19_rpt = new Addiu("00100100000100110000011111010000");
    Addiu addiu20_rpt = new Addiu("00100100000101000000100000110100");
    Addiu addiu21_rpt = new Addiu("00100100000101010000100010011000");
    Addiu addiu22_rpt = new Addiu("00100100000101100000100011111100");
    Addiu addiu23_rpt = new Addiu("00100100000101110000100101100000");
    Addiu addiu24_rpt = new Addiu("00100100000110000000100111000100");
    Addiu addiu25_rpt = new Addiu("00100100000110010000101000101000");
    Addiu addiu26_rpt = new Addiu("00100100000110100000101010001100");
    Addiu addiu27_rpt = new Addiu("00100100000110110000101011110000");
    Addiu addiu28_rpt = new Addiu("00100100000111000000101101010100");
    Addiu addiu29_rpt = new Addiu("00100100000111010000101110111000");
    Addiu addiu30_rpt = new Addiu("00100100000111100000110000011100");
    Addiu addiu31_rpt = new Addiu("00100100000111110000110010000000");
    Add add1_rpt = new Add("00000010001011110100000000100000");
    Addiu addiu32_rpt = new Addiu("00100111011000100000000001100100");
    Add add2_rpt = new Add("00000001001010100010000000100100");
    Lui lui1_rpt = new Lui("00111100000000010001000000000001");
    Ori ori1_rpt = new Ori("00110100001010010000000000000000");
    Sw sw1_rpt = new Sw("10101101001010000000000000100000");
    Addiu addiu33_rpt = new Addiu("00100100000101010000000000110000");
    Sw sw2_rpt = new Sw("10101101001101010000000011110000");
    AndI andi1_rpt = new AndI("00110001001100000000000000001010");
    Beq beq1_rpt = new Beq("00010001000010010000000000001001");
    Bne bne1_rpt = new Bne("00010101000010010000000000001000");
    Lui lui2_rpt = new Lui("00111100000011000000000001100100");
    Lw lw1_rpt = new Lw("10001101001100100000000000000111");
    Or or1_rpt = new Or("00000001001010101100100000100101");
    Ori ori2_rpt = new Ori("00110101001000110000000000001010");
    Slt slt1_rpt = new Slt("00000001001010100000100000101010");
    Sub sub1_rpt = new Sub("00000001001010101011100000100010");
    j j1_rpt = new j("00001000000100000000000000110010");
    Syscall syscall1_rpt = new Syscall();
    Lui lui3_rpt = new Lui("00111100000000010001000000000001");
    Ori ori3_rpt = new Ori("00110100001001000000000000000000");
    Addiu addiu34_rpt = new Addiu("00100100000000100000000000000100");
    Syscall syscall2_rpt = new Syscall();

    String exp_out1 = "Enter your integer: \n" + "Your integer is EVEN!\n" + "-- program is finished running --\n"; //enter even "10"
    String exp_out2 = "Enter your integer: \n" + "Your integer is ODD!\n" + "-- program is finished running --\n"; //enter odd "11"
    int[] exp_reg1 = new int[]{0, 0x10010000, 0x0000000a, -1, 0x10010015, -1, -1, -1, 0, -1, -1, -1, 0x0000000a, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0x10008000, 0x7fffeffc, -1, -1};
    LinkedHashMap<String, Integer> exp_data_mem1 = new LinkedHashMap<>(); // TODO

    String exp_out3 = "This is a   \tData Label-#$/!\n" + "-- program is finished running (dropped off bottom) --\n";
    int[] exp_reg2 = new int[]{0x00000000, 0x10010000, 0x00000004, 0x00000190, 0x10010000, 0x00000258, 0x000002bc, 0x00000320, 0x00000d48, 0x10010000, 0x0000044c, 0x000004b0, 0x00000514, 0x00000578, 0x000005dc, 0x00000640, 0x000000, 0x00000708, 0x0000076c, 0x000007d0, 0x00000834, 0x00000030, 0x000008fc, 0x00000960, 0x000009c4, 0x00000a28, 0x00000a8c, 0x00000af0, 0x00000b54, 0x00000bb8, 0x00000c1c, 0x00000c80, 0x00000c1c, 0x00000c80, 0x004000d8, 0x00000000, 0x00000000};
    LinkedHashMap<String, Integer> exp_data_mem2 = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        hm1.put("10010000", 0x65746e45);
        hm1.put("10010004", 0x6f792072);
        hm1.put("10010008", 0x69207275);
        hm1.put("1001000c", 0x6765746e);
        hm1.put("10010010", 0x203a7265);
        hm1.put("10010014", 0x756f5900);
        hm1.put("10010018", 0x6e692072);
        hm1.put("1001001c", 0x65676574);
        hm1.put("10010020", 0x73692072);
        hm1.put("10010024", 0x45564520);
        hm1.put("10010028", 0x5900214e);
        hm1.put("1001002c", 0x2072756f);
        hm1.put("10010030", 0x65746e69);
        hm1.put("10010034", 0x20726567);
        hm1.put("10010038", 0x4f207369);
        hm1.put("1001003c", 0x00214444);

        hm2.put("10010000", 0x73696854);
        hm2.put("10010004", 0x20736920);
        hm2.put("10010008", 0x20202061);
        hm2.put("1001000c", 0x74614409);
        hm2.put("10010010", 0x614c2061);
        hm2.put("10010014", 0x2d6c6562);
        hm2.put("10010018", 0x212f2423);
        hm2.put("1001001c", 0x00000000);

        exp_data_mem1.put("10010000", 0x65746e45);
        exp_data_mem1.put("10010004", 0x6f792072);
        exp_data_mem1.put("10010008", 0x69207275);
        exp_data_mem1.put("1001000c", 0x6765746e);
        exp_data_mem1.put("10010010", 0x203a7265);
        exp_data_mem1.put("10010014", 0x756f5900);
        exp_data_mem1.put("10010018", 0x6e692072);
        exp_data_mem1.put("1001001c", 0x65676574);
        exp_data_mem1.put("10010020", 0x73692072);
        exp_data_mem1.put("10010024", 0x45564520);
        exp_data_mem1.put("10010028", 0x5900214e);
        exp_data_mem1.put("1001002c", 0x2072756f);
        exp_data_mem1.put("10010030", 0x65746e69);
        exp_data_mem1.put("10010034", 0x20726567);
        exp_data_mem1.put("10010038", 0x4f207369);
        exp_data_mem1.put("1001003c", 0x00214444);

        exp_data_mem2.put("10010000", 0x73696854);
        exp_data_mem2.put("10010004", 0x20736920);
        exp_data_mem2.put("10010008", 0x20202061);
        exp_data_mem2.put("1001000c", 0x74614409);
        exp_data_mem2.put("10010010", 0x614c2061);
        exp_data_mem2.put("10010014", 0x2d6c6562);
        exp_data_mem2.put("10010018", 0x212f2423);
        exp_data_mem2.put("1001001c", 0x00000000);
        exp_data_mem2.put("10010020", 0x00000d48);
        exp_data_mem2.put("100100f0", 0x00000030);
    }

    // NEED TO HARDCODE EVEN NUMBER INTO "syscall_handler()" TO PASS BECAUSE SCANNER DOESN'T WORK WITH TESTS!
    @Test
    void exp_strOutput1_hm1() {
        data_mem = hm1;
        text_mem = new Operation[]{lui1_EOO, ori1_EOO, lui2_EOO, ori2_EOO, lui3_EOO, ori3_EOO, addiu1_EOO, lui4_EOO, ori4_EOO, syscall1, addiu2_EOO, syscall2, add1_EOO, andi1_EOO, beq_EOO, j1_EOO, addiu3_EOO, lui5_EOO, ori5_EOO, syscall3, j2_EOO, addiu4_EOO, lui6_EOO, ori6_EOO, syscall4, addiu5_EOO, syscall5};

        Assertions.assertEquals(exp_out1, CPU.run_program());
    }

    // Testing ODDs - NEED TO HARDCODE ODD NUMBER INTO "syscall_handler()" BECAUSE SCANNER DOESN'T LIKE TESTING
    @Test
    void exp_strOutput2_hm1() {
        data_mem = hm1;

        text_mem = new Operation[]{lui1_EOO, ori1_EOO, lui2_EOO, ori2_EOO, lui3_EOO, ori3_EOO, addiu1_EOO, lui4_EOO, ori4_EOO, syscall1, addiu2_EOO, syscall2, add1_EOO, andi1_EOO, beq_EOO, j1_EOO, addiu3_EOO, lui5_EOO, ori5_EOO, syscall3, j2_EOO, addiu4_EOO, lui6_EOO, ori6_EOO, syscall4, addiu5_EOO, syscall5};

        Assertions.assertEquals(exp_out2, CPU.run_program());
    }

    @Test
    void exp_registers_hm1() {
        CPU.reset_cpu();
        data_mem = hm1;
        text_mem = new Operation[]{lui1_EOO, ori1_EOO, lui2_EOO, ori2_EOO, lui3_EOO, ori3_EOO, addiu1_EOO, lui4_EOO, ori4_EOO, syscall1, addiu2_EOO, syscall2, add1_EOO, andi1_EOO, beq_EOO, j1_EOO, addiu3_EOO, lui5_EOO, ori5_EOO, syscall3, j2_EOO, addiu4_EOO, lui6_EOO, ori6_EOO, syscall4, addiu5_EOO, syscall5};

        CPU.run_program();
        HashMap<String, Integer> hm = CPU.get_registers_state();

        int exp_op_val = -1;
        int actual_op_val = -1;
        String reg_hex_unpadded = "";
        String reg_hex = "";
        String reg = "";

        for (int i = 0; i < hm.size(); i++) {
            exp_op_val = exp_reg1[i];

            reg_hex_unpadded = Integer.toHexString(i);
            reg_hex = GeneralMachineCode.pad_binary(reg_hex_unpadded, 2 - reg_hex_unpadded.length());
            reg = CPU.hex_to_reg(reg_hex);

            actual_op_val = hm.get(reg);

            System.out.println("Register: " + reg + " - Value: " + actual_op_val);

            Assertions.assertEquals(exp_op_val, actual_op_val);
        }
    }

    // TESTING RunProgramTEST
    @Test
    void exp_strOutput_hm2() {
        data_mem = hm2;
        text_mem = new Operation[]{addiu1_rpt, addiu2_rpt, addiu3_rpt, addiu4_rpt, addiu5_rpt, addiu6_rpt, addiu7_rpt, addiu8_rpt, addiu9_rpt, addiu10_rpt, addiu11_rpt, addiu12_rpt, addiu13_rpt, addiu14_rpt, addiu15_rpt, addiu16_rpt, addiu17_rpt, addiu18_rpt, addiu19_rpt, addiu20_rpt, addiu21_rpt, addiu22_rpt, addiu23_rpt, addiu24_rpt, addiu25_rpt, addiu26_rpt, addiu27_rpt, addiu28_rpt, addiu29_rpt, addiu30_rpt, addiu31_rpt, add1_rpt, addiu32_rpt, add2_rpt, lui1_rpt, ori1_rpt, sw1_rpt, addiu33_rpt, sw2_rpt, andi1_rpt, beq1_rpt, bne1_rpt, lui2_rpt, lw1_rpt, or1_rpt, ori2_rpt, slt1_rpt, sub1_rpt, j1_rpt, syscall1_rpt, lui3_rpt, ori3_rpt, addiu34_rpt, syscall2_rpt};
        String return_string = CPU.run_program();

        Assertions.assertEquals(exp_out3, return_string); // problem: not printing the final string (used when no syscall, runs out of instructions)
    }

    @Test
    void exp_registers_hm2() {
        data_mem = hm2;
        text_mem = new Operation[]{addiu1_rpt, addiu2_rpt, addiu3_rpt, addiu4_rpt, addiu5_rpt, addiu6_rpt, addiu7_rpt, addiu8_rpt, addiu9_rpt, addiu10_rpt, addiu11_rpt, addiu12_rpt, addiu13_rpt, addiu14_rpt, addiu15_rpt, addiu16_rpt, addiu17_rpt, addiu18_rpt, addiu19_rpt, addiu20_rpt, addiu21_rpt, addiu22_rpt, addiu23_rpt, addiu24_rpt, addiu25_rpt, addiu26_rpt, addiu27_rpt, addiu28_rpt, addiu29_rpt, addiu30_rpt, addiu31_rpt, add1_rpt, addiu32_rpt, add2_rpt, lui1_rpt, ori1_rpt, sw1_rpt, addiu33_rpt, sw2_rpt, andi1_rpt, beq1_rpt, bne1_rpt, lui2_rpt, lw1_rpt, or1_rpt, ori2_rpt, slt1_rpt, sub1_rpt, j1_rpt, syscall1_rpt, lui3_rpt, ori3_rpt, addiu34_rpt, syscall2_rpt};

        CPU.run_program();
        HashMap<String, Integer> hm = CPU.get_registers_state();

        int exp_op_val = -1;
        int actual_op_val = -1;
        String reg_hex_unpadded = "";
        String reg_hex = "";
        String reg = "";

        for (int i = 0; i < hm.size(); i++) {
            exp_op_val = exp_reg2[i];
            reg_hex_unpadded = Integer.toHexString(i);
            reg_hex = GeneralMachineCode.pad_binary(reg_hex_unpadded, 2 - reg_hex_unpadded.length());
            reg = CPU.hex_to_reg(reg_hex);
            actual_op_val = hm.get(reg);

            System.out.println("Register: " + reg);

            Assertions.assertEquals(exp_op_val, actual_op_val);
        }
    }

    // Testing Data Memories
    @Test
    void exp_data_mem_hm1() {
        data_mem = hm1;
        text_mem = new Operation[]{lui1_EOO, ori1_EOO, lui2_EOO, ori2_EOO, lui3_EOO, ori3_EOO, addiu1_EOO, lui4_EOO, ori4_EOO, syscall1, addiu2_EOO, syscall2, add1_EOO, andi1_EOO, beq_EOO, j1_EOO, addiu3_EOO, lui5_EOO, ori5_EOO, syscall3, j2_EOO, addiu4_EOO, lui6_EOO, ori6_EOO, syscall4, addiu5_EOO, syscall5};
        String return_string = CPU.run_program();

        Set<Map.Entry<String, Integer>> exp_es = exp_data_mem1.entrySet();
        Set<String> exp_keys = exp_data_mem1.keySet();

        Set<Map.Entry<String, Integer>> actual_es = data_mem.entrySet();
        Set<String> actual_keys = data_mem.keySet();

        assertEquals(exp_keys, actual_keys); // Check if key sets are equal

        for (Map.Entry<String, Integer> e : exp_es) { // Check if values are equal
            String key = e.getKey();
            Integer expectedValue = e.getValue();
            Integer actualValue = data_mem.get(key);

            assertEquals(expectedValue, actualValue);
        }
    }

    @Test
    void exp_data_mem_hm2() {
        data_mem = hm2;
        text_mem = new Operation[]{addiu1_rpt, addiu2_rpt, addiu3_rpt, addiu4_rpt, addiu5_rpt, addiu6_rpt, addiu7_rpt, addiu8_rpt, addiu9_rpt, addiu10_rpt, addiu11_rpt, addiu12_rpt, addiu13_rpt, addiu14_rpt, addiu15_rpt, addiu16_rpt, addiu17_rpt, addiu18_rpt, addiu19_rpt, addiu20_rpt, addiu21_rpt, addiu22_rpt, addiu23_rpt, addiu24_rpt, addiu25_rpt, addiu26_rpt, addiu27_rpt, addiu28_rpt, addiu29_rpt, addiu30_rpt, addiu31_rpt, add1_rpt, addiu32_rpt, add2_rpt, lui1_rpt, ori1_rpt, sw1_rpt, addiu33_rpt, sw2_rpt, andi1_rpt, beq1_rpt, bne1_rpt, lui2_rpt, lw1_rpt, or1_rpt, ori2_rpt, slt1_rpt, sub1_rpt, j1_rpt, syscall1_rpt, lui3_rpt, ori3_rpt, addiu34_rpt, syscall2_rpt};
        String return_string = CPU.run_program();

        Set<Map.Entry<String, Integer>> exp_es = exp_data_mem2.entrySet();
        Set<String> exp_keys = exp_data_mem2.keySet();

        Set<Map.Entry<String, Integer>> actual_es = data_mem.entrySet();
        Set<String> actual_keys = data_mem.keySet();

        assertEquals(exp_keys, actual_keys); // Check if key sets are equal

        for (Map.Entry<String, Integer> e : exp_es) { // Check if values are equal
            String key = e.getKey();
            Integer expectedValue = e.getValue();
            Integer actualValue = data_mem.get(key);

            assertEquals(expectedValue, actualValue);
        }
    }
}