package com.unity3d.mediation.rewarded;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10946b;

    public LevelPlayReward(String name, int i2) {
        k.e(name, "name");
        this.f10945a = name;
        this.f10946b = i2;
    }

    public static /* synthetic */ LevelPlayReward copy$default(LevelPlayReward levelPlayReward, String str, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = levelPlayReward.f10945a;
        }
        if ((i8 & 2) != 0) {
            i2 = levelPlayReward.f10946b;
        }
        return levelPlayReward.copy(str, i2);
    }

    public final String component1() {
        return this.f10945a;
    }

    public final int component2() {
        return this.f10946b;
    }

    public final LevelPlayReward copy(String name, int i2) {
        k.e(name, "name");
        return new LevelPlayReward(name, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelPlayReward)) {
            return false;
        }
        LevelPlayReward levelPlayReward = (LevelPlayReward) obj;
        return k.a(this.f10945a, levelPlayReward.f10945a) && this.f10946b == levelPlayReward.f10946b;
    }

    public final int getAmount() {
        return this.f10946b;
    }

    public final String getName() {
        return this.f10945a;
    }

    public int hashCode() {
        return (this.f10945a.hashCode() * 31) + this.f10946b;
    }

    public String toString() {
        return "LevelPlayReward(name=" + this.f10945a + ", amount=" + this.f10946b + ")";
    }
}
