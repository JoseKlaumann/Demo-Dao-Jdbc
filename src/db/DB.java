package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	//M�todo para fazer a conex�o com o banco	
	public static Connection getConnecion() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	//M�todo para fechar o banco de dados e tratar as exce��es
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} 
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} 
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

   /*Est� sendo implementado aqui para o c�digo pricipal ficar
    * mais limpo, cada fun��o ficar no seu devido lugar 
    * e assim poder tratar como uma RuntimeException e n�o 
    * precisar fazer v�rios Try Catch
    */
	
	public static void closeStatement (Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}	
	
	public static void closeResultSet (ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}	
}
