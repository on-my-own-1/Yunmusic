package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginCheck3 implements ActionListener{//找回密码
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null;
	    
	    String QQ=Interface1.textArea_4.getText();
		
		sql = "select *from ap";//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象
	        
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集  
	            while (ret.next()) {  
	                String uid = ret.getString(3);  
	                String ufname = ret.getString(2); 
	                if(uid.equals(QQ))//相与比较
	                {
	                	Interface1.lblNewLabel_6.setText("密码："+ufname);
	                	break;
	                }
	                else {
	                	Interface1.lblNewLabel_6.setText("无此账号，请确定账号已注册");
	                }
	            }//显示数据  
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        } 
}
}
