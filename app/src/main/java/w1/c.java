package w1;

import android.graphics.RectF;
import androidx.core.math.MathUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17691a;

    public c(float f4) {
        this.f17691a = f4;
    }

    @Override // w1.d
    public final float a(RectF rectF) {
        return MathUtils.clamp(this.f17691a, 0.0f, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f17691a == ((c) obj).f17691a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f17691a)});
    }
}
