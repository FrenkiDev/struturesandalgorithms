package pattertexemple.chainofresponsibility;

public class PositivNumberHandler implements ChainOfResponsibility {
    private ChainOfResponsibility chains;

    @Override
    public void nextChain(ChainOfResponsibility locChain) {
        chains = locChain;
    }

    @Override
    public void requestProcess(Number locNumber) {
        if (locNumber.getNumbers() > 0){
            System.out.println("Positiv Number Handler " + locNumber.getNumbers());
        }else{
            chains.requestProcess(locNumber);
        }
    }
}
