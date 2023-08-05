/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.EntityShootBowEvent
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 */
package me.sanhak.hyrixmc.pvp.listener;

import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.task.CombatTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CombatListeners
implements Listener {
    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void onEntityHit(EntityDamageByEntityEvent e) {
        if (e.getDamage() != 0.0 && !e.isCancelled()) {
            Player p;
            if (e.getEntity() instanceof Player) {
                p = (Player)e.getEntity();
                p.setFlying(false);
                p.setAllowFlight(false);
                if (CombatTask.combat.containsKey((Object)p)) {
                    CombatTask.combat.put(p, 0);
                } else {
                    CombatTask.combat.put(p, 0);
                    p.sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are under attack , please don't logout  !".replace("&", "\u00a7"));
                }
            }
            if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
                p = (Player)e.getDamager();
                p.setFlying(false);
                p.setAllowFlight(false);
                if (CombatTask.combat.containsKey((Object)p)) {
                    CombatTask.combat.put(p, 0);
                } else {
                    CombatTask.combat.put(p, 0);
                    p.sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are under attack , please don't logout  !".replace("&", "\u00a7"));
                }
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void onEntityShootBow(EntityShootBowEvent e) {
        if (!e.isCancelled() && e.getEntity() instanceof Player) {
            Player p = (Player)e.getEntity();
            p.setFlying(false);
            p.setAllowFlight(false);
            if (CombatTask.combat.containsKey((Object)p)) {
                CombatTask.combat.put(p, 0);
            } else {
                CombatTask.combat.put(p, 0);
                p.sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are under attack , please don't logout  !".replace("&", "\u00a7"));
            }
        }
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void onEntityHit(EntityDamageEvent e) {
        if (e.getDamage() != 0.0 && !e.isCancelled() && e.getCause().equals((Object)EntityDamageEvent.DamageCause.FIRE_TICK) && e.getEntity() instanceof Player) {
            Player p = (Player)e.getEntity();
            if (CombatTask.combat.containsKey((Object)p)) {
                CombatTask.combat.put(p, 0);
            } else {
                CombatTask.combat.put(p, 0);
                p.sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are under attack , please don't logout  !".replace("&", "\u00a7"));
            }
        }
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
        if (CombatTask.combat.containsKey((Object)e.getPlayer()) && this.blockedCMD(e.getMessage())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("&8\ufe33 &5&lPvP &8\ufe33 &fYou are under attack , you can't use commands while attack !".replace("&", "\u00a7"));
        }
    }

    public boolean blockedCMD(String cmd) {
        return cmd.startsWith("/lobby") || cmd.startsWith("/hub") || cmd.startsWith("/leave") || cmd.startsWith("/l") || cmd.startsWith("/h") || cmd.startsWith("/spawn");
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        Locations.teleportPlayerToSpawnLocation(p);
        if (CombatTask.combat.containsKey((Object)e.getPlayer())) {
            e.getPlayer().setHealth(0.0);
        }
    }
}

