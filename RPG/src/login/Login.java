package login;

import javax.swing.ImageIcon;

import login.PersonalPage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame{

	private JTextField username;
	private JPasswordField password;
	double starttime = System.currentTimeMillis();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login a=new Login();
	}
	
	public Login(){
		
		this.setBounds(0, 0, 1024, 466);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//账号文字
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(645, 235, 70, 40);
		getContentPane().add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
				
		JLabel label_2 = new JLabel("\u8D26\u53F7");
		label_2.setForeground(Color.orange);
		label_2.setFont(new Font("华文琥珀", Font.PLAIN, 30));
		label_2.setBounds(0, 0, 80, 40);
		panel_1.add(label_2);
				
		//帐号文本框
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(714, 235, 208, 40);
		getContentPane().add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		username = new JTextField();
		username.setBounds(10, 5, 185, 30);
		panel_2.add(username);
		username.setColumns(10);
		
		//密码文字
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(645, 307, 70, 40);
		getContentPane().add(panel_3);
		panel_3.setOpaque(false);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setForeground(Color.orange);
		label_1.setFont(new Font("华文琥珀", Font.PLAIN, 30));
		label_1.setBounds(0, 0, 80, 40);
		panel_3.add(label_1);
		
		//密码文本框
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(714, 307, 208, 40);
		getContentPane().add(panel_4);
		panel_4.setOpaque(false);
		panel_4.setLayout(null);
		
		password = new JPasswordField();
		password.setBounds(10, 5, 185, 30);
		panel_4.add(password);
		password.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(649, 367, 90, 40);
		getContentPane().add(panel_5);
		panel_5.setOpaque(false);
		panel_5.setLayout(null);
		
		JButton button = new JButton(new ImageIcon("./buttonPicture//登录按钮.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断输入的账号和密码是否和“data/user”文件里的信息一致，是则弹出包含用户姓氏的欢迎信息，否则提示错误
				List<String> slist = FileUtil.readFileByLines("./data//user");
				boolean success = false;
				User p = null;
				for(int i = 0;i<slist.size();i++){
					User user = new User(slist.get(i));
					if(user.getUsername().equals(username.getText())&&user.getPassword().equals(Md5Util.getMd5(new String(password.getPassword())))){
						success = true;
						p = user;
						System.out.println("Welcome, "+p.getUsername());
						
						new PersonalPage(username.getText());
						
						dispose();
						
						break;
					}
				}
								
				if(!success){
					JOptionPane.showMessageDialog(null, "账号或用户名错误", "提示信息",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(0, 0, 90, 40);
		button.setOpaque(false);
		button.setBorder(null);
		button.setContentAreaFilled(false);
		panel_5.add(button);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(810, 367, 90, 40);
		getContentPane().add(panel_6);
		panel_6.setOpaque(false);
		panel_6.setLayout(null);
		
		JButton button_1 = new JButton(new ImageIcon("./buttonPicture//注册按钮.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register();
				dispose();
			}
		});
		button_1.setBounds(0, 0, 90, 40);
		button_1.setOpaque(false);
		button_1.setBorder(null);
		button_1.setContentAreaFilled(false);
		panel_6.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("./buttonPicture//注册背景1.png"));
		label.setBounds(0, 0, 1024, 466);
		panel.add(label);
		
		this.setVisible(true);
	}
}
