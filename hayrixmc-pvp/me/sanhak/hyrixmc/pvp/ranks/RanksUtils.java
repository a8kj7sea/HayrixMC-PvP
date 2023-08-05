/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.luckperms.api.LuckPerms
 *  net.luckperms.api.LuckPermsProvider
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.ranks;

import me.sanhak.hyrixmc.pvp.ranks.RanksType;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class RanksUtils {
    public static LuckPerms api = LuckPermsProvider.get();

    public static String getRankFromPermisson(String rankPermisson) {
        if (rankPermisson != null && rankPermisson != "" && rankPermisson.contains("pvp.")) {
            return rankPermisson.split("\\.")[1];
        }
        return "Member";
    }

    public static ChatColor getPlayerRankColor(Player player) {
        for (RanksType ranksType : RanksType.values()) {
            if (!api.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup().equalsIgnoreCase(ranksType.getRankName())) continue;
            return ranksType.getRankColor();
        }
        return ChatColor.BLUE;
    }
}

