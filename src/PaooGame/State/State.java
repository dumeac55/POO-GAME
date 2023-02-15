package PaooGame.State;

import PaooGame.Audio.Audio;
import PaooGame.Entity.Player;
import PaooGame.Game;
import PaooGame.Graphics.Handler;
import PaooGame.Utils.PlayerBar;

import java.awt.*;
import java.sql.SQLException;

public abstract class State {
    protected Handler handler;
    protected Audio audio;
    private static State currentState=null;
    private static Player player;
    private static PlayerBar playerbar;
    private int flag;
    public State(Handler handler){
        this.handler=handler;
    }

    public static void setState(State state){
        currentState=state;
    }
    public static State getState(){
        return currentState;
    }


    public abstract void Update() throws SQLException;
    public abstract void Draw(Graphics g);
    public Audio getAudio() {
        return audio;
    }

    public Player getPlayer() {
        return player;
    }

    protected PlayerBar getPlayerBar() {
        return playerbar;
    }
    public int getflag(){return flag;}
}
