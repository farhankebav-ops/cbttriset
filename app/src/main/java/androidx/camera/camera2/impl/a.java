package androidx.camera.camera2.impl;

import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ AdSelectionFromOutcomesConfig.Builder b() {
        return new AdSelectionFromOutcomesConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ GetAdSelectionDataOutcome h(Object obj) {
        return (GetAdSelectionDataOutcome) obj;
    }

    public static /* bridge */ /* synthetic */ CameraDevice.CameraDeviceSetup m(Object obj) {
        return (CameraDevice.CameraDeviceSetup) obj;
    }

    public static /* synthetic */ OutputConfiguration q(int i2, Size size) {
        return new OutputConfiguration(i2, size);
    }
}
