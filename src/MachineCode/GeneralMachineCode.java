package MachineCode;

import Operations.*;

import java.math.BigInteger;

public class GeneralMachineCode {
    // 8 Digit Hex -> 32 Bit Binary
    // Ex - {"02b4e822"} -> "00000010101101001110100000100010"
    public static String hex_to_binary(String hex) {
        BigInteger dec = new BigInteger(hex, 16);
        String bin = dec.toString(2);

        int padding = 32 - bin.length();
        return pad_binary(bin, padding);
    }

    // 32 binary instruction -> operation type
    // Ex - "00000010101101001110100000100010" -> "sub"
    public static String instruction_finder(String bin) {
        String op_code = bin.substring(0, 6);
        return switch (op_code) {
            case "000000" -> rType_finder(bin);
            case "001001" -> "addiu";
            case "001100" -> "andi";
            case "000100" -> "beq";
            case "000101" -> "bne";
            case "000010" -> "j";
            case "001111" -> "lui";
            case "100011" -> "lw";
            case "001101" -> "ori";
            case "101011" -> "sw";
            default -> "Unknown instruction";
        };
    }

    // "instruction_finder" Helper: Finds R-Type instruction based on "func" field
    // Ex - "00000010101101001110100000100010" -> "sub"
    public static String rType_finder(String bin) {
        String func = bin.substring(32 - 6);
        return switch (func) {
            case "100000" -> "add";
            case "100100" -> "and";
            case "100101" -> "or";
            case "101010" -> "slt";
            case "100010" -> "sub";
            case "001100" -> "syscall";
            default -> "Unknown instruction";
        };
    }

    // 32 Bit Binary + Operation Type -> Operation Obj -> Operation's Mnenomic
    // Ex - Args {"00000010101101001110100000100010", "sub"} -> "sub {opcode: 00, rs: 15, rt: 14, rd: 1d, shmt: 00, funct: 22}}
    public static Operation instruction_factory(String bin, String op_type) {
        return switch (op_type) {
            case "add" -> new Add(bin);
            case "addiu" -> new Addiu(bin);
            case "and" -> new And(bin);
            case "andi" -> new AndI(bin);
            case "beq" -> new Beq(bin);
            case "bne" -> new Bne(bin);
            case "j" -> new j(bin);
            case "lui" -> new Lui(bin);
            case "lw" -> new Lw(bin);
            case "or" -> new Or(bin);
            case "ori" -> new Ori(bin);
            case "slt" -> new Slt(bin);
            case "sub" -> new Sub(bin);
            case "sw" -> new Sw(bin);
            case "syscall" -> new Syscall();
            default -> throw new IllegalArgumentException("Entered invalid operation to instruction_factory");
        }; // TODO
    }

    // "n" Digit Binary -> "n/4" Digit Hex
    // Ex - "00000010101101001110100000100010" -> "02B4E822"
    public static String bin_toHexImmediate(String bin_imm) {
        int padding = 4 - (bin_imm.length() % 4);
        if (padding != 4) // Ensure the length of the binary string is a multiple of 4 by padding with leading zeros
            bin_imm = "0".repeat(padding) + bin_imm;

        String hexBuilder = "";
        for (int i = 0; i < bin_imm.length(); i += 4) {
            String group = bin_imm.substring(i, i + 4);

            BigInteger dec_unsigned = new BigInteger(group, 2);

            hexBuilder += dec_unsigned.toString(16);
        }

        return hexBuilder.toLowerCase();
    }

    // "num_padding" MUST be the difference between current length and desired length ... it is NOT the total length
    // Ex: Args {binary_instr = "101", num_pad = 3} -> return "000101"
    public static String pad_binary(String binary_instr, int num_padding) {
        for (int i = 0; i < num_padding; i++) {
            binary_instr = "0" + binary_instr;
        }
        return binary_instr;
    }
}
