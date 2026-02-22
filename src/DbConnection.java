
import java.sql.*;

public class DbConnection {
    private static Connection connection = null;

    private DbConnection(){};
    public static Connection getConnection(){

        try{
            if(connection==null || connection.isClosed()){

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus_agency", "root", "Rahul@123");
            }
        }catch(Exception e){
            System.out.println("Database Connection failed: "+ e.getMessage());
        }
        return connection;
    }
}
