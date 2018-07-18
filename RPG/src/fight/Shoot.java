package fight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import map.Player;
import map.ReadMapFile;
import map.gameConfig;
import map.mainFrame;

public class Shoot extends Thread implements gameConfig{
	
    //定义子弹的初始位置为正中央，与人物位置重合	
	public int bx;
	public int by;
	//定义当前子弹的发射方向
	public int direction;
	//定义射程
	int distance;
	//定义子弹的射速
	static int speed = 10;
	//判断是否发射
	public static boolean islive = true;
	//定义枪的类型
	public static int type;
	
	public Shoot(int bx, int by, int direction,boolean islive,int type) {
		super();
		this.bx = bx;
		this.by = by;
		this.direction = direction;
		this.islive = islive;
		this.type = type;
	}
	
	public static boolean fireable = false;
	
	
    public void move() {
    	if (direction==1) {
    		by = by - speed;
    		distance = distance + speed;
    	}else if(direction==2) {
    		//distance = 0;
    		by = by + speed;
    		distance = distance + speed;
    	}else if(direction==3) {
    		//distance = 0;
    		bx = bx - speed;
    		distance = distance + speed;
    	}else if(direction==4) {
    		//distance = 0;
    		bx = bx + speed;
    		distance = distance + speed;
    	}
    }
  //判断子弹是否存活
  	public boolean isLive() {
  		if(distance>=375 || !islive) {
  			mainFrame.shoot.clear();
  			return false;
  		}
  		return true;
  	}
  	
  	//返回枪的伤害
  	public int damage() {
  		if(type==2) {
  			return 15;
  		}else if(type==3) {
  			return 30;
  		}
  		return 10;
  	}
      
  	//返回子弹所在位置的矩形
    public Rectangle getRect() {
    	if(type!=0) {
    		return new Rectangle(bx,by,5,5);
    	}
    	return new Rectangle(0,0,0,0);
    }
    
    public void draw(Graphics g) {
    	switch(type) {
    	case 0:
    	 	if(direction==1) {
        		g.drawImage(weapon6.getImage(), bx-25, by-20, null);
        	}else if(direction==2) {
        		g.drawImage(weapon7.getImage(), bx-25, by-20, null);
        	}else if(direction==3) {
        		g.drawImage(weapon8.getImage(), bx-25, by-20, null);
        	}else if(direction==4) {
        		g.drawImage(weapon9.getImage(), bx-25, by-20, null);
        	}
        	move();
        	break;
    	case 1: //画出手枪子弹
    	 	if(direction==1) {
        		g.drawImage(weapon6.getImage(), bx-25, by-20, null);
        	}else if(direction==2) {
        		g.drawImage(weapon7.getImage(), bx-25, by-20, null);
        	}else if(direction==3) {
        		g.drawImage(weapon8.getImage(), bx-25, by-20, null);
        	}else if(direction==4) {
        		g.drawImage(weapon9.getImage(), bx-25, by-20, null);
        	}
        	move();
        	break;
    	case 2: //画出机关枪子弹
    	 	if(direction==1) {
        		g.drawImage(weapon6.getImage(), bx-25, by-50, null);
        		g.drawImage(weapon6.getImage(), bx-25, by, null);
        	}else if(direction==2) {
        		g.drawImage(weapon7.getImage(), bx-25, by, null);
        		g.drawImage(weapon7.getImage(), bx-25, by-50, null);
        	}else if(direction==3) {
        		g.drawImage(weapon8.getImage(), bx-50, by-20, null);
        		g.drawImage(weapon8.getImage(), bx, by-20, null);
        	}else if(direction==4) {
        		g.drawImage(weapon9.getImage(), bx+50, by-20, null);
        		g.drawImage(weapon9.getImage(), bx, by-20, null);
        	}
        	move();
    		break;
    	case 3: //画出散弹枪子弹
    		g.drawImage(weapon12.getImage(), bx-25, by-20, null);
    		move();
    		break;
        }
    	}
      
      
      
  	public void run() {
  		while(mainFrame.stop){
  			move();
  			try {
  				Thread.sleep(10);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
  		}
  	}


}
