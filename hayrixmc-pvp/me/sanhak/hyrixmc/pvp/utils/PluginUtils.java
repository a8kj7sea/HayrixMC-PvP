/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package me.sanhak.hyrixmc.pvp.utils;

import org.bukkit.Bukkit;

public class PluginUtils {
    public static boolean exists(String plugin) {
        return Bukkit.getServer().getPluginManager().getPlugin(plugin) != null;
    }
}

