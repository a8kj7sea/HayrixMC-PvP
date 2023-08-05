/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.gmail.filoghost.holographicdisplays.api.Hologram
 *  com.gmail.filoghost.holographicdisplays.api.HologramsAPI
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package me.sanhak.hyrixmc.pvp.configuration;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Locations {
    private static File file;
    private static FileConfiguration configurationFile;

    public Locations(JavaPlugin Pluginparam, boolean saveDefaultData) {
        file = new File(Pluginparam.getDataFolder(), "locations.yml");
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            if (saveDefaultData) {
                Pluginparam.saveResource("locations.yml", saveDefaultData);
            } else {
                try {
                    file.createNewFile();
                }
                catch (IOException ioexception) {
                    ioexception.printStackTrace();
                }
            }
        }
        configurationFile = YamlConfiguration.loadConfiguration((File)file);
    }

    public static void save() {
        try {
            configurationFile.save(file);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    public static void reload() {
        configurationFile = YamlConfiguration.loadConfiguration((File)file);
    }

    public static FileConfiguration getConfigurationFile() {
        return configurationFile;
    }

    public static void setSpawnLocation(Player player) {
        Location location = player.getLocation();
        configurationFile.set("Spawn.location", (Object)location);
        Locations.save();
    }

    public static void teleportPlayerToSpawnLocation(Player player) {
        if (configurationFile.contains("Spawn")) {
            Location location = (Location)configurationFile.get("Spawn.location");
            player.teleport(location);
        } else if (player.hasPermission("pvp.admin")) {
            player.sendMessage("Spawn location not found. Please type /pvpset <spawn> to set spawn.");
        }
    }

    public static void storeTopKillsHologram(Location location) {
        configurationFile.set("leaderboard.location", (Object)location);
        Locations.save();
    }

    public static void loadTopKillsHologram() {
        if (configurationFile.contains("leaderboard.location")) {
            Location location = (Location)configurationFile.get("leaderboard.location");
            Locations.createTopKillsHologram(location);
        }
    }

    public static void createTopKillsHologram(Location location) {
        Hologram hologram = HologramsAPI.createHologram((Plugin)Main.getMain(), (Location)location);
        hologram.appendTextLine("\u00a7e---------- Leaderboard Top 10 Kills ----------");
        hologram.appendTextLine("  ");
        List<String> topKills = PlayerData.getTopKills1();
        for (String line : topKills) {
            hologram.appendTextLine(line);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String lastUpdatedDate = sdf.format(new Date());
        hologram.appendTextLine("  ");
        hologram.appendTextLine("\u00a77Last update was in " + lastUpdatedDate);
        Bukkit.getScheduler().runTaskTimerAsynchronously((Plugin)Main.getMain(), () -> {
            hologram.clearLines();
            hologram.appendTextLine("\u00a7e---------- Leaderboard Top 10 Kills ----------");
            hologram.appendTextLine("  ");
            List<String> updatedTopKills = PlayerData.getTopKills1();
            for (String line : updatedTopKills) {
                hologram.appendTextLine(line);
            }
            String updatedLastUpdatedDate = sdf.format(new Date());
            hologram.appendTextLine("  ");
            hologram.appendTextLine("\u00a77Last update was in " + updatedLastUpdatedDate);
        }, 360000L, 360000L);
    }
}

