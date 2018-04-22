package stackquea;

/**
 * Created by FrenkPO on 15.10.2017.
 */
class StackApp {
    static StackX theStack = new StackX(10);

    public static void main(String[] args) {

    }
}
 public  class StackX {
        private char[] stack;//Массив стека
        private int maxSize;//размер массива стека
        private int top;//Вершина массива

        public StackX(int locSize) {
            this.maxSize = locSize;
            this.stack = new char[maxSize];
            top = -1;
        }

        public void push(char locElems) {
            stack[++top] = locElems;
        }

        public char pop() {
            return stack[top--];
        }

        public char peek() {
            return stack[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public boolean isFull() {
            return (top == maxSize - 1);
        }
    }
