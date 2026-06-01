package w1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17679a;

    public a(float f4) {
        this.f17679a = f4;
    }

    @Override // w1.d
    public final float a(RectF rectF) {
        return this.f17679a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f17679a == ((a) obj).f17679a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f17679a)});
    }

    public final String toString() {
        return this.f17679a + "px";
    }
}
