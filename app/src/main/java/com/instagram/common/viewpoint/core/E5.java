package com.instagram.common.viewpoint.core;

import com.instagram.common.viewpoint.core.E5;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class E5<T extends E5<T>> {
    public final int A00;
    public final int A01;
    public final C2154or A02;
    public final C2120oH A03;

    public abstract int A08();

    public abstract boolean A09(T t3);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.E5 != com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TrackInfo<T extends com.facebook.ads.redexgen.X.E5<T>> */
    public E5(int i2, C2120oH c2120oH, int i8) {
        this.A00 = i2;
        this.A03 = c2120oH;
        this.A01 = i8;
        this.A02 = c2120oH.A08(i8);
    }
}
