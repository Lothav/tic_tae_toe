import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener
{
    public enum Player{
        ONE,
        TWO
    }

    private Cell[] cells;
    private Player turn = Player.ONE;

    public void setCells(Cell[] cells)
    {
        this.cells = cells;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JButton button = (JButton) actionEvent.getSource();
        Cell cell = cells[Integer.parseInt(button.getName())];

        if(cell.getType() != Cell.Type.NONE) {
            return;
        }

        if(turn == Player.ONE) {
            cell.setType(Cell.Type.CROSS);
            turn = Player.TWO;
        } else {
            cell.setType(Cell.Type.NOUGHT);
            turn = Player.ONE;
        }

        button.setIcon(cell.getImage(500, 500));
    }
}
