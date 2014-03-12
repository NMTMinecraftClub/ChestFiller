package com.m0pt0pmatt.chestfiller;

import org.bukkit.plugin.java.JavaPlugin;

public class ChestFillerPlugin extends JavaPlugin{
	
	private boolean first = true;
	private Thread thread;
	
	
	@Override
	public void onEnable(){		
		
		thread = new ChestThread();
	
	
		if (first) {
			thread.start();
			first = false;
		}
	}
	
}
