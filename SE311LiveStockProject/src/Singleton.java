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
		Connection conn2 = null;
		Statement statement=null;
		Statement statement2=null;
		String query1 = "SELECT CattleName FROM Cattle WHERE CattleName=('"+cattle.getName()+"')";
		try {
			conn2 = getConnection();
			statement2 = conn2.createStatement();
			ResultSet rs = statement2.executeQuery(query1);
			if (!rs.next()) {
				String query = "INSERT INTO Cattle (CattleName) VALUES ('" + cattle.getName() + "')";
				try {
					conn = getConnection();
					statement = conn.createStatement();
					statement.execute(query);
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			conn2.close();
		} catch (Exception e) {
			// TODO: handle exception
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
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}