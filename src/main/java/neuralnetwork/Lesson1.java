package neuralnetwork;

import com.googlecode.fannj.*;
import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "D:\\java_Project\\struturesandalgorithms\\");
        System.out.println( System.getProperty("jna.library.path") ); //maybe the path is malformed
        File file = new File(System.getProperty("jna.library.path") + "fannfloat.dll");
        System.out.println("Is the dll file there:" + file.exists());
        System.load(file.getAbsolutePath());

        //System.setProperty("jna.library.path", [fannfloat.dll dir path]);
        //System.setProperty("jna.library.path", "D:\\java_Project\\struturesandalgorithms\\nullfannfloat.dll");

        List<Layer> layers = new ArrayList<>();

        layers.add(Layer.create(3, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layers.add(Layer.create(16, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));
        layers.add(Layer.create(4, ActivationFunction.FANN_SIGMOID_SYMMETRIC, 0.01f));

        Fann fanns = new Fann(layers);

        Trainer trainer = new Trainer(fanns);

        trainer.setTrainingAlgorithm(TrainingAlgorithm.FANN_TRAIN_RPROP);

        /** Проведем обучение взяв уроки из файла, с максимальным колличеством
         циклов 100000, показывая отчет каждую 100ю итерацию и добиваемся
         ошибки меньше 0.0001 **/
        trainer.train(new File("source\\train.data").getAbsolutePath(), 100000, 100, 0.0001f);
    }
}

class Tester {
    public interface Kernel32 extends Library {
        boolean Beep(int frequency, int duration);
    }
    private static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
    private static void toMorseCode(String letter) throws Exception {
        for (byte b : letter.getBytes()) {
            kernel32.Beep(1200, ((b == '.') ? 50 : 150));
            Thread.sleep(50);
        }
    }
    public static void main(String[] args) throws Exception {
        String helloWorld[][] = {
                {"....", ".", ".-..", ".-..", "---"}, // HELLO
                {".--", "---", ".-.", ".-..", "-.."}  // WORLD
        };
        for (String word[] : helloWorld) {
            for (String letter : word) {
                toMorseCode(letter);
                Thread.sleep(150);
            }
            Thread.sleep(350);
        }
    }
}