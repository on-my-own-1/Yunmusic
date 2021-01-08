package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginCheck2 implements ActionListener{//注册
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null;
	    
	    String zhanghao=Interface1.textArea_2.getText();
	    String mima=Interface1.textArea_3.getText();
	    String QQ=Interface1.textField_2.getText();
	    int num=0;
	    for(int i=0;i<mima.length();i++){
	    char x=mima.charAt(i);
	    if((x>'a' &&x<'z' )||(x>'A'&&x<'Z') ){
	    num=1;
	    }
	    }
		sql = "select *from ap";//SQL语句  
	    db1 = new DBHelper(sql);//创建DBHelper对象
	        
	        try {  
	            ret = db1.pst.executeQuery();//执行语句，得到结果集
	            while (ret.next()) {  
	                String uid = ret.getString(1);//得到表中第一列数据
	                String uif= ret.getString(3);
	                if(uid.equals(zhanghao)||uif.equals(QQ)) {
	                	Interface1.lblNewLabel_4.setText("已有此账号，请重新创建");
	                	
	                }
	                else {
	                	if(mima.length()<6) {
	                		Interface1.lblNewLabel_4.setText("密码大小小于6或为纯数字或为纯字母，请重新创建");
	                	}
	                	else {
	                		sql =	"INSERT INTO ap values('"+zhanghao+"','"+mima+"','"+QQ+"')";
	                		//sql = "insert into ap(zg,mm,QQ) values("+zhanghao+","+mima+","+QQ+")";//SQL语句 
	                		System.out.println(sql);
	                		db1 = new DBHelper(sql);//创建DBHelper对象
	                		
	                		new Player();
	                		break;
	                	}
	                	
	    	        	  
	                }
	                
	                
	            }//显示数据  
	            ret.close();  
	            db1.close();//关闭连接  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        }
	}}


