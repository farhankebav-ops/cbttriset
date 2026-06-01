package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SessionResetPolicy {
    private final boolean mNeedAbortCapture;

    public SessionResetPolicy(Quirks quirks) {
        this.mNeedAbortCapture = quirks.contains(Preview3AThreadCrashQuirk.class);
    }

    public boolean needAbortCapture() {
        return this.mNeedAbortCapture;
    }
}
