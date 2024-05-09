package SecConverters;

import MachineCode.GeneralMachineCode;
import Operations.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class TextSecConverter {
    public static Operation[] text_mem = null; // will need to dynamically set size

    public static void textSec_Converter(String hex_txt) { //USE MILESTONE 2 AS EXAMPLE.
        String ln = "";
        ArrayList<Operation> text_mem_arrLst = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new StringReader(hex_txt))) {
            while ((ln = reader.readLine()) != null) {
                text_mem_arrLst.add(lnInterpreter_txtHex(ln));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        text_mem = text_mem_arrLst.toArray(new Operation[0]);
    }

    public static Operation lnInterpreter_txtHex(String hex_txtLn) { // <- THIS IS WHERE TO APPLY MILESTONE’S 3 LOGIC!
        String bin_txtLn = GeneralMachineCode.hex_to_bin(hex_txtLn);
        String op_type = GeneralMachineCode.instruction_finder(bin_txtLn);
        return  GeneralMachineCode.instruction_factory(bin_txtLn, op_type);
    }
}
//uniquie for syscall-->we have maybe beq handeler -bne handler