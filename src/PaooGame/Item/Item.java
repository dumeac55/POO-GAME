package PaooGame.Item;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Item {
    public static Item[] items = new Item[256];
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected int x, y;
    private BufferedImage currentimage;
    public boolean pickedUp;
    int ID;

    protected Rectangle bounds;

    public Item(Handler handler, int x, int y, int id) {
        this.ID=id;
        this.x=x;
        this.y=y;
        this.handler=handler;
        pickedUp=false;
        bounds = new Rectangle(x, y, 32, 32);
        switch (ID){
            case 0:
                currentimage=Assets.tree_chest;
                break;
            case 1:
                currentimage=Assets.ice_chest;
                break;
            case 2:
                currentimage=Assets.purple_chest;
                break;
        }
    }
    public void Update() {
        switch (ID){
            case 0:
                if (handler.getGame().getGameState().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
                    handler.getGame().getGameState().getPlayer().AddPoints(2);
                    handler.getGame().getGameState().getPlayer().addhealth(10);
                    pickedUp = true;
                }
                break;
            case 1:
                if (handler.getGame().getGameState().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
                    handler.getGame().getGameState().getPlayer().AddPoints(6);
                    handler.getGame().getGameState().getPlayer().addhealth(40);
                    pickedUp = true;
                }
                break;
            case 2:
                if (handler.getGame().getGameState().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
                    handler.getGame().getGameState().getPlayer().AddPoints(10);
                    handler.getGame().getGameState().getPlayer().addhealth(20);
                    pickedUp = true;
                    if(handler.getGame().getGameState().getPlayer().getUpgrade_level()==0) {
                        Random a = new Random();
                        int n = a.nextInt(100);
                        if (n < 50) {
                            handler.getGame().getGameState().getPlayer().setUpgrade_level(1);
                        }
                    }
                }
                break;
        }
    }

    public void Draw(Graphics g){
        g.drawImage(currentimage,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 32, 32, null);
    }


    //--------Getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public boolean isPickedUp() {
        return pickedUp;
    }
}