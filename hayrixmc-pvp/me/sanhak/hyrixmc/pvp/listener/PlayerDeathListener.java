/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.plugin.Plugin
 */
package me.sanhak.hyrixmc.pvp.listener;

import java.util.Random;
import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.main.Main;
import me.sanhak.hyrixmc.pvp.ranks.RanksUtils;
import me.sanhak.hyrixmc.pvp.utils.BoardUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDeathListener
implements Listener {
    @EventHandler
    public void onDeath1(PlayerDeathEvent e) {
        Player player = e.getEntity();
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getMain(), () -> player.spigot().respawn(), 1L);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();
        if (k == null) {
            return;
        }
        if (p == null) {
            return;
        }
        if (p == k) {
            return;
        }
        e.setDeathMessage(null);
        Locations.teleportPlayerToSpawnLocation(p);
        PlayerData.addCoins(k.getName(), new Random().nextInt(41));
        BoardUtils.updatePlayerBoard(k);
        PlayerData.removeCoins(p.getName(), new Random().nextInt(21));
        BoardUtils.updatePlayerBoard(p);
        PlayerData.addStreak(k.getName(), 1);
        BoardUtils.updatePlayerBoard(k);
        PlayerData.removeStreak(p.getName(), PlayerData.getStreak(p.getName()));
        PlayerData.setStreaks(p.getName(), 0);
        BoardUtils.updatePlayerBoard(p);
        e.getDrops().clear();
        e.setDroppedExp(0);
        double health = k.getHealth();
        String hp = String.format("%.1f", health / 2.0);
        p.sendMessage(("&8\ufe33 &5&lPvP &8\ufe33 &fYour enemy &c " + k.getDisplayName() + " &fstill had &c" + hp + " &fheart remaining").replace("&", "\u00a7"));
        PlayerData.addDeaths(p.getName(), 1);
        PlayerData.addKills(k.getName(), 1);
        k.setHealth(20.0);
        p.setLevel(0);
        k.setLevel(0);
        BoardUtils.updatePlayerBoard(p);
        BoardUtils.updatePlayerBoard(k);
        k.sendMessage(("&8\ufe33 &5&lPvP &8\ufe33 &fYou Killed &b" + p.getDisplayName() + " &fwith &c" + hp + " &fheart remaning").replace("&", "\u00a7"));
        int killerStreaks = PlayerData.getStreak(k.getName());
        if (killerStreaks % 5 == 0) {
            Bukkit.broadcastMessage((String)((Object)RanksUtils.getPlayerRankColor(k) + k.getName() + " \u00a7f has been got \u00a75\u00a7l" + killerStreaks + " \u00a7f kill streak !."));
        }
    }
}

