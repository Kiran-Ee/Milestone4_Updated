//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import MachineCode.GeneralMachineCode;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

import static MachineCode.GeneralMachineCode.*;

import CPU.CPU;

public class Main {
    public static void main(String[] args) {
        /*
         jar location: out/artifacts/Milestone4_Updated_jar/Milestone4_Updated.jar
         EOO Location:
                      Data: src/ProgramDumps/EOO_D_Dump
                      Text: src/ProgramDumps/EOO_T_Dump
         RunProgramTest:
                      Data: src/ProgramDumps/RPT_D_Dump
                      Text: src/ProgramDumps/RPT_T_Dump
          SimpleCPUTest:
                      Data: src/ProgramDumps/SCT_D_Dump
                      Text: src/ProgramDumps/SCT_T_Dump
         */


        CPU c = new CPU();
        try {
            String textContents = Files.readString(Path.of(args[0]));
            String dataContents = Files.readString(Path.of(args[1]));

            c.cpu(dataContents, textContents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}