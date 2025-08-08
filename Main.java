import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String inpuString = args[0];

        // Initialize the SymbolTable and output file
        SymbolTable table = new SymbolTable();
        String outPutFile = inpuString.replace(".asm", ".hack");

        // First pass: Process the labels and add them to the symbol table
        String currentInst;
        Parser parser = new Parser(new File(args[0]));
        int lineCounter = 0;
        while (parser.hasMoreLines()) {
            parser.advance();
            currentInst = parser.instructionType();
            if (currentInst.equals("L_INSTRUCTION")) {
                // If it's a label, add it to the symbol table with the current address (counter)
                if (!table.contains(parser.symbol())) {
                    table.addEntry(parser.symbol(),lineCounter -1);
                }else {lineCounter++;}
            }else {lineCounter++;}
        }

        // At this point, the symbol table is filled with labels
        // Second pass: Process actual instructions and generate binary machine code
        Parser secondPassParser = new Parser(new File(inpuString));
        BufferedWriter assembledCode = new BufferedWriter(new FileWriter(outPutFile));

        while (secondPassParser.hasMoreLines()) {
            secondPassParser.advance();
            String instruction = secondPassParser.instructionType();

            // Handle A_INSTRUCTION
            if (instruction.equals("A_INSTRUCTION")) {
                String symbol = secondPassParser.symbol();
                int address;

                if (isNumeric(symbol)) {
                    address = Integer.parseInt(symbol);
                } else {
                    // Add the symbol to the table if it doesn't already exist
                    if (!table.contains(symbol)) {
                        table.addEntry(symbol);
                    }
                    address = table.getAddress(symbol);

                }

                // Convert the address to a 16-bit binary string
                String binary = toBinary(address);
                assembledCode.write(binary);
                assembledCode.newLine();
            }

            // Handle C_INSTRUCTION
            else if (instruction.equals("C_INSTRUCTION")) {
                String dest = secondPassParser.dest();
                String comp = secondPassParser.comp();
                String jump = secondPassParser.jump();

                // Generate the binary code for the C instruction
                String binary = "111" + Code.comp(comp)  + Code.dest(dest) + Code.jump(jump);
                assembledCode. write(binary);
                assembledCode.newLine();
                
            }
        }
        // Close the BufferedWriter to save the output file
        assembledCode.close();
    }

    // Helper method to check if a string is numeric
    private static boolean isNumeric(String str) {

        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str); // or Integer.parseInt(str) for integers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    // Helper method to convert an integer to a 16-bit binary string
    private static String toBinary(int value) {
        return String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
    }
}