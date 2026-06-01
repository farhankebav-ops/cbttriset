package com.instagram.common.viewpoint.core;

import android.os.Parcel;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0808Hv {
    public final int A00;
    public final long A01;
    public final long A02;

    public C0808Hv(int i2, long j, long j3) {
        this.A00 = i2;
        this.A02 = j;
        this.A01 = j3;
    }

    public /* synthetic */ C0808Hv(int i2, long j, long j3, C0807Hu c0807Hu) {
        this(i2, j, j3);
    }

    public static C0808Hv A00(Parcel parcel) {
        return new C0808Hv(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}
