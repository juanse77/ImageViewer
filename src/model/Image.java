package model;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface Image {
    public String name();
    public InputStream stream() throws FileNotFoundException;
    public Image next();
    public Image prev();
}
