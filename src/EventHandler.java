import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener
{
    private Cell[] cells;

    public void setCells(Cell[] cells)
    {
        this.cells = cells;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JButton button = (JButton) actionEvent.getSource();
        Cell cell = cells[Integer.parseInt(button.getName())];

        cell.setType(Cell.Type.CROSS);

        button.setIcon(cell.getImage(500, 500));
    }
}
