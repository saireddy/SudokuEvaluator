package com.flurry.codetest.sudoku;

import java.util.List;


public class SudokuPlusUtility {

	public static boolean validateGridDimensions(Grid grid) {
		// check row and columns are of same size
		if (grid.rows != grid.columns) {
			return false;
		}

		// check square root of length of side is an integer
		if (!isPerfectSquare(grid.rows)) {
			return false;
		}

		return true;

	}

	// All grid values should be between 1 and N
	public static boolean validateGridValues(Grid grid) {
		List<List<Integer>> board = grid.getBoard();
		int row = 0;
		int col = 0;
		while (row < grid.rows) {
			List<Integer> rowList = board.get(row);
			col = 0; // reset
			while (col < grid.columns) {
				if (rowList.get(col) < 1 || rowList.get(col) > grid.columns) {
					return false;
				}
				col++;
			}
			row++;
		}
		return true;
	}

	public static boolean validateSumsOfRows(Grid grid) {
		List<List<Integer>> board = grid.getBoard();
		int row = 0;
		int col = 0;
		int currentRowSum = 0;
		int expectedSum = getSum(grid.rows);
		while (row < grid.rows) {
			List<Integer> rowList = board.get(row);
			col = 0; // reset
			currentRowSum = 0;
			while (col < grid.columns) {
				currentRowSum = currentRowSum + rowList.get(col);
				col++;
			}
			// check current row sum
			if (currentRowSum != expectedSum) {
				return false;
			}
			row++;
		}
		return true;
	}

	public static boolean validateSumsOfColumns(Grid grid) {
		List<List<Integer>> board = grid.getBoard();
		int row = 0;
		int col = 0;
		int currentColumnSum = 0;
		int expectedSum = getSum(grid.rows);
		while (col < grid.columns) {
			row = 0; // reset
			currentColumnSum = 0;
			while (row < grid.rows) {
				currentColumnSum = currentColumnSum + board.get(row).get(col);
				row++;
			}
			// check current row sum
			if (currentColumnSum != expectedSum) {
				return false;
			}
			col++;
		}
		return true;
	}

	public static boolean validateRowsHaveNoDuplicates(Grid grid) {
		// Check that the rows contain no duplicate values
		for (int row = 0; row < grid.rows; row++) {
			if (!validateCurrentRowHasNoDuplicates(grid, row)) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateCurrentRowHasNoDuplicates(Grid grid, int currentRow) {
		final int size = grid.columns;
		List<List<Integer>> board = grid.getBoard();
		boolean[] found = new boolean[size];
		for (int col = 0; col < size; col++) {
			// set found[n - 1] to be true if we find n - as index starts from 0
			int index = board.get(currentRow).get(col) - 1;
			if (!found[index]) {
				found[index] = true;
			} else {
				// found it twice, so return false
				return false;
			}
		}

		// didn't find any number twice, so return true
		return true;
	}

	public static boolean validateColumnsHaveNoDuplicates(Grid grid) {
		// Check that the rows contain no duplicate values
		for (int col = 0; col < grid.columns; col++) {
			if (!validateCurrentColumnHasNoDuplicates(grid, col)) {
				return false;
			}
		}
		return true;
	}

	private static boolean validateCurrentColumnHasNoDuplicates(Grid grid,
			int currentColumn) {
		final int size = grid.rows;
		List<List<Integer>> board = grid.getBoard();
		boolean[] found = new boolean[size];
		for (int row = 0; row < size; row++) {
			// set found[n - 1] to be true if we find n - as index starts from 0
			int index = board.get(row).get(currentColumn) - 1;
			if (!found[index]) {
				found[index] = true;
			} else {
				// found it twice, so return false
				return false;
			}
		}

		// didn't find any number twice, so return true
		return true;
	}

	// Check that the sub-squares contain no duplicate values
	public static boolean validateAllSquaresHaveNoDuplicates(Grid grid,
			int subSquareSize) {
		final int size = grid.rows;
		for (int baseRow = 0; baseRow < size; baseRow += subSquareSize) {
			for (int baseCol = 0; baseCol < size; baseCol += subSquareSize) {
				if (!validateCurrentSquareHasNoDuplicates(grid, baseRow,
						baseCol, subSquareSize)) {
					return false;
				}
			}
		}
		return true;
	}

	
	/* 
	 *@param baseRow topmost row of the square
	 *@param baseCol leftmost column of the square
	 *@param subSquareSize - the size of the subsquare to be checked
	 */
	private static boolean validateCurrentSquareHasNoDuplicates(Grid grid,
			int baseRow, int baseCol, int subSquareSize) {
		boolean[] found = new boolean[grid.rows];
		List<List<Integer>> board = grid.getBoard();

		for (int row = baseRow; row < (baseRow + subSquareSize); ++row) {
			for (int col = baseCol; col < (baseCol + subSquareSize); ++col) {
				// set found[n - 1] to be true if we find n
				int index = board.get(row).get(col) - 1;
				if (!found[index]) {
					found[index] = true;
				} else {
					// found it twice, so return false
					return false;
				}
			}
		}
		return true;
	}

	private static int getSum(int max) {
		return max * (max + 1) / 2; // from formula of sum of n number n*(n+1)/2
	}

	private static boolean isPerfectSquare(long n) {
		if (n < 0)
			return false;

		long tst = (long) (Math.sqrt(n));
		return tst * tst == n;
	}

}
