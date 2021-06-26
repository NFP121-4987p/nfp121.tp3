package question2;

public class Pile4Test extends junit.framework.TestCase {
    
    private PileI p1;
    private PileI p2;
    private PileI p3;
    private PileI p4;

    protected void setUp() 
    {
        p1 = new question2.Pile4();
        p2 = new question2.Pile4();
    }
    
    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        PileI pile = new question2.Pile4(3);
        pile.empiler(13);
        assertEquals(1, pile.taille());
        pile.empiler(168);
        assertEquals(2, pile.taille());
        pile.empiler(22);
        assertEquals(3, pile.taille());
        assertEquals(true, pile.estPleine());
        assertEquals(pile.taille(), pile.capacite());
        try {
            pile.empiler(0);
            fail("Cette pile est pleine!");
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        PileI pile = new question2.Pile4(3);
        pile.empiler(3);
        assertEquals(3, pile.sommet());
        assertEquals(3, pile.depiler());
        assertEquals(0, pile.taille());
    }

    public void test_Pile_estVide() throws Exception {
        PileI pile = new question2.Pile4(3);
        assertEquals(true, pile.estVide());
        try {
            Object pile1 = pile.depiler();
            fail("Cette pile est vide!");
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        PileI pile = new question2.Pile4(3);
        assertEquals("[]", pile.toString());
        pile.empiler(6);
        pile.empiler(5);
        pile.empiler(4);
        assertEquals("toString incorrect ? ", "[4, 5, 6]", pile.toString());
    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile4(-6);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());
    }

    public void test_Pile_equals() throws Exception {
        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);
        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);
        assertTrue("égalité?", p1.equals(p2));
        p2.empiler(1);
        assertFalse("égalité?", p1.equals(p2));
    }
    
}
