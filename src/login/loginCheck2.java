package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class loginCheck2 implements ActionListener{//ע��
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
		sql = "select *from ap";//SQL���  
	    db1 = new DBHelper(sql);//����DBHelper����
	        
	        try {  
	            ret = db1.pst.executeQuery();//ִ����䣬�õ������
	            while (ret.next()) {  
	                String uid = ret.getString(1);//�õ����е�һ������
	                String uif= ret.getString(3);
	                if(uid.equals(zhanghao)||uif.equals(QQ)) {
	                	Interface1.lblNewLabel_4.setText("���д��˺ţ������´���");
	                	
	                }
	                else {
	                	if(mima.length()<6) {
	                		Interface1.lblNewLabel_4.setText("�����СС��6��Ϊ�����ֻ�Ϊ����ĸ�������´���");
	                	}
	                	else {
	                		sql =	"INSERT INTO ap values('"+zhanghao+"','"+mima+"','"+QQ+"')";
	                		//sql = "insert into ap(zg,mm,QQ) values("+zhanghao+","+mima+","+QQ+")";//SQL��� 
	                		System.out.println(sql);
	                		db1 = new DBHelper(sql);//����DBHelper����
	                		
	                		new Player();
	                		break;
	                	}
	                	
	    	        	  
	                }
	                
	                
	            }//��ʾ����  
	            ret.close();  
	            db1.close();//�ر�����  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        }
	}}


