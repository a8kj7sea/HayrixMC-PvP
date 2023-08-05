/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package me.sanhak.hyrixmc.pvp.utils;

import me.sanhak.hyrixmc.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlayerUtils {
    public static Player getPlayer(String playerName) {
        Player player = Bukkit.getPlayer((String)playerName);
        if (player != null) {
            return player;
        }
        return Bukkit.getOfflinePlayer((String)playerName).getPlayer();
    }

    public static void fixPlayer(final Player p) {
        if (!p.isOnline() || p == null) {
            return;
        }
        Location newLoc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 0.7, p.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
        p.teleport(newLoc);
        for (Player allPlayers : Bukkit.getOnlinePlayers()) {
            allPlayers.hidePlayer(p);
            p.hidePlayer(allPlayers);
        }
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getMain(), new Runnable(){

            @Override
            public void run() {
                for (Player allPlayers : Bukkit.getOnlinePlayers()) {
                    allPlayers.showPlayer(p);
                    p.showPlayer(allPlayers);
                }
                p.sendMessage("you have been fixed !");
            }
        }, 8L);
    }
}

