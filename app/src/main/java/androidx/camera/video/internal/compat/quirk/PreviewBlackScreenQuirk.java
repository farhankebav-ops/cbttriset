package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk;
import androidx.camera.core.internal.compat.quirk.b;
import kotlin.jvm.internal.f;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewBlackScreenQuirk implements SurfaceProcessingQuirk {
    public static final Companion Companion = new Companion(null);
    private static final boolean isMotorolaEdge20Fusion;
    private static final boolean isSamsungSmT580;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final boolean load() {
            return PreviewBlackScreenQuirk.isMotorolaEdge20Fusion || PreviewBlackScreenQuirk.isSamsungSmT580;
        }

        private Companion() {
        }
    }

    static {
        String str = Build.BRAND;
        boolean z2 = false;
        isMotorolaEdge20Fusion = t.g0(str, "motorola") && t.g0(Build.MODEL, "motorola edge 20 fusion");
        if (t.g0(str, "samsung") && t.g0(Build.MODEL, "sm-t580")) {
            z2 = true;
        }
        isSamsungSmT580 = z2;
    }

    public static final boolean load() {
        return Companion.load();
    }

    @Override // androidx.camera.core.internal.compat.quirk.SurfaceProcessingQuirk
    public final /* synthetic */ boolean workaroundBySurfaceProcessing() {
        return b.a(this);
    }
}
