package com.example.andymusic;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

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
	
	//播放列表
	private List<String> mMusicList = new ArrayList<String>();
	//音乐路径
	private static final String MUSIC_PATH = new String("/外置存储卡/music/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);
        
        //context = getBaseContext();
        //initTabs();
        //initViewPager();
        
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
        
        mTabHost.setCurrentTab(1);   
        
        last = (ImageButton)findViewById(R.id.last);
        next = (ImageButton)findViewById(R.id.next);
        stop = (ImageButton)findViewById(R.id.stop);
        start = (ImageButton)findViewById(R.id.start);
        lv1 = (ListView)findViewById(R.id.tv1);
        
        mTabHost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }
    
    //播放列表
    public void musicList(){
    	//取得指定位置的文件，设置显示到播放列表
    	File home = new File(MUSIC_PATH);
    	if(home.listFiles(new MusicFilter()).length > 0){
    		for(File file : home.listFiles(new MusicFilter())){
    			mMusicList.add(file.getName());
    		}
    		ArrayAdapter<String> musicList = new ArrayAdapter<String>(MainActivity.this,R.id.tv1,mMusicList);
    	}
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.last:
			break;
		case R.id.stop:
			break;
		case R.id.start:
			break;
		case R.id.next:
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
    	
    	//MyFragment f1 = new MyFragment("最近");	
    }

    class MusicFilter implements FilenameFilter{

		@Override
		public boolean accept(File dir, String filename) {
			// TODO Auto-generated method stub
			return (filename.endsWith(".mp3"));
		}
    	
    }
    
    
}
