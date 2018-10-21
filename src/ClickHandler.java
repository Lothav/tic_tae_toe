import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ClickHandler implements ActionListener
{
    private EventHandler callback;

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JButton button = (JButton) actionEvent.getSource();
        String name = button.getName();

        if(Arrays.asList(MessageWindow.BUTTONS_LABELS).contains(name)){
            ButtonEventType type = MessageWindow.getButtonEventByName(name);
            callback.handleClickButton(type);
        } else {
            int cell_id = Integer.parseInt(button.getName());
            callback.handleClickCell(cell_id);
        }
    }

    void setEventHandler(EventHandler eventHandler)
    {
        callback = eventHandler;
    }
}
