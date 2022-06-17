package PersonnagesTest;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

import Grilles.Cell;
import Grilles.Grille;
import Objets.Joyaux;
import Personnages.Hero;

public class HeroTest {
    
    @Test
    public void createHeroTest(){
        Grille maze = new Grille(10, 10);
        Hero hero1 = new Hero("victor",0,maze);
        assertSame(hero1.getName(), "victor");
        assertSame(hero1.getOr(), 0);
    }
   
    @Test
    public void pickUpObjectTest(){
        Grille maze = new Grille(10, 10);
        Hero hero1 = new Hero("victor",0,maze);
        Cell myCell = new Cell(4, 5);
        Joyaux joyaux = new Joyaux("joyaux", 15);

        hero1.setX(4);
        hero1.setY(5);

        assertSame(myCell.isAnItemsThere(),false);
        assertSame(hero1.pickUpObject(),false);

        myCell.setObj(joyaux);
        assertSame(myCell.isAnItemsThere(),true);

    }
    


    // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(HeroTest.class);
	}
}
