package a_pathfinder_visualiser;

public class Node {

    private int x;
    private int y;

    private boolean isWall;
    private boolean isVisited;

    private int distance;

    private Node parent;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean getIsWall() {
        return isWall;
    }
    public boolean getIsVisited() {
        return isVisited;
    }

    private Node getParent() {
        return parent;
    }
}
