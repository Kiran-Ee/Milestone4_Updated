package Operations;

import MachineCode.GeneralMachineCode;


public class Lw implements Operation {
    GeneralMachineCode gmc = new GeneralMachineCode();
    private final String opcode = "23";
    private String base = "";
    private String rt = "";
    private String offset = "";

    /*
    Format:
LW rt, offset(base)
["lw","rt","offset(base)"]
 Machine Code Format:
    [LW(6: 100011), base(5), rt(5), offset(16)]
Desc: rt <--memory[base+offset]
     */
    public Lw(String binary) {
        String[] parsedInstruction = binary_parser(binary);
        if (parsedInstruction.length == 3) {
            String rs_temp = gmc.bin_toHexImmediate(parsedInstruction[0]);
            this.base = gmc.pad_binary(rs_temp, 2 - rs_temp.length());

            String rt_temp = gmc.bin_toHexImmediate(parsedInstruction[1]);
            this.rt = gmc.pad_binary(rt_temp, 2 - rt_temp.length());

            String offset_temp = gmc.bin_toHexImmediate(parsedInstruction[2]);
            this.offset = gmc.pad_binary(offset_temp, 4 - offset_temp.length());
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }

    }

    @Override
    public String[] binary_parser(String binary_instr) {
        if (binary_instr.length() == 32) {
            String base = binary_instr.substring(6, 11);
            String rt = binary_instr.substring(11, 16);
            String offset = binary_instr.substring(16, 32);
            return new String[]{base, rt, offset};
        } else {
            throw new IllegalArgumentException("Invalid binary instruction format.");
        }
    }

    @Override
    public String get_mnenomic() {
        return String.format("lw {opcode: %s, rs(base): %s, rt: %s, immediate(offset): %s}", opcode, base, rt, offset);
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, base, rt, offset};
    }

    @Override
    public String operate() {
        return null;
    }
}
