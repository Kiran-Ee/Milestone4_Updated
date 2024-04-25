package Operations;

import MachineCode.GeneralMachineCode;


public class j implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private String opcode = "02"; //opcode for j instruction
    private String instr_index;

    public j(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 1) {
            String instr_index_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);;
            this.instr_index = gmc.pad_binary(instr_index_temp, 7-instr_index_temp.length());
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String instr_index = binary_instr.substring(6, 32);
            return new String[]{instr_index};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("j {opcode: %s, index: %s}", opcode, instr_index);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, instr_index};
    }

    @Override
    public String operate() {
        return null;
    }
}

