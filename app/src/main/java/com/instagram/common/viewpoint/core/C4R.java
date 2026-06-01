package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4R {
    public long A00;
    public long A01;
    public long A02;
    public final ThreadLocal<Long> A03 = new ThreadLocal<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final synchronized long A06(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A01 != -9223372036854775807L) {
            long jA01 = A01(this.A01);
            long j3 = (4294967296L + jA01) / 8589934592L;
            long j8 = ((j3 - 1) * 8589934592L) + j;
            long j9 = (8589934592L * j3) + j;
            if (Math.abs(j8 - jA01) >= Math.abs(j9 - jA01)) {
                j8 = j9;
            }
            j = j8;
        }
        return A05(A00(j));
    }

    public C4R(long j) {
        A07(j);
    }

    public static long A00(long j) {
        return (1000000 * j) / 90000;
    }

    public static long A01(long j) {
        return (90000 * j) / 1000000;
    }

    public final synchronized long A02() {
        long j;
        if (this.A00 != LocationRequestCompat.PASSIVE_INTERVAL && this.A00 != 9223372036854775806L) {
            j = this.A00;
        } else {
            j = -9223372036854775807L;
        }
        return j;
    }

    public final synchronized long A03() {
        long jA02;
        if (this.A01 != -9223372036854775807L) {
            jA02 = this.A01 + this.A02;
        } else {
            jA02 = A02();
        }
        return jA02;
    }

    public final synchronized long A04() {
        return this.A02;
    }

    public final synchronized long A05(long j) {
        long desiredSampleTimestampUs;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 == -9223372036854775807L) {
            if (this.A00 == 9223372036854775806L) {
                desiredSampleTimestampUs = ((Long) C3M.A01(this.A03.get())).longValue();
            } else {
                desiredSampleTimestampUs = this.A00;
            }
            this.A02 = desiredSampleTimestampUs - j;
            notifyAll();
        }
        this.A01 = j;
        return this.A02 + j;
    }

    public final synchronized void A07(long j) {
        this.A00 = j;
        this.A02 = j == LocationRequestCompat.PASSIVE_INTERVAL ? 0L : -9223372036854775807L;
        this.A01 = -9223372036854775807L;
    }
}
