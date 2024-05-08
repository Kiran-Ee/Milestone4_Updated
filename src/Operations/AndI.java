package Operations;


import MachineCode.GeneralMachineCode;
import CPU.CPU;

import java.math.BigInteger;
import java.util.HashMap;

public class AndI implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String rs = "";
    private String rt = "";
    private int immediate = -1;

    public AndI(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = CPU.hex_to_reg(gmc.pad_binary(rs_temp, 2 - rs_temp.length()));

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            this.immediate = new BigInteger(parsedInstruction[2], 2).intValue();
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String immediate = binary_instr.substring(16, 32);

            return new String[]{rs, rt, immediate};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

//    @Override
//    public String get_mnenomic() {
//        return String.format("andi {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
//                opcode, rs, rt, immediate);
//    }

    @Override
    public String[] getInstruction() {
        return new String[]{rs, rt, "" +immediate};
    }

    @Override
    public String operate() {
        HashMap<String, Integer> registers = CPU.get_registers_state();

        int rsValue = registers.get(rs);
        int result = rsValue & immediate;

        CPU.update_register(rt, result);

        return "Performed ANDI operation: " + rs + " & " + immediate + " -> " + rt + " = " + result;
    }

    @Override
    public String get_mnenomic() {
        return null;
    }
}
