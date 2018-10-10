import javax.swing.*;
import java.awt.*;

public class Cell
{
    public enum Type
    {
        NONE,
        NOUGHT,
        CROSS
    }

    private Type type = Type.NONE;

    public Cell()
    {

    }

    public ImageIcon getImage()
    {
        String path;

        switch (type) {

            case CROSS:
                path = "assets/cross.png";
                break;

            case NOUGHT:
                path = "assets/cross.png";
                break;

            default:
                path = "assets/empty.png";
        }

        ImageIcon img = new ImageIcon(path);
        Image scale_image = img.getImage().getScaledInstance(500/3, 500/3, Image.SCALE_SMOOTH);

        return new ImageIcon(scale_image);
    }

}
