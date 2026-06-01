package com.vungle.ads.fpd;

import b7.c;
import b7.h;
import com.vungle.ads.internal.util.RangeUtil;
import d7.g;
import e7.d;
import f7.d0;
import f7.m1;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class Revenue {
    public static final Companion Companion = new Companion(null);
    private Float earningsByPlacementUSD;
    private Boolean isUserAPurchaser;
    private Boolean isUserASubscriber;
    private Float last30DaysMeanSpendUSD;
    private Float last30DaysMedianSpendUSD;
    private Float last30DaysPlacementFillRate;
    private Float last30DaysTotalSpendUSD;
    private Float last30DaysUserLtvUSD;
    private Float last30DaysUserPltvUSD;
    private Float last7DaysMeanSpendUSD;
    private Float last7DaysMedianSpendUSD;
    private Float last7DaysPlacementFillRate;
    private Float last7DaysTotalSpendUSD;
    private Float last7DaysUserLtvUSD;
    private Float last7DaysUserPltvUSD;
    private List<String> topNAdomain;
    private Float totalEarningsUSD;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return Revenue$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Revenue() {
    }

    public static final void write$Self(Revenue self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.totalEarningsUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, d0.f11433a, self.totalEarningsUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.earningsByPlacementUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, d0.f11433a, self.earningsByPlacementUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.topNAdomain != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, new f7.d(q1.f11501a, 0), self.topNAdomain);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isUserAPurchaser != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, f7.g.f11455a, self.isUserAPurchaser);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isUserASubscriber != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, f7.g.f11455a, self.isUserASubscriber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.last7DaysTotalSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, d0.f11433a, self.last7DaysTotalSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.last7DaysMedianSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, d0.f11433a, self.last7DaysMedianSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.last7DaysMeanSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, d0.f11433a, self.last7DaysMeanSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.last30DaysTotalSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, d0.f11433a, self.last30DaysTotalSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.last30DaysMedianSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, d0.f11433a, self.last30DaysMedianSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.last30DaysMeanSpendUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, d0.f11433a, self.last30DaysMeanSpendUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.last7DaysUserPltvUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, d0.f11433a, self.last7DaysUserPltvUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.last7DaysUserLtvUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, d0.f11433a, self.last7DaysUserLtvUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.last30DaysUserPltvUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, d0.f11433a, self.last30DaysUserPltvUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.last30DaysUserLtvUSD != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, d0.f11433a, self.last30DaysUserLtvUSD);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.last7DaysPlacementFillRate != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, d0.f11433a, self.last7DaysPlacementFillRate);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && self.last30DaysPlacementFillRate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 16, d0.f11433a, self.last30DaysPlacementFillRate);
    }

    public final Revenue setEarningsByPlacement(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.earningsByPlacementUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setIsUserAPurchaser(boolean z2) {
        this.isUserAPurchaser = Boolean.valueOf(z2);
        return this;
    }

    public final Revenue setIsUserASubscriber(boolean z2) {
        this.isUserASubscriber = Boolean.valueOf(z2);
        return this;
    }

    public final Revenue setLast30DaysMeanSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMeanSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast30DaysMedianSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysMedianSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast30DaysPlacementFillRate(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.last30DaysPlacementFillRate = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast30DaysTotalSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysTotalSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast30DaysUserLtvUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserLtvUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast30DaysUserPltvUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last30DaysUserPltvUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysMeanSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMeanSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysMedianSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysMedianSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysPlacementFillRate(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.last7DaysPlacementFillRate = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysTotalSpendUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysTotalSpendUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysUserLtvUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserLtvUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setLast7DaysUserPltvUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.last7DaysUserPltvUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final Revenue setTopNAdomain(List<String> list) {
        this.topNAdomain = list != null ? l.o1(list) : null;
        return this;
    }

    public final Revenue setTotalEarningsUsd(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.totalEarningsUSD = Float.valueOf(f4);
        }
        return this;
    }

    public /* synthetic */ Revenue(int i2, Float f4, Float f8, List list, Boolean bool, Boolean bool2, Float f9, Float f10, Float f11, Float f12, Float f13, Float f14, Float f15, Float f16, Float f17, Float f18, Float f19, Float f20, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.totalEarningsUSD = null;
        } else {
            this.totalEarningsUSD = f4;
        }
        if ((i2 & 2) == 0) {
            this.earningsByPlacementUSD = null;
        } else {
            this.earningsByPlacementUSD = f8;
        }
        if ((i2 & 4) == 0) {
            this.topNAdomain = null;
        } else {
            this.topNAdomain = list;
        }
        if ((i2 & 8) == 0) {
            this.isUserAPurchaser = null;
        } else {
            this.isUserAPurchaser = bool;
        }
        if ((i2 & 16) == 0) {
            this.isUserASubscriber = null;
        } else {
            this.isUserASubscriber = bool2;
        }
        if ((i2 & 32) == 0) {
            this.last7DaysTotalSpendUSD = null;
        } else {
            this.last7DaysTotalSpendUSD = f9;
        }
        if ((i2 & 64) == 0) {
            this.last7DaysMedianSpendUSD = null;
        } else {
            this.last7DaysMedianSpendUSD = f10;
        }
        if ((i2 & 128) == 0) {
            this.last7DaysMeanSpendUSD = null;
        } else {
            this.last7DaysMeanSpendUSD = f11;
        }
        if ((i2 & 256) == 0) {
            this.last30DaysTotalSpendUSD = null;
        } else {
            this.last30DaysTotalSpendUSD = f12;
        }
        if ((i2 & 512) == 0) {
            this.last30DaysMedianSpendUSD = null;
        } else {
            this.last30DaysMedianSpendUSD = f13;
        }
        if ((i2 & 1024) == 0) {
            this.last30DaysMeanSpendUSD = null;
        } else {
            this.last30DaysMeanSpendUSD = f14;
        }
        if ((i2 & 2048) == 0) {
            this.last7DaysUserPltvUSD = null;
        } else {
            this.last7DaysUserPltvUSD = f15;
        }
        if ((i2 & 4096) == 0) {
            this.last7DaysUserLtvUSD = null;
        } else {
            this.last7DaysUserLtvUSD = f16;
        }
        if ((i2 & 8192) == 0) {
            this.last30DaysUserPltvUSD = null;
        } else {
            this.last30DaysUserPltvUSD = f17;
        }
        if ((i2 & 16384) == 0) {
            this.last30DaysUserLtvUSD = null;
        } else {
            this.last30DaysUserLtvUSD = f18;
        }
        if ((32768 & i2) == 0) {
            this.last7DaysPlacementFillRate = null;
        } else {
            this.last7DaysPlacementFillRate = f19;
        }
        if ((i2 & 65536) == 0) {
            this.last30DaysPlacementFillRate = null;
        } else {
            this.last30DaysPlacementFillRate = f20;
        }
    }

    private static /* synthetic */ void getEarningsByPlacementUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast30DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast30DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMeanSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysMedianSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysPlacementFillRate$annotations() {
    }

    private static /* synthetic */ void getLast7DaysTotalSpendUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserLtvUSD$annotations() {
    }

    private static /* synthetic */ void getLast7DaysUserPltvUSD$annotations() {
    }

    private static /* synthetic */ void getTopNAdomain$annotations() {
    }

    private static /* synthetic */ void getTotalEarningsUSD$annotations() {
    }

    private static /* synthetic */ void isUserAPurchaser$annotations() {
    }

    private static /* synthetic */ void isUserASubscriber$annotations() {
    }
}
