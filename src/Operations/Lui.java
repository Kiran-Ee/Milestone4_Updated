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
        int rt_int = hm.get(rt);

        int result = immediate << 16; //shift left 16
        result = result & 0xFFFF0000;
        rt_int = rt_int & 0x0000FFFF;
        rt_int = result | rt_int;

        CPU.update_register(rt, rt_int);

        return "Performed LUI operation: " + immediate + " -> " + rt + " = " + result;
    }
}

