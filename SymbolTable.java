import java.util.Map;
import java.util.HashMap;


public class SymbolTable {
    public static int counter = 16; // Initialized to 0 for the initial run
    public Map<String, Integer> table;
    

    public SymbolTable () //Default costructor
    {
        this.table = new HashMap<>();
        this.table.put("0", 0);
        this.table.put("R0", 0);

        this.table.put("1", 1);
        this.table.put("R1", 1);

        this.table.put("2", 2);
        this.table.put("R2", 2);

        this.table.put("3", 3);
        this.table.put("R3", 3);

        this.table.put("4", 4);
        this.table.put("R4", 4);

        this.table.put("5", 5);
        this.table.put("R5", 5);

        this.table.put("6", 6);
        this.table.put("R6", 6);

        this.table.put("7", 7);
        this.table.put("R7", 7);


        this.table.put("8", 8);
        this.table.put("R8", 8);

        this.table.put("9", 9);
        this.table.put("R9", 9);

        this.table.put("10", 10);
        this.table.put("R10", 10);

        this.table.put("11", 11);
        this.table.put("R11", 11);

        this.table.put("12", 12);
        this.table.put("R12", 12);

        this.table.put("13", 13);
        this.table.put("R13", 13);

        this.table.put("14", 14);
        this.table.put("R14", 14);

        this.table.put("15", 15);
        this.table.put("R15", 15);



        this.table.put("SCREEN",16384);
        this.table.put("KBD",24576);
        this.table.put("SP",0);
        this.table.put("LCL",1);
        this.table.put("ARG",2);
        this.table.put("THIS",3);
        this.table.put("THAT",4);

    }

    public void addEntry(String symbol) {
        if (!this.contains(symbol)) { // Ensure no duplicates are added
            this.table.put(symbol, counter++);
        } 
        
    }

    public void addEntry(String symbol, int adress) {
        if (!this.contains(symbol)) { // Ensure no duplicates are added
            this.table.put(symbol, adress);
        }

    }

    public boolean contains (String symbol) //Checks if symbol exists in the table
    {
        return this.table.containsKey(symbol);
    }

    public int getAddress(String symbol) {
        if (this.contains(symbol)) {
            int address = this.table.get(symbol);
            return address;
        } else {
            return -1; // Or handle this case appropriately
        }
    }
    public int getCounter() {
        return counter;
    }
    
    public void increment() {
        counter++;
    }
    
    



    
    
    

}