package rpg1;



import rpg1.entities.Player;
import rpg1.map.World;
import rpg1.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;


    public GameState(Game game ) {
        super(game);
        player = new Player(game,100,100);
        world= new World("res/worlds/world1.txt");
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        Tile.tiles[2].render(g,0,0);
    }
}
