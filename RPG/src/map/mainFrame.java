package map;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import map.GetMap;
import map.Player;
import map.ReadMapFile;
import map.mainFrame;
import map.mainFrame.Panel2;
import map.mainFrame.Panel4;
import equipment.WtoB;
import equipment.Weapon;
import login.FileUtil;
import login.PersonalPage;
import fight.Animation;
import fight.BaoTou;
import fight.Blood;
import fight.Enemy;
import fight.Shoot;
import music.LoadMusic;




/**
 * 游戏主窗体
 *
 */
public class mainFrame extends JFrame implements gameConfig{
	public static boolean stop=true;
	static int winning = 6;
	private LoadMusic music = new LoadMusic(); //音乐管理器对象
 	//游戏面板
	Blood blood=new Blood();
	JPanel panel,Panel,p1;
	JPanel p2 = new Panel2();
	JPanel p3 = new Panel3();
	JPanel p4 = new Panel4();
	MenuBar jmb = new MenuBar();
	public JLabel la1 = new JLabel();
	public JLabel la2 = new JLabel();
	public JLabel la3 = new JLabel();
	public JLabel la4 = new JLabel();
	public JLabel la5 = new JLabel();
	public JLabel la6 = new JLabel();
	JLabel[] label = {la1,la2,la3,la4,la5,la6};
	public static ArrayList<Player> player = new ArrayList<Player>();
	public static ArrayList<UpdateThread> thread = new ArrayList<UpdateThread>();
	public static ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	public static ArrayList<Weapon> weapon = new ArrayList<Weapon>();
	public static ArrayList<Shoot> shoot = new ArrayList<Shoot>();
	public static ArrayList<WtoB> wtob = new ArrayList<WtoB>();
	public static ArrayList<Animation> animation = new ArrayList<Animation>();
	public static ArrayList<BaoTou> baotou = new ArrayList<BaoTou>();
	public mainFrame() {
		init();
		
	}
	
	public void win(){
		if(Enemy.shootnum>=winning){
			Object[] options = { "退出游戏", "重新游戏" };  
			int option = JOptionPane.showOptionDialog(null, "大吉大利，平安吃鸡！",  
					"退出提示....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,
					null,options, options[0]);
			if(option == JOptionPane.OK_OPTION){
				System.exit(0);
				}else {
					//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					clear();
					restart();
				}
		}
	}
	
