package rpg1.entities;

import rpg1.Game;

import java.awt.*;

public abstract class Entity {

    protected Game game;
    protected int width,height;
    protected float x, y;
     public Entity ( Game game,float x, float y, int width, int height){
         this.game = game;
         this.x = x;
         this.y = y;
         this.height = height;
         this.width = width;

     }
     public abstract void tick();

     public abstract void render(Graphics g);

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
