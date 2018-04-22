package stackquea;

import util.InputStringConsole;

import java.io.IOException;

/**
 * Created by FrenkPO on 09.11.2017.
 */
public class PostfixApp {
    public static void main(String[] args) throws IOException {
        int output;
        String input;
        while (true) {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = InputStringConsole.getString();         // Ввод строки с клавиатуры
            if (input.equals(""))       // Завершение, если нажата клавиша
                break;                    // [Enter]
            // Создание объекта для разбора выражения
            ParsePost aParser = new ParsePost(input);
            output = aParser.doParse();  // Обработка выражения
            System.out.println("Evaluates to " + output);
        }
    }
}

class StackPost {
    private int sizeStack;
    private int[] stack;
    private int top;

    public StackPost(int sizeStack) {
        this.sizeStack = sizeStack;
        this.stack = new int[this.sizeStack];
        this.top = -1;
    }

    public int pop() {
        return stack[top--];
    }

    public void push(int locValue) {
        stack[++top] = locValue;
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == sizeStack + 1);
    }

    public int peekN(int locIndex) {
        return stack[locIndex];
    }

    public int size() {
        return top + 1;
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

class ParsePost {
    private StackPost postStack;
    private String input;

    public ParsePost(String input) {
        this.input = input;
    }

    public int doParse() {
        char tmpCh;
        int operand1, operand2, interAns;
        postStack = new StackPost(input.length());
        for (int i = 0; i < input.length(); i++) {
            tmpCh = input.charAt(i);
            postStack.displayStack("" + tmpCh + " ");  // *диагностика*

            if (tmpCh >= '0' && tmpCh <= '9') {
                postStack.push((int) (tmpCh - '0'));
            } else {
                operand2 = postStack.pop();
                operand1 = postStack.pop();

                switch (tmpCh) {
                    case '+':
                        interAns = operand1 + operand2;
                        break;
                    case '-':
                        interAns = operand1 - operand2;
                        break;
                    case '*':
                        interAns = operand1 * operand2;
                        break;
                    case '/':
                        interAns = operand1 / operand2;
                        break;
                    default:
                        interAns = 0;
                }
                postStack.push(interAns);
            }
        }

        return postStack.pop();
    }
}
