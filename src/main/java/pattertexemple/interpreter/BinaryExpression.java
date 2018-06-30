package pattertexemple.interpreter;

public class BinaryExpression implements Expression {
    private int number;

    public BinaryExpression(int number) {
        this.number = number;
    }

    @Override
    public String interpret(Context contexts) {
        return contexts.getBinaryExpression(number);
    }
}
