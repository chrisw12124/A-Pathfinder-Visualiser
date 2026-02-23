package a_pathfinder_visualiser;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int[][] DIRECTIONS = {{0,1}, {0,-1},{1,0},{-1,0}};
    private int sizeX = 10;
    private int sizeY = 10;
    private Node[][] matrix;

    public Grid(int x, int y) {
        newGrid(x, y);
    }

    private void newGrid(int gridX, int gridY) {
        sizeX = gridX;
        sizeY = gridY;
        matrix = new Node[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                matrix[y][x] = new Node();
            }
        }
    }

    public Node getNode(int x, int y) {
        return matrix[y][x];
    }

    public List<Node> getNeighbors(Node node) {
        int x = node.getX();
        int y = node.getY();

        List<Node> neighbors = new ArrayList<>();
        Node neighbor;

        for(int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX <= sizeX && newY >= 0 && newY <= sizeY) {
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
