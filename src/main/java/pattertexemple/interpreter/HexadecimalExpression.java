package pattertexemple.interpreter;

public class HexadecimalExpression implements Expression {
    private int number;

    public HexadecimalExpression(int number) {
        this.number = number;
    }

    @Override
    public String interpret(Context contexts) {
        return contexts.getHexadecimalExpression(number);
    }
}
