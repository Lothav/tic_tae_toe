import javax.swing.*;

enum ButtonEventType
{
    RESTART,
    CLOSE
}

public interface EventHandler
{
    void handleClickCell(int cell_id);
    void handleClickButton(ButtonEventType type);
}
