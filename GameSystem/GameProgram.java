package GameSystem;


// The default class (superclass) for a game program.
// Your main program will subclass (extend) this class. 
public class GameProgram
{
   // Setup the game by creating the objects, etc.
   // This method is called once at the start of the game.
   public void setup(Game game)
   {
   }
   
   // Update objects in the game as desired before each new animation frame.
   // This method is called 60 times per second once the game starts.
   public void update(Game game)
   {
   }
   
   // Handle a mouse press event at location (x, y).
   // if obj != null then it is the topmost clickable object that contains
   // the point. Use GameObject.setClickable() to make a game object clickable.
   public void onMousePress(Game game, GameObject obj, int x, int y)
   {
   }
   
   // Handle a mouse release event at location (x, y).
   // if obj != null then it is the topmost clickable object that contains
   // the point. Use GameObject.setClickable() to make a game object clickable.
   public void onMouseRelease(Game game, GameObject obj, int x, int y)
   {
   }
    
   // Handle a key press event. See class KeyEvent for key codes.
   public void onKeyPress(Game game, int key)
   {
   }

   // Handle a key release event. See class KeyEvent for key codes.
   public void onKeyRelease(Game game, int key)
   {
   }
   
   // Called when the game window changes size.
   // You can get the new size with game.width and game.height.
   public void onResize(Game game)
   {
   }
}
