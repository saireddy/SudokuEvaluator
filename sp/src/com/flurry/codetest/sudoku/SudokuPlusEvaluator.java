package com.flurry.codetest.sudoku;

public class SudokuPlusEvaluator {
	
	public boolean evaluateSudokuSolution(Grid grid) {
		int subSquareSize = (int) Math.sqrt(grid.rows);
		
		//verify grid dimensions: row size should be equal to column size
		if(!SudokuPlusUtility.validateGridDimensions(grid)){
			System.out.println(String.format("The Grid(Sudoku board) does not have valid dimensions," +
					" number of rows: %s and columns: %s are not equal",grid.rows, grid.columns)); //Exception or return value can be configured to show right message in UI
			return false;
			
		}
		
		//verify grid values are between 1 and N
		if(!SudokuPlusUtility.validateGridValues(grid)){
			System.out.println(String.format("The Grid(Sudoku board) does not have valid values, " +
					"values should be in between 1 and %s", grid.rows));
			return false;
		}
		
		//In all valid configurations sum of values in a row = sum of 1 to N - as all numbers appear at-least once in every row
		//This is not required check but adds performance boost as we eliminate invalid configurations fast
		if(!SudokuPlusUtility.validateSumsOfRows(grid)){
			System.out.println(String.format("The Grid(Sudoku board) does not have valid row values, " +
					"atleast one row does not have valid configuration "));
			return false;
		}		
		
		//In all valid configurations sum of values in a column = sum of 1 to N - as all numbers appear at-least once in every column	
		//This is not required check but adds performance boost as we eliminate invalid configurations fast		
		if(!SudokuPlusUtility.validateSumsOfColumns(grid)){
			System.out.println(String.format("The Grid(Sudoku board) does not have valid colum values, " +
					"atleast one column does not have valid configuration "));
			return false;
		}	
		
		//No row should have duplicate values
		if(!SudokuPlusUtility.validateRowsHaveNoDuplicates(grid)){
			System.out.println(String.format("The Grid(Sudoku board) has duplicates in atleast one row"));
			return false;
		}			
		
		//No column should have duplicate values
		if(!SudokuPlusUtility.validateColumnsHaveNoDuplicates(grid)){
			System.out.println(String.format("The Grid(Sudoku board) has duplicates in atleast one column"));
			return false;
		}		
		
		//Check that the sub-squares contain no duplicate values
		if(!SudokuPlusUtility.validateAllSquaresHaveNoDuplicates(grid, subSquareSize)){
			System.out.println(String.format("The Grid(Sudoku board) has duplicates in atleast one sub-squares"));
			return false;
		}
	//if all checks pass - it is a valid sudoku configuration	
	return true;	
	}
}

