package Milestone4Tests.EX_Operations;

import CPU.CPU;
import Operations.Sw;
import SecConverters.DataSecConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static SecConverters.DataSecConverter.data_mem;
import static org.junit.Assert.assertEquals;

public class SwTest {
    Sw sw = null;
    String bin_instr1 = "10101110010100100000000011110000"; //"sw", "$s2", "240"("$s2") - testing storing word to random location
    String bin_instr2 = "10101110010100101111111111111100"; //"sw", "$s2", "-4"("$s2") - testing negative offset
    String bin_instr3 = "10101110011010010000000000000000"; //"sw", "$t1", "0"("$s3"): testing modifying a data label
    String bin_instr4 = "10101110011100110000000000000000"; //"sw", "$s3", "0"("$s3"): testing modifying a data label
    //

    int t1_val = 0x3e7; // 999 in dec -> ASCII: /0 /0 . .
    int s2_val = 0x10010000; // 0000004e in hex -> ASCII: /0 /0 /0 n
    int s3_val = 268500992; // 10010000 in mem

    int imm1 = 240;
    int imm2 = -4;
    int imm3 = 0;
    int imm4 = 0;

    String exp_val1 = ""+ (char)s2_val;
    String exp_val2 = ""+ (char)s2_val;
    String exp_val3 = ""+ (char)t1_val;
    String exp_val4 = ""+ (char)s3_val;

    @BeforeEach
    public void setUp() {
        CPU.t1 = t1_val;
        CPU.s2 = s2_val;
        CPU.s3 = s3_val;

        // TODO
//        data_mem.put("10010000", "Enter your integer: ");
//        data_mem.put("10010015", "Your integer is EVEN!");
//        data_mem.put("1001002b", "Your integer is ODD!");
    }

    @Test
    public void setSw1(){
        sw = new Sw(bin_instr1);
        sw.operate();

        int address_dec = CPU.s2 + imm1;
        String address_hex = Integer.toHexString(address_dec);
        //String val_in_mem = data_mem.get(address_hex);

        //assertEquals(exp_val1, val_in_mem);
    }

    @Test
    public void setSw2(){
        sw = new Sw(bin_instr2);
        sw.operate();

        int address_dec = CPU.s2 + imm2;
        String address_hex = Integer.toHexString(address_dec);
        //String val_in_mem = data_mem.get(address_hex);

        //assertEquals(exp_val2, val_in_mem);
    }

    @Test
    public void setSw3(){
        sw = new Sw(bin_instr3);
        sw.operate();

        int address_dec = CPU.s3 + imm3;
        String address_hex = Integer.toHexString(address_dec);
        //String val_in_mem = data_mem.get(address_hex);

        //assertEquals(exp_val3, val_in_mem);
    }
    @Test
    public void setSw4(){
        sw = new Sw(bin_instr4);
        sw.operate();

        int address_dec = CPU.s3 + imm4;
        String address_hex = Integer.toHexString(address_dec);
        //String val_in_mem = data_mem.get(address_hex);

       //assertEquals(exp_val4, val_in_mem);
    }




}
