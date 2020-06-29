package GameSystem;

import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;


// An image object that can be created in a Game
public class GameImage extends GameObject
{
   // instance data
   private Image rawImage;       // unscaled image as loaded from file
   private Image scaledImage;    // scaled image for current object size
   
   
   // Construct an image from the filename at the given location
   public GameImage(String filename, double x, double y)
   {
      // Create the GameObject initially 1 x 1 pixel, size will be set below.
      super(x, y, 1, 1);
      
      // Warn the user if the file doesn't exist
      if (!(new File(filename)).isFile())
         System.out.println("ERROR: Cannot find image file \"" + filename + "\"");
         
      // Try to load the raw image and set the object size from it
      ImageIcon icon = new ImageIcon(filename);  // loads asynchronously unfortunately 
      width = icon.getIconWidth();
      height = icon.getIconHeight();
      rawImage = icon.getImage();  // blank image until loaded or if not found
      scaledImage = rawImage;      // until user scales it using setSize
   }
   
   // Set the size of the object
   @Override
   public void setSize(double width, double height)
   {
      super.setSize(width, height);

      // Get scaled image for current size from raw image      
      scaledImage = rawImage.getScaledInstance((int) width, 
                        (int) height, Image.SCALE_SMOOTH);
   }

   // Draw the image into the given graphics surface
   protected void draw(Graphics g)
   {      
      int left = (int) (x - (width / 2));
      int top = (int) (y - (height/ 2));
      
      // Draw the image
      if (scaledImage != null)
         g.drawImage(scaledImage, left, top, null);
      
      // Draw a frame around the image if lineColor is not null   
      if (lineColor != null)
      {
         Graphics2D g2 = (Graphics2D) g;  // so we can call setStroke
         g2.setStroke(new BasicStroke(lineWidth));

         g.setColor(lineColor);
         g.drawRect(left, top, (int) width, (int) height);
      }
   }
}
