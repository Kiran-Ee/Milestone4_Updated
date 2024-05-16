package Milestone4Tests.CPU;

import CPU.CPU;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SyscallHandlerTest {
    LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();

    int print_int = 1;
    int print_str = 4;
    int read_int = 5;
    int exit = 10;

    @BeforeEach
    public void setUp() { //creating data sec for "Print String"
        hm1.put("10010000", 0x65746e45);
        hm1.put("10010004", 0x6f792072);
        hm1.put("10010008", 0x69207275);
        hm1.put("1001000c", 0x6765746e);
        hm1.put("10010010", 0x203a7265);
        hm1.put("10010014", 0x756f5900);
        hm1.put("10010018", 0x6e692072);
        hm1.put("1001001c", 0x65676574);
        hm1.put("10010020", 0x73692072);
        hm1.put("10010024", 0x45564520);
        hm1.put("10010028", 0x5900214e);
        hm1.put("1001002c", 0x2072756f);
        hm1.put("10010030", 0x65746e69);
        hm1.put("10010034", 0x20726567);
        hm1.put("10010038", 0x4f207369);
        hm1.put("1001003c", 0x00214444);

        DataSecConverter.data_mem = hm1;
    }

    @Test
    void printInt_1() {
        CPU.a0 = 10;
        assertEquals("10\n", CPU.syscall_handler(print_int));
    }
    @Test
    void printInt_2() {
        CPU.a0 = 0;
        assertEquals("0\n", CPU.syscall_handler(print_int));
    }
    @Test
    void printInt_3() {
        CPU.a0 = 1234599;
        assertEquals("1234599\n", CPU.syscall_handler(print_int));
    }

    @Test
    void printStr_1() {
        CPU.a0 = 0x10010000;
        assertEquals("Enter your integer: \n", CPU.syscall_handler(print_str));
    }
    @Test
    void printStr_2() {
        CPU.a0 = 0x10010015;
        assertEquals("Your integer is EVEN!\n", CPU.syscall_handler(print_str));
    }
    @Test
    void printStr_3() {
        CPU.a0 = 0x1001002b;
        assertEquals("Your integer is ODD!\n", CPU.syscall_handler(print_str));
    }

//    @Test // can't test this without overhauling method.
//    void readStr_1() { // this might need to removed bc the run_program method should be able to handle ...
//        assertEquals("read int", CPU.syscall_handler(read_int));
//    }

    @Test
    void exit() {
        CPU.a0 = 132432; //doesn't matter
        assertEquals("-- program is finished running --\n", CPU.syscall_handler(exit));
    }
}