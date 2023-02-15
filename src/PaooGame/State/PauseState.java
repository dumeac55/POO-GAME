package PaooGame.State;
import java.sql.*;

import PaooGame.BD.Singleton;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.Handler;

import java.awt.*;

import static java.lang.System.exit;

public class PauseState extends State{
    public PauseState(Handler handler) {
        super(handler);
    }
    Singleton dbConnection = Singleton.getInstance();

    @Override
    public void Update() throws SQLException {
        if( handler.getMouseManager().getMouseX()>=277 && handler.getMouseManager().getMouseX()<=387){
            if( handler.getMouseManager().getMouseY()>=325 && handler.getMouseManager().getMouseY()<=470){
                if(handler.getMouseManager().isLeftPressed()){
                    State.setState(handler.getGame().getGameState());
                }
            }
        }
        if( handler.getMouseManager().getMouseX()>=314 && handler.getMouseManager().getMouseX()<=382) {
            if (handler.getMouseManager().getMouseY() >= 422 && handler.getMouseManager().getMouseY() <= 474) {
                if (handler.getMouseManager().isLeftPressed()) {
                    int score = handler.getGame().getGameState().getPlayer().getPoints();
                    int health=handler.getGame().getGameState().getPlayer().getHealth();
                    float getx=handler.getGame().getGameState().getPlayer().getX();
                    float gety=handler.getGame().getGameState().getPlayer().getY();
                    int enemy=handler.getWorld().getEntityManager().getCounter();
                    insertScoreIntoDB(score,health,getx,gety,enemy);
                   exit(0);
                }
            }
        }
    }

    public void insertScoreIntoDB(int score,int health, float getx, float gety, int enemy) throws SQLException {
        Statement stmt = null;
        Connection connection = dbConnection.getConnection();
        stmt = connection.createStatement();
        String query = "INSERT INTO SCORE VALUES(?,?,?,?,?)";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, score);

        pstmt.setInt(2, health);

        pstmt.setFloat(3, getx);

        pstmt.setFloat(4, gety);

        pstmt.setInt(5,enemy);
        pstmt.executeUpdate();

    }


    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.Pause,0,0,700,700,null);
    }
}
