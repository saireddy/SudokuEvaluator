package com.flurry.codetest.sudoku.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.flurry.codetest.sudoku.Grid;
import com.flurry.codetest.sudoku.SudokuPlusUtility;

public class SudokuPlusUtilityTest {
	
	@Test
	public void testValidateGridDimensionsWithValidDimentions() {
		
		Grid testGrid = new Grid();
		testGrid.setRows(4);
		testGrid.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateGridDimensions(testGrid));			

	}
	
	@Test
	public void testValidateGridDimensionsWithInValidDimentions() {
	
		Grid testGrid = new Grid();
		testGrid.setRows(4);
		testGrid.setColumns(5); //more columns	
		assertFalse(SudokuPlusUtility.validateGridDimensions(testGrid));
		
		testGrid.setRows(5); //more rows
		testGrid.setColumns(4); 
		assertFalse(SudokuPlusUtility.validateGridDimensions(testGrid));
		
		testGrid.setRows(6); //squre root not integer - side is not int
		testGrid.setColumns(6); 
		assertFalse(SudokuPlusUtility.validateGridDimensions(testGrid));		
	}	
	
	@Test
	public void testValidateGridValuesWithValidValues() {
	
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		board.add(Arrays.asList(1,4,2,3));
		board.add(Arrays.asList(2,3,1,4));
		
		board.add(Arrays.asList(4,2,3,1));
		board.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid = new Grid();
		testGrid.setBoard(board);
		testGrid.setRows(4);
		testGrid.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateGridValues(testGrid));
			
	}	
	
	@Test
	public void testValidateGridValuesWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3));
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,5)); //5 is not between 1 and 4
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateGridValues(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(1,4,2,3));
		board2.add(Arrays.asList(2,3,1,4));
		
		board2.add(Arrays.asList(4,2,3,0)); //0 is not between 1 and 4
		board2.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(4);
		testGrid2.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateGridValues(testGrid2));		
			
	}		
	
	@Test
	public void testValidateSumOfRowsWithValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateSumsOfRows(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertTrue(SudokuPlusUtility.validateSumsOfRows(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateSumOfRowsWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,3,4)); //bad row
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateSumsOfRows(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 8, 8, 5, 6)); //bad row
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertFalse(SudokuPlusUtility.validateSumsOfRows(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateSumOfColumnsWithValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateSumsOfColumns(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertTrue(SudokuPlusUtility.validateSumsOfColumns(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateSumOfColumnsWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,3,4)); //bad column - has 3 again
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,3,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateSumsOfColumns(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 8, 4, 5, 6)); 
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 9, 3, 5));//bad column - has 9 again
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertFalse(SudokuPlusUtility.validateSumsOfColumns(testGrid2));		
			
	}		
	
	@Test
	public void testValidateRowsHaveNoDuplicatesWithValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateRowsHaveNoDuplicates(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertTrue(SudokuPlusUtility.validateRowsHaveNoDuplicates(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateRowsHaveNoDuplicatesWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,3,4)); //bad row
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateRowsHaveNoDuplicates(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 8, 8, 5, 6)); //bad row - has 8 again
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertFalse(SudokuPlusUtility.validateRowsHaveNoDuplicates(testGrid2));		
			
	}		
	
	@Test
	public void testValidateColumnsHaveNoDuplicatesWithValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertTrue(SudokuPlusUtility.validateColumnsHaveNoDuplicates(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertTrue(SudokuPlusUtility.validateColumnsHaveNoDuplicates(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateColumnsHaveNoDuplicatesWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,3,4)); //bad column
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,3,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		assertFalse(SudokuPlusUtility.validateColumnsHaveNoDuplicates(testGrid1));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 8, 4, 5, 6)); 
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 9, 3, 5));//bad column - has 9 again
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		
		assertFalse(SudokuPlusUtility.validateColumnsHaveNoDuplicates(testGrid2));		
			
	}		
	
	
	@Test
	public void testValidateAllSquaresHaveNoDuplicatesWithValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,1,4));
		
		board1.add(Arrays.asList(4,2,3,1));
		board1.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		int subSquareSize = (int) Math.sqrt(testGrid1.getRows());				
		assertTrue(SudokuPlusUtility.validateAllSquaresHaveNoDuplicates(testGrid1, subSquareSize));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);	
		subSquareSize = (int) Math.sqrt(testGrid2.getRows());			
		assertTrue(SudokuPlusUtility.validateAllSquaresHaveNoDuplicates(testGrid2, subSquareSize));		
			
	}		
	
	
	@Test
	public void testValidateAllSquaresHaveNoDuplicatesWithInValidValues() {
	
		List<List<Integer>> board1 = new ArrayList<List<Integer>>();
		board1.add(Arrays.asList(1,4,2,3)); //4by4
		board1.add(Arrays.asList(2,3,3,4)); //bad square
		
		board1.add(Arrays.asList(4,2,3,1)); //bad square
		board1.add(Arrays.asList(3,1,3,2));
	
		Grid testGrid1 = new Grid();
		testGrid1.setBoard(board1);
		testGrid1.setRows(4);
		testGrid1.setColumns(4);
		
		int subSquareSize = (int) Math.sqrt(testGrid1.getRows());				
		assertFalse(SudokuPlusUtility.validateAllSquaresHaveNoDuplicates(testGrid1, subSquareSize));
		
		List<List<Integer>> board2 = new ArrayList<List<Integer>>();
		board2.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board2.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board2.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board2.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board2.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board2.add(Arrays.asList(7, 1, 3, 9, 2, 8, 4, 5, 6)); 
		
		board2.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board2.add(Arrays.asList(2, 8, 7, 4, 1, 9, 9, 3, 5));//bad square
		board2.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 4, 9));
		
		Grid testGrid2 = new Grid();
		testGrid2.setBoard(board2);
		testGrid2.setRows(9);
		testGrid2.setColumns(9);		
		subSquareSize = (int) Math.sqrt(testGrid2.getRows());			
		assertFalse(SudokuPlusUtility.validateAllSquaresHaveNoDuplicates(testGrid2, subSquareSize));	
			
	}			
		
		
	
	

}
