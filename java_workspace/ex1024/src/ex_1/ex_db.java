package ex_1;
import java.sql.*;
public class ex_db {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����  
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // ���ӷ����������ݿ�  
        String userName = "sa"; // Ĭ���û���  
        String userPwd = "123456"; // ����  
        Connection dbConn;  
 
        try {  
        Class.forName(driverName);  
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
        Class.forName(driverName);  
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
        System.out.println("Connection Successful!"); // ������ӳɹ�  
        // ����̨���Connection  
        // Successful!  
        } catch (Exception e) {  
        e.printStackTrace();  
        }  */
	}
	// ����JDBC objects.  
	Connection con = null;    
    Statement stmt = null;    
    ResultSet rs = null; 
	public ex_db()
	{
		String urlserver = "jdbc:sqlserver://localhost:1433;DatabaseName=test";//sqlserver�������
   
        try 
        {    
            con = DriverManager.getConnection(urlserver ,"sa","123456");

            // ��������    
            System.out.println("׼�����ӣ�����");    
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
       //     con = DriverManager.getConnection(urlserver);    
            
            System.out.println("���ӳɹ�������");    
    
            // дһ��sql��䣬��ִ�з������� 
    /*        String SQL = "SELECT * FROM test";    
            stmt = con.createStatement();    
            rs = stmt.executeQuery(SQL);    
    
            //��������ʾ����
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
