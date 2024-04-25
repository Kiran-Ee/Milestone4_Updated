package SecConverters;

import Operations.Add;

import java.util.LinkedHashMap;

public class TextSecConverter {
    public static LinkedHashMap<String, Object[]> text_mem = new LinkedHashMap<>();

    public void textSec_Converter(String hex_txt) {
        // TODO - JUST TESTING THE "val" OBJECT ARRAY
        text_mem.put("1", new Object[]{"add $1, $1, $1", new Add("32 bit binary"), "00400000"});
    }


    public String lnInterpreter_txtHex(String hex_txtLn) { // <- THIS IS WHERE TO APPLY MILESTONE’S 3 LOGIC!
        return null;
    }
}
