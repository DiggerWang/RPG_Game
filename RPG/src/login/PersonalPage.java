package login;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import fight.Blood;
import fight.Enemy;
import map.Player;
import map.ReadMapFile;
import map.mainFrame;

//import javax.swing.JPasswordField;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;

import java.util.Date;
import java.text.SimpleDateFormat;

//import gameMainFrame.MainFrame;
//import gameMainFrame.Player;
//import gameMainFrame.Saver;

import java.awt.Font;
//import java.awt.List;
//import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class PersonalPage extends JFrame {
	int tag=0;
	long starttime;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonalPage a = new PersonalPage("Elsa");
	}

	public String username;

	public String getUsername(){
		return username;
	}
	public PersonalPage(){
		
	}
	public PersonalPage(final String username) {
		try {
			this.username = username;
			String n = username + "save";
			FileInputStream fis = new FileInputStream(n);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			tag = 1;
		} catch (IOException e) {
			System.out.println(e);
			tag = 0;
/*		} catch (ClassNotFoundException e) {
			System.out.println(e);
			tag = 0;
		}*/
		this.setBounds(0, 0, 1024, 635);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(626, 480, 90, 40);
		getContentPane().add(panel_5);
		panel_5.setOpaque(false);
		panel_5.setLayout(null);

		JButton button = new JButton(new ImageIcon("./buttonPicture//开始新游戏.png"));
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//首先从地图文件中读入地图数组
				ReadMapFile.readfile("./D_//mygame//map//map1.map");
				//用读到的地图数组创建游戏窗体，开始游戏
				mainFrame mf = new mainFrame();
				
				
			}
		});
		button.setBounds(0, 0, 90, 40);
		button.setOpaque(false);
		panel_5.add(button);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(747, 480, 90, 40);
		getContentPane().add(panel_6);
		panel_6.setOpaque(false);
		panel_6.setLayout(null);

		JButton button_1 = new JButton(new ImageIcon("./buttonPicture//继续游戏.png"));
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Player a = new map.Player();
				Player.name=username;
				ReadMapFile.readfile("./D_//mygame//map//map1.map");
				//用读到的地图数组创建游戏窗体，开始游戏
				mainFrame mf = new mainFrame();
				
			}
		});
		button_1.setBounds(0, 0, 90, 40);
		button_1.setOpaque(false);
		panel_6.add(button_1);

		//登录时间
		JPanel panel = new JPanel();
		panel.setBounds(642, 298, 100, 60);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);

		JLabel label_1 = new JLabel("\u767b\u5f55\u65f6\u95f4");
		label_1.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_1.setForeground(Color.white);
		label_1.setBounds(0, 10, 200, 35);
		panel.add(label_1);

		//昵称
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(642, 239, 74, 60);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setOpaque(false);

		JLabel label = new JLabel("\u6635\u79F0");
		label.setForeground(Color.white);
		label.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label.setBounds(0, 10, 74, 35);
		panel_1.add(label);

		//等级
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(642, 357, 74, 60);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setOpaque(false);

		JLabel label_2 = new JLabel("\u7b49\u7ea7");
		label_2.setForeground(Color.white);
		label_2.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_2.setBounds(0, 16, 144, 29);
		panel_2.add(label_2);

		//经验值
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(642, 416, 100, 60);
		getContentPane().add(panel_11);
		panel_11.setLayout(null);
		panel_11.setOpaque(false);

		JLabel label1 = new JLabel("\u7ecf\u9a8c\u503c");
		label1.setForeground(Color.white);
		label1.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label1.setBounds(0, 10, 100, 35);
		panel_11.add(label1); 
		
		//昵称显示
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(750, 239, 113, 60);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		
		JLabel label_3 = new JLabel(username);
		label_3.setForeground(Color.white);
		label_3.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_3.setBounds(0, 0, 113, 60);
		panel_3.add(label_3);

		//登录时间显示
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(750, 298, 300, 60);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		
		starttime = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		JLabel label_4 = new JLabel(df.format(new Date()));
		label_4.setFont(new Font("华文琥珀", Font.PLAIN, 20));
		label_4.setForeground(Color.white);
		label_4.setBounds(0, 0, 200, 60);
		panel_4.add(label_4);
		
		//等级显示
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(750, 357, 74, 60);
		getContentPane().add(panel_12);
		panel_12.setLayout(null);
		panel_12.setOpaque(false);
		
		JLabel label_5 = new JLabel("One");
		label_5.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_5.setForeground(Color.white);
		label_5.setBounds(0, 0, 86, 60);
		panel_12.add(label_5);
		
		//经验值显示
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(750, 416, 74, 60);
		getContentPane().add(panel_14);
		panel_14.setLayout(null);
		panel_14.setOpaque(false);
		
		JLabel label_14 = new JLabel(""+Enemy.exp);
		label_14.setFont(new Font("华文琥珀", Font.PLAIN, 25));
		label_14.setForeground(Color.white);
		label_14.setBounds(0, 0, 86, 60);
		panel_14.add(label_14);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setOpaque(false);
		panel_8.setBounds(871, 480, 90, 40);
		getContentPane().add(panel_8);

		JButton button_2 = new JButton(new ImageIcon("./buttonPicture//退出游戏.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setOpaque(false);
		button_2.setBounds(0, 0, 90, 40);
		panel_8.add(button_2);

		JPanel bgpanel = new JPanel();
		bgpanel.setBounds(0, 0, 1024, 635);
		getContentPane().add(bgpanel);
		bgpanel.setLayout(null);

		JLabel label_6 = new JLabel(new ImageIcon("./buttonPicture//个人主页.png"));
		label_6.setBounds(0, 0, 1024, 635);
		bgpanel.add(label_6);

		this.setVisible(true);
	}
	}
}

