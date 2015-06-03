public class DivideExpression
<<<<<<< HEAD
   extends BinaryExpression
{
   public DivideExpression(Expression lft, Expression rht)
   {
      super(lft, rht, "/");
   }

   protected double _applyOperator(double lft, double rht) {
      return lft / rht;
=======
   implements Expression
{
   private Expression lft;
   private Expression rht;

   public DivideExpression(Expression lft, Expression rht)
   {
      this.lft = lft;
      this.rht = rht;
   }

   public String toString()
   {
      return "(" + lft + " / " + rht + ")";
   }

   public double evaluate(Bindings bindings)
   {
      return lft.evaluate(bindings) / rht.evaluate(bindings);
>>>>>>> 50cea9d62b4502074fa64aaa20429ba0af3a8fd8
   }
}

