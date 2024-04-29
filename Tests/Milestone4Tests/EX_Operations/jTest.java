package Milestone4Tests.EX_Operations;

import Operations.j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Format: J target
//Machine: J, instr_index(26)
public class jTest {
    j jump = null;
    String bin_instr = "00001000000000000000000111110100"; //"j", "0x1F4-(500), hex-080001F4

    @BeforeEach
    public void setUp(){

    }
    @Test //TODO
    public void setJ1(){
        jump = new j(bin_instr);
    }



}
