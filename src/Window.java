import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame frame;

    public Window()
    {
        frame = new JFrame();
        frame.setSize(500, 500);
        initButtons();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b)
    {
        frame.setVisible(b);
    }

    private void initButtons()
    {
        Container container = frame.getContentPane();

        JButton button = new JButton("Test");
        container.add(button);
    }
}
