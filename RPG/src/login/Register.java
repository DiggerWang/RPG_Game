package login;

import javax.swing.ImageIcon;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Register extends JFrame{
	
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JPasswordField  textField_4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register a=new Register();
	}
	
	public Register(){
		
		this.setBounds(0, 0, 1024, 466);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//玩家昵称
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(537, 150, 103, 42);
		getContentPane().add(panel_1);
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u73A9\u5BB6\u6635\u79F0");
		label.setForeground(Color.orange);
		label.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label.setBounds(0, 0, 103, 42);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(667, 150, 179, 42);
		getContentPane().add(panel_2);
		panel_2.setOpaque(false);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 10, 144, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		//输入密码
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(537, 218, 103, 42);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5BC6\u7801");
		label_1.setForeground(Color.orange);
		label_1.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_1.setBounds(0, 0, 103, 42);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(667, 218, 179, 42);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		
		textField_3 = new JPasswordField ();
		textField_3.setBounds(10, 11, 144, 21);
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		//确认密码
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(537, 286, 103, 42);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		panel_5.setOpaque(false);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setForeground(Color.orange);
		label_2.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_2.setBounds(0, 0, 103, 42);
		panel_5.add(label_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(667, 286, 179, 40);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		panel_6.setOpaque(false);
		
		textField_4 = new JPasswordField ();
		textField_4.setBounds(10, 10, 144, 21);
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(547, 351, 96, 35);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		panel_7.setOpaque(false);
		
		JButton btnNewButton = new JButton(new ImageIcon("./buttonPicture//确定按钮.png"));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("方正正中黑简体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField_2.getText().trim();// 获得用户输入的账号  
				String password1 = textField_3.getText();// 获得用户输入的密 码  
		        String password2 = textField_4.getText();// 获得用户输入的密 码  
				
		        if (username.isEmpty()) {// 判断账号是否为空  
		            JOptionPane.showMessageDialog(null, "玩家账号作为注册账号不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);  
		            return;  
		        }  
		        if (new String(password1).isEmpty()) {// 判断密码是否为空  
		            JOptionPane.showMessageDialog(null, "密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);  
		            return;  
		        }  
		        if (new String(password2).isEmpty()) {// 判断确认密码是否为空  
		            JOptionPane.showMessageDialog(null, "确认密码不能为空！", "警告信息", JOptionPane.WARNING_MESSAGE);  
		            return;  
		        }
				if(!password1.equals(password2)){
					JOptionPane.showMessageDialog(null, "前后密码不一致", "提示信息",JOptionPane.WARNING_MESSAGE);
				}
				else if(Register.checkCode(username)){
					JOptionPane.showMessageDialog(null, "该昵称已存在，请更换昵称，或直接登录", "提示信息",JOptionPane.WARNING_MESSAGE);
				}
				else{
					
					password1=Md5Util.getMd5(password1);
					User user=new User(username,password1);
			        FileUtil.appendFile("./data//user",user.toString() );
			        new Login();
			        dispose();
				}
				
			}
		});
		btnNewButton.setBounds(0, 0, 93, 33);
		panel_7.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(687, 351, 110, 37);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);
		panel_8.setOpaque(false);
		
		JButton button = new JButton(new ImageIcon("./buttonPicture//取消按钮.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login();
			}
		});
		button.setForeground(Color.BLUE);
		button.setBorder(null);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFont(new Font("方正正中黑简体", Font.PLAIN, 17));
		button.setBounds(10, 0, 93, 33);
		panel_8.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel(new ImageIcon("./buttonPicture//注册背景2.png"));
		label_3.setBounds(0, 0, 1024, 466);
		panel.add(label_3);
		
		this.setVisible(true);
	}
	
	//判断用户在注册窗口里输入的学号在“data/user”文件里是否存在
	public static boolean checkCode(String code){
		List<String> blist = FileUtil.readFileByLines("./data//user");
		for(int i = 0;i<blist.size();i++){
			User people = new User(blist.get(i));
			if(people.getUsername().equals(code))
				return true;
		}
		return false;
	}
}

