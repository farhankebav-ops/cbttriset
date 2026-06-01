package androidx.camera.core.impl;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraDeviceSurfaceManager extends InternalCameraPresenceListener {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Provider {
        CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set<String> set) throws InitializationException;
    }

    SurfaceStreamSpecQueryResult getSuggestedStreamSpecs(int i2, String str, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map, boolean z2, boolean z7, boolean z8, boolean z9);

    SurfaceConfig transformSurfaceConfig(int i2, String str, int i8, Size size, StreamUseCase streamUseCase);
}
