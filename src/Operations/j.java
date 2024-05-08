package Operations;

import MachineCode.GeneralMachineCode;

import java.math.BigInteger;


public class j implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private int address = -1;

    public j(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 1) {
            address = new BigInteger(parsedInstruction[0], 2).intValue();
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

//    @Override
//    public String get_mnenomic() {
//        return String.format("j {opcode: %s, index: %s}", opcode, instr_index);
//    }

    @Override
    public String[] getInstruction() {
        return new String[]{""+address};
    }

    @Override
    public String operate() {
        return "jump"; // tells "branch_handler" to jump
    }
}

