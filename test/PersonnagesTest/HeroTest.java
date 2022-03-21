package PersonnagesTest;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

import Personnages.Hero;

public class HeroTest {
    
    @Test
    public void createHeroTest(String prmName, int prmOr){
        Hero hero1 = new Hero("victor",0);
        assertSame(hero1.getName(), "victor");
        assertSame(hero1.getOr(), 0);
    }
   /* 
    @Test
    public void pickUpObjectTest(){
        Hero hero1 = new Hero("victor",0);
         
    }
    
*/

    // ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(HeroTest.class);
	}
}
