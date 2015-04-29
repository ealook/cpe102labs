
public abstract class BinaryExpression implements Expression {

    private Expression lft;
    private Expression rht;
    private String operator;

    public BinaryExpression(Expression lft, Expression rht, String operator) {
        this.lft = lft;
        this.rht = rht;
        this.operator = operator;
    }

    public String toString() { return "(" + lft + " " + operator + " " + rht + ")"; }

    public double evaluate(Bindings bindings)
    {
        return _applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
    }

    protected abstract double _applyOperator(double lft, double rht);
}
