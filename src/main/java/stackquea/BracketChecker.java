package stackquea;

/**
 * Created by FrenkPO on 15.10.2017.
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String locInput){
        this.input = locInput;
    }
    public void check(){
        int maxSize = input.length();
        StackX stackX = new StackX(maxSize);

        for(int i = 0; i < maxSize; i++){

            char tmpSimvol = input.charAt(i);

            switch (tmpSimvol){
                case '{' :
                case '(' :
                case '[' :
                    {stackX.push(tmpSimvol); break;}

                case '}' :
                case ')' :
                case ']' :
                    {
                        if(!stackX.isEmpty()){
                            char outSimvol = stackX.pop();
                            if((tmpSimvol == '}' && outSimvol != '{') ||
                                    (tmpSimvol == ')' && outSimvol != '(') ||
                                        (tmpSimvol == ']' && outSimvol != '[')){
                                System.out.println("Error: " + tmpSimvol + " __ " + i);
                            }
                        }else{
                            System.out.println("Error:" + tmpSimvol + " __ " + i + " __limmited size");
                        }

                    }
                default : break;
            }
        }
        if( !stackX.isEmpty() )
            System.out.println("Error: missing right delimiter");
    }
}
