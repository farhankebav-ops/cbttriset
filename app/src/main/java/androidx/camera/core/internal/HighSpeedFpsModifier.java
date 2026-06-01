package androidx.camera.core.internal;

import android.media.MediaCodec;
import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HighSpeedFpsModifier {
    private static final Companion Companion = new Companion(null);
    private static final int PREVIEW_ONLY_FPS_LOWER = 30;
    private static final String TAG = "HighSpeedFpsModifier";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean hasVideoSurface(CaptureConfig.Builder builder) {
        Set<DeferrableSurface> surfaces = builder.getSurfaces();
        k.d(surfaces, "getSurfaces(...)");
        if (surfaces.isEmpty()) {
            return false;
        }
        for (DeferrableSurface deferrableSurface : surfaces) {
            k.b(deferrableSurface);
            if (isVideoSurface(deferrableSurface)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isHighSpeedFixedFps(Range<Integer> range) {
        return ((Number) range.getUpper()).intValue() >= 120 && k.a(range.getLower(), range.getUpper());
    }

    private final boolean isVideoSurface(DeferrableSurface deferrableSurface) {
        return k.a(deferrableSurface.getContainerClass(), MediaCodec.class);
    }

    private final Range<Integer> toPreviewOnlyRange(Range<Integer> range) {
        Range<Integer> range2 = new Range<>(30, range.getUpper());
        Logger.d(TAG, "Modified high-speed FPS range from " + range + " to " + range2);
        return range2;
    }

    public final void modifyFpsForPreviewOnlyRepeating(Collection<? extends SessionConfig.OutputConfig> outputConfigs, CaptureConfig.Builder repeatingConfigBuilder) {
        Range<Integer> expectedFrameRateRange;
        k.e(outputConfigs, "outputConfigs");
        k.e(repeatingConfigBuilder, "repeatingConfigBuilder");
        if (outputConfigs.size() != 2 || !hasVideoSurface(outputConfigs) || hasVideoSurface(repeatingConfigBuilder) || (expectedFrameRateRange = repeatingConfigBuilder.getExpectedFrameRateRange()) == null) {
            return;
        }
        if (!isHighSpeedFixedFps(expectedFrameRateRange)) {
            expectedFrameRateRange = null;
        }
        if (expectedFrameRateRange != null) {
            repeatingConfigBuilder.setExpectedFrameRateRange(toPreviewOnlyRange(expectedFrameRateRange));
        }
    }

    private final boolean hasVideoSurface(Collection<? extends SessionConfig.OutputConfig> collection) {
        if (collection != null && collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            DeferrableSurface surface = ((SessionConfig.OutputConfig) it.next()).getSurface();
            k.d(surface, "getSurface(...)");
            if (isVideoSurface(surface)) {
                return true;
            }
        }
        return false;
    }
}
