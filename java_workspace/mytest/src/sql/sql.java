package sql;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class sql {
	
	
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String mysql="";
		
		String driver =" com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/webpro";
		String mysqluser ="root";
		String mysqlpwd = "828521";
		
		try {
			Class.forName(driver);//1.��������
			conn = DriverManager.getConnection(url, mysqluser,mysqlpwd);//2.��ȡ����
		} catch (ClassNotFoundException | SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			psmt = conn.prepareStatement(mysql);
			psmt.setString(0, "String");
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//int num = psmt.executeUpdate();
		//�ж���Ӱ������
		//if(num > 0){
		//	updateRs = true;
	    //	}
		
	}

	
}
