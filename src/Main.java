//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import MachineCode.GeneralMachineCode;

import java.math.BigInteger;

import static MachineCode.GeneralMachineCode.*;

public class Main {
    public static void main(String[] args) {
        // MILESTONE'S 3 CODE
//        GeneralMachineCode gmc = new GeneralMachineCode();
//        String hex_instr = args[0];
//        String mnenomic = gmc.hex_to_mnenomic(hex_instr);
//        System.out.println(mnenomic);
//
//
//        System.out.println("TESTING HEX");
//        String hex = "ffff";
//        System.out.println(hex_to_bin(hex));
//        String hex2 = "ffff0000";
//        System.out.println(hex_to_bin(hex2));
//
//        System.out.println("TESTING SIGNED");
//        String bin_signed = "11111111"; // Example binary string
//        System.out.println(bin_to_dec(bin_signed, true));
//        bin_signed = "1000"; // Example binary string
//        System.out.println(bin_to_dec(bin_signed, true));
//        String testMax_signed = "1111111111111111"; // ffff
//        System.out.println(bin_to_dec(testMax_signed, true));
//
//
//        System.out.println("TESTING UN_SIGNED");
//        String bin_unsigned = "11111111"; // Example binary string
//        System.out.println(bin_to_dec(bin_unsigned, false));
//        bin_unsigned = "1000"; // Example binary string
//        System.out.println(bin_to_dec(bin_unsigned, false));
//        String testMax = "1111111111111111"; // ffff
//        System.out.println(bin_to_dec(testMax, false));
//
//        System.out.println("TESTING DEC->BIN");
//        int i1 = -65536;  //want to turn this (signed) into binary
//        String s1 = dec_to_bin(i1,true);
//        System.out.println(s1);
//
//        BigInteger bi1 = BigInteger.valueOf(i1);
//        s1 = bi1.toString(2);
//        System.out.println(s1);
//
////        System.out.println(bin_to_dec(s1, false));
////        System.out.println(new BigInteger(i1+"", 10).toString());
//        int i2 = 655368;  //want to turn this (signed) into binary
//        String s2 = dec_to_bin(i2,true);
//        System.out.println(s2);
//
//        BigInteger bi2 = BigInteger.valueOf(i1);
//        s2 = bi2.toString(2);
//        System.out.println(s2);
//
//        String s3 = dec_to_bin(i2,false);
//        System.out.println(s3);
//
//        BigInteger bi3 = BigInteger.valueOf(i1);
//        s3 = bi3.toString(2);
//        System.out.println(s3);

        System.out.println(bin_to_dec("1111111111111111", false)); //65535
        System.out.println(bin_to_dec("1111111111111111", true)); //-1

        System.out.println(dec_to_bin(65535, false)); //1111111111111111
        System.out.println(dec_to_bin(-1, true)); //1111111111111111
        System.out.println("testing Integer.toBinary String: " + Integer.toBinaryString(-65536)); // toBinaryString = SIGNED
        System.out.println("testing Integer.toHex String: " + Integer.toHexString(-65536)); // toHexString  = SIGNED

        System.out.println("printing ASCII of dec 18" + (char)18 + "testing");

        System.out.println(0x10010000); // "0x" = SIGNED
        System.out.println(Integer.parseInt("101", 2)); //UNSIGNED
        System.out.println(new BigInteger("101", 2)); //UNSIGNED
    }

}