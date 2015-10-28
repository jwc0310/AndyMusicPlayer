package com.example.andymusic;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.musicplayer.andymusic.AndyMusicPlayer;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends TabActivity implements View.OnClickListener {

	TabHost mTabHost;
	
	private ScrollTabView scrollTabsView;
	private TabAdapter tabsAdapter;
	private ViewPager viewPager = null;
	private Context context = null;
	
	private ImageButton last = null;
	private ImageButton next;
	private ImageButton stop;
	private ImageButton start;
	private ListView lv1;
	
	private AndyMusicPlayer mPlayer;
	//播放列表
	private List<String> mMusicList = new ArrayList<String>();
	//当前播放歌曲的索引
	private int currentListItem = 0;
	//音乐路径
	private static final String MUSIC_PATH = new String("/storage/sdcard1/music/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);

        //get TabHost object
        mTabHost = getTabHost();
        mTabHost.addTab(mTabHost.newTabSpec("tab1")
        		.setIndicator("Recent")
        		.setContent(R.id.tv1)
        		);
        mTabHost.addTab(mTabHost.newTabSpec("tab2")
        		.setIndicator("Song")
        		.setContent(R.id.tv2)
        		);
        mTabHost.addTab(mTabHost.newTabSpec("tab3")
        		.setIndicator("Aritst")
        		.setContent(R.id.tv3)
        		);

        mTabHost.setCurrentTab(0);

        last = (ImageButton)findViewById(R.id.last);
        next = (ImageButton)findViewById(R.id.next);
        stop = (ImageButton)findViewById(R.id.stop);
        start = (ImageButton)findViewById(R.id.start);

        start.setOnClickListener(this);
        last.setOnClickListener(this);
        next.setOnClickListener(this);
        stop.setOnClickListener(this);

        lv1 = (ListView)findViewById(R.id.tv1);
        musicList();
        ListClickListener l = new ListClickListener();
        lv1.setOnItemClickListener(l);

        mPlayer = new AndyMusicPlayer();

        mTabHost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }
    //监听类
    class ListClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			String text = lv1.getItemAtPosition(position).toString();
			Log.i("Andy", "Song name is "+text);
			currentListItem = position;
			mPlayer.playMusic(MUSIC_PATH+mMusicList.get(currentListItem));
		}
    }
    //播放列表
    public void musicList(){
    	//取得指定位置的文件，设置显示到播放列表
    	File home = new File(MUSIC_PATH);
    	File[] files = home.listFiles(new MusicFilter());

    	if(files.length > 0){
    		for(File file :files){
    			Log.i("Andy", file.getName());
    			mMusicList.add(file.getName());
    		}

    		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,mMusicList);
    		lv1.setAdapter(adapter);

    	}else{
    		Log.i("Andy", "Please add read storage permission or check the path");
    	}

    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.last:
			Log.i("Andy", "Last button is clicked !");
			if(--currentListItem < 0){
				currentListItem = 0;
				Toast.makeText(this, "this is the first song", Toast.LENGTH_SHORT).show();
			}
			mPlayer.playMusic(MUSIC_PATH+mMusicList.get(currentListItem));
			break;
		case R.id.stop:
			Log.i("Andy", "Stop button is clicked !");
			mPlayer.stopMusic();
			break;
		case R.id.start:
			Log.i("Andy", "Start button is clicked !");
			mPlayer.pauseMusic();
			break;
		case R.id.next:
			Log.i("Andy", "Next button is clicked !");
			if(++currentListItem >mMusicList.size()-1){
				currentListItem = mMusicList.size()-1;
				Toast.makeText(this, "this is the last song", Toast.LENGTH_SHORT).show();
			}
			mPlayer.playMusic(MUSIC_PATH+mMusicList.get(currentListItem));
			break;
		}
	}
    
    
    void initTabs(){
    	scrollTabsView = (ScrollTabView)findViewById(R.id.tabs1);
    	tabsAdapter = new ScrollTabsAdapter(this);
    	
    	tabsAdapter.add("Recent");
    	tabsAdapter.add("Song");
    	tabsAdapter.add("Artist");
    	tabsAdapter.add("DVD");
    	tabsAdapter.add("PlayList");
    	tabsAdapter.add("School");
    	
    	scrollTabsView.setAdapter(tabsAdapter);
    	
    	
    }
    void initViewPager(){
    	viewPager=(ViewPager)findViewById(R.id.viewpager);
    	
    	PagerAdapter pagerAdapter = new PagerAdapter(){

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return false;
			}
    		
    	};
    	
    }

    class MusicFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String filename) {
			// TODO Auto-generated method stub
			return (filename.endsWith(".mp3"));
		}
    	
    }
    
    
}
