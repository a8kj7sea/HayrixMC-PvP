/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package me.sanhak.hyrixmc.pvp.utils;

import me.sanhak.hyrixmc.pvp.listener.AsyncPlayerChatListener;
import me.sanhak.hyrixmc.pvp.listener.CombatListeners;
import me.sanhak.hyrixmc.pvp.listener.PlayerDeathListener;
import me.sanhak.hyrixmc.pvp.listener.PlayerJoinListener;
import me.sanhak.hyrixmc.pvp.listener.PlayerQuitListener;
import me.sanhak.hyrixmc.pvp.listener.PlayerRespawnListener;
import me.sanhak.hyrixmc.pvp.listener.RandomListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenersUtils {
    static Listener[] listeners = new Listener[]{new PlayerDeathListener(), new PlayerJoinListener(), new PlayerQuitListener(), new PlayerRespawnListener(), new RandomListener(), new CombatListeners(), new AsyncPlayerChatListener()};

    public static void registerListener(JavaPlugin plugin) {
        Listener[] arrlistener = listeners;
        int n = listeners.length;
        for (int i = 0; i < n; ++i) {
            Listener listener = arrlistener[i];
            Bukkit.getPluginManager().registerEvents(listener, (Plugin)plugin);
        }
    }
}

