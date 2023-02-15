package PaooGame.Word;

import PaooGame.AnimationManager.AnimationManager;
import PaooGame.Bullet.BulletManager;
import PaooGame.Entity.*;
import PaooGame.Game;
import PaooGame.Graphics.Handler;
import PaooGame.Item.Item;
import PaooGame.Item.ItemManager;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;

public class Word {
    private Handler handler;
    private int width, heigth;
    private int spawnX, spawnY;
    private int[][] tiles;
    private BulletManager bulletManager;
    private EntityManager entityManager;
    private AnimationManager animationManager;
    private ItemManager itemManager;
    private int flag;
    public AnimationManager getAnimationManager() {
        return animationManager;
    }

    public BulletManager getBulletManager() {
        return bulletManager;
    }

    public Word(Handler handler, String path, int number) {
        this.handler = handler;
        bulletManager = new BulletManager(handler);
        entityManager = new EntityManager(handler);
        animationManager = new AnimationManager(handler);
        itemManager = new ItemManager(handler);
        flag=0;
        switch (number) {
            case 1:
                entityManager.addEntity(new Treee(handler, 72, 64));
                entityManager.addEntity(new Treee(handler, 148, 64));
                entityManager.addEntity(new Castel(handler, 72, 136));
                entityManager.addEntity(new Treee(handler, 148, 136));
                entityManager.addEntity(new Treee(handler, 220, 136));
                entityManager.addEntity(new Treee(handler, 220, 64));
                entityManager.addEntity(new Treee(handler, 404, 64));
                entityManager.addEntity(new Castel(handler, 478, 64));
                entityManager.addEntity(new Castel(handler, 581, 64));
                entityManager.addEntity(new Treee(handler, 1010, 280));
                entityManager.addEntity(new Treee(handler, 1010, 352));
                entityManager.addEntity(new Treee(handler, 330, 600));
                entityManager.addEntity(new Treee(handler, 330, 672));
                entityManager.addEntity(new Treee(handler, 330, 528));
                entityManager.addEntity(new Treee(handler, 402, 528));
                itemManager.addItem(new Item(handler,422,620,2));
                entityManager.addEntity(new Treee(handler, 402, 672));
                entityManager.addEntity(new Treee(handler, 474, 528));
                entityManager.addEntity(new Treee(handler, 474, 600));
                entityManager.addEntity(new Treee(handler, 474, 672));
                entityManager.addEntity(new Treee(handler, 1000, 72));
                entityManager.addEntity(new Castel(handler, 1073, 72));
                entityManager.addEntity(new Enemy(handler,325,300,64,64,1));
                entityManager.addEntity(new Enemy(handler, 81, 1100,64,64,2));
                entityManager.addEntity(new Enemy(handler, 225, 500,64,64,3));
                entityManager.addEntity(new Enemy(handler,800,500,64,64,3));
                entityManager.addEntity(new Enemy(handler, 900, 1100,64,64,4));
                entityManager.addEntity(new Enemy(handler, 144, 800,64,64,5));
                itemManager.addItem(new Item(handler,550,460,2));
                itemManager.addItem(new Item(handler,550,490,2));
                itemManager.addItem(new Item(handler,550,520,2));
                itemManager.addItem(new Item(handler,550,570,2));
                itemManager.addItem(new Item(handler,590,460,1));
                itemManager.addItem(new Item(handler,590,490,0));
                itemManager.addItem(new Item(handler,590,520,1));
                itemManager.addItem(new Item(handler,590,570,0));
                break;
            case 2:
                entityManager.addEntity(new Enemy(handler,300,300,64,64,1));
                entityManager.addEntity(new Enemy(handler, 900, 1100,64,64,4));
                entityManager.addEntity(new Enemy(handler, 144, 800,64,64,5));
                break;
        }
        loadWorld(path);

    }

    private void loadWorld(String path){

        String file= Utils.loadFile(path);
        String tokens[]=file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        heigth=Utils.parseInt(tokens[1]);
        spawnX=Utils.parseInt(tokens[2]);
        spawnY=Utils.parseInt(tokens[3]);
        tiles=new int[width][heigth];
        for(int i=0;i<heigth;i++){
            for(int j=0;j<width;j++){
                tiles[i][j]=Utils.parseInt(tokens[(i+j*width)+4]);
            }
        }
    }
    public void Update(){
        entityManager.Update();
        bulletManager.Update();
        animationManager.Update();
        itemManager.Update();
        if(flag==0) {
            if (handler.getWorld().getEntityManager().getCounter() == 3) {
                entityManager.addEntity(new Enemy(handler, 300, 300, 64, 64, 1));
                entityManager.addEntity(new Enemy(handler, 900, 1100, 64, 64, 4));
                entityManager.addEntity(new Enemy(handler, 144, 800, 64, 64, 5));
                entityManager.addEntity(new Enemy(handler,400,300,64,64,1));
                entityManager.addEntity(new Enemy(handler, 900, 240,64,64,4));
                entityManager.addEntity(new Enemy(handler, 500, 240,64,64,5));
                flag = 1;
            }
        }
    }
    public void Draw(Graphics g){
        for(int i=0;i<width;i++) {
            for (int j = 0; j < heigth; j++) {
                getTile(i,j).Draw(g,(int)(i*Tile.TILE_WIDTH-handler.getGameCamera().getxOffset()),(int) (j*Tile.TILE_HEIGHT-handler.getGameCamera().getyOffset()));
            }
        }
        bulletManager.Draw(g);
        entityManager.Draw(g);
        animationManager.Draw(g);
        itemManager.Draw(g);
    }
    public Tile getTile(int i, int j){

        if(i<0 || j<0 || i>=width || j>=heigth)
            return Tile.grassTile;

        Tile t=Tile.tiles[tiles[i][j]];
        if(t==null)
            return Tile.grassTile;
        return t;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return heigth;
    }
    public EntityManager getEntityManager(){return entityManager;}
    public ItemManager getItemManager(){return itemManager;}
}