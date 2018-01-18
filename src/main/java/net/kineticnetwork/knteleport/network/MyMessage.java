package net.kineticnetwork.knteleport.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MyMessage implements IMessage {

	public MyMessage() {
	}

	private int toSend;

	public MyMessage(int toSend) {
		this.setToSend(toSend);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		setToSend(buf.readInt());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(getToSend());
	}

	public int getToSend() {
		return toSend;
	}

	public void setToSend(int toSend) {
		this.toSend = toSend;
	}

}
