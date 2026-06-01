package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface CameraCaptureResult {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class EmptyCameraCaptureResult implements CameraCaptureResult {
        public static CameraCaptureResult create() {
            return new EmptyCameraCaptureResult();
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AeMode getAeMode() {
            return CameraCaptureMetaData.AeMode.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AeState getAeState() {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AfMode getAfMode() {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AfState getAfState() {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AwbMode getAwbMode() {
            return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.AwbState getAwbState() {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CaptureResult getCaptureResult() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public CameraCaptureMetaData.FlashState getFlashState() {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public TagBundle getTagBundle() {
            return TagBundle.emptyBundle();
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public long getTimestamp() {
            return -1L;
        }

        @Override // androidx.camera.core.impl.CameraCaptureResult
        public final /* synthetic */ void populateExifData(ExifData.Builder builder) {
            c.b(this, builder);
        }
    }

    CameraCaptureMetaData.AeMode getAeMode();

    CameraCaptureMetaData.AeState getAeState();

    CameraCaptureMetaData.AfMode getAfMode();

    CameraCaptureMetaData.AfState getAfState();

    CameraCaptureMetaData.AwbMode getAwbMode();

    CameraCaptureMetaData.AwbState getAwbState();

    CaptureResult getCaptureResult();

    CameraCaptureMetaData.FlashState getFlashState();

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(ExifData.Builder builder);
}
