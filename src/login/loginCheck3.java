package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginCheck3 implements ActionListener{//�һ�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sql = null;  
	    DBHelper db1 = null;  
	    ResultSet ret = null;
	    
	    String QQ=Interface1.textArea_4.getText();
		
		sql = "select *from ap";//SQL���  
	        db1 = new DBHelper(sql);//����DBHelper����
	        
	        try {  
	            ret = db1.pst.executeQuery();//ִ����䣬�õ������  
	            while (ret.next()) {  
	                String uid = ret.getString(3);  
	                String ufname = ret.getString(2); 
	                if(uid.equals(QQ))//����Ƚ�
	                {
	                	Interface1.lblNewLabel_6.setText("���룺"+ufname);
	                	break;
	                }
	                else {
	                	Interface1.lblNewLabel_6.setText("�޴��˺ţ���ȷ���˺���ע��");
	                }
	            }//��ʾ����  
	            ret.close();  
	            db1.close();//�ر�����  
	        } catch (SQLException j) {  
	            j.printStackTrace();  
	        } 
}
}
