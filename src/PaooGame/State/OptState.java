package PaooGame.State;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;

import java.awt.*;

public class OptState extends State{
    public OptState(Handler handler) {
        super(handler);
    }

    @Override
    public void Update() {
        if( handler.getMouseManager().getMouseX()>=268 && handler.getMouseManager().getMouseX()<=430){
            if( handler.getMouseManager().getMouseY()>=214 && handler.getMouseManager().getMouseY()<=265){
                if(handler.getMouseManager().isLeftPressed()){
                    State.setState(handler.getGame().getControlState());
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=301 && handler.getMouseManager().getMouseX()<=397) {
            if (handler.getMouseManager().getMouseY() >= 506 && handler.getMouseManager().getMouseY() <= 554) {
                if (handler.getMouseManager().isLeftPressed()) {
                    State.setState(handler.getGame().getMenuState());
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=342 && handler.getMouseManager().getMouseX()<=403) {
            if (handler.getMouseManager().getMouseY() >= 314 && handler.getMouseManager().getMouseY() <= 360) {
                if (handler.getMouseManager().isLeftPressed()) {
                   handler.getGame().getAudio().play();
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=428 && handler.getMouseManager().getMouseX()<=494) {
            if (handler.getMouseManager().getMouseY() >= 314 && handler.getMouseManager().getMouseY() <= 360) {
                if (handler.getMouseManager().isLeftPressed()) {
                    handler.getGame().getAudio().stop();
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=354 && handler.getMouseManager().getMouseX()<=398) {
            if (handler.getMouseManager().getMouseY() >= 410 && handler.getMouseManager().getMouseY() <= 454) {
                if (handler.getMouseManager().isLeftPressed()) {
                   handler.getGame().getGameState().getPlayer().getAudio().play();
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=425 && handler.getMouseManager().getMouseX()<=490) {
            if (handler.getMouseManager().getMouseY() >= 408 && handler.getMouseManager().getMouseY() <= 457) {
                if (handler.getMouseManager().isLeftPressed()) {
                    handler.getGame().getGameState().getPlayer().getAudio().stop();
                }
            }
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.Setings,0,0,700,700,null);
    }

}
