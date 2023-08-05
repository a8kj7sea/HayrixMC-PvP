/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.prestige;

import me.sanhak.hyrixmc.pvp.prestige.PrestigesType;
import org.bukkit.entity.Player;

public class PrestigesUtils {
    public static String getPlayerPrestigeName(int kills) {
        for (PrestigesType rank : PrestigesType.values()) {
            if (kills < rank.getPrestigeMinKills() || kills >= rank.getPrestigeMaxKills()) continue;
            return rank.getPrestigeName();
        }
        return PrestigesType.IMMORTAL.getPrestigeName();
    }

    public static PrestigesType getPlayerPrestigeType(int kills) {
        for (PrestigesType rank : PrestigesType.values()) {
            if (kills < rank.getPrestigeMinKills() || kills >= rank.getPrestigeMaxKills()) continue;
            return rank;
        }
        return PrestigesType.IMMORTAL;
    }

    public static void sendPrestiges(Player player) {
        PrestigesType[] values = PrestigesType.values();
        for (int x = 0; x < values.length; ++x) {
            String rankName = values[x].getPrestigeName();
            int from = values[x].getPrestigeMinKills();
            int to = values[x].getPrestigeMaxKills();
            player.sendMessage("\u00a78\u00a7l\u00bb " + rankName + "\u00a7f\u00a7l (" + from + "/" + to + ")");
        }
    }
}

