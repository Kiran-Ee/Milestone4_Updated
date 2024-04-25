package Operations;



public class Syscall implements Operation{
    private final String opcode = "00";
    private String code = "000000";
    private final String funct = "0c";

    public Syscall(){
        // may not be needed any additional parsings for syscall
    }

    @Override
    public String[] binary_parser(String binary_instr) {
        throw new UnsupportedOperationException("Syscall does not support binary parsing.");
    }

    @Override
    public String get_mnenomic() {
        return "syscall {opcode: 00, code: 000000, funct: 0c}"; // hardcoded
    }

    @Override
    public String[] getInstruction() {
        return new String[]{opcode, funct};
    }

    @Override
    public String operate() {
        return null;
    }

}
