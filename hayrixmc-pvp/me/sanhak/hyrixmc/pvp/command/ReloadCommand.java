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

import me.sanhak.hyrixmc.pvp.configuration.Locations;
import me.sanhak.hyrixmc.pvp.configuration.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player)commandSender;
        if (player.isOp()) {
            if (args.length == 0) {
                PlayerData.reload();
                Locations.reload();
                player.sendMessage("\u00a7aYou have been reloaded configuration successfully ! ");
            } else {
                player.sendMessage("\u00a7aIncorrect use please try to type \u00a7f/pvpreload");
            }
        } else {
            player.sendMessage("\u00a7cYou don't necessary permissions to use this command !");
        }
        return false;
    }
}

