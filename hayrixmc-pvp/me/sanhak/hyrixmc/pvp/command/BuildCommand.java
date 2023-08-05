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

import java.util.ArrayList;
import me.sanhak.hyrixmc.pvp.utils.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand
implements CommandExecutor {
    public static ArrayList<Player> builders = new ArrayList();

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player)commandSender;
        if (player.hasPermission("pvp.build")) {
            if (args.length == 0) {
                if (!builders.contains((Object)player)) {
                    builders.add(player);
                    player.sendMessage("\u00a7fYou been \u00a7a\u00a7lAdded \u00a7fto build mode successfully !");
                } else {
                    builders.remove((Object)player);
                    player.sendMessage("\u00a7fYou been \u00a7c\u00a7lRemoved \u00a7ffrom build mode successfully !");
                }
            } else if (args.length == 1) {
                Player target = PlayerUtils.getPlayer(args[0]);
                if (!builders.contains((Object)target)) {
                    builders.add(target);
                    player.sendMessage("\u00a7fYou been \u00a7a\u00a7lAdded" + target.getName() + " \u00a7fto build mode successfully !");
                    target.sendMessage("\u00a7fYou been \u00a7a\u00a7lAdded \u00a7fto build mode successfully ! by \u00a7b\u00a7l" + player.getName());
                } else {
                    builders.remove((Object)target);
                    player.sendMessage("\u00a7fYou been \u00a7a\u00a7lRemoved" + target.getName() + " \u00a7ffrom build mode successfully !");
                    target.sendMessage("\u00a7fYou been \u00a7c\u00a7lRemoved \u00a7ffrom build mode successfully by \u00a7b\u00a7l" + player.getName());
                }
            } else {
                player.sendMessage("\u00a7cIncorrect input please try to type /pvpbuild <online-player> or /pvpbuild");
            }
        } else {
            player.sendMessage("\u00a7cYou don't have any permissions to use this command !");
        }
        return false;
    }
}

