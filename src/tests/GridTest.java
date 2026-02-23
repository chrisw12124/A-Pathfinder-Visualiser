import a_pathfinder_visualiser.Grid;
import a_pathfinder_visualiser.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(5,5);
    }

    @Test
    @DisplayName("Returns 2 neighbors for corners")
    void testCornerNeighbours() {
        Node cornerNode = grid.getNode(0,0);
        List<Node> neighbors = grid.getNeighbors(cornerNode);
        assertEquals(2, neighbors.size());
    }

    // Learning to test with parameters

    @ParameterizedTest
    @CsvSource({
            "0, 0, 2",   // Top-left corner
            "0, 4, 2",   // Top-right corner
            "4, 0, 2",   // Bottom-left corner
            "4, 4, 2",   // Bottom-right corner
            "0, 2, 3",   // Top edge
            "2, 2, 4"    // Center
    })
    void testNeighborCounts(int x, int y, int expected) {
        Node node = grid.getNode(x, y);
        assertEquals(expected, grid.getNeighbors(node).size());
    }
}
