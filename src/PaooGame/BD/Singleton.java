package PaooGame.BD;
import java.sql.*;

public class Singleton {

    private static Singleton single_instance = null;
    private Connection connection = null;
    public String s;


    private Singleton() {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:score1.db");
            stmt = connection.createStatement();

          /*  String sql = "CREATE TABLE SCORE (player_score INT NOT NULL, health INT NOT NULL, getX FLOAT NOT NULL, getY FLOAT NOT NULL, enemy INT NOT NULL)";
            stmt.execute(sql);*/

        } catch (Exception exception){
            System.out.println(exception);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}