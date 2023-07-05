import java.sql.*;

public class DataCenter {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    DataCenter(){
        try{
            String url = "jdbc:mysql://localhost:3306/dodgeup";
            connection = DriverManager.getConnection(url, "root", "19451945");
            statement = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }

    }

    //@Mm12345678

    public static void loadHighScore(){
        try {
            resultSet = statement.executeQuery("select * from highscore");
            while (resultSet.next()) {
                Main.highScore = resultSet.getInt(1);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void saveHighScore(int score){
        try {
            if (score > Main.highScore) {
                PreparedStatement ps = connection.prepareStatement("update highscore set highScore = ?");
                ps.setInt(1, score);
                ps.executeUpdate();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
