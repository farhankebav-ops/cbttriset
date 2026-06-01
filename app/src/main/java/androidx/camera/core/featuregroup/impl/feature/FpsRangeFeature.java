package androidx.camera.core.featuregroup.impl.feature;

import android.util.Range;
import androidx.camera.core.featuregroup.GroupableFeature;
import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FpsRangeFeature extends GroupableFeature {
    public static final Companion Companion = new Companion(null);
    public static final Range<Integer> DEFAULT_FPS_RANGE = new Range<>(30, 30);
    private final FeatureTypeInternal featureTypeInternal = FeatureTypeInternal.FPS_RANGE;
    private final int maxFps;
    private final int minFps;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public FpsRangeFeature(int i2, int i8) {
        this.minFps = i2;
        this.maxFps = i8;
    }

    @Override // androidx.camera.core.featuregroup.GroupableFeature
    public FeatureTypeInternal getFeatureTypeInternal$camera_core_release() {
        return this.featureTypeInternal;
    }

    public final int getMaxFps() {
        return this.maxFps;
    }

    public final int getMinFps() {
        return this.minFps;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FpsRangeFeature(minFps=");
        sb.append(this.minFps);
        sb.append(", maxFps=");
        return a0.c(sb, this.maxFps, ')');
    }
}
