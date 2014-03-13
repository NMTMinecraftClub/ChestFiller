package com.m0pt0pmatt.chestfiller;

import org.bukkit.Bukkit;

public class ChestThread extends Thread{

	public void run(){
				
		while (Bukkit.getWorld("Wilderness") == null){
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (Bukkit.getWorld("Wilderness").getPopulators().size() <= 1){
			
			
			System.out.println("Added populator!!!!!!!!!!!!!!!");
			Bukkit.getWorld("Wilderness").getPopulators().add(new ChestPopulator());
	
		}
	}	
	
}
