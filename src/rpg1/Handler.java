package rpg1;

import rpg1.controls.KeyMenager;
import rpg1.gfx.GameCamera;
import rpg1.map.World;

public class Handler {
    private Game game;
    private World world;


    public Handler(Game game) {
        this.game = game;
    }
    public int getWidth(){
        return game.getWidth();
    }
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public KeyMenager getKeyMenager(){
        return game.getKeyMenager();
    }
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}