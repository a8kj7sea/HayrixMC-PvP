/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.command;

import me.sanhak.hyrixmc.pvp.cooldown.Cooldown;
import me.sanhak.hyrixmc.pvp.utils.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FixCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player)commandSender;
        if (args.length == 0) {
            if (!Cooldown.isOk(player)) {
                player.sendMessage("\u00a7cYou are in cooldown please wait for \u00a7e" + Cooldown.getRemainingTime(player) + " \u00a7cbefore use fixCommand again !");
            } else {
                PlayerUtils.fixPlayer(player);
                player.sendMessage("\u00a7aYou have been fixed successfully  !");
                Cooldown.setPlayerCooldown(player, 5);
            }
        } else {
            player.sendMessage("\u00a7aIncorrect use please try to type \u00a7f/fix");
        }
        return false;
    }
}

