/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.scoreboard.DisplaySlot
 *  org.bukkit.scoreboard.Objective
 *  org.bukkit.scoreboard.Score
 *  org.bukkit.scoreboard.Scoreboard
 */
package me.sanhak.hyrixmc.pvp.utils;

import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.prestige.PrestigeProgressUtils;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class BoardUtils {
    public static void updatePlayerBoard(Player player) {
        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective ob = sb.registerNewObjective("SeruXQ", "Sanhak");
        ob.setDisplaySlot(DisplaySlot.SIDEBAR);
        ob.setDisplayName("\u00a75\u00a7lPvP");
        Score space_Score = ob.getScore("\u00a7b");
        Score prestige_Score = ob.getScore(" \u00a7f\u00a7lPrestige");
        Score space2_Score = ob.getScore("\u00a75");
        Score prestigeName_Score = ob.getScore(" \u00a78\u00a7l\u00bb " + BoardUtils.getPlayerPrestige(player));
        Score space3_Score = ob.getScore("\u00a7a");
        Score statistics_Score = ob.getScore(" \u00a7f\u00a7lStatistics");
        Score space5_Score = ob.getScore("\u00a71");
        Score coinsScore = ob.getScore(" \u00a78\u00a7l\u00bb \u00a75" + BoardUtils.getCoins(player) + "$ \u00a7fCoins.");
        Score killsScore = ob.getScore(" \u00a78\u00a7l\u00bb \u00a75" + BoardUtils.getKills(player) + " \u00a7fKills.");
        Score streaksScore = ob.getScore(" \u00a78\u00a7l\u00bb \u00a75" + BoardUtils.getStreaks(player) + " \u00a7fStreaks.");
        Score space6_Score = ob.getScore("\u00a70");
        Score ipScore = ob.getScore(" \u00a78\u00a7l\u00bb \u00a7fplay.hayrixmc.tk");
        space_Score.setScore(11);
        prestige_Score.setScore(10);
        space2_Score.setScore(9);
        prestigeName_Score.setScore(8);
        space3_Score.setScore(7);
        statistics_Score.setScore(6);
        space5_Score.setScore(5);
        coinsScore.setScore(4);
        killsScore.setScore(3);
        streaksScore.setScore(2);
        space6_Score.setScore(1);
        ipScore.setScore(0);
        player.setScoreboard(sb);
    }

    static String drawProgress(Player player) {
        return PrestigeProgressUtils.drawPrestigeProgress(PrestigeProgressUtils.getPrestigeProgressPercentage(BoardUtils.getKills(player)));
    }

    static String getPlayerPrestige(Player player) {
        return PrestigesUtils.getPlayerPrestigeName(BoardUtils.getKills(player));
    }

    static int getKills(Player player) {
        return PlayerData.getKills(player.getName());
    }

    static int getStreaks(Player player) {
        return PlayerData.getStreak(player.getName());
    }

    static int getCoins(Player player) {
        return PlayerData.getCoins(player.getName());
    }
}

