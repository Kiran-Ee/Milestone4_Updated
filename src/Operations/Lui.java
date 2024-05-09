package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;

import java.math.BigInteger;
import java.util.HashMap;


public class Lui implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String rt = "";
    private int immediate = -1;

    public Lui(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 2) {
            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            this.immediate = new BigInteger(parsedInstruction[1], 2).intValue();
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rt = binary_instr.substring(11, 16);
            String imm = binary_instr.substring(16, 32);
            return new String[]{rt, imm};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] getInstruction() {
        return new String[]{rt, ""+immediate};
    }

    @Override
    public String operate() {
        HashMap<String, Integer> hm = CPU.get_registers_state();
        int result = immediate << 16; // Load immediate into upper 16 bits, lower 16 bits are zero
        CPU.update_register(rt, result);
        return  "Performed LUI operation:  " + immediate +   "->   "+ rt +"   =   "+ result;
    }
}

