package androidx.camera.core.internal;

import androidx.annotation.GuardedBy;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashWrapper implements ImageCapture.ScreenFlash {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ScreenFlashWrapper";

    @GuardedBy("lock")
    private boolean isClearScreenFlashPending;
    private final Object lock;

    @GuardedBy("lock")
    private ImageCapture.ScreenFlashListener pendingListener;
    private final ImageCapture.ScreenFlash screenFlash;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final ScreenFlashWrapper from(ImageCapture.ScreenFlash screenFlash) {
            return new ScreenFlashWrapper(screenFlash, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ ScreenFlashWrapper(ImageCapture.ScreenFlash screenFlash, kotlin.jvm.internal.f fVar) {
        this(screenFlash);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$2(ScreenFlashWrapper screenFlashWrapper) {
        synchronized (screenFlashWrapper.lock) {
            try {
                if (screenFlashWrapper.pendingListener == null) {
                    Logger.w(TAG, "apply: pendingListener is null!");
                }
                screenFlashWrapper.completePendingScreenFlashListener();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void completePendingScreenFlashClear() {
        synchronized (this.lock) {
            try {
                if (this.isClearScreenFlashPending) {
                    ImageCapture.ScreenFlash screenFlash = this.screenFlash;
                    if (screenFlash != null) {
                        screenFlash.clear();
                    } else {
                        Logger.e(TAG, "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    Logger.w(TAG, "completePendingScreenFlashClear: none pending!");
                }
                this.isClearScreenFlashPending = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void completePendingScreenFlashListener() {
        synchronized (this.lock) {
            try {
                ImageCapture.ScreenFlashListener screenFlashListener = this.pendingListener;
                if (screenFlashListener != null) {
                    screenFlashListener.onCompleted();
                }
                this.pendingListener = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final ScreenFlashWrapper from(ImageCapture.ScreenFlash screenFlash) {
        return Companion.from(screenFlash);
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void apply(long j, ImageCapture.ScreenFlashListener screenFlashListener) {
        k.e(screenFlashListener, "screenFlashListener");
        synchronized (this.lock) {
            this.isClearScreenFlashPending = true;
            this.pendingListener = screenFlashListener;
        }
        ImageCapture.ScreenFlash screenFlash = this.screenFlash;
        if (screenFlash != null) {
            screenFlash.apply(j, new ImageCapture.ScreenFlashListener() { // from class: androidx.camera.core.internal.d
                @Override // androidx.camera.core.ImageCapture.ScreenFlashListener
                public final void onCompleted() {
                    ScreenFlashWrapper.apply$lambda$2(this.f3665a);
                }
            });
        } else {
            Logger.e(TAG, "apply: screenFlash is null!");
            completePendingScreenFlashListener();
        }
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void clear() {
        completePendingScreenFlashClear();
    }

    public final void completePendingTasks() {
        completePendingScreenFlashListener();
        completePendingScreenFlashClear();
    }

    public final ImageCapture.ScreenFlash getBaseScreenFlash() {
        return this.screenFlash;
    }

    private ScreenFlashWrapper(ImageCapture.ScreenFlash screenFlash) {
        this.screenFlash = screenFlash;
        this.lock = new Object();
    }
}
