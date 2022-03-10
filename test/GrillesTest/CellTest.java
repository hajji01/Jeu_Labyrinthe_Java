package GrillesTest;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

import Grilles.Cell;
import Grilles.util.Direction;

public class CellTest {
    
    @Test
    public void destroyWallTest() {
        Cell myCell = new Cell(4, 5);
        assertTrue(myCell.isWallExist(Direction.NORTH));
        myCell.destroyWall(Direction.NORTH);
        assertFalse(myCell.isWallExist(Direction.NORTH));
    }

    @Test
    public void visitedTest() {
        Cell myCell = new Cell(4, 5);
        assertFalse(myCell.isAlreadyVisited());
    }

    @Test
    public void getXTest() {
        Cell myCell = new Cell(4, 5);
        assertSame(myCell.getX(), 4);
    }

    @Test
    public void getYTest() {
        Cell myCell = new Cell(4, 5);
        assertSame(myCell.getY(), 5);
    }


    // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CellTest.class);
	}
}
