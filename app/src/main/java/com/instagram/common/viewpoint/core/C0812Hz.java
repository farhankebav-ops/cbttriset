package com.instagram.common.viewpoint.core;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0812Hz {
    public static String[] A0B = {"nEg82cXZVYZFfZdDmhKyBuPXw98CjCqr", "lWWNRS3KueXb9Tbf73wyUq3w1CVt7zYo", "9i1TifP67Pthfk8s9WN", "2Mfz8aUpVuODbM0LRRY7IzxNE33rrKDp", "lWmgQQDKaNBy8Pu2POQEfpeN2vAsVVBR", "WAUg7lL5KFyy4cAmNpLa1cxU0cT6TIeS", "jMg6XDLnbUHNrmDX3ZR", "RwGxvdCbKX59SF6mGNLLwZG43nCYkk8W"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<C0811Hy> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 23
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0812Hz A02(C4J c4j) {
        long jA0Q = c4j.A0Q();
        boolean z2 = (c4j.A0I() & 128) != 0;
        boolean z7 = false;
        boolean z8 = false;
        ArrayList arrayList = new ArrayList();
        int iA0M = 0;
        int iA0I = 0;
        int iA0I2 = 0;
        boolean z9 = false;
        long jA0Q2 = -9223372036854775807L;
        if (!z2) {
            int iA0I3 = c4j.A0I();
            z7 = (iA0I3 & 128) != 0;
            z8 = (iA0I3 & 64) != 0;
            if (A0B[3].charAt(19) != '7') {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[0] = "nLO0WJRxYuU9qthfzcYyP1P8ccIGaxOi";
            strArr[1] = "OIpoqKTSq2Ia2FsBUXzy5KxMNemzaoxr";
            boolean z10 = (iA0I3 & 32) != 0;
            jA0Q = z8 ? c4j.A0Q() : -9223372036854775807L;
            if (!z8) {
                int iA0I4 = c4j.A0I();
                arrayList = new ArrayList(iA0I4);
                for (int i2 = 0; i2 < iA0I4; i2++) {
                    arrayList.add(new C0811Hy(c4j.A0I(), c4j.A0Q(), null));
                }
                if (A0B[3].charAt(19) == '7') {
                    A0B[4] = "ZIJV8CxCO5lc3X0ct1XMotdLhBio9GzL";
                }
            }
            if (z10) {
                long jA0I = c4j.A0I();
                z9 = (128 & jA0I) != 0;
                jA0Q2 = (1000 * (((1 & jA0I) << 32) | c4j.A0Q())) / 90;
            }
            iA0M = c4j.A0M();
            iA0I = c4j.A0I();
            iA0I2 = c4j.A0I();
        }
        return new C0812Hz(jA0Q, z2, z7, z8, arrayList, jA0Q, z9, jA0Q2, iA0M, iA0I, iA0I2);
    }

    public C0812Hz(long j, boolean z2, boolean z7, boolean z8, List<C0811Hy> list, long j3, boolean z9, long j8, int i2, int i8, int i9) {
        this.A04 = j;
        this.A0A = z2;
        this.A08 = z7;
        this.A09 = z8;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j3;
        this.A07 = z9;
        this.A03 = j8;
        this.A02 = i2;
        this.A00 = i8;
        this.A01 = i9;
    }

    public C0812Hz(Parcel parcel) {
        this.A04 = parcel.readLong();
        this.A0A = parcel.readByte() == 1;
        this.A08 = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        int i2 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i2);
        for (int i8 = 0; i8 < i2; i8++) {
            arrayList.add(C0811Hy.A00(parcel));
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        int componentSpliceListLength = parcel.readByte();
        this.A07 = componentSpliceListLength == 1;
        this.A03 = parcel.readLong();
        int componentSpliceListLength2 = parcel.readInt();
        this.A02 = componentSpliceListLength2;
        int componentSpliceListLength3 = parcel.readInt();
        this.A00 = componentSpliceListLength3;
        int componentSpliceListLength4 = parcel.readInt();
        this.A01 = componentSpliceListLength4;
    }

    public static C0812Hz A00(Parcel parcel) {
        return new C0812Hz(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A06.get(i2).A02(parcel);
        }
        parcel.writeLong(this.A05);
        parcel.writeByte(this.A07 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
