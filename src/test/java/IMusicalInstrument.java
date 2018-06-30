import java.util.Random;

public abstract class IMusicalInstrument {
    IMusicalInstrument(){
        System.out.println("Я могу реализовать свои методы и поля");
    }
    abstract void play();
    abstract void tune();
}

class Guitar extends IMusicalInstrument{
    @Override
    public void play() {
        System.out.println("Play Guitar");
    }

    @Override
    public void tune() {
        System.out.println("Tune Guitar");
    }
}

class Saxophone extends IMusicalInstrument{
    @Override
    public void play() {
        System.out.println("Play Saxophone");
    }

    @Override
    public void tune() {
        System.out.println("Tune Saxophone");
    }
}

class TestAbst{
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Random tmp = new Random(i);
            IMusicalInstrument musicalInstrument
                    = TestAbst.getInstrument(tmp.nextInt());
            TestAbst.orchestra(musicalInstrument);
        }

    }

    public static IMusicalInstrument getInstrument(int locCase){
        if(locCase % 2 == 0){
            return new Guitar();
        }
        return new Saxophone();
    }

    public static void orchestra(IMusicalInstrument locInstrument){
        locInstrument.tune();
        locInstrument.play();
    }
}