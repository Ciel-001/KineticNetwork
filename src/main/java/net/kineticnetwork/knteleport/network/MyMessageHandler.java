package net.kineticnetwork.knteleport.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;

public class MyMessageHandler implements IMessageHandler<MyMessage, IMessage> {

	@Override
	public IMessage onMessage(MyMessage message, MessageContext ctx) {
		// System.out.println(String.format("Received %s from %s", message.getToSend(),
		// ctx.getServerHandler().playerEntity.getDisplayName()));
		// return null; // no response in this case

		int messageCode = message.getToSend();
		if (messageCode == 1) {
			System.out.println("Message Recieved from " + ctx.getServerHandler().playerEntity.getDisplayName());
		}
		return null;
	}

}
