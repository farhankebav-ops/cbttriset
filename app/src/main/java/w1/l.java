package w1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17732a;

    public l(float f4) {
        this.f17732a = f4;
    }

    @Override // w1.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f17732a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.f17732a == ((l) obj).f17732a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f17732a)});
    }

    public final String toString() {
        return a1.a.q(new StringBuilder(), "%", (int) (this.f17732a * 100.0f));
    }
}
