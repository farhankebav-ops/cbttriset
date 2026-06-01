package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ForceCloseCaptureSession {
    private final CaptureSessionOnClosedNotCalledQuirk mCaptureSessionOnClosedNotCalledQuirk;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @FunctionalInterface
    public interface OnConfigured {
        void run(SynchronizedCaptureSession synchronizedCaptureSession);
    }

    public ForceCloseCaptureSession(Quirks quirks) {
        this.mCaptureSessionOnClosedNotCalledQuirk = (CaptureSessionOnClosedNotCalledQuirk) quirks.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void forceOnClosed(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    private void forceOnConfigureFailed(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onConfigureFailed(synchronizedCaptureSession);
        }
    }

    public void onSessionConfigured(SynchronizedCaptureSession synchronizedCaptureSession, List<SynchronizedCaptureSession> list, List<SynchronizedCaptureSession> list2, OnConfigured onConfigured) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = list.iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        onConfigured.run(synchronizedCaptureSession);
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = list2.iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }

    public boolean shouldForceClose() {
        return this.mCaptureSessionOnClosedNotCalledQuirk != null;
    }
}
