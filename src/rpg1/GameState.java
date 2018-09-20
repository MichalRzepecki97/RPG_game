package rpg1;


import rpg1.entities.Player;
import rpg1.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;


    public GameState(Game game ) {
        super(game);
        player = new Player(game,100,100);
    }

    @Override
    public void tick() {

        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        Tile.tiles[0].render(g,0,0);
    }
}
