import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//The classes and/or objects participating in this pattern are:
//1. Singleton   (Singleton)
//		Defines an Instance operation that lets clients access its unique
//		instance. Instance is a class operation. Responsible for
//		creating and maintaining its own unique instance.
//   	Which provides access to a single database from a uniqueInstance.
public class Singleton{
	private static Singleton uniqueInstance=null;
	private Singleton(){ // Constructor (private).
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
        	System.out.println("No definition for the class with the specified name could be found. (Singleton, getConnection) ");
            e.printStackTrace();
        } catch (SQLException e) {
        	System.out.println("Database access error or other errors. (Singleton, getConnection) ");
            e.printStackTrace();
        }
        return dbConnection;
    }
	//When a cattle is created, stores the cattle's name into the database.
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
					System.out.println("Database access error or other errors. (Singleton, addCattle) ");
				}
			} 
			conn2.close();
		} catch (Exception e) {System.out.println("Any exception from addCattle");}
	}
	//When a cattle is attached to an electronic device,
	//stores the cattle's location into the database.
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
			System.out.println("Database access error or other errors. (Singleton, SetCattleLocation) ");
		}
	}
}