package pattertexemple.abstractfactory.factory;

import pattertexemple.abstractfactory.AbstractFactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String factory){
        if(factory == null) return null;
        if(factory.equalsIgnoreCase("ADIDAS")) return new AdidasFactory();
        if(factory.equalsIgnoreCase("NIKE")) return new NikeFactory();
        return null;
    }
}
