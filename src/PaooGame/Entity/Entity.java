package PaooGame.Entity;

import PaooGame.Bullet.Bullet;
import PaooGame.Game;
import PaooGame.Graphics.Handler;

import java.awt.*;

public abstract class Entity {
    protected float x, y;
    protected Handler handler;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean active=true;
    protected int health;
    private int flag=0;
    public Entity(Handler handler,float x, float y, int width,int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        active=true;
        bounds=new Rectangle(0,0,width,height);
    }
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e : handler.getWorld().getEntityManager().getEntities()){
            if (e.equals(this)){
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }
        return false;
    }

    public void hurt(int amount) {
        if (health > 0 ) {
            health -= amount;
            if (health <= 0) {
                //active = false;
                die();
            }
        }
    }
    public abstract void die();

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void Update();
    public abstract void Draw(Graphics g);
}
