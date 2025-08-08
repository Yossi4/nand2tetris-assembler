# Nand2Tetris — Hack Assembler (Java)

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

