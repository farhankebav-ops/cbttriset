package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExperimentalLensFacing;
import androidx.camera.core.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalLensFacing.class})
public final class CameraValidator {
    private static final CameraSelector EXTERNAL_LENS_FACING = new CameraSelector.Builder().requireLensFacing(2).build();
    private static final String TAG = "CameraValidator";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getDeviceId(Context context) {
            return context.getDeviceId();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CameraIdListIncorrectException extends Exception {
        private final int mAvailableCameraCount;

        public CameraIdListIncorrectException(String str, int i2, Throwable th) {
            super(str, th);
            this.mAvailableCameraCount = i2;
        }

        public int getAvailableCameraCount() {
            return this.mAvailableCameraCount;
        }
    }

    private CameraValidator() {
    }

    public static void validateCameras(Context context, CameraRepository cameraRepository, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer lensFacing;
        if (Build.VERSION.SDK_INT >= 34 && Api34Impl.getDeviceId(context) != 0) {
            Logger.d(TAG, "Virtual device with ID: " + Api34Impl.getDeviceId(context) + " has " + cameraRepository.getCameras().size() + " cameras. Skipping validation.");
            return;
        }
        IllegalArgumentException e = null;
        if (cameraSelector != null) {
            try {
                lensFacing = cameraSelector.getLensFacing();
                if (lensFacing == null) {
                    Logger.w(TAG, "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e4) {
                Logger.e(TAG, "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e4);
                return;
            }
        } else {
            lensFacing = null;
        }
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + lensFacing);
        PackageManager packageManager = context.getPackageManager();
        int i2 = 0;
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || lensFacing.intValue() == 1)) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
                i2 = 1;
            }
        } catch (IllegalArgumentException e8) {
            e = e8;
            Logger.w(TAG, "Camera LENS_FACING_BACK verification failed", e);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (cameraSelector == null || lensFacing.intValue() == 0)) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
                i2++;
            }
        } catch (IllegalArgumentException e9) {
            e = e9;
            Logger.w(TAG, "Camera LENS_FACING_FRONT verification failed", e);
        }
        try {
            EXTERNAL_LENS_FACING.select(cameraRepository.getCameras());
            Logger.d(TAG, "Found a LENS_FACING_EXTERNAL camera");
            i2++;
        } catch (IllegalArgumentException unused) {
        }
        if (e == null) {
            return;
        }
        Logger.e(TAG, "Camera LensFacing verification failed, existing cameras: " + cameraRepository.getCameras());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", i2, e);
    }
}
