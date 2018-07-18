package fight;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import map.Player;
import map.gameConfig;
import map.mainFrame;

public class Animation implements gameConfig{
	
	public int effect = 0;
	//定义特效的位置
	public static int ex;
	public static int ey;
	
	public ImageIcon[] img = {pic1,pic3,pic4};
	
	public Animation(int effect, int ex, int ey) {
		this.effect = effect;
		this.ex = ex;
		this.ey = ey;
	}
	
	//画出特效
		public void draw(Graphics g) {
			switch(effect) {
			case 1:
				g.drawImage(pic1.getImage(), ex, ey, null); //爆头图
				break;
			case 2:
				g.drawImage(pic3.getImage(), ex, ey, null);
				break;
			case 3:
				g.drawImage(pic4.getImage(), ex, ey, null);
				break;
			case 4:
				g.drawImage(pic6.getImage(), ex, ey, null);
				break;
			case 5:
				g.drawImage(pic4.getImage(), ex, ey, null);
				break;
			}
		}
}
