package ex4_3;
import java.sql.*;
public class mysql {
	public static void main(String arg[])
	{
		
		private Connection conn = null;
		private PreparedStatement psmt = null;
		protected ResultSet rs = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			dbURL = "jdbc:mysql://localhost:3306";
			conn = DriverManager.getConnection(dbURL,username,"admin");
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("use test");
			
		/*	stmt.executeUpdate("CREATE TABLE  student ("
					+ "snum int(10) NOT NULL AUTO_INCREMENT,"
					+ "sname varchar(20) DEFAULT NULL,"
					+ "sdate VARCHAR(20) DEFAULT NULL,"
					+ "ssex varchar(4) DEFAULT NULL,"
					+ "scollege VARCHAR(20) DEFAULT NULL,"
					+ "smajor VARCHAR(20) DEFAULT NULL,"
					+ "sclass VARCHAR(16) DEFAULT NULL,"
					+"shome VARCHAR(30) DEFAULT NULL,"
					+"shometel VARCHAR(11) DEFAULT NULL,"
					+"stel VARCHAR(11) DEFAULT NULL,"  
					+"PRIMARY KEY (snum))");
			
		*/
			
		//	for(int fla=0; fla <10; fla ++) //数据库初始化
		//	{
		//		stmt.executeUpdate("insert into student values('"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"','"+fla+"')");
		//	}
			
		//	ResultSet rs = stmt.executeQuery("select * from student");  //数据库显示部分数据
			
		/*		while(rs.next())
			{
				String snum = rs.getString("snum");
				String sname = rs.getString("sname");
				
				System.out.println("num:" + snum + "name:" + sname);
			}*/
			System.out.println("表student创建成功");
			stmt.close();
		}
		catch(ClassNotFoundException e){
			System.out.println("database driver not found");
		}
		catch(SQLException e)
		{
			System.out.println("ERROR opening the db connection:" + e.getMessage());
		}
	}
}

