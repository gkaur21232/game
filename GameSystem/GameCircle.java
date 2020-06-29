package GameSystem;

import java.awt.*;


// A circle object that can be created in a Game
public class GameCircle extends GameObject
{
   // Construct a circle at the given location and diameter
   public GameCircle(double x, double y, double diameter)
   {
      // Create the GameObject at the right position and size
      super(x, y, diameter, diameter);
        
      // Default color is red fill with black frame
      setFillColor(Color.RED);
      setLineColor(Color.BLACK);
   }

   // Draw the circle (or oval) into the given graphics surface
   protected void draw(Graphics g)
   {
      int left = (int) (x - (width / 2));
      int top = (int) (y - (height/ 2));
      
      // Fill the circle if fillColor is not null
      if (fillColor != null)
      {
         g.setColor(fillColor);
         g.fillOval(left, top, (int) width, (int) height);
      }
      
      // Outline the circle if lineColor is not null
      if (lineColor != null)
      {
         Graphics2D g2 = (Graphics2D) g;  // so we can call setStroke
         g2.setStroke(new BasicStroke(lineWidth));

         g.setColor(lineColor);
         g.drawOval(left, top, (int) width, (int) height);
      }
   }
}
