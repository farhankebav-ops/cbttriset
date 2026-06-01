package sg.bigo.ads.common.ab;

import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15575b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    public final int f15577d;

    private b(int i2, int i8, @ColorInt int i9) {
        this.f15574a = i2;
        this.f15576c = i8;
        this.f15577d = i9;
    }

    public static b a(int i2, int i8, @ColorInt int i9) {
        return new b(i2, i8, i9);
    }
}
