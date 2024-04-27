import junit.framework.*;

import java.lang.reflect.Array;
import java.util.*;

public class UnitTest extends TestCase{


    public UnitTest(String testName) {
        super(testName);
    }

    public void testblowup(){
        StringCode stringCode = new StringCode();
        assertEquals("attttxzzz", stringCode.blowup("a3tx2z"));
        assertEquals("2xxx", stringCode.blowup("12x"));
    }

    public void testmaxRun(){
        StringCode stringCode = new StringCode();
        assertEquals(3, stringCode.maxRun("xxyyyz"));
        assertEquals(1, stringCode.maxRun("xyz"));
    }

    public void testintersect(){
        StringCode stringCode = new StringCode();
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 1));
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 2));
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 3));
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 4));
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 5));
        assertEquals(true, stringCode.stringIntersect("xaucon", "xauconchung", 6));
        assertEquals(false, stringCode.stringIntersect("xaucon", "xauconchung", 7));
    }

    public void testcharArea(){
        char[][] grid = new char[][] {
                { 'c', 'a', 'x' },
                { 'b', ' ', 'b' },
                { ' ', ' ', 'a' },
        };

        CharGrid charGrid = new CharGrid(grid);
        assertEquals(1, charGrid.charArea('c'));
        assertEquals(6, charGrid.charArea('a'));
        assertEquals(3, charGrid.charArea('b'));
        assertEquals(1, charGrid.charArea('x'));
        assertEquals(4, charGrid.charArea(' '));
        assertEquals(0, charGrid.charArea('t'));
    }

    public void testcountPlus(){
        char[][] grid = new char[][] {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' ', ' '},
                {' ', 'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x', ' '},
                {' ', ' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' ', ' '},
                {' ', ' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' ', ' '},
                {' ', 'z', 'z', 'z', 'z', 'z', 'y', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        CharGrid charGrid = new CharGrid(grid);

        assertEquals(2, charGrid.countPlus());
    }

    public void testclearRows1(){
        boolean[][] grid = new boolean[][] {
                {true, true, true},
                {true, true, false},
                {true, true, true},
                {false, true, true},
                {true, false, false},
                {false, false, false},
                {false, false, false},
        };

        boolean[][] expected = new boolean[][] {
                {true, true, false},
                {false, true, true},
                {true, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
        };

        TetrisGrid tetrisGrid = new TetrisGrid(grid);
        tetrisGrid.clearRows();

        assertTrue(Arrays.deepEquals(expected, tetrisGrid.getGrid()));
    }

    public void testclearRows2(){
        boolean[][] grid = new boolean[][] {
                {true, true, true},
                {true, true, true},
                {true, true, true},
                {true, true, true},
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        boolean[][] expected = new boolean[][] {
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
        };

        TetrisGrid tetrisGrid = new TetrisGrid(grid);
        tetrisGrid.clearRows();

        assertTrue(Arrays.deepEquals(expected, tetrisGrid.getGrid()));
    }

    public void testsameCount(){
       List<String> a = Arrays.asList("a", "b", "a", "b", "c");
       List<String> b = Arrays.asList("c", "a", "a", "d", "b", "b", "b");

       assertEquals(Appearances.sameCount(a, b), 2);
    }

    public void testnoFollow1(){
        List<String> a = Arrays.asList("a", "c", "a", "b");
        Taboo<String> tb = new Taboo<String>(a);

        Set<String> check = new HashSet<String>();
        check.add("b");
        check.add("c");

        assertTrue(Arrays.deepEquals(check.toArray(), tb.noFollow("a").toArray()));
    }

    public void testnoFollow2(){
        List<String> a = Arrays.asList("a", "c", "b", "x", "c", "a");
        Taboo<String> tb = new Taboo<String>(a);

        Set<String> check = new HashSet<String>();
        check.add("c");

        assertTrue(Arrays.deepEquals(check.toArray(), tb.noFollow("a").toArray()));
    }

    public void testreduce(){
        List<String> rule = Arrays.asList("a", "c", "a", "b");
        Taboo<String> tb = new Taboo<String>(rule);

        List<String> a = new LinkedList<>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        tb.reduce(a);

        List<String> check = Arrays.asList("a", "x", "c");
        assertTrue(Arrays.deepEquals(check.toArray(), a.toArray()));
    }
}