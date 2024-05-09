package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.AndI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//op-code ANDI rt, rs, immediate
//Machine ANDI rs rt immediate
public class AndITest {
    AndI andi = null;
    String bin_inst1 = "00110010010100000000100110011001"; //andi $s0 $s2 0x999
    String bin_inst2 = "00110001010000100000000000001010"; //andi $v0 $t2 10
    String bin_inst3 = "00110000011001101111111111111111"; //andi a2 v1 0xffff
    String bin_inst4 = "00110000011001101111111111111111"; //andi a2 v1 65535
    String bin_inst5 = "00110001111010110000000000000000"; //andi t3 t7 0

    int s0_val = 16;
    int s2_val = 18;
    int imm_val1 = 0x999;

    int v0_val = 2;
    int t2_val = 10;
    int imm_val2 = 10;

    int a2_val = 35273;
    int v1_val = 3;
    int imm_val3 = 0xffff;
    int imm_val4 = 65535; // should be same

    int t3_val = -1;
    int t7_val = 10001;
    int imm_val5 = 0;

    int exp_andi1 = s2_val & imm_val1;
    int exp_andi2 = t2_val & imm_val2;
    int exp_andi3 = v1_val & imm_val3;
    int exp_andi4 = v1_val & imm_val4;
    int exp_andi5 = t7_val & imm_val5;


    @BeforeEach
    public void setUp(){
        CPU.s0 = s0_val;
        CPU.s2 = s2_val;

        CPU.v0 = v0_val;
        CPU.t2 = t2_val;

        CPU.a2 = a2_val;
        CPU.v1 = v1_val;

        CPU.t3 = t3_val;
        CPU.t7 = t7_val;
    }

    @Test
    public void setAndi1(){
        andi = new AndI(bin_inst1);
        andi.operate();
        assertEquals(CPU.s0 , exp_andi1);
    }

    @Test
    public void setAndi2(){
        andi = new AndI(bin_inst2);
        andi.operate();
        assertEquals(CPU.v0 , exp_andi2);
    }

    @Test
    public void setAndi3(){
        andi = new AndI(bin_inst3);
        andi.operate();
        assertEquals(CPU.a2 , exp_andi3);
    }

    @Test
    public void setAndi4(){
        andi = new AndI(bin_inst4);
        andi.operate();
        assertEquals(CPU.a2 , exp_andi4);
    }

    @Test
    public void setAndi5(){
        andi = new AndI(bin_inst5);
        andi.operate();
        assertEquals(CPU.t3 , exp_andi5);
    }
}
