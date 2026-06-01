package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PreFillType {

    @VisibleForTesting
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i2) {
            this(i2, i2);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.weight = i2;
            return this;
        }

        public Builder(int i2, int i8) {
            this.weight = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i8 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.width = i2;
            this.height = i8;
        }
    }

    public PreFillType(int i2, int i8, Bitmap.Config config, int i9) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.width = i2;
        this.height = i8;
        this.weight = i9;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
                return true;
            }
        }
        return false;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.config.hashCode() + (((this.width * 31) + this.height) * 31)) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreFillSize{width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", config=");
        sb.append(this.config);
        sb.append(", weight=");
        return a0.c(sb, this.weight, '}');
    }
}
