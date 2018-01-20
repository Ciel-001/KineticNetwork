package net.kineticnetwork.knteleport.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.kineticnetwork.knteleport.BaseClass;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class MyMessageHandler implements IMessageHandler<MyMessage, IMessage> {

	@Override
	public IMessage onMessage(MyMessage message, MessageContext ctx) {
		// System.out.println(String.format("Received %s from %s", message.getToSend(),
		// ctx.getServerHandler().playerEntity.getDisplayName()));
		// return null; // no response in this case

		int messageCode = message.getMessage();
		String messageSender = message.getMessageSender();
		String messageArgument1 = "";

		if (messageCode == 2) {
			messageArgument1 = message.getArgument1();
		}

		World world = DimensionManager.getWorld(0);

		// Server side
		if (!world.isRemote) {
			if (messageCode == 1) {
				System.out.println("Player joined: " + messageSender);
				BaseClass.NETWORK.sendTo(new MyMessage(1, "host"), world.getPlayerEntityByName(messageSender));
			}

		} else {
			// Client side
			if (messageCode == 1) {
				ctx.getServerHandler().playerEntity.addChatComponentMessage(
						new ChatComponentText("Connection established, welcome to the server!"));
			}

		}

		return null;
	}

}
