package com.musicplayer.andymusic;

import java.util.List;

import android.media.MediaPlayer;

public class AndyMusicPlayer extends MediaPlayer {
	//MediaPlayer����
	private MediaPlayer mMediaPlayer;
	
	public AndyMusicPlayer(){
		
		mMediaPlayer = new MediaPlayer();
	}
	
	//ֹͣ
	public void stopMusic(){
		if(mMediaPlayer.isPlaying()){
			mMediaPlayer.reset();
		}
	}
	
	//����
	public void playMusic(String path){
		try{
			//����MediaPlayer
			mMediaPlayer.reset();
			//����Ҫ���ŵ��ļ�·��
			mMediaPlayer.setDataSource(path);
			//׼������
			mMediaPlayer.prepare();
			//��ʼ����
			mMediaPlayer.start();			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��ͣ
	public void pauseMusic(){
		if(mMediaPlayer.isPlaying()){
			mMediaPlayer.pause();
		}else{
			mMediaPlayer.start();
		}
	}
	
}
