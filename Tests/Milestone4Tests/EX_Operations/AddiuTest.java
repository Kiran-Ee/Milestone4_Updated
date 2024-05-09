package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Addiu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// op-code: addiu, rt, rs, immediate
// machine-code: sp, rs, rt, immediate
public class AddiuTest {
    Addiu addiu = null; // used to instantiate new OperationObj every test ...
    String bin_instr1 = "00100110001100000000000000001010"; //addiu", "$s0", "$s1", "10
    String bin_inst_2 = "00100101010010111111111111111111"; //addiu t3 t2 0xFFFF
    String bin_inst_3 = "00100100101101010000000000110000"; //addiu s5 a1 0x30
    String bin_inst_4 = "00100100000000110000000000000000"; //addiu v1 zero 0x0
    String bin_inst_5 = "00100100100001001111111111111110"; //addiu a0 a0 65534

    int s0_val = 16;
    int s1_val = 17;
    int t2_val = 10;
    int t3_val = 11;
    int s5_val = 21;
    int a1_val = 5;
    int v1_val = 0;
    int a0_val = 1;

    int exp_addiu1 = 27;
    int exp_addiu2 = 65545;
    int exp_addiu3 = 53;
    int exp_addiu4 = 0;
    int exp_addiu5 = 65535;

    @BeforeEach
    public void setUp() {
        CPU.s0 = s0_val;
        CPU.s1 = s1_val;
        CPU.t2 = t2_val;
        CPU.t3 = t3_val;
        CPU.a1 = a1_val;
        CPU.s5 = s5_val;
        CPU.v1 = v1_val;
        CPU.zero = 0;
        CPU.a0 = a0_val;
    }

    @Test
    public void setAddiu1() {
        addiu = new Addiu(bin_instr1);
        addiu.operate();
        assertEquals(exp_addiu1, CPU.s0);
    }

    @Test
    public void setAddiu2() {
        addiu = new Addiu(bin_inst_2);
        addiu.operate();
        assertEquals(CPU.t3, exp_addiu2);

    }

    @Test
    public void setAddiu3() {
        addiu = new Addiu(bin_inst_3);
        addiu.operate();
        assertEquals(exp_addiu3, CPU.s5);
    }

    @Test
    public void setAddiu4() {
        addiu = new Addiu(bin_inst_4);
        addiu.operate();
        assertEquals(exp_addiu4, CPU.v1);
    }


    @Test
    public void setAddiu5() {
        addiu = new Addiu(bin_inst_5);
        addiu.operate();
        assertEquals(exp_addiu5, CPU.a0);
    }
}
