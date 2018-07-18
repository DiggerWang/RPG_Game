package fight;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import map.gameConfig;

public class BaoTou implements gameConfig{
	
	int i;
	ImageIcon image;
	ImageIcon[] img = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20};
	
	public BaoTou(int i) {
		this.i = i;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img[i].getImage(), 325, 180, null);
	}

}
