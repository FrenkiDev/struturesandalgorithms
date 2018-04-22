package pattertexemple.builder.builderinnerclass;

public class Account {
    private String login;
    private String password;
    private String email;

    public static Registrar initializeRegistration(){
        return new Account().new Registrar();
    }

    public class Registrar{
        public Registrar logint(String locLogin){
            System.out.println("Login: " + locLogin);
            Account.this.login = locLogin;
            return this;
        };
        public Registrar password(String locPassword){
            System.out.println("Password: " + locPassword);
            Account.this.password = locPassword;
            return this;
        };
        public Registrar email(String locEmail){
            System.out.println("Email: " + locEmail);
            Account.this.email = locEmail;
            return this;
        };
        public Account createAccount(){
            return Account.this;
        }
    }
}
