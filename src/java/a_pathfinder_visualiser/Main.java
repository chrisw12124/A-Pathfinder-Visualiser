package a_pathfinder_visualiser;

import a_pathfinder_visualiser.gui.Panel;

import javax.swing.*;

public class Main {

    private static final int GRID_SIZE = 20;

    public static void main(String[] args) {

        Grid grid = new Grid(GRID_SIZE,GRID_SIZE);
        Panel panel = new Panel(grid);

        JFrame frame = new JFrame("Pathfinder Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        int width = (GRID_SIZE * (Panel.CELL_SIZE + Panel.PADDING)) + 30;
        int height = (GRID_SIZE * (Panel.CELL_SIZE + Panel.PADDING)) + 50;

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null); // Centers the window on your screen
        frame.setVisible(true); // Turn it on!
    }
}
