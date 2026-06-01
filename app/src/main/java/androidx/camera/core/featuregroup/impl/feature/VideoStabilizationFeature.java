package androidx.camera.core.featuregroup.impl.feature;

import androidx.camera.core.featuregroup.GroupableFeature;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoStabilizationFeature extends GroupableFeature {
    public static final Companion Companion = new Companion(null);
    public static final StabilizationMode DEFAULT_STABILIZATION_MODE = StabilizationMode.OFF;
    private final FeatureTypeInternal featureTypeInternal;
    private final StabilizationMode mode;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class StabilizationMode {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ StabilizationMode[] $VALUES;
        public static final StabilizationMode OFF = new StabilizationMode("OFF", 0);
        public static final StabilizationMode ON = new StabilizationMode("ON", 1);
        public static final StabilizationMode PREVIEW = new StabilizationMode("PREVIEW", 2);

        private static final /* synthetic */ StabilizationMode[] $values() {
            return new StabilizationMode[]{OFF, ON, PREVIEW};
        }

        static {
            StabilizationMode[] stabilizationModeArr$values = $values();
            $VALUES = stabilizationModeArr$values;
            $ENTRIES = b.n(stabilizationModeArr$values);
        }

        private StabilizationMode(String str, int i2) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static StabilizationMode valueOf(String str) {
            return (StabilizationMode) Enum.valueOf(StabilizationMode.class, str);
        }

        public static StabilizationMode[] values() {
            return (StabilizationMode[]) $VALUES.clone();
        }
    }

    public VideoStabilizationFeature(StabilizationMode mode) {
        k.e(mode, "mode");
        this.mode = mode;
        this.featureTypeInternal = FeatureTypeInternal.VIDEO_STABILIZATION;
    }

    @Override // androidx.camera.core.featuregroup.GroupableFeature
    public FeatureTypeInternal getFeatureTypeInternal$camera_core_release() {
        return this.featureTypeInternal;
    }

    public final StabilizationMode getMode() {
        return this.mode;
    }

    public String toString() {
        return "VideoStabilizationFeature(mode=" + this.mode.name() + ')';
    }
}
