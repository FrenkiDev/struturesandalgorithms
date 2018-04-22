package stackquea;

import util.InputStringConsole;

import java.io.IOException;

/**
 * Created by FrenkPO on 09.11.2017.
 */
public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while(true){
            System.out.print("Enter infix: ");
            System.out.flush();
            input = InputStringConsole.getString();
            if( input.equals("") )       // Выход, если нажата клавиша [Enter]
                break;
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // Преобразование
            System.out.println("Postfix is " + output + '\n');
        }
    }
}


class StacksX {
    private int maxSize;
    private char[] stack;
    private int top;

    public StacksX(int maxSize) {
        this.maxSize = maxSize;
        stack = new char[this.maxSize];
        top = -1;
    }

    public void push(char locValue) {
        stack[++top] = locValue;
    }

    public char pop() {
        return stack[top--];
    }

    public char peek() {
        return stack[top];
    }

    public boolean isEmpt() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public char peekN(int locTop) {
        return stack[locTop];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}

class InToPost {
    private StacksX stacksX;
    private String input;
    private String postfiX = "";

    public InToPost(String input) {
        this.input = input;
        stacksX = new StacksX(this.input.length());
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char tmpCh = input.charAt(i);

            stacksX.displayStack("For " + tmpCh + " ");

            switch (tmpCh) {
                case '+':
                case '-':
                    gotOper(tmpCh, 1); break;
                case '*':
                case '/':
                    gotOper(tmpCh, 2); break;
                case ')':
                    gotParen(tmpCh); break;
                case '(':
                    stacksX.push(tmpCh); break;
                default:
                    postfiX = postfiX + tmpCh; break;
            }
        }

        while(!stacksX.isEmpt()){
            stacksX.displayStack("While ");  // *диагностика*
            postfiX = postfiX + stacksX.pop();
            stacksX.displayStack("End   ");     // *диагностика*
        }
        return postfiX;
    }

    public void gotOper(char opThis, int prec1) {
        while (!stacksX.isEmpt()) {
            char opTop = stacksX.pop();

            if (opTop == '(') {
                stacksX.push(opTop);
                break;
            } else {
                short prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stacksX.push(opTop);
                    break;
                } else {
                    postfiX = postfiX + opTop;
                }
            }
        }
        stacksX.push(opThis);
    }

    public void gotParen(char ch) {
        while (!stacksX.isEmpt()) {
            char tmpCh = stacksX.pop();
            if (tmpCh == '(') {
                break;
            } else {
                postfiX = postfiX + tmpCh;
            }
        }
    }
}