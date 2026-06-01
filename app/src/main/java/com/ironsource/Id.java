package com.ironsource;

import com.ironsource.S7;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Id implements S7, S7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, LevelPlayReward> f6991a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, LevelPlayReward> f6992b = new LinkedHashMap();

    @Override // com.ironsource.S7.a
    public void a(String placement, String rewardName, int i2) {
        kotlin.jvm.internal.k.e(placement, "placement");
        kotlin.jvm.internal.k.e(rewardName, "rewardName");
        this.f6991a.put(placement, new LevelPlayReward(rewardName, i2));
    }

    @Override // com.ironsource.S7.a
    public void b(String adUnitId, String rewardName, int i2) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(rewardName, "rewardName");
        this.f6992b.put(adUnitId, new LevelPlayReward(rewardName, i2));
    }

    private final LevelPlayReward b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.f6991a.get(str);
    }

    @Override // com.ironsource.S7
    public LevelPlayReward a(String str, String adUnitId) {
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        LevelPlayReward levelPlayRewardB = b(str);
        return levelPlayRewardB == null ? a(adUnitId) : levelPlayRewardB;
    }

    private final LevelPlayReward a(String str) {
        return this.f6992b.get(str);
    }
}
