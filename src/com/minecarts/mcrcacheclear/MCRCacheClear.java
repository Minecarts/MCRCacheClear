package com.minecarts.mcrcacheclear;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.PluginDescriptionFile;

import org.bukkit.event.*;

import net.minecraft.server.RegionFileCache;

import java.util.logging.Logger;

public class MCRCacheClear extends org.bukkit.plugin.java.JavaPlugin{
	public final Logger log = Logger.getLogger("com.minecarts.mcrcacheclear");
    private final long delay = (20 * 60) * 30;
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile pdf = getDescription();
        log.info("[" + pdf.getName() + "] version " + pdf.getVersion() + " enabled.");

        getServer().getScheduler().scheduleSyncRepeatingTask(this,new Runnable() {
            public void run() {
                Bukkit.dispatchCommand(getServer().getConsoleSender(),"save-all");
                log.info("MCRCacheClear> Clearing region file cache");
                RegionFileCache.a();
            }
        },delay,delay);
    }

    public void onDisable(){

    }
}
