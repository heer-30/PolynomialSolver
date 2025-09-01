Polynomial Solver
This project computes the coefficients of a polynomial given its roots in JSON format.  
The roots can be provided in different number bases (binary, decimal, octal, etc.), and the program converts them to decimal before constructing the polynomial.

Features
- Reads input from a JSON file (`input.json`).
- Converts roots from any base to decimal.
- Selects the first **k** roots to construct a polynomial of degree `k-1`.
- Outputs the polynomial coefficients.

 Files
- `PolynomialSolver.java` → Main Java program.
- `input.json` → Sample test case input.
- `output.png` → Screenshot of program output.

 Requirements
- Java JDK 17 (or later)
- Any IDE (VS Code, IntelliJ, Eclipse) or terminal
