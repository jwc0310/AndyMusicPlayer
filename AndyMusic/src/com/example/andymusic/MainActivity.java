package com.example.andymusic;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends TabActivity {

	TabHost mTabHost;
	
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
        
        mTabHost.setBackgroundResource(R.drawable.bg2);
        
        mTabHost.setCurrentTab(0);
        
        mTabHost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
    }
}
