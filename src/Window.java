import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame frame;

    public Window()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b)
    {
        frame.setVisible(b);
    }
}
