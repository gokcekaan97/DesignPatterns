import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Singleton{
	private static Singleton uniqueInstance;
	public Singleton(){
		
	}
	public static Singleton getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new Singleton();
		}
		return uniqueInstance;
	}
	public Connection getConnection() {
        Connection dbConnection= null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection=DriverManager.getConnection("jdbc:sqlite:Cattle.db");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dbConnection;
    }
	public void addCattle(Cattle cattle){
		Connection conn =null;
		PreparedStatement statement=null;
		String query="INSERT INTO Cattle (CattleName) VALUES (?)";
		try {
			conn=getConnection();
			statement=conn.prepareStatement(query);
			statement.setString(1, cattle.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setCattleLocation(ElectronicDevice electronicDevice){
		Connection conn =null;
		Statement statement=null;
		String query="UPDATE Cattle SET Location= ('"+electronicDevice.getLocation()+"') WHERE CattleName=('"+electronicDevice.getCattle().getName()+"')";
		try {
			conn=getConnection();
			statement=conn.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}