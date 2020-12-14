import java.awt.*;
import java.util.ArrayList;

public class DividerBox
{
    private int x,y,w,h;
    private Color myColor;
    private final int colorSpread = 40;  // used in depreciated method
    public DividerBox()
    {
        x = 0;
        y = 0;
        w = 10;
        h = 10;
        myColor = new Color((int)(Math.random()*205+25),
                            (int)(Math.random()*205+25),
                            (int)(Math.random()*205+25));
    }

    public DividerBox(int inX, int inY, int inW, int inH)
    {
        this();
        x = inX;
        y = inY;
        w = inW;
        h = inH;
    }

    public DividerBox(int inX, int inY, int inW, int inH, Color inColor)
    {
        this(inX,inY,inW,inH);
        myColor = inColor;
    }

    public void setColor(Color c)
    {
        myColor = c;
    }

    public void drawSelf(Graphics g)
    {
        //------------
        // TODO: fill this square with the given size and shape.
        //    Alternative: try ovals instead, though you'll want to go one
        //    pixel wider and taller.
        //    Note: this class has variables myColor, x, y, w, h....

        //------------
    }

    /**
    * returns whether or not the given point (px,py) is within the bounds of this box.
    * @param px
    * @param py
    * @return whether (px,py) is inside this box
    */
    public boolean containsPoint(int px, int py)
    {
        //------------
        // TODO: write this method, which will involve comparing px, py
        //   to x, y, w, h.

        return false; // replace this line with something better.
        //------------

    }

    /**
     * generates an ArrayList containing 1-4 DividerBoxes that fill up this box
     * if the width or height is less than 2, does not divide in that direction;
     * if both are less than 2, then we return this same box in the list.
     * @return an ArrayList of boxes that together make up the same space as this one.
     */
    public ArrayList<DividerBox> subdivide()
    {

        // I've written this one for you. - HH

        ArrayList<DividerBox> result = new ArrayList<DividerBox>();
        if (w < 2 && h < 2)
        {
            result.add(this); // no change...
        }
        else if (w < 2)
        {
            result.add(new DividerBox(x, y,         w, h / 2));
            result.add(new DividerBox(x, y + h / 2, w, h - h / 2));
        }
        else if (h < 2)
        {
            result.add(new DividerBox(x,     y, w/2,   h));
            result.add(new DividerBox(x+w/2, y, w-w/2, h));
        }
        else
        {
            result.add(new DividerBox(x,     y,     w/2,   h/2));
            result.add(new DividerBox(x+w/2, y,     w-w/2, h/2));
            result.add(new DividerBox(x,     y+h/2, w/2,   h-h/2));
            result.add(new DividerBox(x+w/2, y+h/2, w-w/2, h-h/2));
        }
        return result;
    }

    /**
     * Given an imageArray of color info, selects the color of the pixel
     * at the center of this box and uses that for this box's color.
     * @param imageArray - color information about an image, in [row][col][colorchannel] format.
     */
    public void setColorAtCenterOfBoxInImage(int[][][] imageArray)
    {
        // I've written this one for you.
        int[] col = imageArray[y+h/2][x+w/2]; // Note: reversed (x,y) -> (row,col)
        myColor = new Color(col[0],col[1],col[2]);
    }

    /**
     * Picks a color that is close to the given color.
     * (Not actually used in this program (leftover from a previous version)
     * But I thought it was interesting and might prove handy another day.
     * @param c source color
     * @return a color in the same neighborhood (RGB)
     */
    public Color nearbyColor(Color c)
    {
        if (c==null)
            return Color.GRAY;
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        int r2 = Math.max(0,Math.min(255,r+(int)(Math.random()*colorSpread-colorSpread/2)));
        int g2 = Math.max(0,Math.min(255,g+(int)(Math.random()*colorSpread-colorSpread/2)));
        int b2 = Math.max(0,Math.min(255,b+(int)(Math.random()*colorSpread-colorSpread/2)));

        return new Color(r2,g2,b2);
    }

    @Override
    public String toString()
    {
        return "DividerBox{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", myColor=" + myColor +
                '}';
    }
}
