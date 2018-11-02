package rpg1;



import rpg1.entities.Player;
import rpg1.entities.statics.Wood;
import rpg1.map.World;
import rpg1.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private World world;



    public GameState(Handler handler ) {
        super(handler);
        //zmiana widoku kamery
        world= new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        Tile.tiles[2].render(g,0,0);
    }
}
