package stackquea;

import util.InputStringConsole;

import java.io.IOException;

/**
 * Created by FrenkPO on 15.10.2017.
 */
public class BracketsApp {
    public static void main(String[] args) throws IOException {
        String inputstring;

        while (true) {
            System.out.println("Enter string conteining delimiter : ");
            System.out.flush();
            inputstring = InputStringConsole.getString();
            if ("".equals(inputstring)) {
                break;
            }

            BracketChecker stackX = new BracketChecker(inputstring);
            stackX.check();
        }
    }
}
