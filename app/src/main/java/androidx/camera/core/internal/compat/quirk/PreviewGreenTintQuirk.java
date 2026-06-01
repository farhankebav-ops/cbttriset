package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Quirk;
import java.util.Collection;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewGreenTintQuirk implements Quirk {
    public static final PreviewGreenTintQuirk INSTANCE = new PreviewGreenTintQuirk();

    private PreviewGreenTintQuirk() {
    }

    private final boolean isMotoE20() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e20".equalsIgnoreCase(Build.MODEL);
    }

    public static final boolean load() {
        return INSTANCE.isMotoE20();
    }

    public static final boolean shouldForceEnableStreamSharing(String cameraId, Collection<? extends UseCase> appUseCases) {
        k.e(cameraId, "cameraId");
        k.e(appUseCases, "appUseCases");
        PreviewGreenTintQuirk previewGreenTintQuirk = INSTANCE;
        if (previewGreenTintQuirk.isMotoE20()) {
            return previewGreenTintQuirk.shouldForceEnableStreamSharingForMotoE20(cameraId, appUseCases);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean shouldForceEnableStreamSharingForMotoE20(java.lang.String r6, java.util.Collection<? extends androidx.camera.core.UseCase> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "0"
            boolean r6 = kotlin.jvm.internal.k.a(r6, r0)
            r0 = 0
            if (r6 == 0) goto L65
            int r6 = r7.size()
            r1 = 2
            if (r6 == r1) goto L11
            goto L65
        L11:
            boolean r6 = r7.isEmpty()
            r1 = 1
            if (r6 == 0) goto L1a
        L18:
            r6 = r0
            goto L2f
        L1a:
            java.util.Iterator r6 = r7.iterator()
        L1e:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L18
            java.lang.Object r2 = r6.next()
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2
            boolean r2 = r2 instanceof androidx.camera.core.Preview
            if (r2 == 0) goto L1e
            r6 = r1
        L2f:
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L37
        L35:
            r7 = r0
            goto L60
        L37:
            java.util.Iterator r7 = r7.iterator()
        L3b:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L35
            java.lang.Object r2 = r7.next()
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2
            androidx.camera.core.impl.UseCaseConfig r3 = r2.getCurrentConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.impl.UseCaseConfigFactory$CaptureType> r4 = androidx.camera.core.impl.UseCaseConfig.OPTION_CAPTURE_TYPE
            boolean r3 = r3.containsOption(r4)
            if (r3 == 0) goto L3b
            androidx.camera.core.impl.UseCaseConfig r2 = r2.getCurrentConfig()
            androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r2 = r2.getCaptureType()
            androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r3 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE
            if (r2 != r3) goto L3b
            r7 = r1
        L60:
            if (r6 == 0) goto L65
            if (r7 == 0) goto L65
            return r1
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk.shouldForceEnableStreamSharingForMotoE20(java.lang.String, java.util.Collection):boolean");
    }
}
