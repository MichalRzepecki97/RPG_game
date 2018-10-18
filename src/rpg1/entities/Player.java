package rpg1.entities;

import rpg1.Handler;
import rpg1.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(Handler handler, float x, float y){
        super(handler,x, y,Creature.DEFAULT_CREATURE_HEIGHT,Creature.DEFAULT_CREATURE_WIDTH);

        bounds.x =40;
        bounds.y = 40;
        bounds.height = 50;
        bounds.width = 40;

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
        g.drawImage(Assets.hero,(int)(x - handler.getGameCamera().getxOffset()),
                                  (int)(y - handler.getGameCamera().getyOffset()), width, height,null);//konwersja do int
   // g.setColor (Color.RED);
    //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
      //  (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
        //bounds.width,bounds.height);*/
    
    }
}
