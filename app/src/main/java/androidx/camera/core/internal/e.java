package androidx.camera.core.internal;

import android.util.Range;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.StreamSpecsCalculator;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    static {
        StreamSpecsCalculator.Companion companion = StreamSpecsCalculator.Companion;
    }

    public static void a(StreamSpecsCalculator streamSpecsCalculator, CameraDeviceSurfaceManager cameraDeviceSurfaceManager) {
        k.e(cameraDeviceSurfaceManager, "cameraDeviceSurfaceManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamSpecQueryResult b(StreamSpecsCalculator streamSpecsCalculator, int i2, CameraInfoInternal cameraInfoInternal, List list, List list2, CameraConfig cameraConfig, int i8, Range range, boolean z2, boolean z7, int i9, Object obj) {
        boolean z8;
        StreamSpecsCalculator streamSpecsCalculator2;
        int i10;
        CameraInfoInternal cameraInfoInternal2;
        List list3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateSuggestedStreamSpecs");
        }
        List list4 = (i9 & 8) != 0 ? r.f13638a : list2;
        CameraConfig cameraConfigDefaultConfig = (i9 & 16) != 0 ? CameraConfigs.defaultConfig() : cameraConfig;
        int i11 = (i9 & 32) != 0 ? 0 : i8;
        Range range2 = (i9 & 64) != 0 ? StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED : range;
        boolean z9 = (i9 & 128) != 0 ? false : z2;
        if ((i9 & 256) != 0) {
            z8 = false;
            i10 = i2;
            cameraInfoInternal2 = cameraInfoInternal;
            list3 = list;
            streamSpecsCalculator2 = streamSpecsCalculator;
        } else {
            z8 = z7;
            streamSpecsCalculator2 = streamSpecsCalculator;
            i10 = i2;
            cameraInfoInternal2 = cameraInfoInternal;
            list3 = list;
        }
        return streamSpecsCalculator2.calculateSuggestedStreamSpecs(i10, cameraInfoInternal2, list3, list4, cameraConfigDefaultConfig, i11, range2, z9, z8);
    }
}
