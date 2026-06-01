package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.InterProcessCoordinatorKt;
import kotlin.jvm.internal.k;
import l7.g0;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorageKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(g0 path) {
        k.e(path, "path");
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(f.d(path.f12851a.t(), true).f12851a.t());
    }
}
