import a_pathfinder_visualiser.Grid;
import a_pathfinder_visualiser.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTesting {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(10,10);
    }

    @Test
    @DisplayName("Returns 2 neighbors for corners")
    void testCornerNeighbours() {
        Node cornerNode = grid.getNode(0,0);
        List<Node> neighbors = grid.getNeighbors(cornerNode);
        assertEquals(2, neighbors.size());
    }
}
