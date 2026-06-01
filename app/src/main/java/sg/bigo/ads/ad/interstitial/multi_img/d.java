package sg.bigo.ads.ad.interstitial.multi_img;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public enum d {
    NONE(0, 3, 20, 0, 1.0f, 1.0f),
    LTR(1, 1, 20, 12, 1.0f, 1.0f),
    CENTER(2, 2, 30, 12, 0.8f, 0.9f),
    FULL(3, 3, 20, 0, 1.0f, 1.0f),
    TILE(Integer.MIN_VALUE, Integer.MIN_VALUE, 20, 12, 1.0f, 1.0f);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14865f;
    final float g;
    final float h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14866i;
    public final int j;
    private final int k;

    d(int i2, int i8, int i9, int i10, float f4, float f8) {
        this.k = i2;
        this.j = i8;
        this.f14866i = i9;
        this.f14865f = i10;
        this.g = f4;
        this.h = f8;
    }

    @NonNull
    public static d a(int i2) {
        return i2 != Integer.MIN_VALUE ? i2 != 1 ? i2 != 2 ? i2 != 3 ? NONE : FULL : CENTER : LTR : TILE;
    }
}
