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
    int s0_val = 16;
    int s2_val = 18;
    int imm_val1 = 2547;
    int exp_andi1 = s2_val & imm_val1;
    String bin_inst2 = "00110001010000100000000000001010"; //andi $v0 $t2 10
    int v0_val = 2;
    int t2_val = 10;
    int imm_val2 = 10;
    int exp_andi2 = v0_val & imm_val2;


    @BeforeEach
    public void setUp(){
        CPU.s0 = s0_val;
        CPU.s2 = s2_val;
        CPU.v0 = v0_val;
        CPU.t2 = t2_val;

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
        assertEquals(CPU.t2 , exp_andi2);
    }
}
