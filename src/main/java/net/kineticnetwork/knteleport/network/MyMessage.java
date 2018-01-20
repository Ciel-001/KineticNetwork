package net.kineticnetwork.knteleport.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MyMessage implements IMessage {

	public MyMessage() {
	}

	private int messageID;
	private String commandSender;
	private String argument1;

	public MyMessage(int messageID, String commandSender) {
		this.messageID = messageID;
		this.commandSender = commandSender;
	}

	public MyMessage(int messageID, String commandSender, String argument1) {
		this.messageID = messageID;
		this.commandSender = commandSender;
		this.argument1 = argument1;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		messageID = buf.readInt();
		commandSender = ByteBufUtils.readUTF8String(buf);

		if (messageID == 2) {
			argument1 = ByteBufUtils.readUTF8String(buf);
		}

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(messageID);
		ByteBufUtils.writeUTF8String(buf, commandSender);

		if (messageID == 2) {
			ByteBufUtils.writeUTF8String(buf, argument1);
		}
	}

	public int getMessage() {
		return messageID;
	}

	public String getMessageSender() {
		return commandSender;
	}

	public String getArgument1() {
		return argument1;
	}

}
