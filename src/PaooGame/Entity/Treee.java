package PaooGame.Entity;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import PaooGame.Item.Item;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Treee extends Entity2{
    protected BufferedImage image;
    public Treee(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
        this.health=50;
        this.image = Assets.tree;
    }

    @Override
    public void Update() {

    }
    @Override
    public void die() {
        Random rand = new Random();
        int n = rand.nextInt(100);
        if (n < 15) {
            handler.getWorld().getItemManager().addItem(new Item(handler,(int) x, (int) y,1));
        } else if (n < 30) {
            handler.getWorld().getItemManager().addItem(new Item(handler,(int) x, (int) y,2));
        } else if (n < 40) {
            handler.getWorld().getItemManager().addItem(new Item(handler,(int) x, (int) y,3));
        }
    }

    @Override
    public void hurt(int amount){
        if (health > 0) {
            health -= amount;
            if (health <= 0) {
                die();
               handler.getGame().getGameState().getPlayer().AddPoints(30);
               active=false;

            }
        }
    }
    @Override
    public void Draw(Graphics g) {
        g.drawImage(this.image, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
