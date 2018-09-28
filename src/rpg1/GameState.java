package rpg1;



import rpg1.entities.Player;
import rpg1.tiles.Tile;
import world.Map;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private Map map;


    public GameState(Game game ) {
        super(game);
        player = new Player(game,100,100);
        map = new Map("");
    }

    @Override
    public void tick() {
        map.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        player.render(g);
        Tile.tiles[2].render(g,0,0);
    }
}
