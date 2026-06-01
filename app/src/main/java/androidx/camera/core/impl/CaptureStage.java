package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CaptureStage {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultCaptureStage implements CaptureStage {
        private final CaptureConfig mCaptureConfig = new CaptureConfig.Builder().build();

        @Override // androidx.camera.core.impl.CaptureStage
        public CaptureConfig getCaptureConfig() {
            return this.mCaptureConfig;
        }

        @Override // androidx.camera.core.impl.CaptureStage
        public int getId() {
            return 0;
        }
    }

    CaptureConfig getCaptureConfig();

    int getId();
}
