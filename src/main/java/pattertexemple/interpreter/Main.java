package pattertexemple.interpreter;

public class Main {
    private Context contexts;

    public Main(Context contexts) {
        this.contexts = contexts;
    }

    public static void main(String[] args) {
        String binary = "256 in Binary: ";
        String octal = "256 in Octal: ";
        String hexadecimal = "256 in Hexadecimal: ";

        Main main = new Main(new Context());

        System.out.println(binary + main.interpret(binary));
        System.out.println(octal + main.interpret(octal));
        System.out.println(hexadecimal + main.interpret(hexadecimal));
    }

    private String interpret(String text){
        Expression expressions;
        if (text.contains("Binary")){
            expressions = new BinaryExpression(Integer.parseInt(text.substring(0, text.indexOf(" "))));
        }else if(text.contains("Octal")){
            expressions = new OctalExpression(Integer.parseInt(text.substring(0, text.indexOf(" "))));
        }else if(text.contains("Hexadecimal")){
            expressions = new HexadecimalExpression(Integer.parseInt(text.substring(0, text.indexOf(" "))));
        }else{
            return text;
        }
        return expressions.interpret(contexts);
    }
}
