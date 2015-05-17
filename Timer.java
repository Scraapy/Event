package me.Scrap.Event;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;

public class Timer implements Runnable {
	
	public void run() {
		if (Event.timeInSeconds >= 60 && Event.timeInSeconds % 60 == 0) {
			broadcastTimeUntilStart(true);
		}
		if(Event.timeInSeconds <= 30 && Event.timeInSeconds%15 ==0 && Event.timeInSeconds > 0) {
			broadcastTimeUntilStart(true);
		}
		if(Event.timeInSeconds <=5 && Event.timeInSeconds>0) {
			broadcastTimeUntilStart(true);
		}
		if (Event.timeInSeconds == 0) {
			if(Event.canStart) {
			Bukkit.getServer().getScheduler().cancelTask(Event.Timer);
			TextComponent event1 = new TextComponent(ChatColor.DARK_GRAY + " ▏ " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD +  "!" + ChatColor.DARK_GRAY + " ▏ " + ChatColor.GRAY + " A drop party has been summoned!" +  ChatColor.GRAY + " Click" + ChatColor.GRAY + " this message " + ChatColor.GRAY + ChatColor.GRAY+" " + ChatColor.GRAY + "to" + ChatColor.GRAY + " be " + ChatColor.GRAY + "teleported to the event!");
			
			event1.setHoverEvent( new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clicking this will teleport you to the drop party arena").bold(false).color(ChatColor.RED).create()));
			event1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joindp"));
			    Bukkit.getServer().broadcastMessage("   ");
				Bukkit.getServer().spigot().broadcast(event1);
				Bukkit.getServer().broadcastMessage("   ");
			}
				else {
 					Bukkit.broadcastMessage(ChatColor.RED + "Welp");
				}
				}
			if (Event.timeInSeconds>0) {
				Event.timeInSeconds--;
			}
	}
	private void broadcastTimeUntilStart(boolean extraArgs) {
		if (extraArgs) {
			
			}
		if(Event.timeInSeconds % 60 == 0 && Event.timeInSeconds >= 60) {
			TextComponent bc1 = new TextComponent(ChatColor.DARK_GRAY + " ▏ " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + " ▏" + ChatColor.GRAY + " A drop party is happening in " + ChatColor.LIGHT_PURPLE + Event.timeInSeconds + " seconds! " + ChatColor.GRAY + "Click " + ChatColor.GRAY + "this " + ChatColor.GRAY + "message" + ChatColor.GRAY + " to" + ChatColor.GRAY + " be " + ChatColor.GRAY + "teleported to the event!");
			
			bc1.setHoverEvent( new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clicking this will teleport you to the drop party arena").bold(false).color(ChatColor.RED).create()));
			bc1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joindp"));
			    Bukkit.getServer().broadcastMessage("   ");
				Bukkit.getServer().spigot().broadcast(bc1);
				Bukkit.getServer().broadcastMessage("   ");
		} else if(Event.timeInSeconds % 15 == 0 && Event.timeInSeconds<60) {
			TextComponent bc2 = new TextComponent(ChatColor.DARK_GRAY + " ▏ " + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + " ▏" + ChatColor.GRAY + " A drop party is happening in " + ChatColor.LIGHT_PURPLE + Event.timeInSeconds + " seconds! " + ChatColor.GRAY + "Click " + ChatColor.GRAY + "this " + ChatColor.GRAY + "message" + ChatColor.GRAY + " to" + ChatColor.GRAY + " be " + ChatColor.GRAY + "teleported to the event!");
			
			bc2.setHoverEvent( new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Clicking this will teleport you to the drop party arena").bold(false).color(ChatColor.RED).create()));
			bc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joindp"));
			    Bukkit.getServer().broadcastMessage("   ");
				Bukkit.getServer().spigot().broadcast(bc2);
				Bukkit.getServer().broadcastMessage("   ");
		}
	}
}
