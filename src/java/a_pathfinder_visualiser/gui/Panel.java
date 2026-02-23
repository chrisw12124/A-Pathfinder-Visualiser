package a_pathfinder_visualiser.gui;

import a_pathfinder_visualiser.Grid;
import a_pathfinder_visualiser.Node;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private final int CELL_SIZE = 30;
    private final int PADDING = 5;

    private Grid grid;

    public Panel(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Node[][] matrix =  grid.getMatrix();
        for  (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                int xPos = x * CELL_SIZE + PADDING;
                int yPos = y * CELL_SIZE + PADDING;
                g.fillRect(xPos, yPos, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}
