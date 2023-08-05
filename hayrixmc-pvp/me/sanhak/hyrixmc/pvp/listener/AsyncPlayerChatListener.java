/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 */
package me.sanhak.hyrixmc.pvp.listener;

import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesUtils;
import me.sanhak.hyrixmc.pvp.ranks.RanksUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener
implements Listener {
    @EventHandler
    public void onPlayerChatting(AsyncPlayerChatEvent e) {
        e.setFormat(String.valueOf(PrestigesUtils.getPlayerPrestigeName(PlayerData.getKills(e.getPlayer().getName()))) + " \u00a78\u00a7l\ufe33 " + (Object)RanksUtils.getPlayerRankColor(e.getPlayer()) + e.getPlayer().getName() + " \u00a78\u00a7l\u00bb \u00a7r" + e.getMessage());
    }
}

