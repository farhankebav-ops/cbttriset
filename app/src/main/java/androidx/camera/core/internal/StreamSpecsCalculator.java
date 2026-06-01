package androidx.camera.core.internal;

import android.util.Range;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.StreamSpec;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface StreamSpecsCalculator {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final StreamSpecsCalculator NO_OP_STREAM_SPECS_CALCULATOR = new StreamSpecsCalculator() { // from class: androidx.camera.core.internal.StreamSpecsCalculator$Companion$NO_OP_STREAM_SPECS_CALCULATOR$1
        @Override // androidx.camera.core.internal.StreamSpecsCalculator
        public StreamSpecQueryResult calculateSuggestedStreamSpecs(int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, List<? extends UseCase> attachedUseCases, CameraConfig cameraConfig, int i8, Range<Integer> targetFrameRate, boolean z2, boolean z7) {
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(attachedUseCases, "attachedUseCases");
            k.e(cameraConfig, "cameraConfig");
            k.e(targetFrameRate, "targetFrameRate");
            return new StreamSpecQueryResult(null, 0, 3, null);
        }

        @Override // androidx.camera.core.internal.StreamSpecsCalculator
        public final /* synthetic */ void setCameraDeviceSurfaceManager(CameraDeviceSurfaceManager cameraDeviceSurfaceManager) {
            e.a(this, cameraDeviceSurfaceManager);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamSpecQueryResult calculateSuggestedStreamSpecsCompat$default(Companion companion, StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List list, CameraConfig cameraConfig, boolean z2, List list2, int i8, Range range, boolean z7, int i9, Object obj) {
            boolean z8;
            Companion companion2;
            StreamSpecsCalculator streamSpecsCalculator2;
            int i10;
            CameraInfoInternal cameraInfoInternal2;
            List list3;
            CameraConfig cameraConfigDefaultConfig = (i9 & 8) != 0 ? CameraConfigs.defaultConfig() : cameraConfig;
            boolean z9 = (i9 & 16) != 0 ? false : z2;
            List list4 = (i9 & 32) != 0 ? r.f13638a : list2;
            int i11 = (i9 & 64) != 0 ? 0 : i8;
            Range range2 = (i9 & 128) != 0 ? StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED : range;
            if ((i9 & 256) != 0) {
                z8 = false;
                streamSpecsCalculator2 = streamSpecsCalculator;
                i10 = i2;
                cameraInfoInternal2 = cameraInfoInternal;
                list3 = list;
                companion2 = companion;
            } else {
                z8 = z7;
                companion2 = companion;
                streamSpecsCalculator2 = streamSpecsCalculator;
                i10 = i2;
                cameraInfoInternal2 = cameraInfoInternal;
                list3 = list;
            }
            return companion2.calculateSuggestedStreamSpecsCompat(streamSpecsCalculator2, i10, cameraInfoInternal2, list3, cameraConfigDefaultConfig, z9, list4, i11, range2, z8);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, null, false, null, 0, null, false, 504, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, cameraConfig, false, null, 0, null, false, 496, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig, boolean z2) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, cameraConfig, z2, null, 0, null, false, 480, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig, boolean z2, List<? extends UseCase> attachedUseCases) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            k.e(attachedUseCases, "attachedUseCases");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, cameraConfig, z2, attachedUseCases, 0, null, false, 448, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig, boolean z2, List<? extends UseCase> attachedUseCases, int i8) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            k.e(attachedUseCases, "attachedUseCases");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, cameraConfig, z2, attachedUseCases, i8, null, false, 384, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig, boolean z2, List<? extends UseCase> attachedUseCases, int i8, Range<Integer> targetFrameRate) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            k.e(attachedUseCases, "attachedUseCases");
            k.e(targetFrameRate, "targetFrameRate");
            return calculateSuggestedStreamSpecsCompat$default(this, streamSpecsCalculator, i2, cameraInfoInternal, newUseCases, cameraConfig, z2, attachedUseCases, i8, targetFrameRate, false, 256, null);
        }

        public final StreamSpecQueryResult calculateSuggestedStreamSpecsCompat(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> newUseCases, CameraConfig cameraConfig, boolean z2, List<? extends UseCase> attachedUseCases, int i8, Range<Integer> targetFrameRate, boolean z7) {
            k.e(streamSpecsCalculator, "<this>");
            k.e(cameraInfoInternal, "cameraInfoInternal");
            k.e(newUseCases, "newUseCases");
            k.e(cameraConfig, "cameraConfig");
            k.e(attachedUseCases, "attachedUseCases");
            k.e(targetFrameRate, "targetFrameRate");
            return streamSpecsCalculator.calculateSuggestedStreamSpecs(i2, cameraInfoInternal, newUseCases, attachedUseCases, cameraConfig, i8, targetFrameRate, z2, z7);
        }
    }

    StreamSpecQueryResult calculateSuggestedStreamSpecs(int i2, CameraInfoInternal cameraInfoInternal, List<? extends UseCase> list, List<? extends UseCase> list2, CameraConfig cameraConfig, int i8, Range<Integer> range, boolean z2, boolean z7);

    void setCameraDeviceSurfaceManager(CameraDeviceSurfaceManager cameraDeviceSurfaceManager);
}
