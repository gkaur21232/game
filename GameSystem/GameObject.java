package GameSystem;

import java.awt.*;


// Base class for an object that can be created in a Game
public abstract class GameObject implements GameObjectInterface
{
   // Public instance variables (you can get or set these directly)
   public double x, y;    //  position of center of object, or start point if line
   
   // Protected instance variables
   protected double width, height;      // size 
   protected double xSpeed, ySpeed;     // velocity
   protected double gravity;            // y gravity in pixels/sec^2
   protected boolean xBounce, yBounce;  // true to auto-bounce off limits
   protected double restitution;        // bounce restitution (usually 0-1)
   protected Color fillColor;     // fill color or null for none
   protected Color lineColor;     // line/frame color or null for none
   protected int lineWidth;       // line/frame thickness in pixels
   protected boolean visible;     // true if object is visible (default true)
   protected boolean clickable;   // true to make object clickable (default false)
   

   // Construct a default object at the given location and size
   GameObject(double x, double y, double width, double height)
   {    
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      xSpeed = 0;
      ySpeed = 0;
      gravity = 0;
      xBounce = false;
      yBounce = false;
      restitution = 1.0;
      fillColor = null;
      lineColor = null;
      lineWidth = 1;
      visible = true;
      clickable = false;
   }
   
   // Simple Accessors
   public double getX()           { return x; }
   public double getY()           { return y; }
   public double getWidth()       { return width; }
   public double getHeight()      { return height; }
   public double getXSpeed()      { return xSpeed; }
   public double getYSpeed()      { return ySpeed; }
   public double getGravity()     { return gravity; }
   public boolean getXBounce()    { return xBounce; }
   public boolean getYBounce()    { return yBounce; }
   public double getRestitution() { return restitution; }
   public Color getFillColor()    { return fillColor; }
   public Color getLineColor()    { return lineColor; }
   public int getLineWidth()      { return lineWidth; }
   public boolean getVisible()    { return visible; }
   public boolean getClickable()  { return clickable; }
   
   // Simple Mutators
   public void setX(double x)                     { this.x = x; }
   public void setY(double y)                     { this.y = y; }
   public void setXSpeed(double xSpeed)           { this.xSpeed = xSpeed; }
   public void setYSpeed(double ySpeed)           { this.ySpeed = ySpeed; }
   public void setGravity(double gravity)         { this.gravity = gravity; }
   public void setXBounce(boolean xBounce)        { this.xBounce = xBounce; }
   public void setYBounce(boolean yBounce)        { this.yBounce = yBounce; }
   public void setRestitution(double restitution) { this.restitution = restitution; }
   public void setFillColor(Color c)              { fillColor = c; }
   public void setLineColor(Color c)              { lineColor = c; }
   public void setLineWidth(int width)            { lineWidth = width; }

   public void setVisible(boolean visible)      { this.visible = visible; }
   public void setClickable(boolean clickable)  { this.clickable = clickable; }

   // Set the position of the object   
   public void setPosition(double x, double y)
   {
      this.x = x;
      this.y = y;
   }

   // Set the size of the object
   public void setSize(double width, double height)
   {
      this.width = width;
      this.height = height;
   }

   // Set the x and y speed of the object in pixels per frame
   public void setSpeed(double xSpeed, double ySpeed)
   {
      this.xSpeed = xSpeed;
      this.ySpeed = ySpeed;
   }
      
   // Set bounce for both x and y
   public void setBounce(boolean bounce)
   {
      xBounce = bounce;
      yBounce = bounce;
   }
   
   // Set auto-bounce for x and y separately
   public void setBounce(boolean xBounce, boolean yBounce)
   {
      this.xBounce = xBounce;
      this.yBounce = yBounce;
   }
   
   // Draw the object into the given graphics surface (subclasses must implement)
   abstract protected void draw(Graphics g);
      
   // Update the object's state for the next animation frame
   void update(int gameWidth, int gameHeight)
   {
      // Apply current velocity
      x += xSpeed;
      y += ySpeed;
       
      // Apply bounce according to auto-bounce
      applyBounce(gameWidth, gameHeight);
      
      // Apply gravity acceleration
      ySpeed += gravity;
   }

   // Bounce the object off walls if out of bounds, according to auto-bounce
   private void applyBounce(int gameWidth, int gameHeight)
   {
      if (xBounce)
      {
         double r = width / 2;
         if (x < r)
         {
            x -= xSpeed;
            if (x < r)
               x = r;
            xSpeed = -xSpeed * restitution;
         }
         double xMax = gameWidth - r;
         if (x > xMax)
         {
            x -= xSpeed;
            if (x > xMax)
               x = xMax;
            xSpeed = -xSpeed * restitution;
         }
      }
      if (yBounce)
      {
         double r = height / 2;
         if (y < r)
         {
            y -= ySpeed;
            if (y < r)
               y = r;
            ySpeed = -ySpeed * restitution;
         }
         double yMax = gameHeight - r;
         if (y > yMax)
         {
            y -= ySpeed;
            if (y > yMax)
               y = yMax;
            ySpeed = -ySpeed * restitution;
         }
      }
   }
}
