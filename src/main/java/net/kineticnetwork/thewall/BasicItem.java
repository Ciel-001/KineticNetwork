package net.kineticnetwork.thewall;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BasicItem extends Item {

	String tooltip;

	public BasicItem(String name, String tooltip) {
		this(name);
		this.tooltip = tooltip;
	}

	public BasicItem(String name) {
		setUnlocalizedName(name);
		setTextureName(BaseClass.MODID + ":" + name);

		GameRegistry.registerItem(this, name);
		System.out.println("Registered Item: " + name);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		if (tooltip != null) {
			list.add(tooltip);
		}
	}
}
