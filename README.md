# A-Pathfinder-Visualiser
A java program which displays the process of the A* algorithm on a grid, where the start point, end point and obstacles can be placed

Building a Pathfinding Visualizer in Java is a strategic move for a University of Sheffield student. It directly complements your **COM114 (Java Programming)** and **COM113 (Practical Algorithms and Data Structures)** modules.

Unlike the web version, a Java implementation allows you to dive deeper into **Object-Oriented Design (OOD)** and **Concurrency**, which are core "Diamond-lab" skills.

---

## Phase 1: The "Model" (Data Structures)

*Alignment: COM114 (Classes/Objects) & COM113 (Graphs)*
Instead of thinking about "pixels," think about "objects."

* **The `Node` Class:** Create a class to represent a single cell. It needs:
* Coordinates: `(int x, int y)`
* State: `boolean isWall`, `boolean isVisited`.
* Pathfinding variables: `int distance` (for Dijkstra) and `Node parent`.


* **The `Grid` Class:** Use a **2D Array** `Node[][] matrix`.
* **Logic:** Implement a method `getNeighbors(Node n)` that returns a `List<Node>`. This is your first step into graph theory—treating a grid as a graph where each node has up to 4 neighbors.

---

## Phase 2: The "View" (GUI with Swing)

*Alignment: Java GUI Basics*
At Sheffield, you'll likely start with **Swing** because it's built into the JDK.

* **The Canvas:** Create a class that `extends JPanel`.
* **Drawing Logic:** Override `paintComponent(Graphics g)`. Use a nested loop to draw each `Node` from your matrix as a `g.fillRect()`.
* **The Window:** Use `JFrame` to host your panel. Set its size and default close operation.

---

## Phase 3: The "Controller" (Input)

*Alignment: Event-Driven Programming*

* **Mouse Listeners:** Add a `MouseListener` and `MouseMotionListener` to your panel.
* **Interaction:** If a user clicks or drags over a cell, set `node.isWall = true` and call `repaint()`.
* **UI Controls:** Add a second `JPanel` with `JButton`s for "Start," "Reset," and a `JComboBox` to pick the algorithm.

---

## Phase 4: The Algorithm (BFS & Dijkstra)

*Alignment: COM113 (Search Algorithms)*

* **BFS (Breadth-First Search):** Use a `java.util.Queue`. It’s the easiest to start with for unweighted grids.
* **Dijkstra:** Use a `java.util.PriorityQueue`. You will need to make your `Node` class implement `Comparable<Node>` so the queue knows to pick the node with the shortest distance.

---

## Phase 5: The "Level Up" (Multi-threading)

*This is what makes it a "Sheffield-tier" project.*
If you run the algorithm in the main thread, the GUI will freeze while it calculates. To animate it:

* **Swing Worker or Threads:** Run the algorithm in a separate `Thread`.
* **The Delay:** Inside your algorithm's loop, use `Thread.sleep(20)` after visiting each node.
* **Repainting:** After each visit, call `SwingUtilities.invokeLater(() -> repaint())` to safely update the UI from a background thread.

---

## Phase 6: Professional Standards

*Alignment: COM1001 (Software Engineering)*

* **Testing:** Write **JUnit** tests for your `getNeighbors` logic and your algorithm. (e.g., "Does BFS find a path of length 5 on a  empty grid?")
* **Maven/Gradle:** Use a build tool to manage your project. This shows you understand how professional Java projects are structured.
* **Documentation:** Use **Javadoc** (`/** ... */`) for your methods.

---

### Why this is a "Gold" Portfolio Project

1. **Complexity:** Shows you can handle multi-threading (the hardest part of Java).
2. **Clean Code:** Demonstrates **MVC (Model-View-Controller)** separation.
3. **Visual Impact:** It’s much more impressive to show a moving animation than a static console app.

**Would you like a "Starter Template" code snippet for the `Node` class and the basic `paintComponent` loop to get you moving?**