/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package me.sanhak.hyrixmc.pvp.configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import me.sanhak.hyrixmc.pvp.main.Main;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesUtils;
import me.sanhak.hyrixmc.pvp.ranks.RanksUtils;
import me.sanhak.hyrixmc.pvp.utils.PlayerUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {
    private static File file = new File(Main.getMain().getDataFolder(), "data.yml");
    private static FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration((File)file);

    public static void savefileConfiguration() {
        try {
            fileConfiguration.save(file);
        }
        catch (IOException var1) {
            var1.printStackTrace();
        }
    }

    public static List<String> getTopKills() {
        ArrayList<String> topKills = new ArrayList<String>();
        HashMap<String, Integer> killsMap = new HashMap<String, Integer>();
        for (String name : fileConfiguration.getKeys(false)) {
            int kills = PlayerData.getKills(name);
            killsMap.put(name, kills);
        }
        killsMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10L).forEach(entry -> {
            boolean bl = topKills.add("\u00a7b" + (String)entry.getKey() + "\u00a78&l\u00a7 - \u00a7c" + entry.getValue() + " kills.");
        });
        return topKills;
    }

    public static List<String> getTopKills1() {
        final ArrayList<String> topKills = new ArrayList<String>();
        HashMap<String, Integer> killsMap = new HashMap<String, Integer>();
        for (String name : fileConfiguration.getKeys(false)) {
            int kills = PlayerData.getKills(name);
            killsMap.put(name, kills);
        }
        killsMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10L).forEachOrdered(new Consumer<Map.Entry<String, Integer>>(){
            AtomicInteger rank = new AtomicInteger(1);

            @Override
            public void accept(Map.Entry<String, Integer> entry) {
                String playerRankColor = RanksUtils.getPlayerRankColor(PlayerUtils.getPlayer(entry.getKey())).toString();
                String playerPrestige = PrestigesUtils.getPlayerPrestigeName(entry.getValue());
                topKills.add("\u00a77#" + this.rank.getAndIncrement() + " " + playerPrestige + " " + playerRankColor + entry.getKey() + "\u00a77 - \u00a7c" + entry.getValue() + "\u00a77 kills.");
            }
        });
        return topKills;
    }

    public static void reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration((File)file);
    }

    public static boolean playerDataExists(String name) {
        return fileConfiguration.contains(name);
    }

    public static void setKills(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Kills", (Object)amount);
        PlayerData.savefileConfiguration();
    }

    public static void addKills(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Kills", (Object)(PlayerData.getKills(name) + amount));
        PlayerData.savefileConfiguration();
    }

    public static void removeKills(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Kills", (Object)(PlayerData.getKills(name) - amount));
        PlayerData.savefileConfiguration();
    }

    public static Integer getKills(String name) {
        return fileConfiguration.getInt(String.valueOf(name) + ".Kills");
    }

    public static void setDeaths(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Deaths", (Object)amount);
        PlayerData.savefileConfiguration();
    }

    public static void addDeaths(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Deaths", (Object)(PlayerData.getDeaths(name) + amount));
        PlayerData.savefileConfiguration();
    }

    public static void removeDeaths(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Deaths", (Object)(PlayerData.getDeaths(name) - amount));
        PlayerData.savefileConfiguration();
    }

    public static Integer getDeaths(String name) {
        return fileConfiguration.getInt(String.valueOf(name) + ".Last-Streaks");
    }

    public static void setStreaks(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Last-Streaks", (Object)amount);
        PlayerData.savefileConfiguration();
    }

    public static void addStreak(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Last-Streaks", (Object)(PlayerData.getStreak(name) + amount));
        PlayerData.savefileConfiguration();
    }

    public static void removeStreak(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Last-Streaks", (Object)(PlayerData.getStreak(name) - amount));
        PlayerData.savefileConfiguration();
    }

    public static Integer getStreak(String name) {
        return fileConfiguration.getInt(String.valueOf(name) + ".Last-Streaks");
    }

    public static void setCoins(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Coins", (Object)amount);
        PlayerData.savefileConfiguration();
    }

    public static void addCoins(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Coins", (Object)(PlayerData.getCoins(name) + amount));
        PlayerData.savefileConfiguration();
    }

    public static void removeCoins(String name, int amount) {
        fileConfiguration.set(String.valueOf(name) + ".Coins", (Object)(PlayerData.getCoins(name) - amount));
        PlayerData.savefileConfiguration();
    }

    public static Integer getCoins(String name) {
        return fileConfiguration.getInt(String.valueOf(name) + ".Coins");
    }
}

