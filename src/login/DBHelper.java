package login;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;

public class DBHelper {
    public static final String url = "jdbc:mysql://localhost:3306/lp?serverTimezone=UTC";  
    public static final String name = "com.mysql.cj.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "2002123";  
 
    public Connection conn = null;  
    public PreparedStatement pst = null;  
 
    public DBHelper(String sql) {  
        try {  
            Class.forName(name);//ָ����������  
            conn = DriverManager.getConnection(url,user,password);//��ȡ����  
            pst = conn.prepareStatement(sql);//׼��ִ�����  
            pst.execute();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
 
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
}
