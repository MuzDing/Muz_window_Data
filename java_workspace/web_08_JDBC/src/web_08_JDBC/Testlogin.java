package web_08_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.junit.Test;

public class Testlogin {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void Testlogin() {
		try {
			login("muZ","admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void login(String uname,String pword) throws SQLException, ClassNotFoundException {

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from tbl_user where uname=? and upassword=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			ResultSet rs = pstmt.executeQuery();    
			
			if(rs.next()) {
				System.out.println("111");
			}else {
				System.out.println("222");
			}
			conn.close();
			pstmt.close();
			rs.close();
			
	}
}
