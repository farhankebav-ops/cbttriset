package sg.bigo.ads.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15850c;

    public p(int i2, int i8) {
        this.f15849b = i2;
        this.f15850c = i8;
    }

    public static p a(int i2, int i8, int i9) {
        return new p((int) (((i9 * 1.0f) * i2) / i8), i9);
    }

    public static p b(int i2, int i8, int i9) {
        return new p(i9, (int) (((i9 * 1.0f) * i8) / i2));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (pVar.f15850c == this.f15850c && pVar.f15849b == this.f15849b) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f15850c;
    }

    public int getWidth() {
        return this.f15849b;
    }

    public String toString() {
        return this.f15849b + "x" + this.f15850c;
    }

    @NonNull
    public static p a(int i2, int i8, int i9, int i10) {
        float f4 = i2;
        float f8 = i8;
        float f9 = i9;
        float f10 = i10;
        if ((f4 * 1.0f) / f8 > (1.0f * f9) / f10) {
            f10 = (f9 / f4) * f8;
        } else {
            f9 = (f10 / f8) * f4;
        }
        return new p((int) f9, (int) f10);
    }

    public final boolean a() {
        return this.f15849b > 0 && this.f15850c > 0;
    }

    public final boolean a(int i2, int i8) {
        int i9;
        int i10;
        return (i2 == 0 || i8 == 0 || (i9 = this.f15849b) == 0 || (i10 = this.f15850c) == 0 || i2 * i10 != i8 * i9) ? false : true;
    }

    public final boolean a(p pVar) {
        return pVar != null && this.f15849b * this.f15850c > pVar.f15849b * pVar.f15850c;
    }
}
