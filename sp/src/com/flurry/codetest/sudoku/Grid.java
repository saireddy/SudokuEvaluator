package com.flurry.codetest.sudoku;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;;


public class Grid {
	public static final int MAX_ELEMENTS = 100;
	List<List<Integer>> board;
	int columns;
	int rows;
	
	public Grid() {
		board = new ArrayList<List<Integer>>();
		columns = 0;
	}
	
	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setBoard(List<List<Integer>> board) {
		this.board = board;
	}

	public List<List<Integer>> getBoard() {
		return board;
	}
	
	public void add(int value, int row, int col) {
	    while (row >= board.size()) 
	        board.add(new ArrayList<Integer>(
				    Collections.<Integer>nCopies(MAX_ELEMENTS, null))); //initiate arraylist with null so we can use set
	        
	    List<Integer> row_list = board.get(row);
	    
	    row_list.set(col, value);
	}	
	
}
