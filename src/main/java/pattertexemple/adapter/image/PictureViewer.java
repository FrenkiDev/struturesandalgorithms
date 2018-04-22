package pattertexemple.adapter.image;

import pattertexemple.adapter.ImageAdapter;

public class PictureViewer implements ImageViewer {
    @Override
    public void watchImage(String title, String formate) {
        switch(formate){
            case (".png"): {
                System.out.println("Watching " + title + ".png");
            }break;
            case (".jpeg"): {
                System.out.println("Watching " + title + ".jpeg");
            }break;
            case (".bmp"): {
                System.out.println("Watching " + title + ".bmp");
            }break;
            case (".gif"): {
                ImageAdapter imageAdapter = new ImageAdapter(formate);
                imageAdapter.watchImage(title, formate);
            }break;
            default:{
                System.out.println("Format " + formate + " not supported");
            }
        }
    }
}
