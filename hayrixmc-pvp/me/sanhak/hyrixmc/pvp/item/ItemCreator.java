/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.sanhak.hyrixmc.pvp.item;

import me.sanhak.hyrixmc.pvp.ranks.RanksType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator {
    public static ItemStack createArmorsItem(Material materialType, RanksType rankType) {
        ItemStack item = new ItemStack(materialType);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName((Object)rankType.getRankColor() + itemMeta.getDisplayName());
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        return item;
    }
}

