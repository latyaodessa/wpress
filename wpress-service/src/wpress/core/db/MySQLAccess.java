package wpress.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MySQLAccess {
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;
	public static final Logger LOG = Logger.getLogger(MySQLAccess.class.getName());

     
     @PostConstruct
     public void initMySqlClient(){
    	 try {
    		 connection =
    		       DriverManager.getConnection("jdbc:mysql://localhost:4949/tempa_dev?" +
    		                                   "user=test&password=test&serverTimezone=UTC");
    	 } catch (SQLException e) {
                LOG.info(String.format("SQLException: ", e));
    		}
     }
     
     public ResultSet execQuery(final String query){
		 try {
			stmt = connection.createStatement();
		    rs = stmt.executeQuery(query);
		    return rs;
		} catch (SQLException e) {
            LOG.info(String.format("UNABLE TO EXECUTE QUERY: ", e));
		}
		 return null;
     }
     

@PreDestroy
private void close() {
         try {
                 if (connection != null) {
                	 connection.close();
                 }

                 if (stmt != null) {
                	 stmt.close();
                 }

                 if (rs != null) {
                	 rs.close();
                 }
         } catch (Exception e) {
             LOG.info(String.format("CLOSE DB CONNECTION: ", e));
         }
 }
}
