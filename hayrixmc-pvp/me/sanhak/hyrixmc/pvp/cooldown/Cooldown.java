/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.cooldown;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Player;

public class Cooldown {
    public static HashMap<UUID, Double> cooldowns = new HashMap();

    public static boolean isOk(Player player) {
        return !cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= (double)System.currentTimeMillis();
    }

    public static void setPlayerCooldown(Player p, int seconds) {
        double delay = System.currentTimeMillis() + (long)(seconds * 1000);
        cooldowns.put(p.getUniqueId(), delay);
    }

    public static int getRemainingTime(Player p) {
        return Math.toIntExact(Math.round((cooldowns.get(p.getUniqueId()) - (double)System.currentTimeMillis()) / 1000.0));
    }
}

