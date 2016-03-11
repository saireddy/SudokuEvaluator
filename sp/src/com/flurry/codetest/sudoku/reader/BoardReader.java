package com.flurry.codetest.sudoku.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.flurry.codetest.sudoku.Grid;

public class BoardReader {
	
	private Grid grid;
	
	public BoardReader() {
		grid = new Grid();
	}

	public Grid buildGridByReadingFromFile(String fileName) throws IOException {
		String newLine;
		int row = 0;
		int col = 0;
		try{
			BufferedReader br = new BufferedReader(
					new FileReader(fileName));
			while ((newLine = br.readLine()) != null) {
				System.out.println(newLine); //print the board
				StringTokenizer st = new StringTokenizer(newLine, ",");
				col = 0;
				while (st.hasMoreTokens()) {
					int value = Integer.parseInt(st.nextToken());
					grid.add(value, row, col);
					col++;
				}
				row++;
			}
			grid.setRows(row);
			grid.setColumns(col);
			br.close(); //close the reader
		} 
		catch(FileNotFoundException fnfException) {
			throw fnfException;
		}
		return grid;
	}
	
}
