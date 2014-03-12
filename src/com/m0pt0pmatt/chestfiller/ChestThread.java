package com.m0pt0pmatt.chestfiller;

import org.bukkit.Bukkit;

public class ChestThread extends Thread{

	public void run(){
				
		while (Bukkit.getWorld("Wilderness") == null){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (Bukkit.getWorld("Wilderness").getPopulators().size() <= 1){
					
			Bukkit.getWorld("Wilderness").getPopulators().add(new ChestPopulator());
	
		}
	}	
	
}
