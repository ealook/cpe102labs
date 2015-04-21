public class BetterLoop
{
   public static boolean contains(int [] values, int v)
   {
      /* TO DO: if value v is in the array, return true.
         If not, return false.  Use a "foreach" loop.
      */

      boolean retval = false;

      for (int value : values) {
         if (value == v) {
            retval = true;
         }
      }

      return retval;
   }
}
