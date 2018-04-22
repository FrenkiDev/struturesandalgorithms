package pattertexemple.builder.builderpublicmethod;

public abstract class Choice {
    protected Query querys;

    public Query getQuerys() {
        return querys;
    }

    public void creatQuery(){
        querys = new Query();
    }

    public abstract void buildPizzaDough();
    public abstract void buildPizzaSauce();
    public abstract void buildPizzaIngredients();
}
