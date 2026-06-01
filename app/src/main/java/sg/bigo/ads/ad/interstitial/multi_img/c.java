package sg.bigo.ads.ad.interstitial.multi_img;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public enum c {
    FILL_MATCH_SELF(1, 1),
    FILL_MATCH_MAIN_VIEW(2, 2),
    FILL_MATCH_PARENT(3, 3);


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14860d;
    private final int e;

    c(int i2, int i8) {
        this.e = i2;
        this.f14860d = i8;
    }

    @NonNull
    public static c a(int i2) {
        return i2 != 2 ? i2 != 3 ? FILL_MATCH_SELF : FILL_MATCH_PARENT : FILL_MATCH_MAIN_VIEW;
    }
}
