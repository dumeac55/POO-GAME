package PaooGame.Bullet;

import PaooGame.Audio.Audio;
import PaooGame.Graphics.Handler;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class BulletManager {
    private LinkedList<Bullet> b = new LinkedList<Bullet>();
    Handler handler;
    Audio audio;

    public BulletManager(Handler handler){
        this.handler = handler;
    }

    public void Update(){
        Iterator<Bullet> it = b.iterator();
        while(it.hasNext()){
            Bullet b1=it.next();
            b1.Update();
            if(!b1.isActive()){
                b1.die();
                it.remove();
            }
        }
        for (int i = 0; i < b.size(); i++){
            b.get(i).Update();
        }
    }

    public void Draw(Graphics g){
        for (int i = 0; i < b.size(); i++){
            b.get(i).Draw(g);
        }
    }

    public void addBullet(Bullet block){
        b.add(block);
    }

    public void removeBullet(Bullet block){
        b.remove(block);
    }
    public LinkedList<Bullet> getBullets() {
        return b;
    }
}
