package PaooGame.State;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;

import java.awt.*;

import static java.lang.System.exit;

public class MenuState extends State {
    protected static boolean load=false;
    public MenuState(Handler handler) {
        super(handler);
    }


    @Override
    public void Update() {
        if( handler.getMouseManager().getMouseX()>=306 && handler.getMouseManager().getMouseX()<=400){
            if( handler.getMouseManager().getMouseY()>=289 && handler.getMouseManager().getMouseY()<=314){
                if(handler.getMouseManager().isLeftPressed()){
                    State.setState(handler.getGame().getGameState());
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=314 && handler.getMouseManager().getMouseX()<=382) {
            if (handler.getMouseManager().getMouseY() >= 352 && handler.getMouseManager().getMouseY() <= 374) {
                if (handler.getMouseManager().isLeftPressed()) {
                    State.setState(handler.getGame().getOptState());
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=331 && handler.getMouseManager().getMouseX()<=359) {
            if (handler.getMouseManager().getMouseY() >= 412 && handler.getMouseManager().getMouseY() <= 434) {
                if (handler.getMouseManager().isLeftPressed()) {
                    exit(0);
                }
            }
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.Menu,0,0,700,700,null);
    }
}
