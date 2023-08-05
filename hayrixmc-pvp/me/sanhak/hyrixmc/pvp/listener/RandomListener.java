/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.block.SignChangeEvent
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.EntitySpawnEvent
 *  org.bukkit.event.entity.FoodLevelChangeEvent
 *  org.bukkit.event.entity.ProjectileHitEvent
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryType$SlotType
 *  org.bukkit.event.player.PlayerAchievementAwardedEvent
 *  org.bukkit.event.player.PlayerDropItemEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerPickupItemEvent
 *  org.bukkit.event.weather.WeatherChangeEvent
 *  org.bukkit.util.Vector
 */
package me.sanhak.hyrixmc.pvp.listener;

import me.sanhak.hyrixmc.pvp.command.BuildCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.util.Vector;

public class RandomListener
implements Listener {
    @EventHandler(priority=EventPriority.HIGHEST)
    public void DisableWeather(WeatherChangeEvent event) {
        event.setCancelled(event.toWeatherState());
    }

    @EventHandler
    public void onJumpPad(PlayerMoveEvent e) {
        Location loc = e.getPlayer().getLocation();
        if (e.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE) {
            Vector v = e.getPlayer().getLocation().getDirection().multiply(4.5).setY(2.0);
            e.getPlayer().playSound(loc, Sound.GHAST_SCREAM2, 1.0f, 1.5f);
            e.getPlayer().setVelocity(v);
        }
    }

    @EventHandler
    public void Acheviment(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(ignoreCancelled=true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntityType() == EntityType.PLAYER && e.getDamager() != null && e.getDamager().getType() == EntityType.ARROW && ((Arrow)e.getDamager()).getShooter() == e.getEntity()) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Arrow) {
            ((Arrow)e.getEntity()).remove();
        }
        if (e.getEntityType() == EntityType.ARROW) {
            e.getEntity().remove();
        }
    }

    @EventHandler
    public void onSpawnEntity(EntitySpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void pickItemFromGroud(PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void disableClickonArmorSlots(InventoryClickEvent e) {
        if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void gg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            e.setCancelled(false);
            e.setDamage(20.0);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.CONTACT) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.SUICIDE) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void spawnEntity(EntitySpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!BuildCommand.builders.contains((Object)e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onplace(BlockPlaceEvent e) {
        if (!BuildCommand.builders.contains((Object)e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSign(SignChangeEvent e) {
        for (int x = 0; x <= 3; ++x) {
            e.setLine(x, ChatColor.translateAlternateColorCodes((char)'&', (String)e.getLine(x)));
        }
    }
}

