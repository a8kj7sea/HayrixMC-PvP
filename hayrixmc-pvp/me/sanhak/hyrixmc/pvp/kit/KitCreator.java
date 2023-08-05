/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.ItemMeta
 */
package me.sanhak.hyrixmc.pvp.kit;

import me.sanhak.hyrixmc.pvp.kit.KitsType;
import me.sanhak.hyrixmc.pvp.ranks.RanksType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCreator {
    public void giveKit(Player p, KitsType kitsType) {
        PlayerInventory inv = p.getInventory();
        inv.clear();
        switch (kitsType) {
            case HAYRIX_MAX: {
                inv.setItem(0, this.Sword(RanksType.HAYRIX_MAX, Material.DIAMOND_SWORD, 1, true));
                inv.setItem(2, this.Bow(4, true, RanksType.HAYRIX_MAX));
                inv.setItem(1, this.Rod(RanksType.HAYRIX_MAX));
                inv.setItem(8, this.Arrows(64, RanksType.HAYRIX_MAX));
                inv.setHelmet(this.helmet(RanksType.HAYRIX_MAX, Material.DIAMOND_HELMET));
                inv.setChestplate(this.chastplate(RanksType.HAYRIX_MAX, Material.IRON_CHESTPLATE));
                inv.setLeggings(this.leggins(RanksType.HAYRIX_MAX, Material.DIAMOND_LEGGINGS));
                inv.setBoots(this.boots(RanksType.HAYRIX_MAX, Material.DIAMOND_BOOTS));
                break;
            }
            case HAYRIX_PLUS: {
                inv.setItem(0, this.Sword(RanksType.HAYRIX_PLUS, Material.IRON_SWORD, 2, true));
                inv.setItem(2, this.Bow(3, true, RanksType.HAYRIX_PLUS));
                inv.setItem(1, this.Rod(RanksType.HAYRIX_PLUS));
                inv.setItem(8, this.Arrows(30, RanksType.HAYRIX_PLUS));
                inv.setHelmet(this.helmet(RanksType.HAYRIX_PLUS, Material.IRON_HELMET));
                inv.setChestplate(this.chastplate(RanksType.HAYRIX_PLUS, Material.IRON_CHESTPLATE));
                inv.setLeggings(this.leggins(RanksType.HAYRIX_PLUS, Material.IRON_LEGGINGS));
                inv.setBoots(this.boots(RanksType.HAYRIX_PLUS, Material.IRON_BOOTS));
                break;
            }
            case HAYRIX: {
                inv.setItem(0, this.Sword(RanksType.HAYRIX, Material.STONE_SWORD, 1, true));
                inv.setItem(2, this.Bow(1, true, RanksType.HAYRIX));
                inv.setItem(1, this.Rod(RanksType.HAYRIX));
                inv.setItem(8, this.Arrows(15, RanksType.HAYRIX));
                inv.setHelmet(this.helmet(RanksType.HAYRIX, Material.IRON_HELMET));
                inv.setChestplate(this.chastplate(RanksType.HAYRIX, Material.CHAINMAIL_CHESTPLATE));
                inv.setLeggings(this.leggins(RanksType.HAYRIX, Material.CHAINMAIL_LEGGINGS));
                inv.setBoots(this.boots(RanksType.HAYRIX, Material.IRON_BOOTS));
                break;
            }
            case MEMBER: {
                inv.setItem(0, this.Sword(RanksType.MEMBER, Material.STONE_SWORD, 1, false));
                inv.setItem(2, this.Bow(1, false, RanksType.MEMBER));
                inv.setItem(1, this.Rod(RanksType.MEMBER));
                inv.setItem(8, this.Arrows(10, RanksType.MEMBER));
                inv.setHelmet(this.helmet(RanksType.MEMBER, Material.CHAINMAIL_HELMET));
                inv.setChestplate(this.chastplate(RanksType.MEMBER, Material.CHAINMAIL_CHESTPLATE));
                inv.setLeggings(this.leggins(RanksType.MEMBER, Material.CHAINMAIL_LEGGINGS));
                inv.setBoots(this.boots(RanksType.MEMBER, Material.CHAINMAIL_BOOTS));
                break;
            }
            default: {
                inv.setItem(0, this.Sword(RanksType.MEMBER, Material.STONE_SWORD, 1, false));
                inv.setItem(2, this.Bow(1, false, RanksType.MEMBER));
                inv.setItem(1, this.Rod(RanksType.MEMBER));
                inv.setItem(8, this.Arrows(10, RanksType.MEMBER));
                inv.setHelmet(this.helmet(RanksType.MEMBER, Material.CHAINMAIL_HELMET));
                inv.setChestplate(this.chastplate(RanksType.MEMBER, Material.CHAINMAIL_CHESTPLATE));
                inv.setLeggings(this.leggins(RanksType.MEMBER, Material.CHAINMAIL_LEGGINGS));
                inv.setBoots(this.boots(RanksType.MEMBER, Material.CHAINMAIL_BOOTS));
            }
        }
    }

    private ItemStack boots(RanksType rankType, Material bootsType) {
        ItemStack item = new ItemStack(bootsType);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "BOOTS");
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack leggins(RanksType rankType, Material legginsType) {
        ItemStack item = new ItemStack(legginsType);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "LEGGINS");
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack chastplate(RanksType rankType, Material chestplateType) {
        ItemStack item = new ItemStack(chestplateType);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "CHESTPLATE");
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack helmet(RanksType rankType, Material helmetType) {
        ItemStack item = new ItemStack(helmetType);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "HELMET");
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack Sword(RanksType rankType, Material swordType, int level, boolean sharpnessEnable) {
        ItemStack item = new ItemStack(swordType);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "SWORD");
        if (sharpnessEnable) {
            meta.addEnchant(Enchantment.DAMAGE_ALL, level, true);
        }
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack Bow(int level, boolean powerEnable, RanksType rankType) {
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "BOW");
        if (powerEnable) {
            meta.addEnchant(Enchantment.ARROW_DAMAGE, level, true);
        }
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack Rod(RanksType rankType) {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "ROD");
        meta.spigot().setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack Arrows(int amount, RanksType rankType) {
        ItemStack item = new ItemStack(Material.ARROW, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName((Object)rankType.getRankColor() + "ARROW");
        item.setItemMeta(meta);
        return item;
    }
}

