package SecConverters;

import Operations.Add;
import Operations.Operation;

import java.util.LinkedHashMap;

public class TextSecConverter {
    public static Operation[] text_mem = null; // will need to dynamically set size

    public static void textSec_Converter(String hex_txt) { //USE MILESTONE 2 AS EXAMPLE.
        // TODO
        text_mem = new Operation[]{new Add("32 bit binary")};
    }

    public String lnInterpreter_txtHex(String hex_txtLn) { // <- THIS IS WHERE TO APPLY MILESTONE’S 3 LOGIC!
        return null;
    }
}
