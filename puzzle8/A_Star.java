package puzzle8;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Ihr Name
 */
public class A_Star {
	// cost ordnet jedem Board die Aktuellen Pfadkosten (g-Wert) zu.
	// pred ordnet jedem Board den Elternknoten zu. (siehe Skript S. 2-25). 
	// In cost und pred sind genau alle Knoten der closedList und openList enthalten!
	// Nachdem der Zielknoten erreicht wurde, lässt sich aus cost und pred der Ergebnispfad ermitteln.
	private static HashMap<Board,Integer> cost = new HashMap<>();
	private static HashMap<Board,Board> pred = new HashMap<>();
	
	// openList als Prioritätsliste.
	// Die Prioritätswerte sind die geschätzen Kosten f = g + h (s. Skript S. 2-66)
	private static IndexMinPQ<Board, Integer> openList = new IndexMinPQ<>();
	
	private static int suchkosten;

	public static int getKosten() {
		return suchkosten;
	}

	public static Deque<Board> aStar(Board startBoard) {
		suchkosten = 1;
		if (startBoard.isSolved())
			return new LinkedList<>();
		cost.clear();
		pred.clear();
		openList.clear();

		cost.put(startBoard, 0);
		pred.put(startBoard, null);
		openList.add(startBoard, 0 + startBoard.h2());
		Board b;
		while (!openList.isEmpty()) {
			b = openList.removeMin();
			++suchkosten;
			Board r;
			if (b.isSolved()) {
				r = b;
				LinkedList<Board> result = new LinkedList<>();
				result.add(b);
				while(pred.get(r) != null) {
					result.add(pred.get(r));
					r = pred.get(r);
				}
				Collections.reverse(result);
				return result;
			}
			for (var p : b.possibleActions()) {
				if (!cost.containsKey(p)) {
					cost.put(p, cost.get(b) + 1);
					openList.add(p, cost.get(p) + p.h2());
					pred.put(p, b);	
				} else if ((cost.get(b) + 1) < cost.get(p)) {
					pred.put(p, b);
					cost.replace(p, cost.get(b) + 1);
					openList.change(p, cost.get(p) + p.h2());
				}
			}
		}
		return null; // Keine Lösung
	}
}
