public class Code {
    public static String dest(String str) {
        str = str.toUpperCase().trim();
        switch (str) {
            case "A": return "100";
            case "D": return "010";
            case "M": return "001";
            case "AD","DA": return "110";
            case "AM","MA": return "101";
            case "DM","MD": return "011";
            case "ADM":return "111";
            default: return "000"; // No destination
        }
    }
    
    
    public static String comp(String str) {
        str = str.trim();  // Convert to uppercase and remove extra spaces        
        switch (str) {
            case "0": return "0101010";   // 0
            case "1": return "0111111";   // 1
            case "-1": return "0111010";  // -1
            case "A": return "0110000";   // A
            case "D": return "0001100";   // D
            case "!D": return "0001101";  // !D
            case "!A": return "0110001";  // !A
            case "-D": return "0001111";  // -D
            case "-A": return "0110011";  // -A
            case "D+1": return "0011111"; // D+1 (fixed binary)
            case "A+1": return "0110111"; // A+1 (fixed binary)
            case "D-1": return "0001110"; // D-1
            case "A-1": return "0110010"; // A-1
            case "D+A","A+D": return "0000010"; // D+A
            case "D-A": return "0010011"; // D-A
            case "A-D": return "0000111"; // A-D
            case "D&A","A&D": return "0000000"; // D&A
            case "D|A","A|D": return "0010101"; // D|A
            case "M": return "1110000";   // M
            case "!M": return "1110001";  // !M
            case "-M": return "1110011";  // -M
            case "M+1": return "1110111"; // M+1
            case "M-1": return "1110010"; // M-1
            case "D+M","M+D": return "1000010"; // D+M
            case "D-M": return "1010011"; // D-M
            case "M-D": return "1000111"; // M-D
            case "D&M","M&D": return "1000000"; // D&M
            default: return "1010101";    // Default (not recognized)
        }
    }
    
    

    public static String jump(String str) {
        str = str.toUpperCase().trim();  // Convert to uppercase and remove extra spaces
        switch (str) {
            case "JMP":
                return "111";
            case "JLE":
                return "110";

            case "JNE":
                return "101";

            case "JLT":
                return "100";

            case "JGE":
                return "011";

            case "JEQ":
                return "010";

            case "JGT":
                return "001";

            default:
                return "000";
        }
    }

    public static String formatNumberAsBinary(String number) {
        int value = Integer.parseInt(number);
        String binaryNumber = Integer.toBinaryString(value);
        String formattedBinaryNumber =
                String.format("%16s", binaryNumber).replace(' ', '0');
        return formattedBinaryNumber;
    }


}