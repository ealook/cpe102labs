import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestCases
{
   private static final double DELTA = 0.00001;

   @Test
   public void testSimpleIf1()
   {
      assertEquals(1.7, SimpleIf.max(1.2, 1.7), DELTA);
   }

   @Test
   public void testSimpleIf2()
   {
      assertEquals(9.0, SimpleIf.max(9.0, 3.2), DELTA);
   }

   @Test
   public void testSimpleIf3() {
      assertEquals(0.0, SimpleIf.max(0.0, -1.1), DELTA);
   }

   @Test
   public void testSimpleLoop1()
   {
      assertEquals(7, SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()
   {
      assertEquals(7, SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3() { assertEquals(55, SimpleLoop.sum(0, 10));}

   @Test
   public void testSimpleArray1()
   {
      /* What are those parameters?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(null, 
         SimpleArray.squareAll(new int[] {1, 2, 3}), new int[] {1, 4, 9});
   }

   @Test
   public void testSimpleArray2()
   {
      assertArrayEquals(null, 
         SimpleArray.squareAll(new int[] {7, 5}), new int[] {49, 25});
   }

   @Test
   public void testSimpleArray3()
   {
      assertArrayEquals(null,
              SimpleArray.squareAll(new int[] {4,5,6}), new int[] {16, 25, 36});
   }

   @Test
   public void testSimpleList1()
   {
      List<Integer> input =
         new LinkedList<Integer>(Arrays.asList(new Integer[] {1, 2, 3}));
      List<Integer> expected =
         new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 4, 9}));

      assertEquals(expected, SimpleList.squareAll(input));

   }

   @Test
   public void testSimpleList2()
   {
      List<Integer> input =
              new LinkedList<Integer>(Arrays.asList(new Integer[] {6, 5, 4}));
      List<Integer> expected =
              new ArrayList<Integer>(Arrays.asList(new Integer[] {36, 25, 16}));

      assertEquals(expected, SimpleList.squareAll(input));
   }

   @Test
   public void testBetterLoop1()
   {
      assertTrue(BetterLoop.contains(new int[] {7, 5}, 5));
   }

   @Test
   public void testBetterLoop2()
   {
      assertTrue(BetterLoop.contains(new int[] {7, 5, 2, 4}, 4));
   }

   @Test
   public void testBetterLoop3() { assertTrue(BetterLoop.contains(new int[] {1, 2, 3, 4, 5, 6}, 1));}
}
