package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginCheck1 implements ActionListener {//��¼����˺�����
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null;
	    
	    String zhanghao=Interface1.textArea.getText();
		String mima=Interface1.textArea_1.getText();
		sql = "select *from ap";//SQL���  
	        db1 = new DBHelper(sql);//����DBHelper����
	        
	        try {  
	            ret = db1.pst.executeQuery();//ִ����䣬�õ������  
	            while (ret.next()) {  
	                String uid = ret.getString(1);  
	                String ufname = ret.getString(2); 
	                if(uid.equals(zhanghao)&&ufname.equals(mima)){//����Ƚ�
	                	Interface1.lblNewLabel_3.setText("��¼�ɹ�");
	                	new Player();break;
	                }
	                else {
	                	
	                	Interface1.lblNewLabel_3.setText("��¼ʧ��");
	                }
	            }//��ʾ����  
	            ret.close();  
	            db1.close();//�ر�����  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        } 
		
		
		
	}
	}


