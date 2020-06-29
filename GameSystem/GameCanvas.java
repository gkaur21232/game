package GameSystem;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.Timer;


// An animation canvas containing a Game that animates 60 frames/sec.
// We subclass Canvas but then implement manual repainting.
class GameCanvas extends Canvas 
         implements ActionListener, MouseListener, KeyListener 
{
   // Instance data
   private final int FRAMES_PER_SEC = 60;  // The animation frame rate
   private Dimension size;           // pixel size of the canvas
   private GameProgram program;   // the main program callback interface
   private Game game;  // The game state  
   private boolean repainting = false;  // to prevent overlapping redraws
   

   // Construct a GameCanvas with the given program callback interface
   GameCanvas(GameProgram program) 
   {
      this.program = program;
       
      // Tell the canvas that we will handle repaints manually
      setIgnoreRepaint(true);
      
      // Add event listeners
      addMouseListener(this);
      addKeyListener(this);
      setFocusable(true);
   }
   
   // Setup the game and the program's game objects
   void setupGame()
   {
      size = getSize();
      game = new Game(size.width, size.height);
      program.setup(game);   // main program creates objects here
   }   
   
   // Start the frame update timer
   void startFrameTimer()
   {    
      // Make a system timer that calls actionPerformed() at each frame
      int ms = 1000 / FRAMES_PER_SEC;   // frame time in milliseconds
      Timer timer = new Timer(ms, this);
      timer.start();
   }
    
   // Action function for frame timer: Update and redraw the canvas.
   public void actionPerformed(ActionEvent e)
   {
      // Check to see if the user resized the window 
      Dimension newSize = getSize();
      if (newSize.width != size.width || newSize.height != size.height)
      {
         // Update game size and notify the main program
         size = newSize;
         game.setSize(size.width, size.height);
         program.onResize(game);
      }

      // Let the game update its object positions
      program.update(game);
      game.update();
       
      // Repaint the canvas manually
      repaintAll();
   }
    
   // Method to manually repaint the canvas using our fast buffering
   private void repaintAll() 
   {
      // Make sure we don't process overlapping calls
      if (repainting)
         return;
      repainting = true;
         
      // Do a repaint on the page that is not currently showing
      BufferStrategy strategy = getBufferStrategy();
      Graphics g = strategy.getDrawGraphics();
      if (g != null)
      {
         // Start with a white background
         g.setColor(Color.WHITE);
         g.fillRect(0, 0, size.width, size.height);
         
         // Draw the game
         game.draw(g);
         g.dispose();
      }
        
      // Switch buffers to show the page we just painted
      strategy.show();
      Toolkit.getDefaultToolkit().sync();
        
      // Allow the next repaint
      repainting = false;
   }
   
   // Mouse pressed event
   public void mousePressed(MouseEvent e)
   {
      GameObject obj = game.findHitObject(e.getX(), e.getY());
      program.onMousePress(game, obj, e.getX(), e.getY());
   }
     
   // Mouse released event
   public void mouseReleased(MouseEvent e)
   {
      GameObject obj = game.findHitObject(e.getX(), e.getY());
      program.onMouseRelease(game, obj, e.getX(), e.getY());
   }

   // Key pressed event
   public void keyPressed(KeyEvent e)
   {
      program.onKeyPress(game, e.getKeyCode());
   }
   
   // Key released event
   public void keyReleased(KeyEvent e)
   {
      program.onKeyRelease(game, e.getKeyCode());
   }
    
   // Unused events
   public void mouseClicked(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e)  {}
   public void keyTyped(KeyEvent e)       {}

}

