package GameSystem;


// These are the methods that you can call on a Game object.
public interface GameInterface
{
   // Add a new circle object to the game with center at (x, y) and size 
   // given by diameter. Returns the new GameCircle.
   public GameCircle addCircle(double x, double y, double diameter);

   // Add a new rectangle object to the game with center at (x, y) and size
   // given by width and height. Returns the new GameRect.
   public GameRect addRect(double x, double y, double width, double height);

   // Add a new line object to the game, drawn from (x, y) to (x2, y2).
   // Returns the new GameLine.
   public GameLine addLine(double x, double y, double x2, double y2);
   
   // Add a new text object to the game, using the given text string, 
   // and (x, y) as the baseline position of the first character.
   // The fontSize specifies the font size in points. Returns the new GameText.
   public GameText addText(String text, double x, double y, int fontSize);
                             
   // Add a new image object to the game with center at (x, y) using the given
   // image filename (.png or .jpg, path is relative to the project folder). 
   // Returns the new GameImage. The initial image size is "full size".
   // You can use the setSize method to scale the image to any size.
   public GameImage addImage(String filename, double x, double y);
   
   // Add an existing GameObject to the game.
   public void addObject(GameObject obj);
   
   // Remove a GameObject from the game.
   // Return true if the object was found and removed, false if not found.
   public boolean removeObject(GameObject obj);
}
