import javax.swing.*;
import java.awt.*;

class MessageWindow extends Window
{
    private JLabel label;
    private ClickGridWindowHandler click_handler;
    private JButton[] buttons;

    MessageWindow()
    {
        super(300, 100);

        click_handler = new ClickGridWindowHandler();
        label = new JLabel("", SwingConstants.CENTER);

        Container container = frame.getContentPane();
        container.add(label);

        frame.setLayout(new GridLayout(3, 1));

        String[] button_labels = {"Restart", "Close Game"};

        buttons = new JButton[2];
        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton(button_labels[i]);
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

    void setMessage(String message)
    {
        label.setText(message);
    }
}
