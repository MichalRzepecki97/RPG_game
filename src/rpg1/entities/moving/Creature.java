package rpg1.entities.moving;

import rpg1.Handler;
import rpg1.entities.Entity;
import rpg1.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH =20;
    public static final float DEFAULT_SPEED = 5.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 100,
                            DEFAULT_CREATURE_HEIGHT = 150;


    protected int health;
    protected float moveSpeed;
    protected float xMove,yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y,width,height);
        health = DEFAULT_HEALTH;
        moveSpeed = DEFAULT_SPEED;
    }

    public void move(){
        if (!checkEntityCollision(xMove,0f))
            moveX();
        if (!checkEntityCollision(0f,yMove))
            moveY();
    }

    public void moveX(){
        if (xMove > 0){// move right
            int xx = (int)(x + xMove + bounds.x + bounds.width)/ Tile.TILEWIDTH;

            if(!collisionWithSolidObject(xx,(int) (y+ bounds.y)/ Tile.TILEHEIGHT)&&
            !collisionWithSolidObject(xx,(int)(y + bounds.y + bounds. height)/Tile.TILEHEIGHT)){
            x+= xMove;
            }else{
                x = xx * Tile.TILEWIDTH - bounds.x - bounds.width -1;
            }

        }else if (xMove < 0){//left
            int xx = (int)(x + xMove + bounds.x)/ Tile.TILEWIDTH;
            if(!collisionWithSolidObject(xx,(int) (y+ bounds.y)/ Tile.TILEHEIGHT)&&
                    !collisionWithSolidObject(xx,(int)(y + bounds.y + bounds. height)/Tile.TILEHEIGHT)){
                x += xMove;
            }else {
                x =xx *Tile.TILEWIDTH + Tile.TILEWIDTH  - bounds.x;
            }

        }
    }

    public void moveY(){//Up
        if(yMove<0){
            int ty = (int)(y + yMove + bounds.y)/Tile.TILEWIDTH;

            if(!collisionWithSolidObject((int)(x+ bounds.x)/Tile.TILEHEIGHT,ty)&&
                    !collisionWithSolidObject((int)(x+ bounds.x+ bounds.width)/Tile.TILEHEIGHT,ty)){
                y += yMove;
            }else {
                y = ty *Tile.TILEHEIGHT +Tile.TILEHEIGHT -bounds.y;
            }
        }else if (yMove > 0){//Down
            int ty = (int)(y + yMove + bounds.y + bounds.height)/Tile.TILEWIDTH;

            if(!collisionWithSolidObject((int)(x+ bounds.x)/Tile.TILEHEIGHT,ty)&&
                    !collisionWithSolidObject((int)(x+ bounds.x+ bounds.width)/Tile.TILEHEIGHT,ty)){
                y += yMove;
            }else{
                y= ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }
    protected boolean collisionWithSolidObject(int x, int y){
        return handler. getWorld().getTile(x,y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
