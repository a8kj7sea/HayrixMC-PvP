/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 */
package me.sanhak.hyrixmc.pvp.ranks;

import net.md_5.bungee.api.ChatColor;

public enum RanksType {
    OWNER(ChatColor.YELLOW, "Owner"),
    HEAD_ADMIN(ChatColor.BLACK, "HeadAdmin"),
    ADMIN(ChatColor.DARK_RED, "Admin"),
    SR_MOD(ChatColor.DARK_PURPLE, "SrMod"),
    MOD(ChatColor.RED, "Mod"),
    HAYRIX_MAX(ChatColor.GOLD, "HayrixMax"),
    HAYRIX_PLUS(ChatColor.AQUA, "Hayrix+"),
    HAYRIX(ChatColor.DARK_GREEN, "Hayrix"),
    MEMBER(ChatColor.BLUE, "Member");

    private final String rankName;
    private final ChatColor rankColor;

    private RanksType(ChatColor rankColor, String rankPrefix) {
        this.rankName = rankPrefix;
        this.rankColor = rankColor;
    }

    public String getRankName() {
        return this.rankName;
    }

    public ChatColor getRankColor() {
        return this.rankColor;
    }
}

