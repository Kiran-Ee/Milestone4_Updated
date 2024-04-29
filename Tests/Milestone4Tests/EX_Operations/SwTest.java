package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Sw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwTest {
    Sw sw = null;
    String bin_instr1 = "10101110010100100000000011110000"; //"sw", "$s2", "240"("$s2") - hex-AE5200f0
    int s2_val = 18;

    @BeforeEach
    public void setUp() {
        CPU.s2 = s2_val;
    }
    @Test
    public void setSw1(){
        sw = new Sw(bin_instr1);
        sw.operate();
        // Assuming something like Memory.setWord(address, value) method exists
        // Calculate the memory address based on the immediate value and base register
        int address = CPU.s2 + 240; // each memory address represents 4 bytes?

        // Set the expected value in memory at the calculated address
        //Memory.setWord(address, 1234); // Set an random value for testing

        // Check if the value at the calculated memory address matches the expected value
        //assertEquals(1234, Memory.getWord(address));
    }

}
