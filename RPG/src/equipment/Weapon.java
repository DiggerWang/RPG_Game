package equipment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import map.Player;
import map.ReadMapFile;
import map.gameConfig;

public class Weapon implements gameConfig{
	public static int bullets=0;
	public int x;
	public int y;
	public int z;
	public ImageIcon[] img = {weapon1,weapon2,weapon3,weapon4,weapon5,weapon11};
	
	//定义武器的数量
	public static int Wnum = 10;
	
	public Weapon(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void draw(Graphics g) {
		if(ReadMapFile.map2[y/elesize][x/elesize]==0) {
		//if(Math.abs(Player.x-x)<=375 && Math.abs(Player.y-y)<=375) {
			g.drawImage(img[z].getImage(),this.x-Player.mx+500, this.y-Player.my+500,null);	
		//}
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x-Player.mx+510,y-Player.my+510,25,25);
	}
	
	//捡装备
	public boolean getWeapon() {
		if(this.getRect().intersects(Player.getRect())) {
			return true;
		}
		return false;
	}
	
	

}
