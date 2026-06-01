package androidx.camera.camera2.internal;

import androidx.camera.core.Logger;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoUsageControl {
    private final Executor executor;
    private final AtomicInteger mVideoUsage;

    public VideoUsageControl(Executor executor) {
        kotlin.jvm.internal.k.e(executor, "executor");
        this.executor = executor;
        this.mVideoUsage = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decrementUsage$lambda$1(VideoUsageControl videoUsageControl) {
        int iDecrementAndGet = videoUsageControl.mVideoUsage.decrementAndGet();
        if (iDecrementAndGet >= 0) {
            Logger.d("VideoUsageControl", "decrementUsage: mVideoUsage = " + iDecrementAndGet);
        } else {
            Logger.w("VideoUsageControl", "decrementUsage: mVideoUsage = " + iDecrementAndGet + ", which is less than 0!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void incrementUsage$lambda$0(VideoUsageControl videoUsageControl) {
        Logger.d("VideoUsageControl", "incrementUsage: mVideoUsage = " + videoUsageControl.mVideoUsage.incrementAndGet());
    }

    public final void decrementUsage() {
        this.executor.execute(new d1(this, 0));
    }

    public final int getUsage() {
        return this.mVideoUsage.get();
    }

    public final void incrementUsage() {
        this.executor.execute(new d1(this, 2));
    }

    public final void reset() {
        this.executor.execute(new d1(this, 1));
    }

    public final void resetDirectly() {
        this.mVideoUsage.set(0);
        Logger.d("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }
}
