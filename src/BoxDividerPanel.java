import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BoxDividerPanel extends JPanel implements MouseMotionListener
{
    //------------
    // TODO: instantiate the private variable "myBoxes" - an arrayList of
    //    DividerBoxes.

    //------------

    // used to hold the pixel color information of a jpg file. You don't
    //  need to worry about this... yet. (We'll talk in the spring.)
    private int[][][] imageColors;

    // used to track whether the window is resized.
    private int latestWidth, latestHeight;

    public BoxDividerPanel()
    {
        super();
        //------------
        // TODO: Initialize myBoxes, an array list of DividerBoxes.

        //------------
        // make this class be one that responds when the user drags the mouse.
        addMouseMotionListener(this);

        // these variables will make sure that we reset the box list at the start of the program,
        //    after this panel is stretched to fit the window.
        latestWidth = -1;
        latestHeight = -1;

        // and we're loading a graphics file.
        imageColors = ImageManager.RGBArrayFromFile("PascalSmile.jpeg");
    }

    /**
     * Checks whether this panel is the same size as remembered and
     * then goes through myBoxes and tells each one to draw itself.
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (getBounds().width != latestWidth || getBounds().height != latestHeight)
        {
            resetBoxList();
        }
        //------------
        // demo of box. Handle "To do"s in DividerBox first.
        // Make sure this works before you edit BoxDividerPanel file.
        // Then delete this section:
        DividerBox tempBox = new DividerBox(300,400,40,50);
        tempBox.drawSelf(g);
        g.setColor(Color.BLACK);
        g.fillOval(328,401,5,5);
        System.out.println("Box contains (330,403): "+tempBox.containsPoint(330,403));
        g.fillOval(-2,-2,5,5);
        System.out.println("Box contains (0,0)    : "+tempBox.containsPoint(0,0));
        g.fillOval(318,448,5,5);
        System.out.println("Box contains (320,450): "+tempBox.containsPoint(320,450));
        g.fillOval(488,406,5,5);
        System.out.println("Box contains (490,408): "+tempBox.containsPoint(490,408));
        g.fillOval(333,598,5,5);
        System.out.println("Box contains (335,600): "+tempBox.containsPoint(335,600));
        System.out.println("(Should be true, false, true, false, false.)");
        //------------

        //------------
        //TODO: tell all the boxes to draw themselves. (There's a method
        //  in DividerBox to make one do this, which you should have written by now.)


        //------------
    }

    /**
     * clears out the box list and updates what the latest
     * bounds of the panel are.
     */
    public void resetBoxList()
    {
        //------------
        // TODO:
        //  a) Empty the list, myBoxes.
        //  b) Add a new box that is of size
        //     getBounds().width x getBounds().height.
        //  c) Then tell that box
        //     to "setColorAtCenterOfBoxInImage(imageColors)"

        System.out.println();
        //------------
        // Keep the rest of this - it's to make sure that we
        //   don't call resetBoxList() again unless there is a change.
        latestWidth= getBounds().width;
        latestHeight = getBounds().height;

        // ... and repaint.
        repaint();
    }



    // -----------------------------------
    // The rest of the methods in this class are for handling the mouse.
    // When we said that we would implement MouseMotionListener at the
    // top of the file, this was a promise that we would have both
    // of these methods, but we're only going to actually do anything
    // with one of them.



    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        //------------
        //TODO: loop through all the boxes in myBoxes. If the point
        //   (e.getX(),e.getY()) is inside a box, ask the box for its subboxes.
        //   Then replace that box with each of the subboxes you got. Then stop
        //   looking for boxes that hold the point (or you'll get one of the ones you
        //   just added).
        //   Then, for each of those boxes you added, tell it to take its color
        //   from the source image.
        //Note: you will make use of the following methods in the DividerBox
        //   class: containsPoint(), subdivide(), and setColorAtCenterOfBoxInImage().


        //------------
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e)
    {
        // you can leave this empty - we aren't doing anything when the
        //   mouse moves and the button isn't held.
    }
}
