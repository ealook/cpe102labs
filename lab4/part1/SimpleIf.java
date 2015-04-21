public class SimpleIf
{
   public static double max(double x, double y)
   {
      /* TO DO: Write an if statement to determine which
         argument is larger and return that value.
      */

      double retval = x;

      if (y > x) {
         retval = y;
      }

      return retval;
   }
}
