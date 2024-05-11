package SecConverters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;

import static CPU.CPU.string_to_ascii;

public class DataSecConverter {
    public static LinkedHashMap<String, String> data_mem = new LinkedHashMap<>();
    /*
    {“address in memory” : “data” }
        {“10010000” : "Enter your integer: "}
        {“10010015” : "Your integer is EVEN!"}
        {“1001002b” : "Your integer is ODD!"}
     */

    public static void dataSec_Converter(String hex_dta) {
        try (BufferedReader reader = new BufferedReader(new StringReader(hex_dta))) {
            String ln = "";
            String cur_addr = "10010000";
            int cur_size = -1;
            String[] str_arr = null;
            String lbl1 = "";
            String lbl2 = "";

            while ((ln = reader.readLine()) != null) {
                str_arr = lnInterpreter_dtaHex(ln);
                lbl1 = lbl1 + str_arr[0];
                lbl2 = str_arr[1];

                if (!lbl2.equals("empty")) { // only happens when found null byte
                    cur_size = calc_data_size(lbl1);
                    data_mem.put(cur_addr, lbl1);
                    cur_addr = calc_next_address(cur_addr, cur_size);
                    lbl1 = lbl2; // lbl2 is the start of the next string
                }
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
    public static int string_to_hex(String str){
        String temp_str = "";
        int n = str.length();

        // Reverses string - preparing for string_to_ascii
        for (int i = n-1; i>=0; i--) {
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

