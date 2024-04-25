package Milestone3Tests.MC_Operations;

import Operations.Bne;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BneTest {
    String bne_instr = "00010110000100010000000000001111"; //"bne", "$s0", "$s1", "15" - hex 1611000F
    //bin 00010110000100010000000000001111
    String exMne = "bne {opcode: 05, rs(base): 10, rt: 11, immediate(offset): 000f}";
    String bne_instr1 = "00010101000010010000000000010000"; //"bne", "$t0", "$t1", "16"-hex 15090010
    //bin  00010101000010010000000000010000
    String exMne1 = "bne {opcode: 05, rs(base): 08, rt: 09, immediate(offset): 0010}";

    @Test
    public void good_variable_setting1(){
        Bne bne = new Bne(bne_instr);
        assertEquals(exMne, bne.get_mnenomic());
    }
    @Test
    public void good_variable_setting2(){
        Bne bne = new Bne(bne_instr1);
        assertEquals(exMne1, bne.get_mnenomic());
    }
}
