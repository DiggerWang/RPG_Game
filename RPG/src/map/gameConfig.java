package map;

import javax.swing.ImageIcon;

/**
 * 游戏配置接口
 * @author yy
 *
 */
public interface gameConfig {
	//游戏主窗体名字
	String title = "平安吃鸡";
	//游戏主窗体的大小
	int frameX = 1000;
	int frameY = 750;
	//游戏面板大小
	int panelX = 750;
	int panelY = 750;
	//游戏素材大小
	int elesize = 50;
	//人物大小
	int playersize = 50;
	//------------[游戏素材]----------
	//-----第一层
	ImageIcon icon0 = new ImageIcon("./maps/000空白.png");
	ImageIcon icon1 = new ImageIcon("./maps/001草地.png");
	ImageIcon icon2 = new ImageIcon("./maps/002地砖.png");
	ImageIcon icon3 = new ImageIcon("./maps/003召泽地板副本.png");
	ImageIcon icon100 = new ImageIcon("./maps/100红树.png");
	ImageIcon icon101 = new ImageIcon("./maps/101绿树.png");
	ImageIcon icon102 = new ImageIcon("./maps/102绿竹.png");
	ImageIcon icon103 = new ImageIcon("./maps/103高绿树.png");
	ImageIcon icon104 = new ImageIcon("./maps/104瓦墙.png");
	ImageIcon icon105 = new ImageIcon("./maps/105篱笆.png");
	ImageIcon icon106 = new ImageIcon("./maps/106水.png");
	ImageIcon icon110 = new ImageIcon("./maps/110草丛.png");
	ImageIcon icon150 = new ImageIcon("./maps/150岩浆.png");
	
	
	//角色行走图
	ImageIcon walk = new ImageIcon("./character/玩家走动图.png");
	ImageIcon walk1 = new ImageIcon("./character/玩家静态图.png");
	ImageIcon walk2 = new ImageIcon("./character/敌人移动图.png");
	ImageIcon shoot1 = new ImageIcon("./character/手枪静止图.png");
	ImageIcon shoot2 = new ImageIcon("./character/机关枪静止图.png");
	ImageIcon shoot3 = new ImageIcon("./character/散弹枪静止图.png");
	ImageIcon move1 = new ImageIcon("./character/手枪走动图.png");
	ImageIcon move2 = new ImageIcon("./character/机关枪走动图.png");
	ImageIcon move3 = new ImageIcon("./character/散弹枪走动图.png");
	
	//武器图
		ImageIcon weapon1 = new ImageIcon("./weapon/手枪.png");
		ImageIcon weapon2 = new ImageIcon("./weapon/机关枪.png");
		ImageIcon weapon3 = new ImageIcon("./weapon/手榴弹.png");
		ImageIcon weapon4 = new ImageIcon("./weapon/小血包.png");
		ImageIcon weapon5 = new ImageIcon("./weapon/大血包.png");
		ImageIcon weapon6 = new ImageIcon("./weapon/子弹U.png");
		ImageIcon weapon7 = new ImageIcon("./weapon/子弹D.png");
		ImageIcon weapon8 = new ImageIcon("./weapon/子弹L.png");
		ImageIcon weapon9 = new ImageIcon("./weapon/子弹R.png");
		ImageIcon weapon10 = new ImageIcon("./weapon/圆形子弹.png");
		ImageIcon weapon11 = new ImageIcon("./weapon/散弹枪.png");
		ImageIcon weapon12 = new ImageIcon("./weapon/火炮.png");
		
		ImageIcon pic1 = new ImageIcon("./pictures/爆头图.gif");
		ImageIcon pic2 = new ImageIcon("./pictures/游戏结束图.gif");
		ImageIcon pic3 = new ImageIcon("./pictures/死亡图.png");
		ImageIcon pic4 = new ImageIcon("./pictures/击中身体图.png");
		ImageIcon pic5 = new ImageIcon("./pictures/空白.png");
		ImageIcon pic6 = new ImageIcon("./pictures/爆炸图.png");
		
		ImageIcon b1 = new ImageIcon("./BaoTou/b1.gif");
		ImageIcon b2 = new ImageIcon("./BaoTou/b2.gif");
		ImageIcon b3 = new ImageIcon("./BaoTou/b3.gif");
		ImageIcon b4 = new ImageIcon("./BaoTou/b4.gif");
		ImageIcon b5 = new ImageIcon("./BaoTou/b5.gif");
		ImageIcon b6 = new ImageIcon("./BaoTou/b6.gif");
		ImageIcon b7 = new ImageIcon("./BaoTou/b7.gif");
		ImageIcon b8 = new ImageIcon("./BaoTou/b8.gif");
		ImageIcon b9 = new ImageIcon("./BaoTou/b9.gif");
		ImageIcon b10 = new ImageIcon("./BaoTou/b10.gif");
		ImageIcon b11 = new ImageIcon("./BaoTou/b11.gif");
		ImageIcon b12 = new ImageIcon("./BaoTou/b12.gif");
		ImageIcon b13 = new ImageIcon("./BaoTou/b13.gif");
		ImageIcon b14 = new ImageIcon("./BaoTou/b14.gif");
		ImageIcon b15 = new ImageIcon("./BaoTou/b15.gif");
		ImageIcon b16 = new ImageIcon("./BaoTou/b16.gif");
		ImageIcon b17 = new ImageIcon("./BaoTou/b17.gif");
		ImageIcon b18 = new ImageIcon("./BaoTou/b18.gif");
		ImageIcon b19 = new ImageIcon("./BaoTou/b19.gif");
		ImageIcon b20 = new ImageIcon("./BaoTou/b20.gif");
		
	
}