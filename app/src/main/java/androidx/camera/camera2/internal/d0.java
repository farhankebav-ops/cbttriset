package androidx.camera.camera2.internal;

import android.content.ClipData;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.params.MultiResolutionStreamInfo;
import android.location.LocationRequest;
import android.os.OutcomeReceiver;
import android.view.ContentInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class d0 {
    public static /* synthetic */ void C() {
    }

    public static /* bridge */ /* synthetic */ CameraExtensionCharacteristics e(Object obj) {
        return (CameraExtensionCharacteristics) obj;
    }

    public static /* synthetic */ MultiResolutionStreamInfo f(int i2, int i8, String str) {
        return new MultiResolutionStreamInfo(i2, i8, str);
    }

    public static /* bridge */ /* synthetic */ LocationRequest g(Object obj) {
        return (LocationRequest) obj;
    }

    public static /* bridge */ /* synthetic */ OutcomeReceiver j(Object obj) {
        return (OutcomeReceiver) obj;
    }

    public static /* synthetic */ ContentInfo.Builder l(ClipData clipData, int i2) {
        return new ContentInfo.Builder(clipData, i2);
    }

    public static /* synthetic */ ContentInfo.Builder m(ContentInfo contentInfo) {
        return new ContentInfo.Builder(contentInfo);
    }

    public static /* bridge */ /* synthetic */ ContentInfo o(Object obj) {
        return (ContentInfo) obj;
    }

    public static /* synthetic */ void t() {
    }
}
