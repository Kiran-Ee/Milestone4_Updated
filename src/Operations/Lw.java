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

            this.offset = temp_offset;
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
        int base_wOffset = base_dec + offset;
        String base_hex = Integer.toHexString(base_wOffset); //the data_mem's keys are in hex

        int data_value = DataSecConverter.data_mem.get(base_hex);

        CPU.update_register(rt, data_value);
        return "Performed LW operation: Base - " + base + " Rt - " + rt + "   = offset" + offset;
    }
}
