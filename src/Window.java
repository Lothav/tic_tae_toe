import javax.swing.*;
import java.awt.*;

public class Window
{
    private int width;
    private int height;

    private JFrame frame;
    private Cell[] cells;
    private EventHandler event_handler;

    public Window(int width, int height)
    {
        this.width = width;
        this.height = height;

        event_handler = new EventHandler();

        frame = new JFrame();
        frame.setLayout(new GridLayout(3, 3));
        frame.setSize(this.width, this.height);
        initButtons();

        event_handler.setCells(cells);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        event_handler.setWindow(this);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void playerWins(EventHandler.Player player)
    {
        System.out.println("asdsaf");
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
            cells[i] = new Cell();

            JButton button = new JButton(cells[i].getImage(width, height));
            button.setName(Integer.toString(i));
            button.addActionListener(event_handler);

            container.add(button);
        }
    }
}
