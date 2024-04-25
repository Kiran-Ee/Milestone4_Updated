package Operations;


import MachineCode.GeneralMachineCode;

public class AndI implements Operation{
    GeneralMachineCode gmc = new GeneralMachineCode();
    private final String opcode = "0c";
    private String rs = "";
    private String rt = "";
    private String immediate = "";

    public AndI(String binary){
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.rs = gmc.pad_binary(rs_temp, 2 - rs_temp.length());

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = gmc.pad_binary(rt_temp, 2 - rt_temp.length());

            String immediate_temp = gmc.bin_toHexImmediate(parsedInstruction[2]);
            this.immediate = gmc.pad_binary(immediate_temp, 4 - immediate_temp.length());
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
        return String.format("andi {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}",
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
