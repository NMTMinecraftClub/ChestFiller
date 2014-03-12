package com.m0pt0pmatt.chestfiller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestFillerPlugin extends JavaPlugin{

	
	private boolean first = true;
	private Thread thread;
	
	private Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
	
	@Override
	public void onEnable(){
		
		items.put(new ItemStack(Material.WEB), 100);
		
		
		thread = new Thread(){
			
			public void run(){
				
				getLogger().info("Thread started");
				
				while (Bukkit.getWorld("Wilderness") == null){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				getLogger().info("Wilderness exists");
				
				if (Bukkit.getWorld("Wilderness").getPopulators().size() <= 1){
				
					getLogger().info("Added populator");
					
					Bukkit.getWorld("Wilderness").getPopulators().add(new BlockPopulator(){
	
						Random r = new Random();
						
						@Override
						public void populate(World world, Random arg1, Chunk chunk) {
							for (BlockState bs: chunk.getTileEntities()){
								
								if (bs.getType().equals(Material.CHEST)){
								
									getLogger().info("Found a chest at x:" + bs.getX() + " y:" + bs.getY() + " z:" + bs.getZ());
									
									int count = 0;
									
									org.bukkit.block.Chest chest = (org.bukkit.block.Chest)bs;		
									
									for (Entry<ItemStack, Integer> entry: items.entrySet()){
										int rand = r.nextInt(100);
										
										if (rand >= entry.getValue()){
											getLogger().info("Added " + entry.getKey());
											
											chest.getInventory().addItem(entry.getKey().clone());
											if (count > 5){
												break;
											}
										}
									}
									
								}
								
							}
						}
						
					});
			
				}
			}	
		};
	
	
		if (first) {
			thread.start();
			first = false;
		}
	}
	
}
