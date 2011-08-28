import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	
    private static String dbUrl;

    static {
        dbUrl = System.getenv("DATABASE_URL");
        dbUrl = dbUrl.replaceAll("postgres://(.*):(.*)@(.*)", "jdbc:postgresql://$3?user=$1&password=$2");
    }

    private static void dbUpdate(String sql) throws SQLException {
        Connection dbConn = null;
        try {
            dbConn = DriverManager.getConnection(dbUrl);
            Statement stmt = dbConn.createStatement();
            stmt.executeUpdate(sql);
        } finally {
            if (dbConn != null) dbConn.close();
        }
    }

    public static void createTable() throws SQLException {
        System.out.println("Creating ticks table.");
        dbUpdate("DROP TABLE IF EXISTS ticks");
        dbUpdate("CREATE TABLE ticks (tick timestamp)");
    }

    
	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException{
		System.out.println(dbUrl);
		
		createTable();
	}

}
