package com.gg5.cosblocks;

import com.gg5.cosblocks.metadata.MetaBlockAlien;
import com.gg5.cosblocks.metadata.MetaBlockColours;
import com.gg5.cosblocks.metadata.MetaBlockDirections;

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
	public static final String MODID = "gg5cosblocks";
	public static final String VERSION = "0.1";

	public static Block metallicSimple;
	public static Block metallicTiled;
	public static Block metallicLinear;
	public static Block metallicLight;

	public static Block alienBlock;

	public static Block colouredBricks;

	public static Block ventilatorGrid;
	public static Block ventilator;

	public static Block bleachedStone;
	public static Block kineticBlock; // TODO other types
	public static Block warningBlock;
	public static Block mud;
	public static Block packedSnow;

	public static Block darkenedBlock;
	public static Block darkenedPanel;

	public static Block dataBlock1;
	public static Block dataBlock2;
	public static Block dataBlock3;
	public static Block dataBlock4;
	public static Block dataBlock5;
	public static Block dataBlock6;

	public static Block parodySand;
	public static Block parodySand2;
	public static Block parodySandStone; // TODO
	public static Block parodySandStoneSmooth; // TODO
	public static Block parodySandStoneCarved; // TODO

	public static Block shadowStone;
	public static Block shadowStoneBrick;
	public static Block shadowStoneBrickFancy;
	public static Block shadowStoneSlab; // TODO

	// TODO Vent door
	public static Block blockVentDoor;
	public static Item itemVentDoor;

	public static Item pinchOfGlowstone;
	public static Item kineticDust;
	public static Item gleamingDust;
	public static Item clutterDust;

	public static CreativeTabs tabCosBlocks = new TabCosBlocks(CreativeTabs.getNextID(), "cosblocks");

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Normal Blocks
		metallicSimple = new BasicBlock(Material.iron, "metallicsimple");
		metallicTiled = new BasicBlock(Material.iron, "metallictiled");

		ventilatorGrid = new BasicBlock(Material.iron, "ventilatorgrid");
		ventilator = new BasicBlock(Material.iron, "ventilator");

		bleachedStone = new BasicBlock(Material.rock, "bleachedstone");
		kineticBlock = new BasicBlock(Material.iron, "kineticblock");
		warningBlock = new BasicBlock(Material.cloth, "warningblock");
		mud = new BasicBlock(Material.ground, "mud");

		packedSnow = new BasicBlock(Material.snow, "packedsnow");
		parodySand = new BasicBlock(Material.sand, "parodysand");

		darkenedBlock = new BasicBlock(Material.iron, "darkenedblock");
		darkenedPanel = new BasicBlock(Material.iron, "darkenedpanel");

		dataBlock1 = new BasicBlock(Material.iron, "datablock1");
		dataBlock2 = new BasicBlock(Material.iron, "datablock2");
		dataBlock3 = new BasicBlock(Material.iron, "datablock3");
		dataBlock4 = new BasicBlock(Material.iron, "datablock4");
		dataBlock5 = new BasicBlock(Material.iron, "datablock5");
		dataBlock6 = new BasicBlock(Material.iron, "datablock6");

		shadowStone = new BasicBlock(Material.rock, "shadowstone");
		shadowStoneBrick = new BasicBlock(Material.rock, "shadowstonebrick");
		shadowStoneBrickFancy = new BasicBlock(Material.rock, "shadowstonebrickfancy");

		// Metadata Blocks
		metallicLinear = new MetaBlockDirections(Material.iron, "metalliclinear", 0f);
		metallicLight = new MetaBlockDirections(Material.iron, "metalliclight", 0.9375f);

		alienBlock = new MetaBlockAlien(Material.clay, "alien", 0.1f);

		colouredBricks = new MetaBlockColours(Material.rock, "bricks", 0f);

		// Normal Items
		pinchOfGlowstone = new BasicItem("pinchofglowstone");
		kineticDust = new BasicItem("kineticdust");
		gleamingDust = new BasicItem("gleamingdust");
		clutterDust = new BasicItem("clutterdust", "This looks a lot like redstone...");

		// Item Doors
		blockVentDoor = new MyBlockDoor(Material.iron, "blockventdoor");
		itemVentDoor = new MyItemDoor(Material.iron, "itemventdoor");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Item Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(pinchOfGlowstone, 4), new Object[] { Items.glowstone_dust });

		// 8x pinchOfGlowstone + 1x lapis
		GameRegistry.addShapelessRecipe(new ItemStack(kineticDust, 8),
				new Object[] { new ItemStack(Items.dye, 1, 4), pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone,
						pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone });

		// 8x pinchOfGlowstone + 1x cactus green
		GameRegistry.addShapelessRecipe(new ItemStack(gleamingDust, 8),
				new Object[] { new ItemStack(Items.dye, 1, 2), pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone,
						pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone });

		// 8x pinchOfGlowstone + 1x red dye
		GameRegistry.addShapelessRecipe(new ItemStack(clutterDust, 8),
				new Object[] { new ItemStack(Items.dye, 1, 1), pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone,
						pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone });

		// pinchOfGlowstone > glowstone dust
		GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust),
				new Object[] { pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone, pinchOfGlowstone });

		// Block Recipes
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 0), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 1), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 1));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 2), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 2));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 3), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 3));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 4), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 4));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 5), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 5));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 6), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 6));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 7), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 7));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 8), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 8));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 9), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 9));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 10), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 10));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 11), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 11));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 12), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 12));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 13), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 13));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 14), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 14));
		GameRegistry.addShapedRecipe(new ItemStack(colouredBricks, 2, 15), "aaa", "aba", "aaa", 'a', Items.brick, 'b',
				new ItemStack(Items.dye, 1, 15));

		// Plain Metallic block
		GameRegistry.addShapedRecipe(new ItemStack(metallicSimple, 8), "aaa", "aba", "aaa", 'a', Blocks.stone, 'b',
				Blocks.iron_bars);

		// Tiled Metallic block
		GameRegistry.addShapelessRecipe(new ItemStack(metallicTiled, 4), metallicSimple, metallicSimple, metallicSimple,
				metallicSimple);

		// Linear Blocks
		GameRegistry.addShapedRecipe(new ItemStack(metallicLinear, 4, 0), "aba", "bcb", "aba", 'a', metallicSimple, 'b',
				Blocks.glass_pane, 'c', kineticDust);
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLinear, 1, 0), new ItemStack(metallicLinear, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLinear, 1, 1), new ItemStack(metallicLinear, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLinear, 1, 2), new ItemStack(metallicLinear, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLinear, 1, 3), new ItemStack(metallicLinear, 1, 2));

		// Linear Light Blocks
		GameRegistry.addShapedRecipe(new ItemStack(metallicLight, 4, 0), "aba", "bcb", "aba", 'a', metallicSimple, 'b',
				Blocks.glass_pane, 'c', gleamingDust);
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLight, 1, 0), new ItemStack(metallicLight, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLight, 1, 1), new ItemStack(metallicLight, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLight, 1, 2), new ItemStack(metallicLight, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(metallicLight, 1, 3), new ItemStack(metallicLight, 1, 2));

		// Alien Blocks
		GameRegistry.addShapedRecipe(new ItemStack(alienBlock, 4, 0), "aaa", "aba", "aca", 'a', Items.rotten_flesh, 'b',
				clutterDust, 'c', Items.slime_ball);
		GameRegistry.addShapelessRecipe(new ItemStack(alienBlock, 1, 0), new ItemStack(alienBlock, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(alienBlock, 1, 1), new ItemStack(alienBlock, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(alienBlock, 1, 2), new ItemStack(alienBlock, 1, 1));

		// Bleached Stone
		GameRegistry.addShapelessRecipe(new ItemStack(bleachedStone, 8), new ItemStack(Items.dye, 1, 15), Blocks.stone);

		// Kinetic Block
		GameRegistry.addShapelessRecipe(new ItemStack(kineticBlock), kineticDust, kineticDust, kineticDust, kineticDust,
				kineticDust, kineticDust, kineticDust, kineticDust, kineticDust);

		// Warning Block
		GameRegistry.addShapedRecipe(new ItemStack(warningBlock, 2), "ab", "ba", 'a', new ItemStack(Blocks.wool, 1, 15),
				'b', new ItemStack(Blocks.wool, 1, 4));
		GameRegistry.addShapedRecipe(new ItemStack(warningBlock, 2), "ba", "ab", 'a', new ItemStack(Blocks.wool, 1, 15),
				'b', new ItemStack(Blocks.wool, 1, 4));

	}
}
