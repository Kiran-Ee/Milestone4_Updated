package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;
import SecConverters.DataSecConverter;

import java.math.BigInteger;


public class Lw implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String base = "";
    private String rt = "";
    private int offset = -1; // dec signed

    public Lw(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_to_hex(parsedInstruction[0]);
            this.base = CPU.hex_to_reg(gmc.pad_binary(rs_temp, 2 - rs_temp.length()));

            String rt_temp = gmc.bin_to_hex(parsedInstruction[1]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            int temp_offset = GeneralMachineCode.bin_to_dec(parsedInstruction[2], true); // dec immediate

            if (temp_offset % 4 == 0) {this.offset = temp_offset;}
            else throw new IllegalArgumentException("LW: Can't send in offset not a factor of 4");
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String base = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String offset = binary_instr.substring(16, 32);
            return new String[]{base, rt, offset};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] getInstruction() {
        return new String[]{base, rt, "" + offset};
    }

    @Override
    public String operate() { // puts value, at the address (base + offset), into destination register
        int base_dec = CPU.get_registers_state().get(base);
        String base_hex = Integer.toHexString(base_dec); //the data_mem's keys are in hex
        String lbl = DataSecConverter.data_mem.get(base_hex);

        String subStr_lbl = lbl.substring(offset, offset + 4); //word is 8 bytes, 4 chars

        int lbl_ASCII = CPU.string_to_ascii(subStr_lbl);

        CPU.update_register(rt, lbl_ASCII);
        return "Performed LW operation: Base - " + base + " Rt - " + rt + "   = offset" + offset;
    }
}
