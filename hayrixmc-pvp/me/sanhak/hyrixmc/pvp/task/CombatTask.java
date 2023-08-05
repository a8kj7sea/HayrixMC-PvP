/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.task;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class CombatTask
implements Runnable {
    public static HashMap<Player, Integer> combat = new HashMap();

    @Override
    public void run() {
        ArrayList<Player> list = new ArrayList<Player>();
        for (Player player : combat.keySet()) {
            if (combat.get((Object)player) >= 15) {
                player.sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are now out the attack , you can logout !".replace("&", "\u00a7"));
                list.add(player);
                continue;
            }
            combat.replace(player, combat.get((Object)player) + 1);
        }
        for (Player player : list) {
            combat.remove((Object)player);
        }
    }
}

