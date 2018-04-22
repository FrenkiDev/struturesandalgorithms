package patternEx;

import pattertexemple.adapter.image.PictureViewer;

public class TestAdapter {
    public static void main(String[] args) {
        PictureViewer pictureViewer = new PictureViewer();
        pictureViewer.watchImage("sque", ".jpeg");
        pictureViewer.watchImage("siercle", ".bmp");
        pictureViewer.watchImage("reqtangle", ".gif");
        pictureViewer.watchImage("sque", ".jpdfeg");
    }
}
