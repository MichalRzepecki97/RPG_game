package rpg1.entities;

import rpg1.Game;
import rpg1.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    private Game game;

    public Player(Game game,float x, float y){
        super(x, y,Creature.DEFAULT_CREATURE_HEIGHT,Creature.DEFAULT_CREATURE_WIDTH);
        this. game = game;
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
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(game.getKeyMenager().up)
            yMove= -moveSpeed;
        if(game.getKeyMenager().down)
            yMove= moveSpeed;
        if(game.getKeyMenager().left)
            xMove= -moveSpeed;
        if(game.getKeyMenager().right)
            xMove= moveSpeed;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player,(int)x, (int)y, width, height,null);//konwersja do int
    }
}
