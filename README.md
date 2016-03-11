# SudokuEvaluator
 Sudoku Puzzle Evaluator
 
What is Sudoku?

Sudoku is a number-based logic puzzle. The objective is to fill a 9×9 grid with 

digits so that each column, each row, and each of the nine 3×3 sub-grids that 

compose the grid (also called "boxes", "blocks", "regions", or "sub-squares") 

contains all of the digits from 1 to 9. The puzzle setter provides a partially 

completed grid, which typically has a unique solution. Completed puzzles are 

always a type of Latin square with an additional constraint on the contents of 

individual regions.

What is Sudoku Plus?

Sudoku Plus is a game we just invented which follows all the same rules of 

Sudoku but has a grid of variable size. A Sudoku Plus board might be 4x4, 9x9, 

etc. All valid grids will have the following characteristics:

1. The grid will be square (same number of rows and columns). The length of 

a side should have a integer value square root. Valid side lengths would 

include: 4, 9,16, etc.

2. The grid can be divided into square regions of equal size where the size of 

a region is equal to the square root of a side of the entire grid. Each region 

will have the same number of cells as rows in the grid. On a 16x16 grid

there would be 16 regions of size 4x4.

3. The numbers that can be used are in the range from 1 to N where N is the

length of a side.
Ex: 4 by 4
1,4,2,3
2,3,1,4
4,2,3,1
3,1,4,2


Programming Task

Write a Java program that accepts a possible Sudoku Plus solution and 

evaluates whether or not it is a valid solution. Input should be in the form of a 

CSV (comma-separated value) text file with columns separated by commas and 

rows separated by ‘\n’ return characters. Example input files representing the 

examples shown in this document are attached. 

This task is purposefully vague so that the solution can best represent what you 

believe to be the most important characteristics of a well-written program.

You should provide all source code, build scripts and instructions for how to run 

your program.

How to run the code?

The git repo has files for SudokuPlusEvaluator (archived eclipse project) and can be imported into Eclipse to view the source code and unit tests(can be run via eclipse junit configuration). It also has the evaluate script to run the evaluator. I have added a few sample input files (nine.txt and four.txt) with the grid configuration you sent me. The way to run the script is(after giving it execute permission) ./evaluate.sh <fileNameWithPath>, below are few examples and sample responses. Let me know if you have any questions and please acknowledge the receipt.

balaji@balaji-mac.local:~/Documents/workspacedev$ ./evaluate.sh 
No arguments were given - expecting filename
balaji@balaji-mac.local:~/Documents/workspacedev$ ./evaluate.sh nine.txt
5,3,4,6,7,8,9,1,2
6,7,2,1,9,5,3,4,8
1,9,8,3,4,2,5,6,7
8,5,9,7,6,1,4,2,3
4,2,6,8,5,3,7,9,1
7,1,3,9,2,4,8,5,6
9,6,1,5,3,7,2,8,4
2,8,7,4,1,9,6,3,5
3,4,5,2,8,6,1,7,9
Well done!!! The Grid(Sudoku board) has valid solution
balaji@balaji-mac.local:~/Documents/workspacedev$ ./evaluate.sh four.txt
1,4,2,3
2,3,1,4
4,2,3,1
3,1,4,2
Well done!!! The Grid(Sudoku board) has valid solution
balaji@balaji-mac.local:~/Documents/workspacedev$ ./evaluate.sh nineinvalid.txt
5,3,4,6,7,8,9,1,2
6,7,2,1,9,5,3,4,8
1,9,8,3,4,2,5,6,7
8,5,9,7,6,1,4,2,3
4,2,8,8,5,3,7,9,1
7,1,3,9,2,4,8,5,6
9,6,1,5,3,7,2,8,4
2,8,7,4,1,9,6,3,9
3,4,5,2,8,6,1,7,9
The Grid(Sudoku board) does not have valid row values, atleast one row does not have valid configuration 
Try again!!!
balaji@balaji-mac.local:~/Documents/workspacedev$ ./evaluate.sh fourinvalid.txt
1,4,2,3
2,3,1,4
4,2,3,1
3,1,4,4
The Grid(Sudoku board) does not have valid row values, atleast one row does not have valid configuration 
Try again!!!



