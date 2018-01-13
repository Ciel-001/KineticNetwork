package com.gg5.cosblocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

	public BasicBlock(Material m, String name) {
		this(m, name, 0f);
	}
	
	public BasicBlock(Material m, String name, float lightlevel) {
		super(m);
		setBlockName(name);
		setBlockTextureName(BaseClass.MODID + ":" + name);
		setCreativeTab(BaseClass.tabCosBlocks);
		setHardness(1.0f);
		setResistance(10.0f);
		setLightLevel(lightlevel);
		
		GameRegistry.registerBlock(this, name);
		System.out.println("Registered Block: " + name);
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}
}
