package GameSystem;

import java.awt.*;


// A rectangle object that can be created in a Game
public class GameRect extends GameObject
{
   // Construct a rectangle at the given location and diameter
   public GameRect(double x, double y, double width, double height)
   {
      // Create the GameObject at the right position and size
      super(x, y, width, height);
        
      // Default color is yellow fill with black outline
      setFillColor(Color.YELLOW);
      setLineColor(Color.BLACK);
   }

   // Draw the rectangle into the given graphics surface
   protected void draw(Graphics g)
   {
      int left = (int) (x - (width / 2));
      int top = (int) (y - (height/ 2));

      // Fill the rect if fillColor is not null      
      if (fillColor != null)
      {
         g.setColor(fillColor);
         g.fillRect(left, top, (int) width, (int) height);
      }
      
      // Outline the rect if lineColor is not null
      if (lineColor != null)
      {
         Graphics2D g2 = (Graphics2D) g;  // so we can call setStroke
         g2.setStroke(new BasicStroke(lineWidth));

         g.setColor(lineColor);
         g.drawRect(left, top, (int) width, (int) height);
      }
   }
}
