package PaooGame.Item;


import PaooGame.Graphics.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler){
        this.handler = handler;
        this.items = new ArrayList<Item>();
    }

    public void Update(){

        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            i.Update();
            if (i.isPickedUp()){
                it.remove();
            }
        }
    }

    public void Draw(Graphics g){
        for (Item i : items){
            i.Draw(g);
        }
    }

    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
