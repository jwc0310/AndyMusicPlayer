package com.example.andymusic;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

public abstract class TabAdapter {
	List<String> tabsList = new ArrayList<String>();
	
	public abstract View getView(int position);
	
	public int getCount(){
		return tabsList.size();
	}
	
	public void add(String name){
		tabsList.add(name);
	}
}
