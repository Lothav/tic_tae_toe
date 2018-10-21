import javax.swing.*;
import java.awt.event.WindowEvent;

class Window
{
    private int width;
    private int height;

    JFrame frame;

    Window(int width, int height)
    {
        this.width = width;
        this.height = height;

        frame = new JFrame();
        frame.setSize(this.width, this.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    int getWidth()
    {
        return width;
    }

    int getHeight()
    {
        return height;
    }

    void setVisible(boolean b)
    {
        frame.setVisible(b);
    }

    void close()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
