package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Add;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// op-code: add, rd, rs, rt
// machine-code: sp, rs, rt, rd, 0, add
public class AddTest {
    Add add = null; // used to instantiate new OperationObj every test ...

    int a0_val = 4; // used to perform operation ...
    int a1_val = 10;
    int a2_val = 15;
    int s0_val = 16;
    int s1_val = 17;
    int t7_val = 15;
    int exp_add1 = 14;
    int exp_add2 = 20;
    // add more return variables for more tests ...

    @BeforeEach
    public void setUp() { // setting the CPU:
        CPU.a0 = a0_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
        CPU.s0 = s0_val;
        CPU.s1 = s1_val;
        CPU.t7 = t7_val;
        // set more regs ... LOOK AT "GetRegistersStateTest"'s "@BeforeEach" method for template!
    }
//String bin_instr1 = "00000010001011111000000000100000"; // "add", "$s0", "$s1", "$t7"
    @Test
    public void setAdd1(){
        add = new Add("00000000101001100010000000100000"); // we're not sending in "registers" to OpObjs ... we're sending 32 bit Bin (so we don't have to change MLST3)
        add.operate();
        assertEquals(CPU.a2 , exp_add1);
    }
    @Test
    public void setAdd2(){
        add = new Add("00000010001011111000000000100000");
        add.operate();
        assertEquals(CPU.t7, exp_add2);
    }
    @Test
    public void setAdd5(){
        // Test adding zero to a register
        add = new Add("00000000000000000000000000000000");
        add.operate();
        assertEquals(CPU.a2, a2_val); // Expected result for the new test case should be the initial value?
    }

    // add more combos (testing different ints & registers) ...
}