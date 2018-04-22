package pattertexemple.builder.builderpublicmethod;

public class Pizza extends Choice {
    @Override
    public void buildPizzaDough() {
        querys.setPizzaDough("XL, thin");
    }

    @Override
    public void buildPizzaSauce() {
        querys.setPizzaSauce("Barbecue");
    }

    @Override
    public void buildPizzaIngredients() {
        querys.setPizzaIngreients("Sausages, onions, mashroom, parmesan");
    }
}
