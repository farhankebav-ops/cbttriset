package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.core.util.Pair;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CompositionSettings {
    public static final CompositionSettings DEFAULT = new Builder().setAlpha(1.0f).setOffset(0.0f, 0.0f).setScale(1.0f, 1.0f).build();
    private final float mAlpha;
    private final Pair<Float, Float> mOffset;
    private final Pair<Float, Float> mScale;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private float mAlpha;
        private Pair<Float, Float> mOffset;
        private Pair<Float, Float> mScale;

        public Builder() {
            Float fValueOf = Float.valueOf(1.0f);
            this.mAlpha = 1.0f;
            Float fValueOf2 = Float.valueOf(0.0f);
            this.mOffset = Pair.create(fValueOf2, fValueOf2);
            this.mScale = Pair.create(fValueOf, fValueOf);
        }

        public CompositionSettings build() {
            return new CompositionSettings(this.mAlpha, this.mOffset, this.mScale);
        }

        public Builder setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
            this.mAlpha = f4;
            return this;
        }

        public Builder setOffset(@FloatRange(from = -1.0d, to = 1.0d) float f4, @FloatRange(from = -1.0d, to = 1.0d) float f8) {
            this.mOffset = Pair.create(Float.valueOf(f4), Float.valueOf(f8));
            return this;
        }

        public Builder setScale(float f4, float f8) {
            this.mScale = Pair.create(Float.valueOf(f4), Float.valueOf(f8));
            return this;
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public Pair<Float, Float> getOffset() {
        return this.mOffset;
    }

    public Pair<Float, Float> getScale() {
        return this.mScale;
    }

    private CompositionSettings(float f4, Pair<Float, Float> pair, Pair<Float, Float> pair2) {
        this.mAlpha = f4;
        this.mOffset = pair;
        this.mScale = pair2;
    }
}
