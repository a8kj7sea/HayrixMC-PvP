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

import me.sanhak.hyrixmc.pvp.utils.PlayerUtils;
import me.sanhak.hyrixmc.pvp.utils.StatsUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player)commandSender;
        if (args.length == 0) {
            StatsUtils.get4PlayerHisStats(player);
        } else if (args.length == 1) {
            Player target = PlayerUtils.getPlayer(args[0]);
            StatsUtils.getSenderTargetStats(player, target);
        } else {
            player.sendMessage("\u00a7cIncorrect input please try to type /stats <online-player> or /stats");
        }
        return false;
    }
}

