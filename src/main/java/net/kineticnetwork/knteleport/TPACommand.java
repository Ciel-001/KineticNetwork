package net.kineticnetwork.knteleport;

import java.util.ArrayList;
import java.util.List;

import net.kineticnetwork.knteleport.network.MyMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TPACommand extends CommandBase {

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
			System.out.println("Server only processing");
		} else { // If the command is being sent from the server...

			if (args.length < 1 || args.length > 1) {
				sender.addChatMessage(new ChatComponentText("Incorrect usage! /tpa <username>"));
			} else {
				if (!args[0].equals(sender.getCommandSenderName())) {
					for (int i = 0; i < getPlayers().length; i++) {
						if (getPlayers()[i].equals(args[0])) {
							BaseClass.NETWORK.sendToServer(new MyMessage(2, sender.getCommandSenderName(), getPlayers()[i]));
							System.out.println(
									"Tpa request sent from: " + sender.getCommandSenderName() + " to " + args[0]);
							sender.addChatMessage(new ChatComponentText(
									"Sent teleport request to " + args[0] + ", awaiting reply..."));
							return;
						}
					}
				} else {
					sender.addChatMessage(new ChatComponentText("You can't teleport to yourself!"));
					return;
				}

				sender.addChatMessage(new ChatComponentText("The player '" + args[0] + "' could not be found."));

				// TODO Send request to player
			}
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] par2) {
		return par2.length == 1 ? getListOfStringsMatchingLastWord(par2, this.getPlayers()) : null;

	}

	protected String[] getPlayers() {
		return MinecraftServer.getServer().getAllUsernames();
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}

}
