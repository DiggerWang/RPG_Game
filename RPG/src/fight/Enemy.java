package fight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import map.Player;
import map.ReadMapFile;
import map.gameConfig;
import map.mainFrame;

public class Enemy extends Thread implements gameConfig{
	//定义敌人的坐标
	public int x;
	public int y;
	//定义敌人的方向
	public int direction;
	//定义敌人的移动速度
	public static int speed=3;
	public static int shootnum=0;
	public static int exp=0;
	
	public boolean u = false;
	public boolean d = false;
	public boolean l = false;
	public boolean r = false;
	//定义敌人的数量
	public static int Enum = 10;
	//定义敌人血量
	public static int blood = 50;
	public int state = blood;
	//定义敌人的伤害
	public static int damage = 1;
	public static int baotou = 0;
	
    //角色的移动累积量（这个就是用来控制循环的变化4张角色图片来达成动态移动的）  
    static int up1 = 0;  
    static int down1 = 0;  
    static int left1 = 0;  
    static int right1 = 0; 
	
	public Enemy() {
		x=Enemy.random(39)*50+50;
		y=Enemy.random(39)*50+50;
		direction = random(4);
	}
	
    public void run() {  
        while(mainFrame.stop){  
        	move();
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    } 
    
    //生成随机数
    public static int random(int n) {
    	Random r = new Random();
    	int random = r.nextInt(n);
    	return random;
    }
    
    
    public void move() {
    	if(direction==0) {
    		if(ReadMapFile.map2[y/elesize-1][x/elesize]!=0) {
    			direction = random(4);
    		}else {
    			y = y-speed;
    			up1++;
    			if(up1>=20) {
    				up1=0;
    			}
    		}
    	}else if(direction==1) {
    		if(ReadMapFile.map2[y/elesize+1][x/elesize]!=0) {
    			direction = random(4);
    		}else {
    			y = y+speed;
    			down1++;
    			if(down1>=20) {
    				down1=0;
    			}
    		}
    	}else if(direction==2) {
    		if(ReadMapFile.map2[y/elesize][x/elesize-1]!=0) {
    			direction = random(4);
    		}else {
    			x = x-speed;
    			left1++;
    			if(left1>=20) {
    				left1=0;
    			}
    		}
    	}else if(direction==3) {
    		if(ReadMapFile.map2[y/elesize][x/elesize+1]!=0) {
    			direction = random(4);
    		}else {
    			x = x+speed;
    			right1++;
    			if(right1>=20) {
    				right1=0;
    			}
    		}
    	}
    	}
    
    public void draw(Graphics g) {
		if(direction==0){  
            //通过up1的值，来决定画哪一张图片  
            if(up1<5){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 0, 96*3, 96, 96*4, null);  
            }else if(up1<10){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96, 96*3, 96*2, 96*4, null);  
            }else if(up1<15){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*2, 96*3, 96*3, 96*4, null);  
            }else{  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*3, 96*3, 96*4, 96*4, null);  
            }  
        }else if(direction==1){  
            if(down1<5){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 0, 0, 96, 96, null);  
            }else if(down1<10){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96, 0, 96*2, 96, null);  
            }else if(down1<15){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*2, 0, 96*3, 96, null);  
            }else{  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*3, 0, 96*4, 96, null);  
            }  
        }else if(direction==2){  
            if(left1<5){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 0, 96, 96, 96*2, null);  
            }else if(left1<10){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96, 96, 96*2, 96*2, null);  
            }else if(left1<15){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*2, 96, 96*3, 96*2, null);  
            }else{  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*3, 96, 96*4, 96*2, null);  
            }  
              
        }else if(direction==3){  
            if(right1<5){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 0, 96*2, 96, 96*3, null);  
            }else if(right1<10){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96, 96*2, 96*2, 96*3, null);  
            }else if(right1<15){  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*2, 96*2, 96*3, 96*3, null);  
            }else{  
                g.drawImage(walk2.getImage(), x-Player.mx+460, y-Player.my+430, x-Player.mx+540, y-Player.my+510, 96*3, 96*2, 96*4, 96*3, null);  
            }  
        }  
    } 
  //返回敌人身体所在的位置的矩形
    public Rectangle getRect1() {
    	return new Rectangle(x-Player.mx+500,y-Player.my+470,60,40);
    }

  //返回敌人头部所在的位置的矩形
    public Rectangle getRect2() {
    	return new Rectangle(x-Player.mx+500,y-Player.my+450,60,20);
    }


    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    //返回敌人所在线路的矩形(在400范围内会进行攻击)
    /*public Rectangle getRectU() {
    	return new Rectangle(x-Player.mx+500,y-Player.my+100,50,400);
    }

    public Rectangle getRectD() {
    	return new Rectangle(x-Player.mx+500,y-Player.my+500,50,400);
    }

    public Rectangle getRectL() {
    	return new Rectangle(x-Player.mx+100,y-Player.my+500,400,50);
    }

    public Rectangle getRectR() {
    	return new Rectangle(x-Player.mx+500,y-Player.my+100,400,50);
    }*/

    //判断是否击中敌人
    public void hit() {
    	for(Shoot num:mainFrame.shoot) {
    	if(this.getRect1().intersects(num.getRect()) && Shoot.islive) { //击中身体
    		state = state-num.damage();
    		mainFrame.shoot.clear();
    		if(Player.yy == 3) {
    			mainFrame.animation.add(new Animation(4,x-Player.mx+480,y-Player.my+460));
    		}else {
    			mainFrame.animation.add(new Animation(3,x-Player.mx+480,y-Player.my+460));
    		}
    	}
    	if(this.getRect2().intersects(num.getRect())) { //击中头
    		state = 0;
    		mainFrame.baotou.clear();
    		mainFrame.baotou.add(new BaoTou(baotou));
    		mainFrame.shoot.clear();
    		baotou = baotou+1;
    	}}
    }
    
    
    //判断是否碰到玩家
    public void hitplayer() {
    	if(this.getRect1().intersects(Player.getRect())) {
    		Blood.state = Blood.state - damage;
    		mainFrame.animation.add(new Animation(5,325,325));
    	}
    }

    //判断是否存活
    public boolean isLive() {
    	if(state <= 0) {
    		mainFrame.animation.add(new Animation(2,x-Player.mx+480,y-Player.my+420));
    		return false;
    	}
    	return true;
    }
  //设置敌人的自动攻击
   /* public void autoAttack(Graphics g,int direction) {
    	if(direction == 0 && Math.random()>0.5) {
    		g.drawImage(weapon6.getImage(), bx-Player.mx+500, by-Player.my+500, null);
    		u = true;
    	}else if(direction == 1 && Math.random()>0.5) {
    		g.drawImage(weapon7.getImage(), bx-Player.mx+500, by-Player.my+500, null);
    		d = true;
    	}else if(direction == 2 && Math.random()>0.5) {
    		g.drawImage(weapon8.getImage(), bx-Player.mx+500, by-Player.my+500, null);
    		l = true;
    	}else if(direction == 3 && Math.random()>0.5) {
       	g.drawImage(weapon9.getImage(), bx-Player.mx+500, by-Player.my+500, null);
    		r = true;
    	}
    }*/
    
    //重新启动敌人的线程
    public void restart() {
    	new Enemy().start();
    }
    
    public void autoAttack() {
    	if(Math.random()>0.997) {
    		mainFrame.shoot.add(new Shoot(x,y,this.direction+1,true,0));
    	}
    }
    
    public void drawBlood(Graphics g) {
       	g.setColor(Color.RED);
    	    g.fillRect(x-Player.mx+475, y-Player.my+425,state,6);
    	    g.drawRect(x-Player.mx+475, y-Player.my+425,50,6);
    }
    	



}