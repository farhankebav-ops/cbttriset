package com.onesignal.common.consistency;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RywData {
    private final Long rywDelay;
    private final String rywToken;

    public RywData(String rywToken, Long l) {
        k.e(rywToken, "rywToken");
        this.rywToken = rywToken;
        this.rywDelay = l;
    }

    public static /* synthetic */ RywData copy$default(RywData rywData, String str, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rywData.rywToken;
        }
        if ((i2 & 2) != 0) {
            l = rywData.rywDelay;
        }
        return rywData.copy(str, l);
    }

    public final String component1() {
        return this.rywToken;
    }

    public final Long component2() {
        return this.rywDelay;
    }

    public final RywData copy(String rywToken, Long l) {
        k.e(rywToken, "rywToken");
        return new RywData(rywToken, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RywData)) {
            return false;
        }
        RywData rywData = (RywData) obj;
        return k.a(this.rywToken, rywData.rywToken) && k.a(this.rywDelay, rywData.rywDelay);
    }

    public final Long getRywDelay() {
        return this.rywDelay;
    }

    public final String getRywToken() {
        return this.rywToken;
    }

    public int hashCode() {
        int iHashCode = this.rywToken.hashCode() * 31;
        Long l = this.rywDelay;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "RywData(rywToken=" + this.rywToken + ", rywDelay=" + this.rywDelay + ')';
    }
}
