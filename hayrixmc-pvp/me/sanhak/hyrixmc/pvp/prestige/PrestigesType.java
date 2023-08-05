/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 */
package me.sanhak.hyrixmc.pvp.prestige;

import net.md_5.bungee.api.ChatColor;

public enum PrestigesType {
    ROOKIE("Rookie", 0, 499, ChatColor.GRAY),
    NOVICE("Novice", 500, 999, ChatColor.WHITE),
    APPRENTICE("Apprentice", 1000, 1499, ChatColor.GREEN),
    SOLDIER("Soldier", 1500, 2499, ChatColor.BLUE),
    WARRIOR("Warrior", 2500, 4999, ChatColor.DARK_PURPLE),
    VETERAN("Veteran", 5000, 9999, ChatColor.YELLOW),
    ELITE("Elite", 10000, 24999, ChatColor.RED),
    MERCENARY("Mercenary", 25000, 49999, ChatColor.DARK_GREEN),
    SLAYER("Slayer", 50000, 99999, ChatColor.GOLD),
    ASSASSIN("Assassin", 100000, 149999, ChatColor.DARK_AQUA),
    LEGEND("Legend", 150000, 249999, ChatColor.LIGHT_PURPLE),
    ARCHON("Archon", 250000, 499999, ChatColor.AQUA),
    DIVINE("Divine", 500000, 549999, ChatColor.RED),
    MYTHIC("Mythic", 550000, 999999, ChatColor.DARK_PURPLE),
    IMMORTAL("Immortal", 1000000, Integer.MAX_VALUE, ChatColor.BLACK);

    private final String prestigeName;
    private final int prestigeMinKills;
    private final int prestigeMaxKills;
    private final ChatColor prestigeColor;

    private PrestigesType(String prestigeName, int prestigeMinKills, int prestigeMaxKills, ChatColor prestigeColor) {
        this.prestigeName = prestigeName;
        this.prestigeMinKills = prestigeMinKills;
        this.prestigeMaxKills = prestigeMaxKills;
        this.prestigeColor = prestigeColor;
    }

    public String getPrestigeName() {
        return (Object)this.prestigeColor + this.prestigeName;
    }

    public int getPrestigeMinKills() {
        return this.prestigeMinKills;
    }

    public int getPrestigeMaxKills() {
        return this.prestigeMaxKills;
    }

    public ChatColor getPrestigeColor() {
        return this.prestigeColor;
    }
}

