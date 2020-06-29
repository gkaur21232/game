package GameSystem;

import java.awt.*;


// These are the methods you can call on any type of game object
// (GameCircle, GameRect, GameLine, GameText, GameImage, or GameObject).
public interface GameObjectInterface     
{   
   // The x and y coordinates of the center of the object.
   // These are also available as the public data variables x and y.
   public double getX();
   public double getY();
   public void setX(double x);
   public void setY(double y);
   public void setPosition(double x, double y);

   // The width and height (size) of the object
   public double getWidth();
   public double getHeight();
   public void setSize(double width, double height);

   // The speed of the object in the x and y directions in pixels/sec
   public double getXSpeed();
   public double getYSpeed();
   public void setXSpeed(double xSpeed);
   public void setYSpeed(double ySpeed);
   public void setSpeed(double xSpeed, double ySpeed);

   // The gravity (downward) acceleration in pixels/sec^2. 
   public double getGravity();
   public void setGravity(double gravity);
   
   // If bounce is true then a moving object will automatically bounce
   // off the limits of the window. You can control autoBounce separately
   // in the x and y directions, or set both at the same time.
   public boolean getXBounce();
   public boolean getYBounce();
   public void setXBounce(boolean xBounce);
   public void setYBounce(boolean xBounce);
   public void setBounce(boolean bounce);
   
   // The restitution is the coefficient of bounce energy recovery.
   // This typically ranges from 0.0 (sticks to wall) to 1.0 (very bouncy).
   public double getRestitution();
   public void setRestitution(double restitution);

   // The color of the interior of an object, or null for no fill.
   // See class Color for constants (e.g. Color.BLACK, Color.RED) and more.
   public Color getFillColor();
   public void setFillColor(Color c);
   
   // The color of the outline of an object, or null for no outline.
   // See class Color for constants (e.g. Color.BLACK, Color.RED) and more.
   public Color getLineColor();
   public void setLineColor(Color c);
   
   // The width of the outline (line thickness) of an object in pixels.
   // This defaults to 1 pixel.
   public int getLineWidth();
   public void setLineWidth(int width);

   // True if you want the object to be shown (drawn).
   // This defaults to true. Set to false to hide the object.
   public boolean getVisible();
   public void setVisible(boolean visible);

   // True if the object will trigger mouse events when clicked.
   // This defaults to false. To get mouse events, set to true then
   // implement onMousePress in your GameProgram.
   public boolean getClickable();
   public void setClickable(boolean clickable);
}
