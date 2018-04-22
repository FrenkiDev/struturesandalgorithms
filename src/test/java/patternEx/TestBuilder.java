package patternEx;

import pattertexemple.builder.builderinnerclass.Account;
import pattertexemple.builder.builderpublicmethod.Choice;
import pattertexemple.builder.builderpublicmethod.Client;
import pattertexemple.builder.builderpublicmethod.Pizza;
import pattertexemple.builder.builderpublicmethod.Query;

public class TestBuilder {
    public static void main(String[] args) {
        testInnerClass();
        testPublicMethod();
    }

    private static void testPublicMethod() {
        Client clients = new Client();
        Choice choice = new Pizza();

        clients.setChoice(choice);
        clients.buildPizza();

        Query query = clients.acceptQuery();
    }

    private static void testInnerClass() {
        Account accounts = Account.initializeRegistration()
                .logint("admin")
                .password("Qwerty123")
                .email("xy@mail.ru")
                .createAccount();
    }
}
