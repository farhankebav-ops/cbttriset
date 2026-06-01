package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl.ErrorTimeoutReopenScheduler.ScheduleNode f3522b;

    public /* synthetic */ t(Camera2CameraImpl.ErrorTimeoutReopenScheduler.ScheduleNode scheduleNode, int i2) {
        this.f3521a = i2;
        this.f3522b = scheduleNode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3521a) {
            case 0:
                this.f3522b.execute();
                break;
            default:
                this.f3522b.executeInternal();
                break;
        }
    }
}
