package rpg1.map;

import rpg1.tiles.Tile;
import rpg1.utils.Utils;

import java.awt.*;

public class World {
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    
    public World(String path){
        loadWorld(path);
    }
    
    public void tick(){
        
    }
    public void render(Graphics g){

        for (int y = 0; y <height ; y++) {
            for (int x = 0; x <width ; x++) {
                getTile(x,y).render(g,x *Tile.TILEWIDTH,y* Tile.TILEHEIGHT);
            }
        }
    }
    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.dirtTile;
        return  t;

    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String [] tokens  = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        tiles = new int [width][height];
        for (int y = 0; y <height ; y++) {
            for (int x = 0; x <width ; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }
}
