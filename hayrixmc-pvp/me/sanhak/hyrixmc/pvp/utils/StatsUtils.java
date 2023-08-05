/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.utils;

import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.prestige.PrestigeProgressUtils;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesUtils;
import org.bukkit.entity.Player;

public class StatsUtils {
    public static void get4PlayerHisStats(Player player) {
        if (!StatsUtils.playerDataExists(player)) {
            player.sendMessage("\u00a7cThis player doesn't have any stats !");
            return;
        }
        int kills = PlayerData.getKills(player.getName());
        int deaths = PlayerData.getDeaths(player.getName());
        int streaks = PlayerData.getStreak(player.getName());
        int coins = PlayerData.getCoins(player.getName());
        String playerPrestige = PrestigesUtils.getPlayerPrestigeName(kills);
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage("\u00a78\u00bb \u00a7r" + playerPrestige + " \u00a77prestige");
        player.sendMessage("\u00a78\u00bb \u00a77Prestige-Progress : " + PrestigeProgressUtils.drawPrestigeProgress(PrestigeProgressUtils.getPrestigeProgressPercentage(kills)) + " \u00a7b" + PrestigeProgressUtils.getPrestigeProgressPercentage(kills) + "%");
        player.sendMessage("\u00a78\u00bb \u00a7c" + kills + " \u00a77kill.");
        player.sendMessage("\u00a78\u00bb \u00a74" + deaths + " \u00a77death.");
        player.sendMessage("\u00a78\u00bb \u00a76" + streaks + " \u00a77streak.");
        player.sendMessage("\u00a78\u00bb \u00a72" + coins + "$ \u00a77coins.");
        player.sendMessage(" ");
        player.sendMessage(" ");
    }

    public static void getSenderTargetStats(Player sender, Player target) {
        if (!StatsUtils.playerDataExists(target)) {
            sender.sendMessage("\u00a7cThis player doesn't have any stats !");
            return;
        }
        int kills = PlayerData.getKills(target.getName());
        int deaths = PlayerData.getDeaths(target.getName());
        int streaks = PlayerData.getStreak(target.getName());
        int coins = PlayerData.getCoins(target.getName());
        String playerPrestige = PrestigesUtils.getPlayerPrestigeName(kills);
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage("\u00a78\u00bb \u00a7r" + playerPrestige + " \u00a77prestige");
        sender.sendMessage("\u00a78\u00bb \u00a77Prestige-Progress : " + PrestigeProgressUtils.drawPrestigeProgress(PrestigeProgressUtils.getPrestigeProgressPercentage(kills)) + " \u00a7b" + PrestigeProgressUtils.getPrestigeProgressPercentage(kills) + "%");
        sender.sendMessage("\u00a78\u00bb \u00a7c" + kills + " \u00a77kill.");
        sender.sendMessage("\u00a78\u00bb \u00a74" + deaths + " \u00a77death.");
        sender.sendMessage("\u00a78\u00bb \u00a76" + streaks + " \u00a77streak.");
        sender.sendMessage("\u00a78\u00bb \u00a72" + coins + "$ \u00a77coins.");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
    }

    public static boolean playerDataExists(Player player) {
        return PlayerData.playerDataExists(player.getName());
    }
}

