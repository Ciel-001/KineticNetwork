package net.kineticnetwork.knteleport;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.server.network.NetHandlerLoginServer;

@Mod(modid = BaseClass.MODID, name = BaseClass.NAME, version = BaseClass.VERSION)
public class BaseClass {

	/**
	 * TODO LIST TP player to spawn upon join
	 **/

	public static final String MODID = "knteleport";
	public static final String NAME = "KN Teleport";
	public static final String VERSION = "0.0.1";

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		// register server commands
		event.registerServerCommand(new TPACommand());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
		System.out.println("Loaded Spawn TP!");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
