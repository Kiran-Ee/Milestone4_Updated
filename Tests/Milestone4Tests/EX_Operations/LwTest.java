package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Lw;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LwTest {
    Lw lw = null;
    LinkedHashMap<String, String> hm1 = new LinkedHashMap<>();


    String bin_instr1 = "10001110001010000000000000001000"; //"lw", "$t0", "8", "$s1
    String bin_instr2 = "10001110001110100000000000000000"; //lw k0 0x0 s1
    String bin_invalid_instr1 = "10001110001010000000000000001010"; //"lw", "$t0", "10", "$s1 ... offset must be factor of 4 bc word addressing (4 bytes)

    int t0_val = 8;
    int s1_val = 268500992; //0x10010000

    int k0_val = 938457;
    //int s1_val = 268500992; //0x10010000


    int exp_lui1 = 0x69207275;
    int exp_lui2 = 0x65746e45;
    // exception for invalid1



    @BeforeEach
    public void setUp() {
        CPU.t0 = t0_val;
        CPU.s1 = s1_val;

        CPU.k0 = k0_val;

        DataSecConverter.data_mem.put("10010000", "Enter your integer: ");
        DataSecConverter.data_mem.put("10010015", "Your integer is EVEN!");
        DataSecConverter.data_mem.put("1001002b", "Your integer is ODD!");
    }

    @Test
    public void setLui1() {
        lw = new Lw(bin_instr1);
        lw.operate();
        assertEquals(exp_lui1, CPU.t0);
    }

    @Test
    public void setLui2() {
        lw = new Lw(bin_instr2);
        lw.operate();
        assertEquals(exp_lui2, CPU.k0);
    }

    @Test
    public void setLui1_invalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            lw = new Lw(bin_invalid_instr1);
        });
    }
}
