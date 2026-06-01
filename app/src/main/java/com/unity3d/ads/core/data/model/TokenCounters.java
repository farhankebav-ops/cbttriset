package com.unity3d.ads.core.data.model;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TokenCounters {
    private int seq;
    private int starts;
    private int wins;

    public TokenCounters(int i2, int i8, int i9) {
        this.seq = i2;
        this.wins = i8;
        this.starts = i9;
    }

    public static /* synthetic */ TokenCounters copy$default(TokenCounters tokenCounters, int i2, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i2 = tokenCounters.seq;
        }
        if ((i10 & 2) != 0) {
            i8 = tokenCounters.wins;
        }
        if ((i10 & 4) != 0) {
            i9 = tokenCounters.starts;
        }
        return tokenCounters.copy(i2, i8, i9);
    }

    public final int component1() {
        return this.seq;
    }

    public final int component2() {
        return this.wins;
    }

    public final int component3() {
        return this.starts;
    }

    public final TokenCounters copy(int i2, int i8, int i9) {
        return new TokenCounters(i2, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenCounters)) {
            return false;
        }
        TokenCounters tokenCounters = (TokenCounters) obj;
        return this.seq == tokenCounters.seq && this.wins == tokenCounters.wins && this.starts == tokenCounters.starts;
    }

    public final int getSeq() {
        return this.seq;
    }

    public final int getStarts() {
        return this.starts;
    }

    public final int getWins() {
        return this.wins;
    }

    public int hashCode() {
        return (((this.seq * 31) + this.wins) * 31) + this.starts;
    }

    public final void setSeq(int i2) {
        this.seq = i2;
    }

    public final void setStarts(int i2) {
        this.starts = i2;
    }

    public final void setWins(int i2) {
        this.wins = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TokenCounters(seq=");
        sb.append(this.seq);
        sb.append(", wins=");
        sb.append(this.wins);
        sb.append(", starts=");
        return a0.c(sb, this.starts, ')');
    }
}
