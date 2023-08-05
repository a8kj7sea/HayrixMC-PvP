/*
 * Decompiled with CFR 0.150.
 */
package me.sanhak.hyrixmc.pvp.prestige;

import me.sanhak.hyrixmc.pvp.prestige.PrestigeProgressType;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesType;
import me.sanhak.hyrixmc.pvp.prestige.PrestigesUtils;

public class PrestigeProgressUtils {
    public static final char passChar = '#';
    public static final char notPassChar = '-';
    public static final int charsLength = 10;

    public static double getPrestigeProgressPercentage(int playerKills) {
        int currentKills = playerKills;
        PrestigesType playerPrestige = PrestigesUtils.getPlayerPrestigeType(currentKills);
        double prestigeProgressPercentage = (double)currentKills / (double)playerPrestige.getPrestigeMaxKills() * 100.0;
        return Math.ceil(prestigeProgressPercentage);
    }

    public static PrestigeProgressType getPlayerPrestigeProgressType(double prestigeProgressPercentage) {
        for (PrestigeProgressType prestigeProgress : PrestigeProgressType.values()) {
            if (!(prestigeProgressPercentage >= (double)prestigeProgress.getMinProgressPercentage()) || !(prestigeProgressPercentage < (double)prestigeProgress.getMaxProgressPercentage())) continue;
            return prestigeProgress;
        }
        return PrestigeProgressType.PP100;
    }

    public static int getPassCharLength(double prestigeProgressPercentage) {
        return PrestigeProgressUtils.getPlayerPrestigeProgressType(prestigeProgressPercentage).getPassCharLength();
    }

    public static int getNotPassCharLength(double prestigeProgressPercentage) {
        int passCharLength = PrestigeProgressUtils.getPlayerPrestigeProgressType(prestigeProgressPercentage).getPassCharLength();
        return 10 - passCharLength;
    }

    public static String drawPrestigeProgress(double prestigeProgressPercentage) {
        int x;
        int passCharLength = PrestigeProgressUtils.getPassCharLength(prestigeProgressPercentage);
        int notPassCharLength = PrestigeProgressUtils.getNotPassCharLength(prestigeProgressPercentage);
        String totalDraw = "";
        for (x = 0; x < passCharLength; ++x) {
            totalDraw = String.valueOf(totalDraw) + "\u00a7a#";
        }
        if (totalDraw != null && totalDraw != "") {
            if (totalDraw.length() == 10) {
                return "\u00a78[" + totalDraw + "\u00a78]";
            }
            for (x = 0; x < notPassCharLength; ++x) {
                totalDraw = String.valueOf(totalDraw) + "\u00a77-";
            }
            return "\u00a78[" + totalDraw + "\u00a78]";
        }
        for (x = 0; x < 9; ++x) {
            totalDraw = String.valueOf(totalDraw) + "\u00a77-";
        }
        return "\u00a78[" + totalDraw + "\u00a78]";
    }
}

