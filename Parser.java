import java.io.*;


public class Parser {
    public BufferedReader reader;
    public String currentInstruction;
    public String nextLine;


    public Parser (File fileName )  throws IOException// Constuctor
    {
        if (fileName == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        // Handle file existence check (optional)
        if (!fileName.exists() || !fileName.isFile()) {
            throw new FileNotFoundException("The provided file does not exist or is not a valid file: " + fileName);
        }
        this.reader = new BufferedReader(new FileReader(fileName));
        this.nextLine = reader.readLine().trim();
        this.currentInstruction = null;
    }

    public boolean hasMoreLines()
    {
        return nextLine != null;
    }


    private boolean isComment(String input) {
        return input.trim().startsWith("//");
    }

    public void advance() throws IOException {
        String line;
        // Update the current instruction with the previous next line
        currentInstruction = nextLine;
        // Find the next valid instruction
        nextLine = null;
        while ((line = reader.readLine()) != null) {
            line = line.trim(); // Remove leading and trailing whitespace
            if (!line.isEmpty() && !line.startsWith("//")) { // Ignore comments and empty lines
                nextLine = line; // Set as the next instruction
                break;
            }
        }
    }

    public String instructionType()
    {
        if (currentInstruction.startsWith("@")) // checking wether it's an @ inst
        {
            return "A_INSTRUCTION";
        }
        else if(currentInstruction.startsWith("(") && currentInstruction.endsWith(")")) // if the instruction is a label
        {
            return "L_INSTRUCTION";
        } else if (currentInstruction.trim().startsWith("//")) {
            return "comment";
        } else return "C_INSTRUCTION"; // if niether A nor L, then has to be C
    }



    // now we start the actual parsing:

    public String symbol() // For dealing with A/L instructions
    {
        String line = instructionType();
        switch (line) {
            case "A_INSTRUCTION" :
                return currentInstruction.substring(1); // eliminating the "@"
            case "L_INSTRUCTION" :
                return currentInstruction.substring(1,currentInstruction.length()-1); // eliminating the starting "(" and the ending ")"

            default:
                return "";
        }
    }


    // Now we'll handle C instructions:

    public String dest() // Optional
    {
        if (!instructionType().equals("C_INSTRUCTION"))
        {
            throw new IllegalStateException();
        }
        // At this point we have a C_INSTRUCTION
        int equalsIndex = currentInstruction.indexOf("=");
        return equalsIndex != -1 ? currentInstruction.substring(0, equalsIndex) : ""; // if "=" was obtained return the string up to it, else return the empty string
    }

    public String comp()
    {
        if (!instructionType().equals("C_INSTRUCTION"))
        {
            throw new IllegalStateException();
        }
        // At this point we have a C_INSTRUCTION
        int equalsIndex = currentInstruction.indexOf("=");
        int semiColumnIndex = currentInstruction.indexOf(";");

        // If no kind of "JMP" then we assign semiColumnIndex to the end of the String
        if (semiColumnIndex == -1)
        {
            semiColumnIndex = currentInstruction.length();
        }


        return  semiColumnIndex != -1 ? currentInstruction.substring(equalsIndex + 1, semiColumnIndex) : currentInstruction.substring(0, semiColumnIndex);
    }

    public String jump()
    {
        if (!instructionType().equals("C_INSTRUCTION"))
        {
            throw new IllegalStateException();
        }
        // At this point we have a C_INSTRUCTION
        int semiColumnIndex = currentInstruction.indexOf(";");

        return semiColumnIndex != -1 ? currentInstruction.substring(semiColumnIndex+1, currentInstruction.length()) : "";

    }
    public void close() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
}