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
    private Window window;
    public void setCells(Cell[] cells)
    {
        this.cells = cells;
    }

    public void setWindow(Window window)
    {
        this.window = window;
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

        button.setIcon(cell.getImage(window.getWidth(), window.getHeight()));

        if (checkPlayerWin()) {
            window.playerWins(turn == Player.ONE ? Player.TWO : Player.ONE);
        }
    }

    private boolean checkPlayerWin()
    {
        // Check horizontal Win.
        if (cells[0].getType() == cells[1].getType() && cells[1].getType() == cells[2].getType() && cells[0].getType() != Cell.Type.NONE) {
            return true;
        }
        if (cells[3].getType() == cells[4].getType() && cells[4].getType() == cells[5].getType() && cells[3].getType() != Cell.Type.NONE) {
            return true;
        }

        if (cells[6].getType() == cells[7].getType() && cells[7].getType() == cells[8].getType() && cells[6].getType() != Cell.Type.NONE) {
            return true;
        }

        // Check vertical Win.
        if (cells[0].getType() == cells[3].getType() && cells[3].getType() == cells[6].getType() && cells[0].getType() != Cell.Type.NONE) {
            return true;
        }
        if (cells[1].getType() == cells[4].getType() && cells[4].getType() == cells[7].getType() && cells[1].getType() != Cell.Type.NONE) {
            return true;
        }

        if (cells[2].getType() == cells[5].getType() && cells[5].getType() == cells[8].getType() && cells[2].getType() != Cell.Type.NONE) {
            return true;
        }

        // Check diagonal Win.
        if (cells[0].getType() == cells[4].getType() && cells[4].getType() == cells[8].getType() && cells[0].getType() != Cell.Type.NONE) {
            return true;
        }

        if (cells[2].getType() == cells[4].getType() && cells[4].getType() == cells[6].getType() && cells[2].getType() != Cell.Type.NONE) {
            return true;
        }

        return false;
    }
}
