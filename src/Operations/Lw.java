package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;
import SecConverters.DataSecConverter;

import java.math.BigInteger;


public class Lw implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String base = "";
    private String rt = "";
    private int offset = -1;

    public Lw(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.base = CPU.hex_to_reg(gmc.pad_binary(rs_temp, 2 - rs_temp.length()));

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            this.offset = new BigInteger(parsedInstruction[2]).intValue();
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

//    @Override
//    public String get_mnenomic() {
//        return String.format("lw {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}", opcode, base, rt, offset);
//    }

    @Override
    public String[] getInstruction() {
        return new String[]{base, rt, ""+offset};
    }

    @Override
    public String operate() {
        int base_int = CPU.get_registers_state().get(base);
        int return_int = base_int + offset;
        String return_hex = GeneralMachineCode.bin_toHexImmediate(Integer.toBinaryString(return_int));
        String return_str = DataSecConverter.data_mem.get(return_hex);

        return null;
    }
}
