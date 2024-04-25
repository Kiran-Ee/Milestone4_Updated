package Operations;

import MachineCode.GeneralMachineCode;

public class Ori implements Operation{
    private final String opcode = "0d";
    private String rs = "";
    private String rt = "";
    private String immediate = "";

    public Ori(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            this.rs = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[0]);
            this.rt = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[1]);
            this.immediate = GeneralMachineCode.bin_toHexImmediate(parsedInstruction[2]);
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

    @Override
    public String get_mnenomic() {
        return String.format("ori {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
                opcode, rs, rt, immediate);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, rs, rt, immediate};
    }

    @Override
    public String operate() {
        return null;
    }
}
