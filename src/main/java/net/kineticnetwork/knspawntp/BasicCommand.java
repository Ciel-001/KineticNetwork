package net.kineticnetwork.knspawntp;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BasicCommand implements ICommand {

	private final List aliases;

	public BasicCommand() {
		aliases = new ArrayList();
		aliases.add("help");
		aliases.add("?");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "help";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "How to use command here.";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] p_71515_2_) {

		World world = sender.getEntityWorld();

		// If the command is being sent from a client...
		if (world.isRemote) {
			System.out.println("Server only");
		} else { // If the command is being sent from the server...
			System.out.println("Processing...");
			
			sender.addChatMessage(new ChatComponentText("Ta da!"));
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
