package com.gg5.cosblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabCosBlocks extends CreativeTabs {

	public TabCosBlocks(int par1, String par2) {
		super(par1, par2);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BaseClass.metallicLinear);
	}

}
