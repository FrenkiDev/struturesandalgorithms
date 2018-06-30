package pattertexemple.interpreter;

public class Context {

    public String getBinaryExpression(int number){
        return Integer.toBinaryString(number);
    }

    public String getOctalExpression(int number){
        return Integer.toOctalString(number);
    }

    public String getHexadecimalExpression(int number){
        return Integer.toHexString(number);
    }
}
