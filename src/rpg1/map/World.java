package rpg1.map;

import rpg1.Handler;
import rpg1.entities.Menager;
import rpg1.entities.moving.Player;
import rpg1.entities.statics.Wood;
import rpg1.tiles.Tile;
import rpg1.utils.Utils;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    //Menago
    private Menager menager;

    public Menager getMenager() {
        return menager;
    }

    public void setMenager(Menager menager) {
        this.menager = menager;
    }

    public World(Handler handler, String path){
        this.handler = handler;
        menager = new Menager(handler,new Player(handler,500,500));
        menager.addEntityToList(new Wood(handler,100,200));
        loadWorld(path);

        menager.getPlayer().setX(spawnX);
        menager.getPlayer().setY(spawnY);
    }
    
    public void tick(){
        menager.tick();
        
    }
    public void render(Graphics g){
        //renderowanie tego co aktualnie jest na ekranie
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int)Math.min(width,(handler.getGameCamera().getxOffset()+ handler.getWidth()) / Tile.TILEWIDTH+1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int)Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight()) / Tile.TILEHEIGHT+1);

        for (int y = yStart; y <yEnd ; y++) {
            for (int x = xStart; x <xEnd ; x++) {
                getTile(x,y).render(g,(int) (x *Tile.TILEWIDTH - handler.getGameCamera().getxOffset())
                                     ,(int )(y* Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Obiekty
        menager.render(g);
    }
    public Tile getTile(int x, int y){
       //renderwoanie poza mapa
        if(x<0 || y<0 || x >= width || y >= height)
            return Tile.grassTile;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
