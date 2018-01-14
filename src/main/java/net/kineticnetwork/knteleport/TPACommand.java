package net.kineticnetwork.knteleport;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TPACommand implements ICommand {

	private final List aliases;

	public TPACommand() {
		aliases = new ArrayList();
		aliases.add("tpa");
		aliases.add("requesttp");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "tpa";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "tpa <username>";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {

		World world = sender.getEntityWorld();

		// If the command is being sent from a client...
		if (world.isRemote) {
			System.out.println("Server only");
		} else { // If the command is being sent from the server...

			if (args.length < 1 || args.length > 1) {
				sender.addChatMessage(new ChatComponentText("Incorrect usage! /tpa <username>"));
			} else {
				// TODO if(player is logged on) {
				System.out.println("Tpa request sent from: " + sender.getCommandSenderName() + " to " + args[0]);
				sender.addChatMessage(new ChatComponentText("Sent teleport request to " + args[0] + ", awaiting reply..."));
				
				//TODO Send request to player
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] p_71516_2_) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}

}
