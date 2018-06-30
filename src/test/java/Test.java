public class Test {
    public static void main(String[] args) {
        Human vasya = new Human();
        vasya.aquaLangs_1.breatheUnderWater();//Используем Композицию
        AquaLang aquaLangs = new AquaLang();//Создаем обьект AquaLang
        vasya.aquaLangs_2 =  aquaLangs;//помещаем объект aquaLangs в обьект vasya
        vasya.aquaLangs_2.breatheUnderWater();//Используем Делегацию
    }
}