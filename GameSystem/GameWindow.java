package GameSystem;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;


// A window for a game to run in
public class GameWindow extends JFrame
{
   // Start a game window with the given title and window size
   public static void start(GameProgram program, String title, int width, int height) 
   {
      // Create a GameWindow on the event dispatch thread for proper GUI updates
      SwingUtilities.invokeLater(new Runnable() 
         {
            public void run() 
            {
               // Make the window with our title and size
               new GameWindow(program, title, width, height);
            }
         }
      );
   }

   // Construct a GameWindow
   GameWindow(GameProgram program, String title, int width, int height) 
   {
      // Create the JFrame with the given title for the window
      super(title);
      
      // Position the window near upper-left corner of screen
      setLocation(10, 30);
      setSize(width, height);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // closing window quits the app

      // Fill the whole window with our Canvas subclass
      GameCanvas canvas = new GameCanvas(program);
      add(canvas, BorderLayout.CENTER);
      setVisible(true);   
      canvas.createBufferStrategy(2);  // use double buffering for smooth draws
      canvas.requestFocus();
      
      // Create the game objects then start the frame redraw sequence
      canvas.setupGame();
      canvas.startFrameTimer();
   }
}

