package equipment;

import javax.swing.ImageIcon;

import map.Player;
import map.gameConfig;
import fight.Blood;

public class WtoB implements gameConfig{
	
	public int z;
	public int i;
	
	//定义大小血包的回血量
	static int restore1 = 20;
	static int restore2 = 50;
	public ImageIcon[] img = {weapon1,weapon2,weapon3,weapon4,weapon5,weapon11};
	
	public WtoB(int i, int z) {
		this.i = i;
		this.z = z;
	}
	
	public void doWeapon() {
		switch(z) {
		case 0:
			Player.yy = 1;
			Weapon.bullets = 20;
			break;
		case 1:
			Player.yy = 2;
			Weapon.bullets = 30;
			break;
		case 2:
			break;
		case 3:
			if(Blood.state+restore1<Blood.blood) {
				Blood.state = Blood.state+restore1;
			}else
				Blood.state=Blood.blood;
			break;
		case 4:
			if(Blood.state+restore2<Blood.blood) {
				Blood.state = Blood.state+restore2;
			}else
				Blood.state=Blood.blood;
			break;
		case 5:
			Player.yy = 3;
			Weapon.bullets = 15;
			break;
	}
	}

}
