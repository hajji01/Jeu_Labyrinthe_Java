package GrillesTest;


import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

import Grilles.Cell;
import Grilles.util.Direction;

import org.junit.Before;


public class DirectionTest {
    

    @Test
    public void getOppositeDirectionTest() {
        assertTrue(Direction.NORTH.getOpposite().equals(Direction.SOUTH));
        assertTrue(Direction.WEST.getOpposite().equals(Direction.EAST));
    }

    @Test
    public void getOtherSolutionTest() {
        assertTrue(Direction.SOUTH.getOtherSolution().equals(Direction.EAST));
        assertTrue(Direction.EAST.getOtherSolution().equals(Direction.SOUTH));
    }

    // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(CellTest.class);
	}
}
