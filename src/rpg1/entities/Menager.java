package rpg1.entities;

import rpg1.Handler;
import rpg1.entities.moving.Player;

import java.awt.*;
import java.util.ArrayList;

public class Menager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;


    public Menager(Handler handler,Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntityToList(player);

    }
    public void tick(){
        for (int i = 0; i <entities.size() ; i++) {
            Entity entity = entities.get(i);
            entity.tick();
        }
    }
    public void render(Graphics g){

        for (Entity entity : entities){
         entity.render(g);
        }
    }

    public void addEntityToList(Entity entity){
        entities.add(entity);
    }
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
