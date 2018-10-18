import javax.swing.*;
import java.awt.*;

class MessageWindow extends Window
{
    private JLabel label;

    MessageWindow()
    {
        super(300, 100);

        Container container = frame.getContentPane();
        label = new JLabel("");

        container.add(label);
    }

    void setMessage(String message)
    {
        label.setText(message);
    }
}
