package persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import model.Image;

public final class FileImageLoader implements ImageLoader {

    private File[] fotos;

    public FileImageLoader(File dir) {
        fotos = dir.listFiles(imageType());
    }

    public FileFilter imageType() {
        return new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(".jpg");
            }

        };
    }

    public Image imageAt(final int i) {
        return new Image() {
            @Override
            public String name() {
                return fotos[i].getName();
            }

            @Override
            public InputStream stream() throws FileNotFoundException {
                return new BufferedInputStream(new FileInputStream(fotos[i]));
            }

            @Override
            public Image next() {
                if(i == fotos.length){
                    return imageAt(0);
                }else{
                    return imageAt(i + 1);
                }
            }

            @Override
            public Image prev() {
                if(i == 0){
                    return imageAt(fotos.length - 1);
                }else{
                    return imageAt(i - 1);
                }
            }
        };
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }

}
