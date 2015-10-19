package com.example.andymusic;

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
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity {

	TabHost mTabHost;
	
	private ScrollTabView scrollTabsView;
	private TabAdapter tabsAdapter;
	private ViewPager viewPager;
	private Context context;
	
	
	
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
        
        //mTabHost.setBackgroundResource(R.drawable.bg2);
        
        mTabHost.setCurrentTab(0);
        
        mTabHost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
			}
        	
        });
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
    	
    	//MyFragment f1 = new MyFragment("×î½ü");
    	
    }
    
    
    
}
