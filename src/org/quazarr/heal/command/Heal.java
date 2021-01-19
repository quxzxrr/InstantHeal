package org.quazarr.heal.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.quazarr.heal.Main;

public class Heal implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Heal(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("heal").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String em = plugin.getCustomConfig().getString("messages.consoleMessage");
		String hm = plugin.getCustomConfig().getString("messages.healMessage");
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(em);
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("heal.use")) {
			p.setHealth(20);
			p.sendMessage(hm);
		}
		
		return false;
	}
}
