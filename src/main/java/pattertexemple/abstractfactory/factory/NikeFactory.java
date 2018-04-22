package pattertexemple.abstractfactory.factory;

import pattertexemple.abstractfactory.AbstractFactory;
import pattertexemple.abstractfactory.adidas.AdidasProduct;
import pattertexemple.abstractfactory.nike.NikeOutewear;
import pattertexemple.abstractfactory.nike.NikeProduct;
import pattertexemple.abstractfactory.nike.NikeShoes;

public class NikeFactory extends AbstractFactory {
    @Override
    public AdidasProduct getAdidasProduct(String product) {
        return null;
    }

    @Override
    public NikeProduct getNikeProduct(String product) {
        if (product == null) return null;
        if (product.equalsIgnoreCase("NIKE OUTEWEAR")) return new NikeOutewear();
        if (product.equalsIgnoreCase("NIKE SHOES")) return new NikeShoes();
        return null;
    }
}
