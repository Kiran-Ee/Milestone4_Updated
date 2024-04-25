package Operations;


public interface
Operation {
    String[] binary_parser(String binary_instr);
    // String get_mnenomic();
    String[] getInstruction();
    String operate();
}
