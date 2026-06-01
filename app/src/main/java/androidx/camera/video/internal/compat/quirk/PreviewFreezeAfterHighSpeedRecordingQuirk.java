package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewFreezeAfterHighSpeedRecordingQuirk implements Quirk {
    public static final PreviewFreezeAfterHighSpeedRecordingQuirk INSTANCE = new PreviewFreezeAfterHighSpeedRecordingQuirk();
    private static final boolean isPixelPhone;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    static {
        /*
            androidx.camera.video.internal.compat.quirk.PreviewFreezeAfterHighSpeedRecordingQuirk r0 = new androidx.camera.video.internal.compat.quirk.PreviewFreezeAfterHighSpeedRecordingQuirk
            r0.<init>()
            androidx.camera.video.internal.compat.quirk.PreviewFreezeAfterHighSpeedRecordingQuirk.INSTANCE = r0
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r1 = "google"
            boolean r0 = n6.t.g0(r0, r1)
            if (r0 == 0) goto L22
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "MODEL"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "Pixel"
            r2 = 1
            boolean r0 = n6.t.n0(r0, r1, r2)
            if (r0 == 0) goto L22
            goto L23
        L22:
            r2 = 0
        L23:
            androidx.camera.video.internal.compat.quirk.PreviewFreezeAfterHighSpeedRecordingQuirk.isPixelPhone = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.compat.quirk.PreviewFreezeAfterHighSpeedRecordingQuirk.<clinit>():void");
    }

    private PreviewFreezeAfterHighSpeedRecordingQuirk() {
    }

    public static final boolean load() {
        return isPixelPhone;
    }
}
