package Milestone4Tests.CPU;

import CPU.CPU;
import MachineCode.GeneralMachineCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class CpuTest {

    // EvenOrOdd(1).asm
    String dataSec1 = "65746e45\n" + "6f792072\n" + "69207275\n" + "6765746e\n" + "203a7265\n" + "756f5900\n" + "6e692072\n" + "65676574\n" + "73692072\n" + "45564520\n" + "5900214e\n" + "2072756f\n" + "65746e69\n" + "20726567\n" + "4f207369\n" + "00214444\n";
    String textSec1 = "3c011001\n" + "34240000\n" + "3c011001\n" + "34240015\n" + "3c011001\n" + "3424002b\n" + "24020004\n" + "3c011001\n" + "34240000\n" + "0000000c\n" + "24020005\n" + "0000000c\n" + "00026020\n" + "31880001\n" + "11000001\n" + "08100015\n" + "24020004\n" + "3c011001\n" + "34240015\n" + "0000000c\n" + "08100019\n" + "24020004\n" + "3c011001\n" + "3424002b\n" + "0000000c\n" + "2402000a\n" + "0000000c\n";

    String exp_out1 = "Enter your integer: \n" + "Your integer is EVEN!\n" + "-- program is finished running --\n"; //from syscall
    int[] exp_reg1 = new int[]{0, 0x10010000, 0x0000000a, -1, 0x10010015, -1, -1, -1, 0, -1, -1, -1, 0x0000000a, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0x10008000, 0x7fffeffc, -1, -1};


    // RunProgramTest
    String dataSec2 = "73696854\n" + "20736920\n" + "20202061\n" + "74614409\n" + "614c2061\n" + "2d6c6562\n" + "212f2423\n" + "00000000";
    String textSec2 = "240100c8\n" + "2402012c\n" + "24030190\n" + "240401f4\n" + "24050258\n" + "240602bc\n" + "24070320\n" + "24080384\n" + "240903e8\n" + "240a044c\n" + "240b04b0\n" + "240c0514\n" + "240d0578\n" + "240e05dc\n" + "240f0640\n" + "241006a4\n" + "24110708\n" + "2412076c\n" + "241307d0\n" + "24140834\n" + "24150898\n" + "241608fc\n" + "24170960\n" + "241809c4\n" + "24190a28\n" + "241a0a8c\n" + "241b0af0\n" + "241c0b54\n" + "241d0bb8\n" + "241e0c1c\n" + "241f0c80\n" + "022f4020\n" + "27620064\n" + "012a2024\n" + "3c011001\n" + "34290000\n" + "ad280020\n" + "24150030\n" + "ad3500f0\n" + "3130000a\n" + "11090009\n" + "15090008\n" + "3c0c0064\n" + "8d320007\n" + "012ac825\n" + "3523000a\n" + "012a082a\n" + "012ab822\n" + "08100032\n" + "0000000c\n" + "3c011001\n" + "34240000\n" + "24020004\n" + "0000000c\n";

    String exp_out2 = "This is a   \tData Label-#$/!\n" + "-- program is finished running (dropped off bottom) --\n";
    int[] exp_reg2 = new int[]{0x00000000, 0x10010000, 0x00000004, 0x00000190, 0x10010000, 0x00000258, 0x000002bc, 0x00000320, 0x00000d48, 0x10010000, 0x0000044c, 0x000004b0, 0x00000514, 0x00000578, 0x000005dc, 0x00000640, 0x000000, 0x00000708, 0x0000076c, 0x000007d0, 0x00000834, 0x00000030, 0x000008fc, 0x00000960, 0x000009c4, 0x00000a28, 0x00000a8c, 0x00000af0, 0x00000b54, 0x00000bb8, 0x00000c1c, 0x00000c80};


    // simpleCPUTest
    String dataSec3 = "";
    String textSec3 = "240203f2\n" + "24170009\n" + "00574020\n" + "24020001\n" + "00082020\n" + "0000000c\n";

    String exp_out3 = "1019\n" + "-- program is finished running (dropped off bottom) --\n";
    int[] exp_reg3 = new int[]{0, // zero
            -1, // at
            0x00000001, // v0
            -1, // v1
            0x000003fb, // a0
            -1, // a1
            -1, // a2
            -1, // a3
            0x000003fb, // to
            -1, // t1
            -1, // t2
            -1, // t3
            -1, // t4
            -1, // t5
            -1, // t6
            -1, // t7
            -1, // s0
            -1, // s1
            -1, // s2
            -1, // s3
            -1, // s4
            -1, // s5
            -1, // s6
            0x00000009, // s7
            -1, // t8
            -1, // t9
            -1, // k0
            -1, // k1
            0x10008000, // gp
            0x7fffeffc, // sp
            -1, // fp
            -1, // ra
    };

    @Test
    void print_program1() {
        String return_string = CPU.cpu(dataSec1, textSec1);
        assertEquals(exp_out1, return_string);
    }

    @Test
    void registers_program1() {
        CPU.cpu(dataSec1, textSec1);
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

    @Test
    void print_program2() {
        String return_string = CPU.cpu(dataSec2, textSec2);
        assertEquals(exp_out2, return_string);
    }

    @Test
    void registers_program2() {
        CPU.cpu(dataSec2, textSec2);
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

            System.out.println("Register: " + reg + " - Value: " + actual_op_val);

            Assertions.assertEquals(exp_op_val, actual_op_val);
        }
    }

    @Test
    void print_program3() {
        assertEquals(exp_out3, CPU.cpu(dataSec3, textSec3));
    }

    @Test
    void registers_program3() {
        CPU.cpu(dataSec3, textSec3);
        HashMap<String, Integer> hm = CPU.get_registers_state();

        int exp_op_val = -1;
        int actual_op_val = -1;
        String reg_hex_unpadded = "";
        String reg_hex = "";
        String reg = "";

        for (int i = 0; i < hm.size(); i++) {
            exp_op_val = exp_reg3[i];

            reg_hex_unpadded = Integer.toHexString(i);
            reg_hex = GeneralMachineCode.pad_binary(reg_hex_unpadded, 2 - reg_hex_unpadded.length());
            reg = CPU.hex_to_reg(reg_hex);

            actual_op_val = hm.get(reg);

            System.out.println("Register: " + reg + " - Value: " + actual_op_val);

            Assertions.assertEquals(exp_op_val, actual_op_val);
        }
    }
}