package ex_1;
import java.sql.*;
public class ex_db {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动  
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // 连接服务器和数据库  
        String userName = "sa"; // 默认用户名  
        String userPwd = "123456"; // 密码  
        Connection dbConn;  
 
        try {  
        Class.forName(driverName);  
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
        Class.forName(driverName);  
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("Connection Successful!"); // 如果连接成功  
        // 控制台输出Connection  
        // Successful!  
        } catch (Exception e) {  
        e.printStackTrace();  
        }  */
	}
	// 声明JDBC objects.  
	Connection con = null;    
    Statement stmt = null;    
    ResultSet rs = null; 
	public ex_db()
	{
		String urlserver = "jdbc:sqlserver://localhost:1433;DatabaseName=test";//sqlserver身份连接
   
        try 
        {    
            con = DriverManager.getConnection(urlserver ,"sa","123456");

            // 建立连接    
            System.out.println("准备连接！！！");    
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
       //     con = DriverManager.getConnection(urlserver);    
            
            System.out.println("连接成功！！！");    
    
            // 写一个sql语句，并执行返回数据 
    /*        String SQL = "SELECT * FROM test";    
            stmt = con.createStatement();    
            rs = stmt.executeQuery(SQL);    
    
            //将数据显示出来
            while (rs.next())
            {    
                System.out.println(rs.getString(2));    
            }    */
        }    
        catch (Exception e) 
        {    
            e.printStackTrace();    
        }     
        finally 
        {    
            if (rs != null)    
                try 
                {    
                    rs.close();    
                }
                catch (Exception e)
                {    
                }    
            if (stmt != null)    
                try 
                {    
                    stmt.close();    
                }
                catch (Exception e) 
                {    
                }    
            if (con != null)    
                try
                {    
                    con.close();    
                } 
                catch (Exception e)
                {    
                }    
        }    

	}

}
