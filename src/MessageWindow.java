import javax.swing.*;
import java.awt.*;

class MessageWindow extends Window
{
    private JLabel label;
    private ClickHandler click_handler;
    private JButton[] buttons;

    static String[] BUTTONS_LABELS = {"Restart", "Close Game"};

    MessageWindow()
    {
        super(300, 100);

        click_handler = new ClickHandler();
        label = new JLabel("", SwingConstants.CENTER);

        Container container = frame.getContentPane();
        container.add(label);

        frame.setLayout(new GridLayout(3, 1));


        buttons = new JButton[2];
        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton(BUTTONS_LABELS[i]);
            // Set button id as name.
            buttons[i].setName(BUTTONS_LABELS[i]);
            buttons[i].addActionListener(click_handler);
            // Add button to container.
            container.add(buttons[i]);
        }
    }

    static ButtonEventType getButtonEventByName(String name)
    {
        if(name.equals(BUTTONS_LABELS[0])){
            return ButtonEventType.RESTART;
        }

        return ButtonEventType.CLOSE;
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
