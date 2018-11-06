package rpg1.entities.moving;

import rpg1.Handler;
import rpg1.entities.moving.Creature;
import rpg1.gfx.Animation;
import rpg1.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation animationDown,animationUp,animationRight,animationLeft,animationStay;

    public Player(Handler handler, float x, float y){
        super(handler,x, y,Creature.DEFAULT_CREATURE_HEIGHT,Creature.DEFAULT_CREATURE_WIDTH);

     //długość animiacji
        animationDown = new Animation(500,Assets.heroAnimationDown);
        animationUp = new Animation(500,Assets.heroAnimationUp);
        animationLeft = new Animation(200,Assets.heroAnimationLeft);
        animationRight = new Animation(200,Assets.heroAnimationRight);
        //dokonczyc
        //animationStay = new Animation(500,Assets.stayAnimation);
    }


    @Override
    public void tick() {
      /*  if (game.getKeyMenager().up)
            y -= 3;
        if (game.getKeyMenager().down)
            y += 3;
        if (game.getKeyMenager().left)
            x -= 3;
        if (game.getKeyMenager().right)
            x += 3;*/
      animationDown.tick();
      animationUp.tick();
      animationLeft.tick();
      animationRight.tick();
      getInput();
      move();
      handler.getGameCamera().centerOnEntity(this);
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(handler.getKeyMenager().up)
            yMove= -moveSpeed;
        if(handler.getKeyMenager().down)
            yMove= moveSpeed;
        if(handler.getKeyMenager().left)
            xMove= -moveSpeed;
        if(handler.getKeyMenager().right)
            xMove= moveSpeed;

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(CurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),
                                  (int)(y - handler.getGameCamera().getyOffset()), width, height,null);//konwersja do int
   // g.setColor (Color.RED);
    //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
      //  (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
        //bounds.width,bounds.height);*/
    
    }
    private BufferedImage CurrentAnimationFrame(){
      if (xMove<0){
          return animationLeft.CurrentFrame();
       }else if (xMove>0){
          return animationRight.CurrentFrame();
       }else if (yMove<0){
          return animationUp.CurrentFrame();
       }else{
          return animationDown.CurrentFrame();
      }//TODO
    }


}
