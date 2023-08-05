/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.GameMode
 *  org.bukkit.WeatherType
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerRespawnEvent
 */
package me.sanhak.hyrixmc.pvp.listener;

import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.kit.KitUtils;
import me.sanhak.hyrixmc.pvp.utils.BoardUtils;
import org.bukkit.GameMode;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener
implements Listener {
    @EventHandler
    public void onrespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        BoardUtils.updatePlayerBoard(p);
        p.setPlayerWeather(WeatherType.CLEAR);
        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setLevel(0);
        PlayerData.removeStreak(p.getName(), PlayerData.getStreak(p.getName()));
        PlayerData.setStreaks(p.getName(), 0);
        Locations.teleportPlayerToSpawnLocation(p);
        KitUtils.grantKit(p);
    }
}

