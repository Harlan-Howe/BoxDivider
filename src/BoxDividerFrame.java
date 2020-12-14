import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoxDividerFrame extends JFrame
{

    private BoxDividerPanel myPanel;

    public BoxDividerFrame()
    {
        super("Box Divider");
        setSize(800,800);
        getContentPane().setLayout(new GridLayout(1,1));
        myPanel = new BoxDividerPanel();
        getContentPane().add(myPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
