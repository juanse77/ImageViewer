package imageviewer;

import java.io.File;
import model.Image;
import persistence.FileImageLoader;

public class Main {
        public static void main(String[] args) {
        
        File folder = new File("Fotos");
        FileImageLoader listImages = new FileImageLoader(folder);
        
        Image image = listImages.load();
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
        
    }
}
