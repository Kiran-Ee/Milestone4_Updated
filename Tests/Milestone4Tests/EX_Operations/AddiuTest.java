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
     String bin_instr1 = "00100110111110110000000000111110"; //addiu", "$s0", "$s1", "10
     String bin_inst_2 = "00100101010010111111111111111111"; //addiu t3 t2 0xFFFF
    String bin_inst_3 = "00100101010010111111111111111111";//addiu $s5 $a1 30
    int s0_val = 16;
    int s1_val = 17;
    int t2_val= 10;
    int t3_val = 11;
    int s5_val = 21;
    int a1_val = 5;
   // int immediate_val1 = 10;
    int immediate_val2 = 0xFFFF;
    int immediate_val3 = 30;
    int exp_addiu1 = 26;
    int exp_addiu2 = t2_val + immediate_val2;
    int exp_addiu3 = a1_val + immediate_val3; //00100100101101010000000000011110

    @BeforeEach
    public void setUp() {
        CPU.s0 = s0_val;
        CPU.s1 = s1_val;
        CPU.t2 = t2_val;
        CPU.t3 = t3_val;
        CPU.a1 = a1_val;
        CPU.s5 = s5_val;
    }

    @Test
    public void setAddiu1() {
        addiu = new Addiu(bin_instr1);
        addiu.operate();
        assertEquals(CPU.s1, exp_addiu1);

    }
    @Test
    public void setAddiu2() {
        addiu = new Addiu(bin_inst_2);
        addiu.operate();
        assertEquals(CPU.t2, exp_addiu2);

    }
    @Test
    public void setAddiu3(){
        addiu = new Addiu(bin_inst_3);
        addiu.operate();
        assertEquals(CPU.a1, exp_addiu3);
    }
}
