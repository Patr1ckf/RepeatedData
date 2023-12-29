# Compression Algorithm - Java Implementation
## Description
This is an implementation of a data compression algorithm that saves space by storing repeated data as a single value, along with the number of times it's repeated. For instance, the string "AAAAABBB#####" could be compressed to "A±5B±3#±5". The symbol ± acts as a separator between the frequency and the character itself.

## How to Run
Run the Run.java file.
Choose one of the options: 'c' for data compression, 'd' for data decompression, 'x' to exit the program.
Follow the instructions displayed on the screen.
## Safeguards
The algorithm is protected against anomalous data.
Unsupported data will display corresponding error messages.
## Unit Tests
The code is covered by unit tests for key functionalities of compression and decompression. These tests verify the correctness of the algorithm with various input data.

## Notes
Memory and execution time of the algorithm have been optimized.
Program performance may vary based on the type and size of input data.
