package com.vungle.ads.internal.model;

import a1.a;
import b7.c;
import b7.h;
import com.vungle.ads.internal.Constants;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class Placement {
    public static final Companion Companion = new Companion(null);
    private final boolean headerBidding;
    private final String referenceId;
    private final String type;
    private Long wakeupTime;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return Placement$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Placement(int i2, String str, boolean z2, String str2, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(Placement$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.referenceId = str;
        if ((i2 & 2) == 0) {
            this.headerBidding = false;
        } else {
            this.headerBidding = z2;
        }
        if ((i2 & 4) == 0) {
            this.type = null;
        } else {
            this.type = str2;
        }
        this.wakeupTime = null;
    }

    public static /* synthetic */ Placement copy$default(Placement placement, String str, boolean z2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = placement.referenceId;
        }
        if ((i2 & 2) != 0) {
            z2 = placement.headerBidding;
        }
        if ((i2 & 4) != 0) {
            str2 = placement.type;
        }
        return placement.copy(str, z2, str2);
    }

    public static final void write$Self(Placement self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.referenceId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.headerBidding) {
            output.encodeBooleanElement(serialDesc, 1, self.headerBidding);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.type == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.type);
    }

    public final String component1() {
        return this.referenceId;
    }

    public final boolean component2() {
        return this.headerBidding;
    }

    public final String component3() {
        return this.type;
    }

    public final Placement copy(String referenceId, boolean z2, String str) {
        k.e(referenceId, "referenceId");
        return new Placement(referenceId, z2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) obj;
        return k.a(this.referenceId, placement.referenceId) && this.headerBidding == placement.headerBidding && k.a(this.type, placement.type);
    }

    public final boolean getHeaderBidding() {
        return this.headerBidding;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getType() {
        return this.type;
    }

    public final Long getWakeupTime() {
        return this.wakeupTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.referenceId.hashCode() * 31;
        boolean z2 = this.headerBidding;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        String str = this.type;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isAppOpen() {
        return k.a(this.type, Constants.PLACEMENT_TYPE_APP_OPEN);
    }

    public final boolean isBanner() {
        return k.a(this.type, "banner");
    }

    public final boolean isInline() {
        return k.a(this.type, "in_line");
    }

    public final boolean isInterstitial() {
        return k.a(this.type, "interstitial");
    }

    public final boolean isMREC() {
        return k.a(this.type, "mrec");
    }

    public final boolean isNative() {
        return k.a(this.type, "native");
    }

    public final boolean isRewardedVideo() {
        return k.a(this.type, "rewarded");
    }

    public final void setWakeupTime(Long l) {
        this.wakeupTime = l;
    }

    public final void snooze(long j) {
        this.wakeupTime = Long.valueOf((j * ((long) 1000)) + System.currentTimeMillis());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Placement(referenceId=");
        sb.append(this.referenceId);
        sb.append(", headerBidding=");
        sb.append(this.headerBidding);
        sb.append(", type=");
        return a.e(')', this.type, sb);
    }

    public Placement(String referenceId, boolean z2, String str) {
        k.e(referenceId, "referenceId");
        this.referenceId = referenceId;
        this.headerBidding = z2;
        this.type = str;
    }

    public /* synthetic */ Placement(String str, boolean z2, String str2, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ void getHeaderBidding$annotations() {
    }

    public static /* synthetic */ void getReferenceId$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public static /* synthetic */ void getWakeupTime$annotations() {
    }
}
