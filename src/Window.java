import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame frame;

    public Window()
    {
        frame = new JFrame();
        Container container = frame.getContentPane();
        JLabel label = new JLabel ("Hello World");
        container.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b)
    {
        frame.setVisible(b);
    }
}
