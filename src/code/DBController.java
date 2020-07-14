package code;

import java.sql.Connection;

import java.sql.DriverManager;

public class DBController {
static final String URL = "jdbc:postgresql://localhost:5432/postgres";

//  Database credentials
private final static String user = "postgres";
private final static String password = "7BUG.4GLCH";
private static DBController instance = new DBController();
  /* public static Connection DB_Connection() {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection(URL,user, password);
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println("Database connecction failed");
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return c;
   }*/
   private DBController(){
 
   }
   public static Connection getConnection() {
	      Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection(URL,user, password);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println("Database connecction failed");
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return c;
	   }

	public static DBController getInstance(){
		return instance;
	}
}
