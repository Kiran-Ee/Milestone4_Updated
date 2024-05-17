package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;

import java.math.BigInteger;
import java.util.HashMap;

import static MachineCode.GeneralMachineCode.bin_to_dec;
import static MachineCode.GeneralMachineCode.dec_to_bin;


public class Lui implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String rt = "";
    private int immediate = -1; //unsigned dec

    public Lui(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 2) {
            String rt_temp = gmc.bin_to_hex(parsedInstruction[0]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            int imm_temp = bin_to_dec(parsedInstruction[1], false);
            if (imm_temp < 0 || imm_temp > 0xFFFF)
                throw new IllegalArgumentException("Sent immediate out of range of Lui: [0,FFFF]");
            else
                this.immediate = imm_temp;
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
        return new String[]{rt, "" + immediate};
    }

    @Override
    public String operate() {
        HashMap<String, Integer> hm = CPU.get_registers_state();
        int result = immediate << 16; // Load immediate into upper 16 bits, lower 16 bits are zero

//        String bin = dec_to_bin(result, true); // extract binary representation
//
//        result = bin_to_dec(bin,true); // making sure it's in unsigned

        CPU.update_register(rt, result);
        return "Performed LUI operation:  " + immediate + "->   " + rt + "   =   " + result;
    }
}

