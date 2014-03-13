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
		
		Bukkit.getWorld("Wilderness").setMonsterSpawnLimit(600);
		Bukkit.getWorld("Wilderness").setTicksPerMonsterSpawns(1);
		Bukkit.getWorld("Wilderness").setTicksPerAnimalSpawns(1);
		Bukkit.getWorld("Wilderness").setAnimalSpawnLimit(600);
		
		if (Bukkit.getWorld("Wilderness").getPopulators().size() <= 1){	
			Bukkit.getWorld("Wilderness").getPopulators().add(new ChestPopulator());
			
		}
		
		while(true){
			Bukkit.getWorld("Wilderness").setTime(15000);
			Bukkit.getWorld("Wilderness").setMonsterSpawnLimit(600);
			Bukkit.getWorld("Wilderness").setTicksPerMonsterSpawns(1);
			Bukkit.getWorld("Wilderness").setTicksPerAnimalSpawns(1);
			Bukkit.getWorld("Wilderness").setAnimalSpawnLimit(600);
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}	
	
}
