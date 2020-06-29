package GameSystem;

import java.awt.*;


// A text object that can be created in a Game
public class GameText extends GameObject
{
   // Protected instance variables
   protected String text;    // the text to draw
   protected Font font;      // the font to draw in   


   // Construct a text object with the given string, location
   // of the baseline of the first character, and fontSize.
   public GameText(String text, double x, double y, int fontSize)
   {
      // Create the GameObject at the given position and 0 size
      super(x, y, 0, 0);
      
      // Store the text and make the font
      this.text = text;
      font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize); 
              
      // Default text color is black
      setFillColor(Color.BLACK);
   }

   // Set the text of the text object
   public void setText(String text)
   {
      this.text = text;
   }
   
   // Set the font of the text object
   public void setFont(Font font)
   {
      this.font = font;
   }   
   
   // Draw the text into the given graphics surface
   protected void draw(Graphics g)
   {
      if (fillColor != null)
      {
         g.setColor(fillColor);
         g.setFont(font);   
         g.drawString(text, (int) x, (int) y);
      }
   }
}
