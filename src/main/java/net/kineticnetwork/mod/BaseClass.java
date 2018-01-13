package net.kineticnetwork.mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = BaseClass.MODID, version = BaseClass.VERSION)
public class BaseClass {
	
	/** TODO LIST
	 * I think that's it...
	**/ 
	
	public static final String MODID = "knthewall";
	public static final String VERSION = "0.0.1";

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Loaded THE WALL!");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
