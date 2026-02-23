package a_pathfinder_visualiser.gui;

import a_pathfinder_visualiser.Grid;
import a_pathfinder_visualiser.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {

    public static final int CELL_SIZE = 30;
    public static final int PADDING = 5;

    private Grid grid;

    private class CustomMouseListener extends MouseAdapter {

        public void handleMouseInput(MouseEvent e) {
            int pixelX = e.getX();
            int pixelY = e.getY();

            int gridX = (pixelX - PADDING) / (CELL_SIZE +PADDING);
            int gridY = (pixelY - PADDING) / (CELL_SIZE +PADDING);

            if (gridX >= 0 && gridX < grid.getSizeX() && gridY >= 0 && gridY < grid.getSizeY()) {
                Node selectedNode = grid.getNode(gridX, gridY);
                if (selectedNode != null) {
                    selectedNode.setIsWall(true);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            handleMouseInput(e);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            handleMouseInput(e);
        }

    }


    public Panel(Grid grid) {
        this.grid = grid;
    }

    public void addListeners() {
        // Mouse Listener and Mouse Motion Listener
        CustomMouseListener customMouseListener = new CustomMouseListener();
        this.addMouseListener(customMouseListener);
        this.addMouseMotionListener(customMouseListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Node[][] matrix =  grid.getMatrix();
        for  (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                int xPos = PADDING + x * (CELL_SIZE + PADDING);
                int yPos = PADDING + y * (CELL_SIZE + PADDING);
                g.fillRect(xPos, yPos, CELL_SIZE, CELL_SIZE);
            }
        }
    }
}
