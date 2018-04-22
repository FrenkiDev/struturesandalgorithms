package pattertexemple.abstractfactory.factory;

import pattertexemple.abstractfactory.AbstractFactory;
import pattertexemple.abstractfactory.adidas.AdidasOutewear;
import pattertexemple.abstractfactory.adidas.AdidasProduct;
import pattertexemple.abstractfactory.adidas.AdidasShoes;
import pattertexemple.abstractfactory.nike.NikeProduct;

public class AdidasFactory extends AbstractFactory {
    @Override
    public AdidasProduct getAdidasProduct(String product) {
        if (product == null) return null;
        if (product.equalsIgnoreCase("ADIDAS OUTEWEAR")) return new AdidasOutewear();
        if (product.equalsIgnoreCase("ADIDAS SHOES")) return new AdidasShoes();
        return null;
    }

    @Override
    public NikeProduct getNikeProduct(String product) {
        return null;
    }
}
