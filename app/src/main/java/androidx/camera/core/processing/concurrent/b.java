package androidx.camera.core.processing.concurrent;

import androidx.camera.core.CompositionSettings;
import androidx.camera.core.DynamicRange;
import e6.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements q {
    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return new DualSurfaceProcessor((DynamicRange) obj, (CompositionSettings) obj2, (CompositionSettings) obj3);
    }
}
