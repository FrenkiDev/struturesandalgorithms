package pattertexemple.abstractfactory;

import pattertexemple.abstractfactory.adidas.AdidasProduct;
import pattertexemple.abstractfactory.nike.NikeProduct;

public abstract class AbstractFactory {

    public abstract AdidasProduct getAdidasProduct(String product);
    public abstract NikeProduct getNikeProduct(String product);
}
