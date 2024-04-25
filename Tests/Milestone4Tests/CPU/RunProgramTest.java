package Milestone4Tests.CPU;

import CPU.CPU;
import Operations.*;
import SecConverters.DataSecConverter;
import SecConverters.TextSecConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

// taken from CpuTest
class RunProgramTest {

    // EvenOrOdd(1).asm
    // data_mem set in each method bc static variable
    // text_mem set in each method bc static variable
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
    j j1_EOO = new j("00001000000100000000000000010101");
    Addiu addiu3_EOO = new Addiu("00100100000000100000000000000100");
    Lui lui5_EOO = new Lui("00111100000000010001000000000001");
    Ori ori5_EOO = new Ori("00110100001001000000000000010101");
    Syscall syscall3 = new Syscall();
    j j2_EOO = new j("00001000000100000000000000011001");
    Addiu addiu4_EOO = new Addiu("00100100000000100000000000000100");
    Lui lui6_EOO = new Lui("00111100000000010001000000000001");
    Ori ori6_EOO = new Ori("00110100001001000000000000101011");
    Syscall syscall4 = new Syscall();
    Addiu addiu5_EOO = new Addiu("00100100000000100000000000001010");
    Syscall syscall5 = new Syscall();

    String exp_out1 = "Enter your integer: 10\n" + "Your integer is EVEN!\n" + "-- program is finished running --";
    int[] exp_reg1 = new int[]{0, 268500992, 10, 0, 268501013, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268468224, 2147479548, 0, 0};

//  GO THROUGH AND MAKE VARIABLES FOR OTHE PROGRAMS WHEN TESTING ... DIN'T WANT TO DO ALL THIS BC WE MIGHT END UP CHANGING EVERYTHING

    @Test
    void exp_out1() {
        DataSecConverter.data_mem.put("10010000", "Enter your integer:");
        DataSecConverter.data_mem.put("10010015", "Your integer is EVEN!");
        DataSecConverter.data_mem.put("1001002b", "Your integer is ODD!");
        TextSecConverter.text_mem = new Operation[]{lui1_EOO, ori1_EOO, lui2_EOO, ori2_EOO, lui3_EOO, ori3_EOO, addiu1_EOO, lui4_EOO, ori4_EOO, syscall1, addiu2_EOO, syscall2, add1_EOO, andi1_EOO, beq_EOO, j1_EOO, addiu3_EOO, lui5_EOO, ori5_EOO, syscall3, j2_EOO, addiu4_EOO, lui6_EOO, ori6_EOO, syscall4, addiu5_EOO, syscall5};

        Assertions.assertEquals(exp_out1, CPU.run_program());
    }

    @Test
    void exp_reg1() {
        CPU.run_program();
        HashMap<String, Integer> hm = CPU.get_registers_state();
        Set<Map.Entry<String, Integer>> hm_entrySet = hm.entrySet();
        int i = 0;
        for (Map.Entry<String, Integer> entry : hm_entrySet) {
            Assertions.assertEquals(exp_reg1[i++], entry.getValue());
        }
    }
}