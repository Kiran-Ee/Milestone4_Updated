package SecConverters;

import java.util.LinkedHashMap;

public class DataSecConverter {
    public static LinkedHashMap<String, String> data_mem = new LinkedHashMap<>();
    /*
    {“address in memory” : “data” }
        {“10010000” : "Enter your integer: "]}
        {“10010015” : "Your integer is EVEN!"}
        {“1001002b” : "Your integer is ODD!"}
     */

    public static void dataSec_Converter(String hex_dta) {

    }

//converts a hex_string in little endian to its original string
    //Ex:"65746e45"-> Ente

    public String[] lnInterpreter_dtaHex(String hex_dtaLn) { // <- THIS IS WHERE TO APPLY MILESTONE’S 3 LOGIC!
        return null;
    }

    //helper method for Lw to convert string into its little endian hex
    public int str_to_little_endian(String word, int offset){
        //1. -find the start of the string according to the offset
        //2. - grab 4 char
        //3. - reverse the 4 char
        //4.-turn char into hex
        //5.-return the 8 hex digit int

        return 1;
    }

}

