package GameSystem;

import java.awt.*;


// A line object that can be created in a Game
public class GameLine extends GameObject
{
   // Protected instance variables
   protected double x2, y2;       // the second endpoint of the line
   
         
   // Construct a line that goes from (x, y) to (x2, y2)
   public GameLine(double x, double y, double x2, double y2)
   {
      // Create the GameObject using 0 size
      super(x, y, 0, 0);
      
      // Store the second endpoint
      this.x2 = x2;
      this.y2 = y2;
              
      // Default color is black
      setLineColor(Color.BLACK);
   }

   // Accessors and Mutators for the second endpoint
   public double getX2()         { return x2; }
   public double getY2()         { return y2; }
   public void setX2(double x2)  { this.x2 = x2; }
   public void setY2(double y2)  { this.y2 = y2; }
   
   // Set the second endpoint of the line
   public void setEndpoint(double x2, double y2)
   {
      this.x2 = x2;
      this.y2 = y2;
   }

   // Draw the line into the given graphics surface
   protected void draw(Graphics g)
   {
      if (lineColor != null)
      {
         Graphics2D g2 = (Graphics2D) g;  // so we can call setStroke
         g2.setStroke(new BasicStroke(lineWidth));

         g.setColor(lineColor);
         g.drawLine((int) x, (int) y, (int) x2, (int) y2);
      }
   }
}
