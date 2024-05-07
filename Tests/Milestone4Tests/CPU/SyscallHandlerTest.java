package Milestone4Tests.CPU;

import CPU.CPU;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SyscallHandlerTest {
    int print_int = 1;
    int print_str = 4;
    int read_int = 5;
    int exit = 10;

    @BeforeEach
    public void setUp() { //creating data sec for "Print String"
        LinkedHashMap<String, String> lhm = DataSecConverter.data_mem;
        lhm.put("10010000", "Enter your integer: ");
        lhm.put("10010015", "Your integer is EVEN!");
        lhm.put("1001002b", "Your integer is ODD");
    }

    @Test
    void printInt_1() {
        CPU.a0 = 10;
        assertEquals("10", CPU.syscall_handler(print_int));
    }
    @Test
    void printInt_2() {
        CPU.a0 = 0;
        assertEquals("0", CPU.syscall_handler(print_int));
    }
    @Test
    void printInt_3() {
        CPU.a0 = 1234599;
        assertEquals("1234599", CPU.syscall_handler(print_int));
    }

    @Test
    void printStr_1() {
        CPU.a0 = 268500992; //10010000;
        assertEquals("Enter your integer: ", CPU.syscall_handler(print_str));
    }
    @Test
    void printStr_2() {
        CPU.a0 = 268501013; //10010015;
        assertEquals("Your integer is EVEN!", CPU.syscall_handler(print_str));
    }
    @Test
    void printStr_3() {
        CPU.a0 = 268501035; //1001002b;
        assertEquals("Your integer is ODD", CPU.syscall_handler(print_str));
    }

//    @Test // can't test this without overhauling method.
//    void readStr_1() { // this might need to removed bc the run_program method should be able to handle ...
//        assertEquals("read int", CPU.syscall_handler(read_int));
//    }

    @Test
    void exit() {
        CPU.a0 = 132432; //doesn't matter
        assertEquals("-- program is finished running --", CPU.syscall_handler(exit));
    }
}