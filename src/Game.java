import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

    public class Game implements EventHandler
{
    private GridWindow grid;
    private MessageWindow message;
    private Cell[] cells;

    private boolean paused = true;

    private static int CELLS_SIZE = 9;

    Game()
    {
        cells = new Cell[CELLS_SIZE];
        for (int i = 0; i < CELLS_SIZE; i++) {
            cells[i] = new Cell();
        }

        message = new MessageWindow();
        message.setEventHandler(this);

        grid = new GridWindow(500, 500, 3, cells);
        grid.setEventHandler(this);
    }

    void restart()
    {
        message.setVisible(false);
        paused = false;
        for (int i =0; i < CELLS_SIZE; i++) {
            cells[i].setType(Cell.Type.NONE);
            Icon icon = cells[i].getImage(grid.getWidth(), grid.getHeight());
            grid.setCellIcon(i, icon);
        }
        begin();
    }

    void begin()
    {
        paused = false;
        grid.setVisible(true);
    }

    @Override
    public void handleClickCell(int cell_id)
    {
        if (paused) {
            message.setVisible(true);
            return;
        }

        if (!playerTurn(cell_id)){
            return;
        }
        if (checkFinish()){
            message.setMessage("Player Win");
            message.setVisible(true);
            paused = true;
            return;
        }
        if (checkFull()){
            message.setMessage("Draw");
            message.setVisible(true);
            paused = true;
            return;
        }

        computerTurn();
        if (checkFinish()){
            message.setMessage("Computer Win");
            message.setVisible(true);
            paused = true;
            return;
        }
        if (checkFull()){
            message.setMessage("Draw");
            message.setVisible(true);
            paused = true;
        }
    }

    private boolean checkFull()
    {
        for (int i = 0; i < cells.length; i++) {
            if(cells[i].getType() == Cell.Type.NONE){
                return false;
            }
        }

        return true;
    }

    @Override
    public void handleClickButton(ButtonEventType type)
    {
        if(type == ButtonEventType.RESTART){
            this.restart();
        } else if(type == ButtonEventType.CLOSE){
            message.setVisible(false);
            message.close();
            grid.setVisible(false);
            grid.close();
        }
    }

    private void computerTurn()
    {
        ArrayList<Integer> empty_cells = new ArrayList<>();

        for (int i = 0; i < cells.length; i++) {
            if(cells[i].getType() == Cell.Type.NONE){
                empty_cells.add(i);
            }
        }

        Random rand = new Random();
        int n = rand.nextInt(empty_cells.size()-1);
        if(n < 0) return;

        int i = empty_cells.get(n);

        cells[i].setType(Cell.Type.NOUGHT);
        Icon icon = cells[i].getImage(grid.getWidth(), grid.getHeight());
        grid.setCellIcon(i, icon);
    }

    private boolean playerTurn(int player_choose)
    {
        Cell cell = cells[player_choose];
        if(cell.getType() != Cell.Type.NONE) {
            return false;
        }

        cell.setType(Cell.Type.CROSS);

        Icon icon = cell.getImage(grid.getWidth(), grid.getHeight());
        grid.setCellIcon(player_choose, icon);

        return true;
    }

    private boolean checkFinish()
    {
        Cell.Type[] cells_types = new Cell.Type[CELLS_SIZE];

        for(int i = 0; i < CELLS_SIZE; i++){
            cells_types[i] = cells[i].getType();
        }

        if (cells_types[0] != Cell.Type.NONE)
        {
            if (cells_types[0] == cells_types[1] && cells_types[1] == cells_types[2]) {
                return true;
            }

            if (cells_types[0] == cells_types[3] && cells_types[3] == cells_types[6]) {
                return true;
            }

            if (cells_types[0] == cells_types[4] && cells_types[4] == cells_types[8]) {
                return true;
            }
        }

        if(cells_types[2] != Cell.Type.NONE)
        {
            if (cells_types[2] == cells_types[5] && cells_types[5] == cells_types[8]) {
                return true;
            }

            if (cells_types[2] == cells_types[4] && cells_types[4] == cells_types[6]) {
                return true;
            }
        }

        if (cells_types[3] == cells_types[4] && cells_types[4] == cells_types[5] && cells_types[3] != Cell.Type.NONE) {
            return true;
        }

        if (cells_types[6] == cells_types[7] && cells_types[7] == cells_types[8] && cells_types[6] != Cell.Type.NONE) {
            return true;
        }

        if (cells_types[1] == cells_types[4] && cells_types[4] == cells_types[7] && cells_types[1] != Cell.Type.NONE) {
            return true;
        }

        return false;
    }
}
