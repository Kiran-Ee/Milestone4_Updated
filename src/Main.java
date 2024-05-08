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
        int immediate = 5;
        int result = immediate << 16;
        System.out.println();
        System.out.print("Before masking " + result);
        System.out.println();
        result = result & 0xFFFF0000;  // Mask to keep only upper 16 bits
        System.out.print("After masking " + result);
    }
}