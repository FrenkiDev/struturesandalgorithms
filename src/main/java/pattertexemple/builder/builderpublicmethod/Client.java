package pattertexemple.builder.builderpublicmethod;

public class Client {
    private Choice choice;

    public void setChoice(Choice locChoice){
        this.choice = locChoice;
    }

    public Query acceptQuery(){
        System.out.println("Orders is accepted");
        return choice.getQuerys();
    }

    public void buildPizza(){
        choice.creatQuery();
        choice.buildPizzaDough();
        choice.buildPizzaSauce();
        choice.buildPizzaIngredients();
    }
}
