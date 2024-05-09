//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import MachineCode.GeneralMachineCode;

import java.io.*;
import java.math.BigInteger;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // MILESTONE'S 3 CODE
//        GeneralMachineCode gmc = new GeneralMachineCode();
//        String hex_instr = args[0];
//        String mnenomic = gmc.hex_to_mnenomic(hex_instr);
//        System.out.println(mnenomic);
        String bin = "11111111"; // Example binary string
        System.out.println(GeneralMachineCode.bin_to_signedDec(bin));
        bin = "100000000000000000"; // Example binary string
        System.out.println(GeneralMachineCode.bin_to_signedDec(bin));
    }
}