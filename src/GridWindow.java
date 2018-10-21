import javax.swing.*;
import java.awt.*;

class GridWindow extends Window
{
    private ClickHandler click_handler;
    private JButton[] buttons;

    GridWindow(int width, int height, int grid_size, Cell[] cells)
    {
        super(width, height);

        click_handler = new ClickHandler();
        buttons = new JButton[cells.length];
        frame.setLayout(new GridLayout(grid_size, grid_size));

        Container container = frame.getContentPane();
        for (int i = 0; i < cells.length; i++) {
            buttons[i] = new JButton(cells[i].getImage(width, height));
            // Set button id as name.
            buttons[i].setName(Integer.toString(i));
            buttons[i].addActionListener(click_handler);
            // Add button to container.
            container.add(buttons[i]);
        }
    }

    void setEventHandler(EventHandler event_handler)
    {
        click_handler.setEventHandler(event_handler);
    }

    void setCellIcon(int cell_id, Icon icon)
    {
        buttons[cell_id].setIcon(icon);
    }
}
