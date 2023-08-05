/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package me.sanhak.hyrixmc.pvp.kit;

import me.sanhak.hyrixmc.pvp.kit.KitCreator;
import me.sanhak.hyrixmc.pvp.kit.KitsType;
import org.bukkit.entity.Player;

public class KitUtils {
    public static void grantKit(Player player) {
        KitCreator kitCreator = new KitCreator();
        if (player.hasPermission("pvp.hayrixmax")) {
            kitCreator.giveKit(player, KitsType.HAYRIX_MAX);
        } else if (player.hasPermission("pvp.hayrixplus")) {
            kitCreator.giveKit(player, KitsType.HAYRIX_PLUS);
        } else if (player.hasPermission("pvp.hayrix")) {
            kitCreator.giveKit(player, KitsType.HAYRIX);
        } else {
            kitCreator.giveKit(player, KitsType.MEMBER);
        }
    }
}

