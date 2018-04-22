package pattertexemple.adapter.animation;

public class GifViewer implements AnimatedImageViewer {
    @Override
    public void watchGif(String title) {
        System.out.println("Watching " + title + ".gif");
    }
}
