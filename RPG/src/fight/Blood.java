package fight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import map.Player;
import map.gameConfig;
import map.mainFrame;

public class Blood implements gameConfig {
	
	//定义满血为100
	public static int blood = 100; 
	//定义当前血量
	public static int state = 100;
	
	public int getBlood(){
		return state;
	}
	//画出玩家血条
	public static void drawPlayer(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(345, 315,state/2,6);
		g.drawRect(345, 315,50,6);
	}
	public static boolean isLive() {
		if(state<=0) {
			return false;
		}
		return true;
	}
	
	public static void gameover(Graphics g) {
		if(!isLive()) {
			g.drawImage(pic2.getImage(), 275, 300, null);
			mainFrame.stop = false;
		}
	}


}
