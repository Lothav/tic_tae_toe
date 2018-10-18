import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickGridWindowHandler implements ActionListener
{
    private EventHandler callback;

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JButton button = (JButton) actionEvent.getSource();
        int cell_id = Integer.parseInt(button.getName());

        callback.handleClickCell(cell_id);
    }

    void setEventHandler(EventHandler eventHandler)
    {
        callback = eventHandler;
    }
}
