package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CornerRounding {
    public static final Companion Companion;
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        f fVar = null;
        Companion = new Companion(fVar);
        float f4 = 0.0f;
        Unrounded = new CornerRounding(f4, f4, 3, fVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f4 = 0.0f;
        this(f4, f4, 3, null);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        this.radius = f4;
        this.smoothing = f8;
    }

    public /* synthetic */ CornerRounding(float f4, float f8, int i2, f fVar) {
        this((i2 & 1) != 0 ? 0.0f : f4, (i2 & 2) != 0 ? 0.0f : f8);
    }
}
