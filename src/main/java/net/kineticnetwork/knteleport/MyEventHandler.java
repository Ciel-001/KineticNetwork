package net.kineticnetwork.knteleport;

import java.util.UUID;

import com.sun.javafx.collections.MappingChange.Map;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.kineticnetwork.knteleport.network.MyMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import scala.collection.mutable.HashMap;

public class MyEventHandler {

	public HashMap<UUID, String> playerMap;

	private boolean joined = false;

	public MyEventHandler() {
		playerMap = new HashMap<UUID, String>();
	}

	// Tick event, 20 ticks == 1 second
	@SubscribeEvent
	public void onUpdate(TickEvent e) {
		if (e.side == Side.SERVER) {
			World world = MinecraftServer.getServer().getEntityWorld();

			if (world != null) {

				for (int i = 0; i < world.playerEntities.size(); i++) {
					EntityPlayer currentplayer = (EntityPlayer) world.playerEntities.get(i);
					playerMap.put(currentplayer.getUniqueID(), currentplayer.getDisplayName());
				}
			}
		} else {
			if (!joined && Minecraft.getMinecraft().theWorld != null) {
				BaseClass.NETWORK.sendToServer(new MyMessage(1, Minecraft.getMinecraft().thePlayer.getDisplayName()));
				joined = true;
			}
		}
	}

	// On block destroyed by player
	@SubscribeEvent
	public void onBlockDestroyed(PlayerInteractEvent e) {
		/**
		 * We need to verify the line below is reliable - should be but ModPacks are
		 * unpredictable.
		 **/
		World world = DimensionManager.getWorld(0);

		// Is the world remotely controlled (true = client, false = server)
		if (!world.isRemote) {
			System.out.println("test");
		}
	}

}
