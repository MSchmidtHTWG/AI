package puzzle8;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Klasse IDFS für iterative deepening depth-first search
 * @author Ihr Name
 */
public class IDFS {

	private static int suchkosten;

	public static int getKosten() {
		return suchkosten;
	}

	private static Deque<Board> dfs(Board curBoard, Deque<Board> path, int limit) {
		if (curBoard.isSolved()) {
			return path;
		} else if (limit == 0) {
			return null;
		} else {
			for (Board child : curBoard.possibleActions()) {
				if (path.contains(child)) {
					continue;
				}
				++suchkosten;
				path.add(child);
				Deque<Board> result = dfs(child,path,limit - 1);
				if (result != null)
					return result;
				path.remove(child);
			}
		}
		return null;
	}
	
	private static Deque<Board> idfs(Board curBoard, Deque<Board> path) {
		for (int limit = 5; limit < Integer.MAX_VALUE; limit++) {
			Deque<Board> result = dfs(curBoard,path,limit);
			if (result != null)
				return result;
		}
		return null;
	}
	
	public static Deque<Board> idfs(Board curBoard) {
		suchkosten = 1;
		Deque<Board> path = new LinkedList<>();
		path.addLast(curBoard);
		Deque<Board> res =  idfs(curBoard, path); 
		return res;
	}
}
