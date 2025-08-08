k# Nand2Tetris — Hack Assembler (Java)

Java implementation of the Hack Assembler from the [Nand2Tetris](https://www.nand2tetris.org/) course.  
Translates `.asm` Hack assembly code into `.hack` binary machine code.

## Features
- Parses Hack assembly (A and C instructions, labels, and symbols)
- Two-pass assembler with symbol table support
- Produces `.hack` files compatible with the Hack CPU emulator
- Includes a Makefile and an `Assembler` shell script for easy execution

## Build & Run

### Option 1 — Using Makefile & Assembler script (recommended)
```bash
# Compile the project
make

# Run the assembler
./Assembler path/to/YourFile.asm
```
Example:
```bash
make
./Assembler Rect.asm
# Output: Rect.hack
```

### Option 2 — Manual Java compilation
```bash
# Compile all Java source files
javac *.java

# Run the assembler
java Main path/to/YourFile.asm
```
Example:
```bash
javac *.java
java Main Rect.asm
# Output: Rect.hack
```

## Project structure
```
.
├── AUTHORS
├── Main.java
├── Parser.java
├── Code.java
├── SymbolTable.java
├── Makefile
├── lang.txt
└── Assembler       # executable wrapper for running the program
```

## Notes
- This project passed all official Nand2Tetris assembler tests.
- Works with any Java 8+ installation.
- No external dependencies required.

