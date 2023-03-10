package PaooGame.Entity;



import PaooGame.Bullet.Bullet;
import PaooGame.Graphics.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private int counter=0;
    public int getCounter() {
        return counter;
    }
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override
        public int compare(Entity a, Entity b){
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()){
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(Handler handler){
        this.handler = handler;
        entities = new ArrayList<Entity>();
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

    public void Update() {
        Iterator<Entity> it = entities.iterator();

        while (it.hasNext()) {
            Entity e = it.next();
            e.Update();
            if (!e.isActive()) {
                it.remove();
                if(e instanceof Enemy){
                    counter--;
                }
            }
        }
        entities.sort(renderSorter);
    }
    public void Draw(Graphics g){
        for (Entity e : entities){
            e.Draw(g);
        }
        //player.Draw(g);
    }
    public void addEntity(Entity e){
        if ((e instanceof Enemy)){
            counter++;
        }
        entities.add(e);
    }

}
