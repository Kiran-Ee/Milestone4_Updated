package Milestone4Tests.CPU;

import SecConverters.DataSecConverter;
import org.junit.jupiter.api.Test;

// taken from CpuTest
class RunProgramTest {

    // EvenOrOdd(1).asm
    String textSec1 = "3c011001\n" +
            "34240000\n" +
            "3c011001\n" +
            "34240015\n" +
            "3c011001\n" +
            "3424002b\n" +
            "24020004\n" +
            "3c011001\n" +
            "34240000\n" +
            "0000000c\n" +
            "24020005\n" +
            "0000000c\n" +
            "00026020\n" +
            "31880001\n" +
            "11000001\n" +
            "08100015\n" +
            "24020004\n" +
            "3c011001\n" +
            "34240015\n" +
            "0000000c\n" +
            "08100019\n" +
            "24020004\n" +
            "3c011001\n" +
            "3424002b\n" +
            "0000000c\n" +
            "2402000a\n" +
            "0000000c\n";

    String exp_out1 = "Enter your integer: 10\n" + "Your integer is EVEN!\n" + "-- program is finished running --";
    int[] exp_reg1 = new int[]{0, 268500992, 10, 0, 268501013, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268468224, 2147479548, 0, 0};

    // RunProgramTest
    String dataSec2 = "73696854\n" +
            "20736920\n" +
            "20202061\n" +
            "74614409\n" +
            "614c2061\n" +
            "2d6c6562\n" +
            "212f2423";
    String textSec2 = "240100c8\n" +
            "2402012c\n" +
            "24030190\n" +
            "240401f4\n" +
            "24050258\n" +
            "240602bc\n" +
            "24070320\n" +
            "24080384\n" +
            "240903e8\n" +
            "240a044c\n" +
            "240b04b0\n" +
            "240c0514\n" +
            "240d0578\n" +
            "240e05dc\n" +
            "240f0640\n" +
            "241006a4\n" +
            "24110708\n" +
            "2412076c\n" +
            "241307d0\n" +
            "24140834\n" +
            "24150898\n" +
            "241608fc\n" +
            "24170960\n" +
            "241809c4\n" +
            "24190a28\n" +
            "241a0a8c\n" +
            "241b0af0\n" +
            "241c0b54\n" +
            "241d0bb8\n" +
            "241e0c1c\n" +
            "241f0c80\n" +
            "022f4020\n" +
            "27620064\n" +
            "012a2024\n" +
            "3130000a\n" +
            "1109000a\n" +
            "15090009\n" +
            "3c0c0064\n" +
            "8d320000\n" +
            "012ac825\n" +
            "3523000a\n" +
            "012a082a\n" +
            "012ab822\n" +
            "ad280000\n" +
            "0810002e\n" +
            "0000000c\n" +
            "3c011001\n" +
            "34240000\n" +
            "24020004\n" +
            "0000000c";

    String exp_out2 = "This is a   \tData Label-#$/!\n" +
            "-- program is finished running (dropped off bottom) --";
    int[] exp_reg2 = new int[]{
            0,
            268500992,
            4,
            400,
            268500992,
            600,
            700,
            800,
            3400,
            1000,
            1100,
            1200,
            1300,
            1400,
            1500,
            1600,
            8,
            1800,
            1900,
            2000,
            2100,
            2200,
            2300,
            2400,
            2500,
            2600,
            2700,
            2800,
            2900,
            3000,
            3100,
            3200,
            4194504
    };

    // simpleCPUTest
    String dataSec3 = "";
    String textSec3 = "240203f2\n" +
            "24170009\n" +
            "00574020\n" +
            "24020001\n" +
            "00082021\n" +
            "0000000c\n";

    String exp_out3 = "1019\n" +
            "-- program is finished running (dropped off bottom) --";
    int[] exp_reg3 = new int[]{
            0, // zero
            0, // at
            1, // v0
            0, // v1
            1019, // a0
            0, // a1
            0, // a2
            0, // a3
            1019, // to
            0, // t1
            0, // t2
            0, // t3
            0, // t4
            0, // t5
            0, // t6
            0, // t7
            0, // s0
            0, // s1
            0, // s2
            0, // s3
            0, // s4
            0, // s5
            0, // s6
            9, // s7
            0, // t8
            0, // t9
            0, // k0
            0, // k1
            268500992, // gp
            2147479548, // sp
            0, // fp
            0, // ra
            4194328 // pc
    };


    @Test
    void run_program1() {
        DataSecConverter.data_mem.put("10010000", "Enter your integer:");
        DataSecConverter.data_mem.put("10010015", "Your integer is EVEN!");
        DataSecConverter.data_mem.put("1001002b", "Your integer is ODD!");


    }
}