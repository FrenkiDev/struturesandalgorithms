package pattertexemple.adapter;

import pattertexemple.adapter.animation.AnimatedImageViewer;
import pattertexemple.adapter.animation.GifViewer;
import pattertexemple.adapter.image.ImageViewer;

public class ImageAdapter implements ImageViewer{
    private AnimatedImageViewer animatedImageViewer;

    public ImageAdapter(String formate) {
        if(formate.equalsIgnoreCase(".GIF")){
            animatedImageViewer = new GifViewer();
        }
    }

    @Override
    public void watchImage(String title, String formate) {
        if(formate.equalsIgnoreCase(".GIF")){
            animatedImageViewer.watchGif(title);
        }
    }
}
