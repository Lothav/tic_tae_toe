import javax.swing.*;

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

        return new ImageIcon (path);
    }

}
