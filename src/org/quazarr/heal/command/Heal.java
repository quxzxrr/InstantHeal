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
		
		String cm = plugin.getCustomConfig().getString("messages.consoleMessage");
		String hm = plugin.getCustomConfig().getString("messages.healMessage");
		String pm = plugin.getCustomConfig().getString("messages.permissionMessage");
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(cm);
			return true;
		}
		
		Player p = (Player) sender;

		if (p.hasPermission("heal.use")) {
			p.setHealth(20);
			p.sendMessage(hm);
		} else { 
			p.sendMessage(pm);
		}
		
		return false;
	}
}
