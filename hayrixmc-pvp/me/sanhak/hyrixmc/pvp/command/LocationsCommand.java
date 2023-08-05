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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocationsCommand
implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        block14: {
            Player player;
            block11: {
                block12: {
                    if (!(commandSender instanceof Player)) {
                        return false;
                    }
                    player = (Player)commandSender;
                    if (!player.isOp()) break block11;
                    if (args.length != 1) break block12;
                    switch (args[0]) {
                        case "leaderboard": {
                            Locations.storeTopKillsHologram(player.getLocation());
                            Locations.loadTopKillsHologram();
                            player.sendMessage("\u00a7aYou have been set the leaderboard location successfully !");
                            break;
                        }
                        case "spawn": {
                            Locations.setSpawnLocation(player);
                            player.sendMessage("\u00a7aYou have been set the spawn location successfully !");
                            break;
                        }
                        default: {
                            player.sendMessage("\u00a7cThat incorrect use please try to type \u00a7f/pvpset <leaderboard/spawn>");
                            break;
                        }
                    }
                    break block14;
                }
                player.sendMessage("\u00a7cThat incorrect use please try to type \u00a7f/pvpset <leaderboard/spawn>");
                break block14;
            }
            player.sendMessage("\u00a7cYou don't have nesseccary permissions to use it !");
        }
        return false;
    }
}

