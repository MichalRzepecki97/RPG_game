package rpg1.entities;

import rpg1.Handler;
import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected int width,height;
    protected float x, y;
    protected Rectangle bounds;

     public Entity ( Handler handler,float x, float y, int width, int height){
         this.handler = handler;
         this.x = x;
         this.y = y;
         this.height = height;
         this.width = width;
         bounds = new Rectangle(0,0,width,height);
     }
     public abstract void tick();

     public abstract void render(Graphics g);

     public boolean checkEntityCollision(float xOffset, float yOffset){
         for (Entity entity : handler.getWorld().getMenager().getEntities()){
             if (entity.equals(this))
             continue;
             if (entity.ColissionEntity(0f,0f).intersects(ColissionEntity(xOffset,yOffset)))
                 return true;
         }
         return  false;
     }

     public Rectangle ColissionEntity(float xOffset, float yOffset){
         return  new Rectangle((int)(x+bounds.x +xOffset),
                 (int) (y +bounds.y + yOffset),bounds.width, bounds.height);
     }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
