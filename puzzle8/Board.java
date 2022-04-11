package puzzle8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * Klasse Board für 8-Puzzle-Problem
 * @author Ihr Name
 */
public class Board {

	/**
	 * Problemgröße
	 */
	public static final int N = 8;

	/**
	 * Board als Feld. 
	 * Gefüllt mit einer Permutation von 0,1,2, ..., 8.
	 * 0 bedeutet leeres Feld.
	 */
	protected int[] board = new int[N+1];

	/**
	 * Generiert ein zufälliges Board.
	 */
	public Board() {
		for (int i = 0; i < N + 1; ++i) {
			board[i] = i;
		}
		Collections.shuffle(Arrays.asList(board));
	}
	
	/**
	 * Generiert ein Board und initialisiert es mit board.
	 * @param board Feld gefüllt mit einer Permutation von 0,1,2, ..., 8.
	 */
	public Board(int[] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Puzzle{" + "board=" + Arrays.toString(board) + '}';
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Board other = (Board) obj;
		return Arrays.equals(this.board, other.board);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Arrays.hashCode(this.board);
		return hash;
	}
	
	/**
	 * Paritätsprüfung.
	 * @return Parität.
	 */
	public boolean parity() {
		int p = 0;
		for (int i = 0; i < board.length - 1; ++i) {
			for (int j = i + 1; j < board.length; ++j) {
				if (board[i] != 0 && board[j] !=0 && board[i] > board[j]) {
					++p;
				}
			}
		}
		if (p % 2 == 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Heurstik h1. (siehe Aufgabenstellung)
	 * @return Heuristikwert.
	 */
	public int h1() {
		int h = 0;
		for (int i = 1; i < board.length; ++i) {
			if (board[i] != i) {
				++h;
			}
		}
		return h; 
	}
	
	/**
	 * Heurstik h2. (siehe Aufgabenstellung)
	 * @return Heuristikwert.
	 */
	public int h2() {
		int h = 0;
		//int[][] mboard = new int[3][3];
		for (int i = 0; i < board.length; ++i) {
			if (board[i] == 0) {
				continue;
			}
			int x = Math.abs(board[i] - i);
			h += (x / 3) + (x % 3);
			if (x == 1 && (i == 2 || i == 3 || i == 5 || i == 6)) {
				h += 2;
			}
		}
		return h;
	}
	
	/**
	 * Liefert eine Liste der möglichen Aktion als Liste von Folge-Boards zurück.
	 * @return Folge-Boards.
	 */
	public List<Board> possibleActions() {
		List<Board> boardList = new LinkedList<>();
		// ...
		return boardList;
	}
	
	
	/**
	 * Prüft, ob das Board ein Zielzustand ist.
	 * @return true, falls Board Ziestzustand (d.h. 0,1,2,3,4,5,6,7,8)
	 */
	public boolean isSolved() {
		return true;
	}
	
	
	public static void main(String[] args) {
		Board b = new Board(new int[]{7,2,4,5,0,6,8,3,1});		// abc aus Aufgabenblatt
		Board goal = new Board(new int[]{0,1,2,3,4,5,6,7,8});
				
		System.out.println(b);
		System.out.println(b.parity());
		System.out.println(b.h1());
		System.out.println(b.h2());
		
		/** for (Board child : b.possibleActions())
			System.out.println(child);
		
		System.out.println(goal.isSolved()); */
	}
}
	
