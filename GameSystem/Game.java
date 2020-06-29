package GameSystem;

import java.awt.*;
import java.util.*;


// A game where objects can be created and modified
public class Game implements GameInterface
{
   // Public data fields
   public int width, height;    // The size of the game window in pixels
   
   // Private instance data
   private ArrayList<GameObject> objects;   // The objects in the game
   
 
   // Construct the game with the given initial window size
   public Game(int width, int height)
   {
      this.width = width;
      this.height = height;
      objects = new ArrayList<GameObject>();
   }
    
   // Add a new circle object to the game with the given position and diameter.
   // Returns the new GameCircle.
   public GameCircle addCircle(double x, double y, double diameter)
   {
      GameCircle circle = new GameCircle(x, y, diameter);
      objects.add(circle);
      return circle;
   }
       
   // Add a new rectangle object to the game with the given position and size.
   // Returns the new GameRect.
   public GameRect addRect(double x, double y, double width, double height)
   {
      GameRect rect = new GameRect(x, y, width, height);
      objects.add(rect);
      return rect;
   }

   // Add a new line object to the game, drawn from (x, y) to (x2, y2).
   public GameLine addLine(double x, double y, double x2, double y2)
   {
      GameLine line = new GameLine(x, y, x2, y2);
      objects.add(line);
      return line;
   }
                             
   // Add a new text object to the game, using the given text string, 
   // and (x, y) as the baseline position of the first character.
   // Returns the new GameText.
   public GameText addText(String text, double x, double y, int fontSize)
   {
      GameText textObj = new GameText(text, x, y, fontSize);
      objects.add(textObj);
      return textObj;
   }
   
   // Add a new image object to the game using the given image filename
   // (.png or .jpg, path is relative to the project folder) and position. 
   // Returns the new GameImage. The initial image size is "full size".
   // You can use the setSize method to scale the image to any size.
   public GameImage addImage(String filename, double x, double y)
   {
      GameImage image = new GameImage(filename, x, y);
      objects.add(image);
      return image;
   }
   
   // Add an existing GameObject to the game.
   public void addObject(GameObject obj)
   {
      objects.add(obj);
   }
   
   // Remove a GameObject from the game. 
   // Return true if the object was found and removed, false if not found.
   public boolean removeObject(GameObject obj)
   {
      return objects.remove(obj);
   }
    
   // Update the size of the game
   void setSize(int width, int height)
   {
      this.width = width;
      this.height = height;
   }
        
   // Draw the game onto the given graphics surface
   void draw(Graphics g)
   {
      // Draw the visible objects
      for (GameObject obj: objects)
      {
         if (obj.visible)
            obj.draw(g);
      }
   }

   // Update the game for the next frame
   void update()
   {
      // Update the objects
      for (GameObject obj: objects)
      {
         obj.update(width, height);
      }
   }
   
   // Find and return the topmost clickable object that contains 
   // the point (x, y), or return null if none.
   GameObject findHitObject(double x, double y)
   {
      // Search objects in reverse (top-down) order
      for (int i = objects.size() - 1; i >= 0; i--)
      {
         GameObject obj = objects.get(i);
         if (obj.clickable)
         {
            double r = obj.width / 2;
            double left = obj.x - r;
            double right = obj.x + r;
            if (x < left || x > right)
               continue;
            r = obj.height / 2;
            double top = obj.y - r;
            double bottom = obj.y + r;
            if (y < top || y > bottom)
               continue;
            return obj;  // found one
         } 
      }
      return null;  // none found
   }
}
