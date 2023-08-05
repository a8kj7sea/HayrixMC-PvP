/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.GameMode
 *  org.bukkit.WeatherType
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package me.sanhak.hyrixmc.pvp.listener;

import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.kit.KitUtils;
import me.sanhak.hyrixmc.pvp.main.Main;
import me.sanhak.hyrixmc.pvp.utils.BoardUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener
implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        e.setJoinMessage(null);
        if (!PlayerData.playerDataExists(p.getName())) {
            PlayerData.setCoins(p.getName(), 50);
            PlayerData.setKills(p.getName(), 0);
            PlayerData.setStreaks(p.getName(), 0);
            PlayerData.setDeaths(p.getName(), 0);
            p.setPlayerWeather(WeatherType.CLEAR);
            p.setGameMode(GameMode.SURVIVAL);
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setLevel(0);
            Locations.teleportPlayerToSpawnLocation(p);
            KitUtils.grantKit(p);
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getMain(), new BukkitRunnable(){

                public void run() {
                    BoardUtils.updatePlayerBoard(p);
                }
            }, 20L);
        } else {
            KitUtils.grantKit(p);
            BoardUtils.updatePlayerBoard(p);
            p.setPlayerWeather(WeatherType.CLEAR);
            p.setGameMode(GameMode.SURVIVAL);
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setLevel(0);
            PlayerData.removeStreak(p.getName(), PlayerData.getStreak(p.getName()));
            PlayerData.setStreaks(p.getName(), 0);
            Locations.teleportPlayerToSpawnLocation(p);
        }
    }
}

