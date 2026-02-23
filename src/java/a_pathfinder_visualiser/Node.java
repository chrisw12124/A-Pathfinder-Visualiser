package a_pathfinder_visualiser;

public class Node {

    private int x;
    private int y;

    private boolean isWall;
    private boolean isVisited;

    private int distance;

    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean getIsWall() {
        return isWall;
    }
    public void setIsWall(boolean isWall) {
        this.isWall = isWall;
    }
    public boolean getIsVisited() {
        return isVisited;
    }
    private Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
}
