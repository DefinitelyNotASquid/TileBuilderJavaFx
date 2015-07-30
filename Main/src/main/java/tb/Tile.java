package tb;
import  javafx.scene.image.Image;
/**
 * Created by Someonepic on 07/30/2015.
 */
public class Tile {

    private int imageWidth = 0;
    private int imageHeight = 0;
    int zoomWidth, zoomHeight;

    String name = null;
    int number = -1;
    String type = null;
    String path = null;
    String info = null;

    Image image = null;

    public Tile(int number, String path, String name, String type)
    {
        this.type = type;
        this.number = number;
        this.name = name;
        this.path = path;
        //System.out.println("load image" + path);
        //this.image = new Image(path).getImage();

        if(image == null) {
            throw new RuntimeException("Could not load image" + path);
        }

        imageWidth = (int)image.getWidth();
        imageHeight = (int)image.getHeight();
        zoomWidth = imageWidth;
        zoomHeight = imageHeight;

        //System.out.println(imageWidth);
    }

    public Tile(int number, String path, String name, String type, String info)
    {
        this(number, path, name, type);
        if(info.indexOf(',') >= 0) {
            throw new RuntimeException("Info string cannot contain \",\" characters");
        }
        this.info = info;
    }
    public Tile(Tile t)
    {
        System.err.println("WARNING: Creating shallow copy of tile");

        this.number = t.number;
        this.type = t.type;
        this.name = t.name;
        this.path = t.path;
        this.image = t.image;
    }

    String getImageLocation() {
        return path;
    }

    public boolean equals(Tile t) {
        if(t == null) return false;
        if(this.number == t.number/* &&
       this.name.equals(t.name) &&
       this.type == t.type &&
       this.image == t.image*/) {
            return true;
        } else {
            return false;
        }
    }

    static boolean areEqual(Tile t1, Tile t2) {
        if(t1 == null && t2 == null) {
            return true;
        } else if (t1 != null) {
            return t1.equals(t2);
        } else {
            return false;
        }
    }

    public Tile()
    {
        image = null;
    }

    public Image getImage()
    {
        return image;
    }
    public String getType()
    {
        return type;
    }
    public int getNumber()
    {
        return number;
    }
    public String getName()
    {
        return name;
    }

    public String getInfo() {
        return info;
    }
    public String getPath() {
        return path;
    }




}
