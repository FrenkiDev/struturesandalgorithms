package patternEx;

import pattertexemple.abstractfactory.adidas.AdidasProduct;
import pattertexemple.abstractfactory.AbstractFactory;
import pattertexemple.abstractfactory.factory.FactoryGenerator;
import pattertexemple.abstractfactory.nike.NikeProduct;

public class TestFactory {
    public static void main(String[] args) {
        AbstractFactory adidasFactory = FactoryGenerator.getFactory("ADIDAS");
        AdidasProduct adidasProduct = adidasFactory.getAdidasProduct("adidas shoes");
        adidasProduct.makeAdidasProduct();

        AbstractFactory nikeFactory = FactoryGenerator.getFactory("NIKE");
        NikeProduct nikeProduct = nikeFactory.getNikeProduct("Nike outewear");
        nikeProduct.makeNikeProduct();
    }
}
