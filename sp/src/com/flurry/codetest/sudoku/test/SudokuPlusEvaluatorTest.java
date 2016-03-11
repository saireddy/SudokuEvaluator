package com.flurry.codetest.sudoku.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.flurry.codetest.sudoku.Grid;
import com.flurry.codetest.sudoku.SudokuPlusEvaluator;

public class SudokuPlusEvaluatorTest {
	
	private SudokuPlusEvaluator classUnderTest;
	
	@Before
	public void setUp() {
		classUnderTest = new SudokuPlusEvaluator();
		
	}

	@Test
	public void testEvaluateSudokuSolution4By4CorrectSolution() {
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		board.add(Arrays.asList(1,4,2,3));
		board.add(Arrays.asList(2,3,1,4));
		
		board.add(Arrays.asList(4,2,3,1));
		board.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid = new Grid();
		testGrid.setBoard(board);
		testGrid.setRows(4);
		testGrid.setColumns(4);
		
		assertTrue(classUnderTest.evaluateSudokuSolution(testGrid));	
	}	
	
	@Test
	public void testEvaluateSudokuSolution4By4InorrectSolution() {
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		board.add(Arrays.asList(1,4,2,3));
		board.add(Arrays.asList(2,3,1,4));
		
		board.add(Arrays.asList(4,2,3,3));
		board.add(Arrays.asList(3,1,4,2));
	
		Grid testGrid = new Grid();
		testGrid.setBoard(board);
		testGrid.setRows(4);
		testGrid.setColumns(4);
		
		assertFalse(classUnderTest.evaluateSudokuSolution(testGrid));	
	}		
	
	@Test
	public void testEvaluateSudokuSolution9By9CorrectSolution() {
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		board.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3));
		board.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid = new Grid();
		testGrid.setBoard(board);
		testGrid.setRows(9);
		testGrid.setColumns(9);
		
		assertTrue(classUnderTest.evaluateSudokuSolution(testGrid));	
	
	}
	
	@Test
	public void testEvaluateSudokuSolution9By9InCorrectSolution() {
		
		List<List<Integer>> board = new ArrayList<List<Integer>>();
		board.add(Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2));
		board.add(Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8));
		board.add(Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7));
		
		board.add(Arrays.asList(8, 5, 9, 7, 6, 1, 4, 5, 3));
		board.add(Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1));
		board.add(Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6));
		
		board.add(Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4));
		board.add(Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5));
		board.add(Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9));
		
		Grid testGrid = new Grid();
		testGrid.setBoard(board);
		testGrid.setRows(9);
		testGrid.setColumns(9);
		
		assertFalse(classUnderTest.evaluateSudokuSolution(testGrid));	
	
	}	

}
