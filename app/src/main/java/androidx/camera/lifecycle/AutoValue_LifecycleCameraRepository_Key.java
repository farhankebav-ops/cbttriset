package androidx.camera.lifecycle;

import androidx.camera.core.CameraIdentifier;
import androidx.camera.lifecycle.LifecycleCameraRepository;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraIdentifier cameraIdentifier;
    private final int lifecycleOwnerHash;

    public AutoValue_LifecycleCameraRepository_Key(int i2, CameraIdentifier cameraIdentifier) {
        this.lifecycleOwnerHash = i2;
        if (cameraIdentifier == null) {
            throw new NullPointerException("Null cameraIdentifier");
        }
        this.cameraIdentifier = cameraIdentifier;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LifecycleCameraRepository.Key) {
            LifecycleCameraRepository.Key key = (LifecycleCameraRepository.Key) obj;
            if (this.lifecycleOwnerHash == key.getLifecycleOwnerHash() && this.cameraIdentifier.equals(key.getCameraIdentifier())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public CameraIdentifier getCameraIdentifier() {
        return this.cameraIdentifier;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    public int getLifecycleOwnerHash() {
        return this.lifecycleOwnerHash;
    }

    public int hashCode() {
        return ((this.lifecycleOwnerHash ^ 1000003) * 1000003) ^ this.cameraIdentifier.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwnerHash=" + this.lifecycleOwnerHash + ", cameraIdentifier=" + this.cameraIdentifier + "}";
    }
}
