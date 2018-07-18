package music;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class LoadMusic {

	public static boolean bgMusic = false;
	private static AudioInputStream inputStream;
	private static Clip clip = null;
	/*
	 *  功能：播放音乐
	 *  参数str：代表要播放的音乐文件名
	 */
	public static void playMusic(String str) {
		try {
			inputStream = AudioSystem.getAudioInputStream(new File("./music/" + str +".wav"));
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			// 如果是背景音乐则循环播放
			if(str.equals("bgm")){
				//System.out.println("播放背景音乐");
				clip.loop(-1);
			}else{
				clip.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 功能：关闭正在播放的音乐
	 */
	public static void closeMusic(){
		System.out.println("关闭音乐："+clip.hashCode());
		clip.close();
	}
	
	public static void setBgMusic(boolean bgMusic) {
		LoadMusic.bgMusic = bgMusic;
	}
	


}
