package com.instagram.common.viewpoint.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0811Hy {
    public final int A00;
    public final long A01;

    public C0811Hy(int i2, long j) {
        this.A00 = i2;
        this.A01 = j;
    }

    public /* synthetic */ C0811Hy(int i2, long j, C0810Hx c0810Hx) {
        this(i2, j);
    }

    public static C0811Hy A00(Parcel parcel) {
        return new C0811Hy(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
