import java.lang.Math;
import java.awt.event.KeyEvent;
import GameSystem.*;

// The main program
public class MainProgram extends GameProgram
{
   // Variables declared here can be used in any method body below
   GameImage HP;
   GameImage piggy;  
   GameImage pizza;   
   int x;             // x pizza
   int y;             // y pizza
   double X;          // x piggy
   double Y;          // y piggy

   GameImage knife;      
   int a;             // x  knife
   int b;             // y  knife  
   double kX;
   double kY;
   
   GameImage s;
  
   GameText hits;
   int score;
     
   
   GameRect rect;
   GameRect rect2;
   GameRect rect3;
   
   
   // The Java main method
   public static void main(String[] args) 
   {
      // Start a game window with this class as the main program,
      // and specify the window title and initial size.
      GameWindow.start(new MainProgram(), "My Game", 800, 800);
   }
   
   // Setup the objects in the game
   public void setup(Game game)
   {      
       
       
              
      //background
      GameImage sky = game.addImage("sky.jpg", game.width/2, game.height/2);
      sky.setSize(game.width,game.height);  
           
      
      //pizza
      x = (int)((Math.random()*600) +1);
      y = (int)((Math.random()*600) +1);
      pizza = game.addImage("pizza.png", x, y );
      pizza.setSize(90,90); 
      
      rect = game.addRect(400,400,150,150); 
      rect2 = game.addRect(400,100,150,150);
      rect3 = game.addRect(400,700,150,150);
      
      //piggy
      piggy = game.addImage("piggy.png", 700, 400);
      piggy.setSize(300,300);
      //piggy.setXSpeed(-10);  
      //piggy.setGravity(.03);      
      
      //knife     
      int A = (int)((Math.random()*800) + 0);
      int B = (int)((Math.random()*800) + 0);
      knife = game.addImage("knife.png",A ,B ); 
      knife.setSize(150,150);
      knife.setXSpeed(15);  
      kX = knife.getX();
      kY = knife.getY();     
      
      //jumpscare
      s = game.addImage("scare.png", 400, 400);
      s.setSize(game.width ,game.height - 50);
      s.setVisible(false);
      s.setGravity(-9);
      s.setYSpeed(10);
      s.setBounce(true);     
       
   }
   
   
   
   // Update objects in the game as desired before each new animation frame.
   // This method is called 60 times per second once the game starts.
   public void update(Game game)  
   
   {   
   
    //HP
     // HP = game.addImage("hp.gif", 300,300 ); 


       //distance between piggy & pizza    
       X = piggy.getX();
       Y = piggy.getY();
             
       double distance = Math.sqrt(((X-x)*(X-x))+ ((Y - y)*(Y - y))); 
       
              
       //game.removeObject(hits);
               
         if (distance <= 20)     
         {    
         
           x = (int)((Math.random()*700) + 0);
           y = (int)((Math.random()*700) + 0);
           
           pizza.setPosition (x,y);
           
           
           game.removeObject(hits);
           ++score;  
           hits = game.addText("Score = " + score, 600,700,20);                              
          }    
          
              
         //killing piggy
         X = piggy.getX();
         Y = piggy.getY();
         kX = knife.getX();
         kY = knife.getY();
         
         double opp = Math.sqrt((((kX + 80)-(X - 30))*((kX + 80)-(X - 30)))+ ((kY -(Y - 15))*(kY -(Y -15 ))));
         
         GameText over =game.addText("DORA WINS! ", 100,400,100);  
         game.removeObject(over);
         
         GameText win =game.addText("You  Win! ", 200,400,100);  
         game.removeObject(win);
         
         
           if (opp <= 35)
         
            {    
               s.setVisible(true);
               game.removeObject(hits);
                          
               game.addObject(over);                           

            }
            else if ( score == 5)
           { 
              
            game.addObject(win);
           }

             
             
                       
            
      
      
         
         // Bring piggy back on screen
         double pigPosition = piggy.getX();
         double pigY = piggy.getY();
      
         if ((pigPosition <= 0 || pigPosition >= 800) || (pigY <= 0 || pigY >= 790 ))
          
       
            piggy.setPosition( 400,400);  
            
            
          if ( pigPosition == 400 &&  pigY == 100  )
         
            piggy.setPosition(400, 700);
           
                  
         
         
         
        //random position for knife       

      for (int i = 0; i <= 1; i++) 
       {      
      
         double knifePos = knife.getX(); 
                 
         if (knifePos >= 800)
         
            knife.setPosition( X - 550 , Y - 60);                 
       }  
                  
   }

   // Handle a key press event. See class KeyEvent for key codes.
   public void onKeyPress(Game game, int key)  
      
      {
         double up = piggy.getYSpeed()- 5;              
         double down = piggy.getYSpeed ()+ 5;        
         double right = piggy.getXSpeed ()+ 5;
         double left = piggy.getXSpeed ()- 5;               
               
            if (key == 'N')
            {
               //s.setVisible(false);
               game.removeObject(s);
            }
               
                       
            switch(key)
            {
               case KeyEvent.VK_DOWN:
                  piggy.setYSpeed(down);
                  
                  break;
                  
               case KeyEvent.VK_UP:
                  piggy.setYSpeed(up);
                  
                  break;
                  
               case KeyEvent.VK_LEFT:
                  piggy.setXSpeed(left);
                  
                  break;
                  
               case KeyEvent.VK_RIGHT:
                  piggy.setXSpeed(right);            
              
             }    
      
      } 
      
      
   //key release   
   public void onKeyRelease(Game game, int key)
      { 
         double stop = piggy.getYSpeed() - piggy.getYSpeed();    
      
                
             switch(key)
            {
               case KeyEvent.VK_DOWN:
                  piggy.setYSpeed(stop);
                  
                  break;
                  
               case KeyEvent.VK_UP:
                  piggy.setYSpeed(stop);
                  
                  break;
                                                                                                                         
               case KeyEvent.VK_LEFT:
                  piggy.setXSpeed(stop);
                  
                  break;
                  
               case KeyEvent.VK_RIGHT:
                  piggy.setXSpeed(stop);
                  
            }     
         

      
   }
      
      
}

