/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.Bukkit
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package me.sanhak.hyrixmc.pvp.main;

import me.sanhak.hyrixmc.pvp.command.BuildCommand;
import me.sanhak.hyrixmc.pvp.command.FixCommand;
import me.sanhak.hyrixmc.pvp.command.LocationsCommand;
import me.sanhak.hyrixmc.pvp.command.ReloadCommand;
import me.sanhak.hyrixmc.pvp.command.StatsCommand;
import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.task.CombatTask;
import me.sanhak.hyrixmc.pvp.utils.ListenersUtils;
import me.sanhak.hyrixmc.pvp.utils.PluginUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin {
    private static Main main;
    public Locations locationConfig;

    public void onEnable() {
        main = this;
        this.locationConfig = new Locations(this, true);
        Locations.loadTopKillsHologram();
        ListenersUtils.registerListener(this);
        this.getCommand("pvpset").setExecutor((CommandExecutor)new LocationsCommand());
        this.getCommand("stats").setExecutor((CommandExecutor)new StatsCommand());
        this.getCommand("pvprl").setExecutor((CommandExecutor)new ReloadCommand());
        this.getCommand("fix").setExecutor((CommandExecutor)new FixCommand());
        this.getCommand("pvpbuild").setExecutor((CommandExecutor)new BuildCommand());
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)this, (Runnable)new CombatTask(), 20L, 20L);
        if (PluginUtils.exists("HolographicDisplays") && PluginUtils.exists("LuckPerms")) {
            Bukkit.getConsoleSender().sendMessage((Object)ChatColor.GREEN + "[SanhakPvP] has been Enabled !");
        } else {
            Bukkit.getConsoleSender().sendMessage((Object)ChatColor.RED + "[SanhakPvP] has been disabled please install luckperms plugin & HolographicDisplays plugin to start plugin !");
        }
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage((Object)ChatColor.RED + "[SanhakPvP] has been disabled !");
    }

    public static Main getMain() {
        return main;
    }
}

