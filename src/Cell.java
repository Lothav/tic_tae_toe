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

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public ImageIcon getImage(int width, int height)
    {
        String path;

        switch (type) {

            case CROSS:
                path = "assets/cross.png";
                break;

            case NOUGHT:
                path = "assets/nought.png";
                break;

            default:
                path = "assets/empty.png";
        }

        ImageIcon img = new ImageIcon(path);
        Image scale_image = img.getImage().getScaledInstance(width/3, height/3, Image.SCALE_SMOOTH);

        return new ImageIcon(scale_image);
    }
}
