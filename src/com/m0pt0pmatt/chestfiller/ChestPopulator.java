package com.m0pt0pmatt.chestfiller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.SpawnEgg;

public class ChestPopulator extends BlockPopulator{

	private Map<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
	
	public ChestPopulator(){
		items.put(new ItemStack(Material.WEB, 5), 100);
		items.put(new ItemStack(Material.CHAINMAIL_BOOTS), 20);
		items.put(new ItemStack(Material.CHAINMAIL_CHESTPLATE), 20);
		items.put(new ItemStack(Material.CHAINMAIL_HELMET), 20);
		items.put(new ItemStack(Material.CHAINMAIL_LEGGINGS), 20);
		
		ItemStack item;
		
		item = new SpawnEgg(EntityType.BAT).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.BLAZE).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.CHICKEN).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.COW).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.CREEPER).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.ENDERMAN).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.GHAST).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.IRON_GOLEM).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.OCELOT).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.SNOWMAN).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.PIG).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.SHEEP).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.SPIDER).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.SKELETON).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.ZOMBIE).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		item = new SpawnEgg(EntityType.WOLF).toItemStack();
		item.setAmount(1);
		items.put(item, 5);
		
		
		items.put(new ItemStack(Material.MOSSY_COBBLESTONE, 5), 20);
		items.put(new ItemStack(Material.NAME_TAG), 10);
		items.put(new ItemStack(Material.SPONGE, 5), 10);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.CREEPER.ordinal()), 15);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.SKELETON.ordinal()), 15);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.WITHER.ordinal()), 15);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.ZOMBIE.ordinal()), 15);	
	}
	
	private Random r = new Random();
	
	@Override
	public void populate(World world, Random arg1, Chunk chunk) {
		for (BlockState bs: chunk.getTileEntities()){
			
			if (bs.getType().equals(Material.CHEST)){
				
				org.bukkit.block.Chest chest = (org.bukkit.block.Chest)bs;		
				
				chest.getInventory().clear();
				
				for(int count = 0; count < 5; ){
					
					int rand = r.nextInt(100);
					
					int r2 = r.nextInt(items.size());
					
					Entry<ItemStack, Integer> item = (Entry<ItemStack, Integer>) items.entrySet().toArray()[r2];
					
					if (item.getValue() >= rand){
												
						chest.getInventory().addItem(item.getKey().clone());
						count++;
					}
				}
				
			}
			
		}
	}

}
