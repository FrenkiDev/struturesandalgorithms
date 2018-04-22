package pattertexemple.chainofresponsibility;

public class NegativNumberHandler implements ChainOfResponsibility {
    private ChainOfResponsibility chains;

    @Override
    public void nextChain(ChainOfResponsibility locChain) {
        chains = locChain;
    }

    @Override
    public void requestProcess(Number locNumber) {
        if (locNumber.getNumbers() < 0){
            System.out.println("Negativ Number Handler " + locNumber.getNumbers());
        }else{
            chains.requestProcess(locNumber);
        }
    }
}
