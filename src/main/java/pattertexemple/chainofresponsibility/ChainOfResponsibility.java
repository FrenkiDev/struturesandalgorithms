package pattertexemple.chainofresponsibility;

public interface ChainOfResponsibility {
    void nextChain(ChainOfResponsibility locChain);
    void requestProcess(Number locNumber);
}
