package Operations;

import CPU.CPU;
import MachineCode.GeneralMachineCode;


public class And implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String rs = "";
    private String rt = "";
    private String rd = "";

    public And(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = CPU.hex_to_reg(gmc.pad_binary(rs_temp, 2 - rs_temp.length()));

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = CPU.hex_to_reg(gmc.pad_binary(rt_temp, 2 - rt_temp.length()));

            String rd_temp = gmc.bin_toHexImmediate(parsedInstruction[2]);
            this.rd = CPU.hex_to_reg(gmc.pad_binary(rd_temp, 2 - rd_temp.length()));
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String rs = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String rd = binary_instr.substring(16, 21);
            return new String[]{rs, rt, rd};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

//    @Override
//    public String get_mnenomic() {
//        return String.format("and {opcode: %s, rs: %s, rt: %s, rd: %s, shmt: %s, funct: %s}",
//                opcode, rs, rt, rd, shamt, funct);
//    }

    @Override
    public String[] getInstruction() {
        return new String[]{rs, rt, rd};
    }

    @Override
    public String operate() {
        return null;
    }
}
