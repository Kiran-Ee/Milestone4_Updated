package SecConverters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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
        try (BufferedReader reader = new BufferedReader(new StringReader(hex_dta))) {
            String line;
            String cur_addr = "10010000";
            String[] ret_strArr;
            String label = "";
            String label2 = "";

            while ((line = reader.readLine()) != null) {
                int cur_size = calc_data_size(cur_addr);
                ret_strArr = lnInterpreter_dtaHex(line);
                label = label + ret_strArr[0];
                label2 = ret_strArr[1];

                if (!label2.equals("")) { // only happens when found null byte
                    data_mem.put(cur_addr, label);
                    label = label2; //lbl2 is the start of the next string
                }

                cur_addr = calc_next_address(cur_addr, cur_size);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Converts a hex_string in little endian to its original string
    // Ex:"65746e45"-> Ente
    public static String[] lnInterpreter_dtaHex(String hex_dtaLn) { // <- THIS IS WHERE TO APPLY MILESTONE’S 3 LOGIC!
        int str_size = hex_dtaLn.length();
        String[] return_arr = new String[]{"", ""};
        String two_hex_digits = "";
        int dec = -1;
        char ascii;
        boolean isNewString = false;

        for (int i = str_size; i >= 2; i = i - 2) { //65746e45 "etnE"
            two_hex_digits = hex_dtaLn.substring(i - 2, i);
            dec = Integer.parseInt(two_hex_digits, 16);
            ascii = (char) dec;

            if (dec == 0) {
                isNewString = true;
            } else if (!isNewString) {
                return_arr[0] += ascii;
            } else {
                return_arr[1] += ascii;
            }
        }
        return return_arr;
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

