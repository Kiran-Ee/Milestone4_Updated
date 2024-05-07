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

            }
        } catch (IOException e) {
            throw new RuntimeException("Error opening file: " + filePath, e);
        }
        System.out.println("Total Passed: " + totalPassed + " out of 1000");
    }
}
