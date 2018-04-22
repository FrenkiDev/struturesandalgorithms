package patternEx;

import pattertexemple.chainofresponsibility.ChainOfResponsibility;
import pattertexemple.chainofresponsibility.NegativNumberHandler;
import pattertexemple.chainofresponsibility.PositivNumberHandler;
import pattertexemple.chainofresponsibility.ZeroNumberHandler;
import pattertexemple.chainofresponsibility.Number;

public class TestChainOfResponibility {
    public static void main(String[] args) {
        ChainOfResponsibility first = new ZeroNumberHandler();
        ChainOfResponsibility second = new PositivNumberHandler();
        ChainOfResponsibility three = new NegativNumberHandler();

        first.nextChain(second);
        second.nextChain(three);

        first.requestProcess(new Number(-1));
        first.requestProcess(new Number(1));
        first.requestProcess(new Number(0));
    }
}
