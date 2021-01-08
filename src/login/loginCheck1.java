package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginCheck1 implements ActionListener {//登录检测账号密码
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null;
	    
	    String zhanghao=Interface1.textArea.getText();
		String mima=Interface1.textArea_1.getText();
		sql = "select *from ap";//SQL语句  
	        db1 = new DBHelper(sql);//创建DBHelper对象
	        
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集  
	            while (ret.next()) {  
	                String uid = ret.getString(1);  
	                String ufname = ret.getString(2); 
	                if(uid.equals(zhanghao)&&ufname.equals(mima)){//相与比较
	                	Interface1.lblNewLabel_3.setText("登录成功");
	                	new Player();break;
	                }
	                else {
	                	
	                	Interface1.lblNewLabel_3.setText("登录失败");
	                }
	            }//显示数据  
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        } 
		
		
		
	}
	}


