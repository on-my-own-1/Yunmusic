package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.AncestorListener;


import javax.swing.event.AncestorEvent;

public class Interface1 extends JFrame {
	static	JTextArea textArea = new JTextArea();//用户名
	static  JTextArea textArea_1 = new JTextArea();//密码
	static  JLabel lblNewLabel_3 = new JLabel("\u8BF7\u767B\u5F55");//请登录
	static  JTextArea textArea_2 = new JTextArea();//用户名注册
	static  JTextArea textArea_3 = new JTextArea();//注册密码
	static  JTextField textField_2 = new JTextField();//QQ输入框
	static  JLabel lblNewLabel_4 = new JLabel(" ");//报错框
	static  JTextField textArea_4 = new JTextField();//找回输入框
	static  JLabel lblNewLabel_6 = new JLabel("");//找回密码显示框
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface1 frame = new Interface1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface1() {
		setForeground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 443);
		
		final JLabel l = new JLabel();
		
        ImageIcon i = new ImageIcon("d:/java/yunmusic/QQ图片20191110185827.jpg");
        l.setIcon(i);
        l.setBounds(200, 443, i.getIconWidth(), i.getIconHeight());
  
        getContentPane().add(l);
        
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("\u76F4\u63A5\u8FDB\u5165");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Player();
			}
		});
		btnNewButton_3.setBounds(0, 383, 97, 23);
		
		
		
		
		textArea.addAncestorListener(new AncestorListener() {//用户名
			public void ancestorAdded(AncestorEvent event) {
				
				
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		textArea.setBounds(79, 45, 193, 24);
		contentPane.add(textArea);
		
		
		textArea_1.addAncestorListener(new AncestorListener() {//密码
			public void ancestorAdded(AncestorEvent event) {
				
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		textArea_1.setBounds(79, 94, 193, 24);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");//用户名
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 44, 60, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");//密码
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 99, 60, 19);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new loginCheck1() //登录
					);
		btnNewButton.setBounds(79, 139, 193, 38);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {//注册
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("\u8D26\u53F7\u6CE8\u518C");//注册
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
				lblNewLabel.setBounds(44, 0, 306, 25);
				contentPane.add(lblNewLabel);
				
				
				textArea_2.setBounds(44, 35, 172, 25);
				contentPane.add(textArea_2);
				textArea_2.setColumns(10);
				
				
				textField_2.setBounds(44, 107, 172, 21);//QQ输入框
				contentPane.add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("QQ:");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(0, 40, 58, 15);
				contentPane.add(lblNewLabel_1);
				
				
				textArea_3.setBounds(44, 76, 172, 21);
				contentPane.add(textArea_3);
				textArea_3.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");//密码
				lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 10));
				lblNewLabel_2.setBounds(0, 79, 58, 15);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_7 = new JLabel("\u7528\u6237\u540D\uFF1A");//用户名标签
				lblNewLabel_7.setBounds(0, 110, 58, 15);
				contentPane.add(lblNewLabel_7);
				
				JButton btnNewButton2 = new JButton("\u6CE8\u518C\u5E76\u767B\u5F55");//注册并进入
				btnNewButton2.addActionListener(new loginCheck2() 
					
				);
				btnNewButton2.setBounds(44, 135, 172, 37);
				contentPane.add(btnNewButton2);
				
				
				lblNewLabel_4.setBounds(44, 182, 172, 44);
				contentPane.add(lblNewLabel_4);
				
			}
		});
		btnNewButton_1.setBounds(79, 187, 99, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("YUNMUSIC");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(79, 0, 193, 35);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("\u627E\u56DE\u5BC6\u7801");
		btnNewButton_2.addActionListener(new ActionListener() {//找回密码
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("\u627E\u56DE\u5BC6\u7801");//标签找回密码
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));//标签找回密码
				lblNewLabel.setBounds(77, 0, 235, 34);
				contentPane.add(lblNewLabel);
				
				
				textArea_4.setBounds(77, 44, 153, 21);//输入框
				contentPane.add(textArea_4);
				textArea_4.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("QQ:");
				lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
				lblNewLabel_5.setBounds(9, 47, 58, 15);
				contentPane.add(lblNewLabel_5);
				
				JButton btnNewButton3 = new JButton("\u627E\u56DE");//找回-组件
				btnNewButton3.addActionListener(new loginCheck3() //找回-组件
					
				);
				btnNewButton3.setFont(new Font("宋体", Font.PLAIN, 20));
				btnNewButton3.setBounds(77, 99, 153, 34);
				contentPane.add(btnNewButton3);
				
				lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 15));//找回密码显示框
				lblNewLabel_6.setBounds(77, 156, 153, 34);
				contentPane.add(lblNewLabel_6);

				
			}
		});
		btnNewButton_2.setBounds(188, 187, 86, 30);
		contentPane.add(btnNewButton_2);
		
		
		contentPane.add(btnNewButton_3);
		
		
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(79, 253, 198, 58);
		contentPane.add(lblNewLabel_3);
	}
}
