package me.Scrap.Event;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Event extends JavaPlugin implements Listener{
	public static int Timer = 0;
	
	public static int timeInSeconds = 120;
	
	public static boolean canStart;
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info("Event handler has loaded correctly");
	}
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Event handler has disabled");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("host")) {
			TextComponent host1 = new TextComponent("         Click what event you would like to host");
			host1.setColor(ChatColor.GOLD);
			host1.setBold(true);
			host1.setHoverEvent( new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("This is the hosting menu").color(ChatColor.RED).create()));
			TextComponent event1 = new TextComponent("   Drop Party");
			event1.setColor(ChatColor.LIGHT_PURPLE);
			event1.setBold(true);
			event1.setHoverEvent( new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("When you click this you will start a drop party event").color(ChatColor.RED).create()));
			event1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/sdp"));
			
			p.sendMessage("    ");
			p.sendMessage("    "); 
			p.spigot().sendMessage(host1); 
			p.sendMessage("    ");
			p.sendMessage("    ");
			p.spigot().sendMessage(event1);
			p.sendMessage("    ");
			p.sendMessage("    ");
			return true;
		}
			if (cmd.getName().equalsIgnoreCase("sdp")) {
				Bukkit.getServer().broadcastMessage(ChatColor.RED + " " + ChatColor.BOLD + "" + sender.getName() + " has started a drop party!");
				canStart = false;
				timeInSeconds = 120;
				Timer = getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Timer(), 20l, 20l);
				canStart = Bukkit.getOnlinePlayers().size() >= 1;
				return true;
	}
			if (cmd.getName().equalsIgnoreCase("edp")) {
				Bukkit.getServer().broadcastMessage(ChatColor.RED + " " + ChatColor.BOLD + "" + sender.getName() + " has stopped the drop party countdown!");
				getServer().getScheduler().cancelTask(Timer);
			}
			if (cmd.getName().equalsIgnoreCase("joindp")) {
				p.sendMessage(ChatColor.GREEN + "You have telerpoted to the drop party event");
				p.teleport(new Location(Bukkit.getWorld("world"), -32.5, 48, 709.5));
				return true;
				
			}
			
			return false;
	}
}
