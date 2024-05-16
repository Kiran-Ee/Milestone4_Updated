package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;
import SecConverters.DataSecConverter;

import java.math.BigInteger;
import java.util.HashMap;


public class Sw implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String base = "";
    private String rt = "";
    private int offset = -1;

    public Sw(String binary) {
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
    public String operate() {
        HashMap<String, Integer> registers = CPU.get_registers_state();

        // 1] get the value of the base register & rt
        int rt_dec = registers.get(rt);
        int base_dec = registers.get(base);

        // 2] Calculate the memory address based on base register and offset
        int addr_dec = base_dec + offset;

        String hex = Integer.toHexString(addr_dec); //signed

        // 3] Store the value of register rt INTO MEMORY at the calculated address
        DataSecConverter.data_mem.put(hex, rt_dec);

        return "Stored value of " + rt + " into memory address " + hex;
    }
}
