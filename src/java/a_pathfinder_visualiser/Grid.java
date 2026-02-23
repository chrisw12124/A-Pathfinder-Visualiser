package a_pathfinder_visualiser;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int[][] DIRECTIONS = {{0,1}, {0,-1},{1,0},{-1,0}};
    private final int SIZE_X = 10;
    private final int SIZE_Y = 10;
    private final Node[][] matrix;

    public Grid(Node[][] matrix) {
        this.matrix = matrix;
    }

    public List<Node> getNeighbors(Node node) {
        int x = node.getX();
        int y = node.getY();

        List<Node> neighbors = new ArrayList<>();
        Node neighbor;

        for(int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX <= SIZE_X && newY >= 0 && newY <= SIZE_Y) {
                neighbor = matrix[newX][newY];

                if (neighbor != null) {
                    if (!neighbor.getIsWall()) {
                        neighbors.add(neighbor);
                    }
                }
            }
        }
        return neighbors;
    }
}
