package com.flurry.codetest.sudoku;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.flurry.codetest.sudoku.reader.BoardReader;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		String fileName = "";

		if (args.length == 0) {
			System.out.println("No arguments were given - expecting filename");
			System.exit(0);
		} else {
			fileName = args[0];
		}

		BoardReader boardReader = new BoardReader();
		try {
			Grid grid = boardReader.buildGridByReadingFromFile(fileName);
			SudokuPlusEvaluator evaluator = new SudokuPlusEvaluator();
			if (evaluator.evaluateSudokuSolution(grid)) {
				System.out.println(String.format("Well done!!! The Grid(Sudoku board) has valid solution"));
			} else {
				System.out.println(String.format("Try again!!!"));
			}
		} catch (FileNotFoundException fnfException) {
			System.out.println("File not found, please enter full file path(separated by //). \n" +
					" For example: C://src//resource//sampleinput9By9.txt or if it is in same directory as jar file - pass file name at command line");
			System.exit(0); //exit - no file to work with
		}

	}

}
