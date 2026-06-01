package w1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f17685b;

    public b(float f4, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f17684a;
            f4 += ((b) dVar).f17685b;
        }
        this.f17684a = dVar;
        this.f17685b = f4;
    }

    @Override // w1.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f17684a.a(rectF) + this.f17685b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f17684a.equals(bVar.f17684a) && this.f17685b == bVar.f17685b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17684a, Float.valueOf(this.f17685b)});
    }
}
