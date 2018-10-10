import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame frame;
    private Cell[] cells;

    public Window()
    {
        frame = new JFrame();
        frame.setLayout(new GridLayout(3, 3));
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

        cells = new Cell[9];

        for (int i = 0; i < cells.length; i++) {
            JButton button = new JButton("Test");
            container.add(button);
        }
    }
}
