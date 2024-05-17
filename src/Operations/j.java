package Operations;

import MachineCode.GeneralMachineCode;

import java.math.BigInteger;


public class j implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private int address = -1; //should be byte addressing

    public j(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 1) {
            String addr_str = parsedInstruction[0];

            address = new BigInteger(addr_str, 2).intValue();
            if(addr_str.charAt(3) == '0') {
                address *= 4;
            }
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
    public String[] getInstruction() {
        return new String[]{""+address};
    }

    @Override
    public String operate() {
        return "jump"; // tells "branch_handler" to jump
    }
}

