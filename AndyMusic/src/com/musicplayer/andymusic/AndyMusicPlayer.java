package com.musicplayer.andymusic;

import java.util.List;

import android.media.MediaPlayer;

public class AndyMusicPlayer extends MediaPlayer {
	//MediaPlayer对象
	private MediaPlayer mMediaPlayer;
	
	public AndyMusicPlayer(){
		
		mMediaPlayer = new MediaPlayer();
	}
	
	//停止
	public void stopMusic(){
		if(mMediaPlayer.isPlaying()){
			mMediaPlayer.reset();
		}
	}
	
	//播放
	public void playMusic(String path){
		try{
			//重置MediaPlayer
			mMediaPlayer.reset();
			//设置要播放的文件路径
			mMediaPlayer.setDataSource(path);
			//准备播放
			mMediaPlayer.prepare();
			//开始播放
			mMediaPlayer.start();			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//暂停
	public void pauseMusic(){
		if(mMediaPlayer.isPlaying()){
			mMediaPlayer.pause();
		}else{
			mMediaPlayer.start();
		}
	}
	
}
