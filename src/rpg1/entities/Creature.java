package rpg1.entities;

import rpg1.Game;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH =20;
    public static final float DEFAULT_SPEED = 5.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 100,
                            DEFAULT_CREATURE_HEIGHT = 150;


    protected int health;
    protected float moveSpeed;
    protected float xMove,yMove;

    public Creature(Game game,float x, float y, int width, int height) {
        super(game, x, y,width,height);
        health = DEFAULT_HEALTH;
        moveSpeed = DEFAULT_SPEED;
    }

    public void move(){
        x += xMove;
        y += yMove;
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
