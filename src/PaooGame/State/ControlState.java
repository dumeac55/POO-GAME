package PaooGame.State;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;

import java.awt.*;

public class ControlState extends State{
    public ControlState(Handler handler) {
        super(handler);
    }

    @Override
    public void Update() {
        if( handler.getMouseManager().getMouseX()>=303 && handler.getMouseManager().getMouseX()<=394){
            if( handler.getMouseManager().getMouseY()>=634 && handler.getMouseManager().getMouseY()<=674){
                if(handler.getMouseManager().isLeftPressed()){
                    State.setState(handler.getGame().getOptState());
                }
            }
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.Controls,0,0,700,700,null);
    }

}
