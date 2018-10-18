import javax.swing.*;

public class Game implements EventHandler
{
    private GridWindow grid;
    private Cell[] cells;

    static int CELLS_SIZE = 9;

    Game()
    {
        cells = new Cell[CELLS_SIZE];
        for (int i =0; i < CELLS_SIZE; i++) {
            cells[i] = new Cell();
        }
        grid  = new GridWindow(500, 500, 3, cells);
        grid.setEventHandler(this);
    }

    void restart()
    {
        for (int i =0; i < CELLS_SIZE; i++) {
            cells[i].setType(Cell.Type.NONE);
        }
        begin();
    }

    void begin()
    {
        grid.setVisible(true);
    }

    private boolean check()
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

    @Override
    public void handleClickCell(int cell_id)
    {
        playerTurn(cell_id);
        if (check()){
            System.out.println("Player Win");
        }

        computerTurn();
        if (check()){
            System.out.println("Computer Win");
        }
    }

    private void computerTurn()
    {
        for (int i = 0; i < cells.length; i++) {
            if(cells[i].getType() != Cell.Type.NONE){
                cells[i].setType(Cell.Type.NOUGHT);
                Icon icon = cells[i].getImage(grid.getWidth(), grid.getHeight());
                grid.setCellIcon(i, icon);
                return;
            }
        }
    }

    private void playerTurn(int player_choose)
    {
        Cell cell = cells[player_choose];
        if(cell.getType() != Cell.Type.NONE) {
            return;
        }

        cell.setType(Cell.Type.CROSS);

        Icon icon = cell.getImage(grid.getWidth(), grid.getHeight());
        grid.setCellIcon(player_choose, icon);
    }

}
