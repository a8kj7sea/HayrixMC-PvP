/*
 * Decompiled with CFR 0.150.
 */
package me.sanhak.hyrixmc.pvp.prestige;

public enum PrestigeProgressType {
    PP100(99, 100, 10),
    PP90(90, 99, 9),
    PP80(80, 89, 8),
    PP70(70, 79, 7),
    PP60(60, 69, 6),
    PP50(50, 59, 5),
    PP40(40, 49, 4),
    PP30(30, 39, 3),
    PP20(20, 29, 2),
    PP10(10, 19, 1),
    PP0(0, 9, 0);

    private final int minProgressPercentage;
    private final int maxProgressPercentage;
    private final int passCharLength;

    private PrestigeProgressType(int minProgressPercentage, int maxProgressPercentage, int passCharLength) {
        this.minProgressPercentage = minProgressPercentage;
        this.maxProgressPercentage = maxProgressPercentage;
        this.passCharLength = passCharLength;
    }

    public int getMaxProgressPercentage() {
        return this.maxProgressPercentage;
    }

    public int getMinProgressPercentage() {
        return this.minProgressPercentage;
    }

    public int getPassCharLength() {
        return this.passCharLength;
    }
}

