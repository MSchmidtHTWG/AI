# Aufgabenblatt 2

## Aufgabe 1 : Parität

### Welche Parität hat der Zustand S in Abb. 1? 

Antwort: Die Parität beträgt 18 und ist damit gerade, also in unserem Programm "True".

## Aufgabe 2 : Heuristiken

### Für  einen  Zustand  z  ist  h1(z)  die  Anzahl  der  falsch  platzierten  Steine  in  Bezug  auf  den Zielzustand. In Abb. 1 ist h1(S) = 8. Wieso ist h1 eine monotone Heuristik?

Antwort: Jeder falsch platzierte Stein muss immer mindestens einmal bewegt werden, um auf seine korrekte Position kommen zu können. Daher müssen für X falsch platzierte Steine immer mindestens X Züge durchgeführt werden, um eine Lösung erreichen zu können. Deshalb ist die Heuristik h1 immer kleiner oder gleich der Anzahl der zum Lösen notwendigen Zügen.

### Für  einen  Zustand  z  ist  h2(z)  die  Summe  der  Manhattan-Distanzen  der  Steine  von  ihren Zielpositionen. In Abb. 1 ist h2(S) = 3 + 1 + 2 + 2 + 2 + 3 + 3 + 2 = 18. Wieso ist h2 eine monotone Heuristik?

Antwort: Da ich keine zwei Zahlen (ohne die 0, bzw. dem leeren Feld) miteinander tauschen darf, verringert sich die Manhattan-Distanz nach einem Zug immer maximal um 1 (sie kann sich auch um 1 erhöhen). Es existiert also kein Zug, der zwei Steine gleichzeitig näher an ihre Zielposition bringt. Daraus folgt, dass die Zahl der Züge bis zur Lösung immer gleich oder größer der Manhattan-Distanz ist. Die Manhattan-Distanz ist damit für jede Position immer kleiner oder gleich der bis zur Lösung notwendigen Züge.

### Wieso ist h1(n) ≤ h2(n)? Welche Heuristik ist also besser? 

Antwort: Ein Stein, der richtig platziert ist, bekommt in beiden Heuristiken den Wert 0. Jeder falsch platzierte Stein bekommt in h1 den Wert 1 und in h2 mindestens den Wert 1 oder einen größeren zugewiesen. Damit ist h1 immer kleiner oder gleich h2. Für eine gegebene Position sind die tatsächliche Kosten zum Lösen dieser konstant und immer größer oder gleich der Werte der Heuristiken. Zieht man von dieser Konstanten jeweils die Werte der beiden Heuristiken ab, so ist das Ergebnis für die Heuristik h2 immer kleiner oder gleich des Ergebnis für Heuristik h1. Die Heuristik h2 ist also schärfer, sie liegt also näher oder maximal gleich weit entfernt von den tatsächlichen Kosten im Vergleich zu h1.