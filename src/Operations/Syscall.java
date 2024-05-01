package Operations;


import CPU.CPU;

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

//    @Override
//    public String get_mnenomic() {
//        return "syscall {opcode: 00, code: 000000, funct: 0c}"; // hardcoded
//    }

    @Override
    public String[] getInstruction() { //returns "$v0"'s val since that's the only thing syscall cares about
        return new String[]{""+CPU.get_registers_state().get("$v0")};
    }

    @Override
    public String operate() { // USE SYSCALL HANDLER!
        return null;
    }

    @Override
    public String get_mnenomic() {
        return null;
    }

}
