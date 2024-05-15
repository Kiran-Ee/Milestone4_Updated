package SecConverters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;

import static CPU.CPU.string_to_ascii;

public class DataSecConverter {
    public static LinkedHashMap<String, Integer> data_mem = new LinkedHashMap<>();

    /*
     {“address in memory” : }
        {“10010000” : 1702129221} //0x65746e45 ... etnE
        {“10010004” : 1870209138} //0x6f792072 ... oy r
        {“10010008” : 1763734133} //0x69207275 ... i ru
        {“1001000a” : 1734702190} //0x6765746e ... getn
        {"1001000e" : 1970231552} //0x756f5900 ... uoy/0
     */

    /**
     * Takes entire data section, which is in hex, and converts it into memory: keys = string of hex address, values = data of the hex value.
     *
     * @param hex_dta: String representing the entire hex section sent in by main.
     */
    public static void dataSec_Converter(String hex_dta) {
        try (BufferedReader reader = new BufferedReader(new StringReader(hex_dta))) {
            int cur_addr_dec = 0x10010000; //used for addition
            String cur_addr_str = "10010000"; //used for key
            String ln = "";
            int ln_int = -1;

            while ((ln = reader.readLine()) != null) {
                ln_int = Integer.parseInt(ln, 16);
                data_mem.put(cur_addr_str, ln_int);
                cur_addr_dec += 4; //4 bytes
                cur_addr_str = Integer.toHexString(cur_addr_dec);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Converts a hex_string in little endian to its original string
    // Ex:"65746e45" -> Ente
    public static String[] lnInterpreter_dtaHex(String hex_dtaLn) {
        int str_size = hex_dtaLn.length();
        String[] return_arr = new String[]{"", "empty"};
        String two_hex_digits = "";
        int dec = -1;
        char ascii;
        boolean isNewString = false; // determines whether to add to current string or start next one

        for (int i = str_size; i >= 2; i = i - 2) { //65746e45 "etnE"
            two_hex_digits = hex_dtaLn.substring(i - 2, i);
            dec = Integer.parseInt(two_hex_digits, 16);
            ascii = (char) dec;

            if (dec == 0) {
                isNewString = true;
                return_arr[1] = ""; // prepares fresh element to add chars to
            } else if (!isNewString) {
                return_arr[0] += ascii;
            } else {
                return_arr[1] += ascii;
            }
        }
        return return_arr;
    }

    // used by LW: reverses string, turns into hex, returns int ascii
    public static int string_to_hex(String str) {
        String temp_str = "";
        int n = str.length();

        // Reverses string - preparing for string_to_ascii
        for (int i = n - 1; i >= 0; i--) {
            temp_str += "" + str.charAt(i);
        }

        return string_to_ascii(temp_str);
    }

    private static int calc_data_size(String data) {
        return data.length() + 1;
    }

    private static String calc_next_address(String prev_address, int current_size) {
        int hexValue = Integer.parseInt(prev_address, 16);
        int sum = hexValue + current_size;
        return Integer.toHexString(sum);
    }
}




    /* outdated data_mem ...
    {“address in memory” : “data” }
        {“10010000” : "Enter your integer: "}
        {“10010015” : "Your integer is EVEN!"}
        {“1001002b” : "Your integer is ODD!"}
     */
