package androidx.camera.core;

import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ConcurrentCamera {
    private List<Camera> mCameras;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SingleCameraConfig {
        private CameraSelector mCameraSelector;
        private CompositionSettings mCompositionSettings;
        private LifecycleOwner mLifecycleOwner;
        private UseCaseGroup mUseCaseGroup;

        public SingleCameraConfig(CameraSelector cameraSelector, UseCaseGroup useCaseGroup, LifecycleOwner lifecycleOwner) {
            this(cameraSelector, useCaseGroup, CompositionSettings.DEFAULT, lifecycleOwner);
        }

        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        public CompositionSettings getCompositionSettings() {
            return this.mCompositionSettings;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        public SingleCameraConfig(CameraSelector cameraSelector, UseCaseGroup useCaseGroup, CompositionSettings compositionSettings, LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mCompositionSettings = compositionSettings;
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    public ConcurrentCamera(List<Camera> list) {
        this.mCameras = list;
    }

    public List<Camera> getCameras() {
        return this.mCameras;
    }
}
