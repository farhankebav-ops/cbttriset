package androidx.camera.view.internal;

import androidx.camera.core.ImageCapture;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ScreenFlashUiInfo {
    private final ProviderType mProviderType;
    private final ImageCapture.ScreenFlash mScreenFlash;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum ProviderType {
        PREVIEW_VIEW,
        SCREEN_FLASH_VIEW
    }

    public ScreenFlashUiInfo(ProviderType providerType, ImageCapture.ScreenFlash screenFlash) {
        this.mProviderType = providerType;
        this.mScreenFlash = screenFlash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenFlashUiInfo)) {
            return false;
        }
        ScreenFlashUiInfo screenFlashUiInfo = (ScreenFlashUiInfo) obj;
        return this.mProviderType == screenFlashUiInfo.mProviderType && Objects.equals(this.mScreenFlash, screenFlashUiInfo.mScreenFlash);
    }

    public ProviderType getProviderType() {
        return this.mProviderType;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public int hashCode() {
        return Objects.hash(this.mProviderType, this.mScreenFlash);
    }
}
