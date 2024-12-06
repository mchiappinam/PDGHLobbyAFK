package me.mchiappinam.pdghlobbyafk;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	final HashMap<String, Integer> taskIDs = new HashMap<String, Integer>();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyAFK] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyAFK] §2Acesse: http://pdgh.com.br/");
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyAFK] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLobbyAFK] §2Acesse: http://pdgh.com.br/");
	}
		
	public void startTask(final Player p) {
		taskIDs.put(p.getName(), getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				p.kickPlayer(ChatColor.RED+"Ⓥⓞⓒⓔ ⓝⓐⓞ ⓟⓞⓓⓔ ⓕⓘⓒⓐⓡ ⓜⓐⓘⓢ ⓓⓔ ⑩ ⓜⓘⓝⓤⓣⓞⓢ ⓝⓞ ⓛⓞⓑⓑⓨ");
			}
		}, 10*60*20L));
	}
		
	public void cancelTask(Player p) {
		Bukkit.getScheduler().cancelTask(taskIDs.get(p.getName()));
	}
	  
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		startTask(e.getPlayer());
	}
	  
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		cancelTask(e.getPlayer());
	}
		
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		cancelTask(e.getPlayer());
	}
	  
}