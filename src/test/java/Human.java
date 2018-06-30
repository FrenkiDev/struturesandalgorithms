public class Human {
    AquaLang aquaLangs_1 = new AquaLang();//Композиция
    AquaLang aquaLangs_2;//Делегация

    public void breathe(){
        System.out.println("Human breathe air");
    }
}

class Amphibian extends Human{

    public void breatheUnderWater(){
        System.out.println("Amphibian breathe under water");
    }

}

class AquaLang{
    public void breatheUnderWater(){
        System.out.println("Human breathe under water using AquaLang");
    }
}