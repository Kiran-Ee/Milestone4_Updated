package MachineCode;

import MachineCode.GeneralMachineCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        String filePath = "src/MachineCode/Profs_Test_File";
        int totalPassed = 0;
        int debugcounter = 0; // for conditional breakpoints ...

        try (FileReader fileReader = new FileReader(filePath); BufferedReader bufferReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                debugcounter++;
                String[] parts = line.split(" ", 2); //find at most 2 parts of the string seperated by space

                String hex_instr = parts[0];
                String exp_mnenomic = parts[1];

                GeneralMachineCode gmc = new GeneralMachineCode();
                String actual_mnenomic = gmc.hex_to_mnenomic(hex_instr);

                System.out.println("Counter " + debugcounter);
                if (actual_mnenomic.equals(exp_mnenomic)) {
                    System.out.println("+++ Verification passed for: " + line);
                    totalPassed++;
                } else {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("--- Verification failed for: " + line);
                    System.out.println("   Expected: " + exp_mnenomic);
                    System.out.println("   Actual: " + actual_mnenomic);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error opening file: " + filePath, e);
        }
        System.out.println("Total Passed: " + totalPassed + " out of 1000");
    }
}
