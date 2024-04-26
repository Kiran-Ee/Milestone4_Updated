package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Add;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTest {
    Add add = null; // used to instantiate new OperationObj every test ...

    int a0_val = 4; // used to perform operation ...
    int a1_val = 10;
    int a2_val = 15;

    int exp_add1 = 14;
    // add more return variables for more tests ...

    @BeforeEach
    public void setUp() { // setting the CPU:
        CPU.a0 = a0_val;
        CPU.a1 = a1_val;
        CPU.a2 = a2_val;
        // set more regs ... LOOK AT "GetRegistersStateTest"'s "@BeforeEach" method for template!
    }

    @Test
    public void setAdd1(){
        add = new Add("00000000101001100010000000100000"); // we're not sending in "registers" to OpObjs ... we're sending 32 bit Bin (so we don't have to change MLST3)
        add.operate();
        assertEquals(CPU.a2 , exp_add1);
    }

    // add more combos (testing different ints & registers) ...
}