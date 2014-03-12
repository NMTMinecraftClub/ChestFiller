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
		items.put(new ItemStack(Material.WEB), 100);
		items.put(new ItemStack(Material.CHAINMAIL_BOOTS), 20);
		items.put(new ItemStack(Material.CHAINMAIL_CHESTPLATE), 20);
		items.put(new ItemStack(Material.CHAINMAIL_HELMET), 20);
		items.put(new ItemStack(Material.CHAINMAIL_LEGGINGS), 20);
		items.put(new SpawnEgg(EntityType.BAT).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.BLAZE).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.CHICKEN).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.COW).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.CREEPER).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.ENDERMAN).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.GHAST).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.IRON_GOLEM).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.OCELOT).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.SNOWMAN).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.PIG).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.SHEEP).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.PLAYER).toItemStack(), 100);
		items.put(new SpawnEgg(EntityType.SPIDER).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.SKELETON).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.ZOMBIE).toItemStack(), 5);
		items.put(new SpawnEgg(EntityType.WOLF).toItemStack(), 5);
		items.put(new ItemStack(Material.MOSSY_COBBLESTONE, 5), 20);
		items.put(new ItemStack(Material.NAME_TAG), 10);
		items.put(new ItemStack(Material.SPONGE, 5), 10);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.CREEPER.ordinal()), 10);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.SKELETON.ordinal()), 10);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.WITHER.ordinal()), 10);
		items.put(new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.ZOMBIE.ordinal()), 10);
		
	}
	
	private Random r = new Random();
	private int index = 0;
	
	
	@Override
	public void populate(World world, Random arg1, Chunk chunk) {
		for (BlockState bs: chunk.getTileEntities()){
			
			if (bs.getType().equals(Material.CHEST)){
				
				org.bukkit.block.Chest chest = (org.bukkit.block.Chest)bs;		
				
				for(int count = 0; count > 5; index++){
					
					int rand = r.nextInt(100);
					Entry<ItemStack, Integer>
					
					if (valuelist[index % valuelist.length] >= rand){
						chest.getInventory().addItem(itemlist[index % itemlist.length].clone());
						count++;
					}
				}
				
			}
			
		}
	}

}
