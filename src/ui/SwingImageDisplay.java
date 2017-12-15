package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image currentImage;

    private BufferedImage imageOf(Image imagen) throws FileNotFoundException, IOException {
        return ImageIO.read(imagen.stream());
    }

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image imagen) {
        this.currentImage = imagen;
        this.repaint();
    }

    @Override
    public void paint(Graphics g){
        if (currentImage == null) {
            return;
        }
        try {
            g.drawImage(imageOf(currentImage), 0, 0, null);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
