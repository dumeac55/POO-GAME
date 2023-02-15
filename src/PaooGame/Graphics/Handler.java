package PaooGame.Graphics;


import PaooGame.Game;
import PaooGame.GameWindow.GameCamera;
import PaooGame.KeyManager.KeyManager;
import PaooGame.MouseManager.MouseManager;
import PaooGame.Word.Word;

public class Handler {
    private Game game;
    private Word world;

    public Handler(Game game){
        this.game = game;
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHight();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public MouseManager getMouseManager() {return game.getMouseManager();}

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Word getWorld() {
        return world;
    }

    public void setWorld(Word world) {
        this.world = world;
    }


}