	/**
	 * 设置窗体
	 */
	public void init(){
		music.playMusic("bgm");
		music.setBgMusic(true);//播放音乐
		this.setTitle(title);
		this.setSize(frameX, frameY);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//创建游戏面板
		panel = setpanel();
		Panel = setPanel();
		p1=setp1();
		p2=setPanel2();
		p4=setPanel4();
		/*
		 * 设置界面
		 */
		
		jmb=setmenu();
		this.setMenuBar(jmb);
		this.setVisible(true);
		//安装键盘监听器
		PanelListenner plis = new PanelListenner();
		this.addKeyListener(plis);
		this.requestFocus();
		
		//启动人物移动线程
		player.add(new Player());
		for(Player num:player) {
			num.start();
		}

		//启动刷新面板线程
		thread.add(new UpdateThread(panel));
		thread.add(new UpdateThread(Panel));
		thread.add(new UpdateThread(p3));
		thread.add(new UpdateThread(p2));
		for(UpdateThread num:thread) {
			num.start();
		}
		
	for(int i=0;i<Enemy.Enum;i++) {
	    	enemy.add(new Enemy());
	 }
	 for(Enemy num:enemy) {
	    	num.start();
	 }
	    
	 weapon.add(new Weapon(Enemy.random(8)*50,Enemy.random(8)*50,0));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,0));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,1));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,1));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,5));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,2));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,2));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,3));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,3));
	 weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,4));
	 
	/*weapon.add(new Weapon(Enemy.random(8)*50,Enemy.random(8)*50,0));
	for(int i=0;i<Weapon.Wnum;i++) {
	    	weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,(int)(Math.random()*6)));
	    }*/  
	}
	public void clear(){ //清除之前的缓存
		Player.x=375;
		Player.y=375;
		Player.mx = 500;
		Player.my = 500;
		Player.yy = 0;
		Player.towards = 2;
		Weapon.bullets = 0;
		Enemy.exp=0;
		Enemy.shootnum=0;
		Blood.state=100;
		la1.setIcon(null);
		la2.setIcon(null);
		la3.setIcon(null);
		la4.setIcon(null);
		la5.setIcon(null);
		la6.setIcon(null);
		thread.clear();
		enemy.clear();
		animation.clear();
		weapon.clear();
		shoot.clear();
		wtob.clear();
		mainFrame.stop = true;
		}
	
	public void restart() { //重新开始
		thread.add(new UpdateThread(panel));
		thread.add(new UpdateThread(Panel));
		thread.add(new UpdateThread(p3));
		thread.add(new UpdateThread(p2));
		for(UpdateThread num:thread) {
			num.start();
		}
		
		for(int i=0;i<Enemy.Enum;i++) {
	    	enemy.add(new Enemy());
	    }
	    for(Enemy num:enemy) {
	      	num.start();
	    }
	    
	    weapon.add(new Weapon(Enemy.random(8)*50,Enemy.random(8)*50,0));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,0));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,1));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,1));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,5));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,2));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,4));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,3));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,3));
	    weapon.add(new Weapon(Enemy.random(39)*50+50,Enemy.random(39)*50+50,4));
	}
	
	public void conceal() { //隐藏
		this.setVisible(false);
	}
	/*
	 ** 设置菜单
	 */
	public MenuBar setmenu(){
		MenuBar jmb = new MenuBar();
		Menu jm1 = new Menu("Game");
		Menu jm2 = new Menu("Stop/Continue");
		Menu jm3 = new Menu("Game Level");
		Menu jm4 = new Menu("Help");
		Menu jm5 = new Menu("Music");
		jm1.setFont(new Font("宋体", Font.BOLD, 15));// 设置菜单显示的字体
		jm2.setFont(new Font("宋体", Font.BOLD, 15));// 设置菜单显示的字体
		jm3.setFont(new Font("宋体", Font.BOLD, 15));// 设置菜单显示的字体
		jm4.setFont(new Font("宋体", Font.BOLD, 15));// 设置菜单显示的字体
		MenuItem jmi1 = new MenuItem("NewGame");
		MenuItem jmi2 = new MenuItem("Exit");
		MenuItem jmi3 = new MenuItem("Stop");
		MenuItem jmi4 = new MenuItem("Continue");
		MenuItem jmi5 = new MenuItem("Easy Level");
		MenuItem jmi6 = new MenuItem("Normal Level");
		MenuItem jmi7 = new MenuItem("Hard Level");
		MenuItem jmi8 = new MenuItem("Hell Level");
		MenuItem jmi9 = new MenuItem("About Game");
		MenuItem jmi10 = new MenuItem("About Team");
		MenuItem jmi11 = new MenuItem("OpenMusic");
		MenuItem jmi12 = new MenuItem("CloseMusic");
		jmi1.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi2.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi3.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi4.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi5.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi5.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi6.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi7.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi8.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi9.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi10.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jmi11.setFont(new Font("TimesRoman", Font.BOLD, 15));
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm2.add(jmi3);
		jm2.add(jmi4);
		jm3.add(jmi5);
		jm3.add(jmi6);
		jm3.add(jmi7);
		jm3.add(jmi8);
		jm4.add(jmi9);
		jm4.add(jmi10);
		jm5.add(jmi11);
		jm5.add(jmi12);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		/*
		 *菜单栏的具体实现 
		 *
		 */
		jm1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("NewGame")){
					//启动人物移动线程
					clear();
					restart();
					}else if(e.getActionCommand().equals("Exit")){
						Object[] options = { "是的，我要退出", "不好意思，点错了" };  
						int option = JOptionPane.showOptionDialog(null, "您确定要退出游戏吗？",  
								"退出提示....",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,
								null,options, options[0]);
						if(option == JOptionPane.OK_OPTION){
							System.exit(0);
							}
						}
			}
		});

		jm2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd=e.getActionCommand();
				if(cmd.equals("Stop")){
					stop = false;
					Player.run = false;
					
				}else if(cmd.equals("Continue")){
					stop = true;
					Player.run = true;
					new Player().start();
					for(int i=0;i<enemy.size();i++) {
						new Enemy().start();
					}
					new UpdateThread(panel).start();
					new UpdateThread(Panel).start();
					new UpdateThread(p3).start();
					new UpdateThread(p2).start();
					
					
				}
			}
		});
		jm3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd=e.getActionCommand();
				if(cmd.equals("Easy Level")){
					clear();
					restart();
					Enemy.speed=2;
					winning = 5;
				}else if(cmd.equals("Normal Level")){
					clear();
					restart();
					Enemy.speed=3;
				}else if(cmd.equals("Hard Level")){
					clear();
					restart();
					Enemy.speed=5;
					Enemy.damage = 2;
					winning = 8;
				}else if(cmd.equals("Hell Level")){
					clear();
					restart();
					Enemy.speed=6;
					Enemy.damage = 3;
					winning = 10;
				}
			}
		});
		
		jm4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("About Team")){
					JOptionPane.showMessageDialog(null,"大吉大利，今晚吃鸡\n本游戏由平安吃鸡组制作\n" +  
	                        "小组成员：王昊，朱琦，曾慧婷，刘小毓，向明珠\n"+     
	                        "最后谢谢您的使用！\n版权所有，请勿侵权！","游戏介绍",JOptionPane.INFORMATION_MESSAGE);  
					}else if(e.getActionCommand().equals("About Game")){
						JOptionPane.showMessageDialog(null,"大吉大利，今晚吃鸡\n" +  
		                        "游戏说明：通过键盘上下左右操纵人物移动\n" + 
								"拾取枪支后通过F键进行射击敌人\n通过1,2,3,4,5,6件可实现工具栏功能\n"+
		                        "你可以选择不同的关卡进行游戏","游戏介绍",JOptionPane.INFORMATION_MESSAGE);  
					}
				}  
			}); 
		
		jm5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("OpenMusic")){
					if(music.bgMusic==false){
						music.setBgMusic(true);
						music.playMusic("bgm");
					}
					}else if(e.getActionCommand().equals("CloseMusic")){
						music.setBgMusic(false);
						music.closeMusic();
						}
			} 
			});  
		return jmb;
		
	}
	
	public JPanel setp1(){
		JPanel p1 = new JPanel();
		p2.setBounds(10, 120, 220, 100);
		p2.setBackground(Color.LIGHT_GRAY);
		
		JButton b7=new JButton(new ImageIcon("./buttonPicture//人物头像.png"));
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				List<String> slist = FileUtil.readFileByLines("./data//user");
				new PersonalPage(Player.name);
				conceal();
			}
		}
		);
		b7.setBounds(60, 10, 100, 100);
		p3.setBorder(new EmptyBorder(5, 5, 5, 5));
		p3.setLayout(null);
		p3.add(b7);	
		p3.add(p2);
		p3.setBackground(Color.LIGHT_GRAY);
		p3.setPreferredSize(new Dimension(250,200));
		p4.setLayout(null);
		p4.setPreferredSize(new Dimension(250,200));
		p4.add(la1);
		la1.setBounds(20, 0, 70, 100);
		p4.add(la2);
		la2.setBounds(100, 0, 70, 100);
		p4.add(la3);
		la3.setBounds(180, 0, 70, 100);
		p4.add(la4);
		la4.setBounds(20, 100, 70, 100);
		p4.add(la5);
		la5.setBounds(100, 100, 70, 100);
		p4.add(la6);
		la6.setBounds(180, 100, 70, 100);
		this.add(panel,BorderLayout.EAST);
		this.add(p1, BorderLayout.WEST);
		p1.setLayout(new BorderLayout());
		p1.add(Panel,BorderLayout.SOUTH);
		p1.add(p3,BorderLayout.CENTER);
		p1.add(p4,BorderLayout.NORTH);
		
		return p1;
		
		
		
	}
	
	/**
	 * 设置游戏面板
	 */
	public JPanel setpanel(){
		JPanel panel = new MyPanel();
		panel.setPreferredSize(new Dimension(panelX, panelY));
		panel.setLayout(null);
		panel.setBackground(new Color(60,111,41));
		
		return panel;
	}
	
	public JPanel setPanel() {
		JPanel panel = new SmallPanel();
		panel.setPreferredSize(new Dimension(250,250));
		panel.setLayout(null);
		return panel;
	}
	public JPanel setPanel2(){
		JPanel panel =new Panel2();
		panel.setPreferredSize(new Dimension(250,250));
		panel.setLayout(null);
		return panel;
	}
	public JPanel setPanel3(){
		JPanel panel =new Panel3();
		panel.setPreferredSize(new Dimension(250,250));
		panel.setLayout(null);
		return panel;
	}
	public JPanel setPanel4() {
		JPanel panel = new Panel4();
		panel.setPreferredSize(new Dimension(250,250));
		panel.setLayout(null);
		return panel;
	}
	
	/**
	 * 内部游戏按键监听类s
	 * 
	 *
	 */
	class PanelListenner extends KeyAdapter{
		//当按键按下
		public void keyPressed(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = true;
				Player.towards = 1;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = true;
				Player.towards = 2;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = true;
				Player.towards = 3;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = true;
				Player.towards = 4;
				break;
				
			case KeyEvent.VK_F:
				if(Player.yy==1 || Player.yy==2 || Player.yy==3) {
					Weapon.bullets--;
					if(Weapon.bullets>=0){
						mainFrame.shoot.add(new Shoot(375,375,Player.towards,true,Player.yy));
					}else Weapon.bullets=0;
				}
				win();
				break;
			case KeyEvent.VK_1:
				if(la1.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==0) {
						num.doWeapon();
					}
				}
				}
				la1.setIcon(null);
				break;
			case KeyEvent.VK_2:
				if(la2.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==1) {
						num.doWeapon();
					}
				}
				}
				la2.setIcon(null);
				break;
			case KeyEvent.VK_3:
				if(la3.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==2) {
						num.doWeapon();
					}
				}
				}
				la3.setIcon(null);
				break;
			case KeyEvent.VK_4:
				if(la4.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==3) {
						num.doWeapon();
					}
				}
				}
				la4.setIcon(null);
				break;
			case KeyEvent.VK_5:
				if(la5.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==4) {
						num.doWeapon();
					}
				}
				}
				la5.setIcon(null);
				break;
			case KeyEvent.VK_6:
				if(la6.getIcon()!=null) {
				for(WtoB num:wtob) {
					if(num.i==5) {
						num.doWeapon();
					}
				}
				}
				la6.setIcon(null);
				break;
			default:
				break;
			}
		}
		//当按键释放
		public void keyReleased(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = false;
				Player.up1 = 0;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = false;
				Player.down1 = 0;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = false;
				Player.left1 = 0;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = false;
				Player.right1 = 0;
				break;

			default:
				break;
			}
		}
	}
	
	/**
	 * 自定义内部游戏面板类
	 *
	 */
	class MyPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//找到角色旁边的素材，上下左右各5格
			for(int i=Player.getI()-8;i<=Player.getI()+8;i++){
				for(int j=Player.getJ()-9;j<=Player.getJ()+9;j++){
					//如果这一格没有超界
					if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){
						//画第一层元素
						ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);
						g.drawImage(icon.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//第二层
						ImageIcon icon2 = GetMap.int2icon(ReadMapFile.map2[i][j]);
						g.drawImage(icon2.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//第三层
						ImageIcon icon3 = GetMap.int2icon(ReadMapFile.map3[i][j]);
						g.drawImage(icon3.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//第四层
						ImageIcon icon4 = GetMap.int2icon(ReadMapFile.map4[i][j]);
						g.drawImage(icon4.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
					}
				}
			}
			
			for(Weapon num:weapon) {//画出武器
		 		num.draw(g);
		 		if(num.getWeapon()) {
		 			int z = num.z;
		 			r:for(int i=0;i<6;i++) {
		 				if(label[i].getIcon()==null) {
		 					label[i].setIcon(num.img[z]);
		 					wtob.add(new WtoB(i,z));
		 					break r;
		 				}
		 			}
		 			weapon.remove(num);
		 		}
		 	}
			
			for(Player num:player) {
				num.draw(g);
			}
			Blood.drawPlayer(g);
			
			
			for(Enemy num:enemy) {//画出敌人
		 		num.draw(g);
		 		//num.autoAttack();
		 		num.hit();
		 		num.hitplayer();
		 		num.drawBlood(g);
		 		if(!num.isLive()) {
		 			Enemy.shootnum++;
		 			Enemy.exp=Enemy.exp+20;
		 			enemy.remove(num);
		 		}
		 	}
			
			//画第五层
			for(int i=Player.getI()-8;i<=Player.getI()+8;i++){
				for(int j=Player.getJ()-8;j<=Player.getJ()+8;j++){
					if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){
						ImageIcon icon5 = GetMap.int2icon(ReadMapFile.map5[i][j]);
						g.drawImage(icon5.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
					}
				}
			}
			
			for(Shoot num:shoot) {
				num.draw(g);
				if(!num.isLive()) {
				shoot.remove(num);
				}
			}
			Blood.gameover(g);
			
			double s = System.currentTimeMillis();
			do {
			for(Animation num:animation) { //画出特效
				num.draw(g);
			}}while(System.currentTimeMillis()-s==800);
			for(BaoTou num:baotou) {
				num.draw(g);
			}
			for(int i=0;i<animation.size();i++) {
				animation.remove(i);
			}
		}
		
	}
	
	/*
	 * 设置小地图角色定位
	 */
	class SmallPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			ImageIcon icon = new ImageIcon("./pictures/小地图.png");
			Image img = icon.getImage();
			g.drawImage(img,0,0,250,250,this);
			g.fillOval(Player.getJ()*50/8, Player.getI()*50/8, 10, 10);
			for(Enemy num:enemy) {
				g.setColor(Color.RED);
				g.fillOval(num.x/8, num.y/8, 10, 10);
			}
		}
	}
	//设置个人主页的数据刷新
		class Panel2 extends JPanel{
			public void paint(Graphics g){
				super.paint(g);
				ImageIcon icon = new ImageIcon();
				Image img = icon.getImage();
				g.drawImage(img,0,0,250,250,this);
				Color c = g.getColor();
				g.setColor(Color.BLACK); // 设置字体显示属性
				Font f1 = g.getFont();
				g.setFont(new Font("宋体", Font.BOLD, 15));
				g.drawString(""+Player.name, 120, 15);
				g.drawString(""+Blood.state, 120, 35);
				g.drawString(""+Enemy.shootnum, 120, 55);
				g.drawString(""+Enemy.exp, 120, 75);
				g.drawString(""+Weapon.bullets, 120, 95);
				g.setFont(f1);
			}
		}
		//设置工具包的背景图
		class Panel3 extends JPanel{
			public void paint(Graphics g){
				super.paint(g);
				ImageIcon icon = new ImageIcon("./pictures/中间框.png");
				Image img = icon.getImage();
				g.drawImage(img,0,0,250,250,this);
			}
		}
		//设置工具包的背景图
		class Panel4 extends JPanel{
			public void paint(Graphics g){
				super.paint(g);
				ImageIcon icon = new ImageIcon("./pictures/工具栏.png");
				Image img = icon.getImage();
				g.drawImage(img,0,0,250,200,this);
				}
			}
}
