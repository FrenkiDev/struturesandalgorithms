package pattertexemple.interpreter;

public class OctalExpression implements Expression {
    private int number;

    public OctalExpression(int number) {
        this.number = number;
    }

    @Override
    public String interpret(Context contexts) {
        return contexts.getOctalExpression(number);
    }
}
