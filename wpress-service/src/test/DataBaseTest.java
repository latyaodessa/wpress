package test;

import org.junit.Test;

import wpress.core.db.MySQLAccess;

public class DataBaseTest {
	@Test
	public void checkConnection(){
		MySQLAccess sql = new MySQLAccess();
		sql.initMySqlClient();
		sql.execQuery("SELECT * FROM tem_posts");
	}
}
