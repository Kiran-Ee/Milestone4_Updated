package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Objects;

public class Beq implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String rs = "";
    private String rt = "";
    private int offset = -1;

    public Beq(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = CPU.hex_to_reg(gmc.pad_binary(rs_temp, 2 - rs_temp.length()));

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            this.offset = new BigInteger(parsedInstruction[2], 2).intValue();
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String offset = binary_instr.substring(16, 32);

            return new String[]{rs, rt, offset};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

//    @Override
//    public String get_mnenomic() {
//        return String.format("beq {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
//                opcode, rs, rt, offset);
//    }

    @Override
    public String[] getInstruction() {
        return new String[]{rs,rt,"" + offset};
    }

    @Override
    public String operate() {
        HashMap<String, Integer> hm = CPU.get_registers_state();

        return (Objects.equals(hm.get(rs), hm.get(rt))) ? "branch" : "no branch" ;
    }

    @Override
    public String get_mnenomic() {
        return null;
    }
}
