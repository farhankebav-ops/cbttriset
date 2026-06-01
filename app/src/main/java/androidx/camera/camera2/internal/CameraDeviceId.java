package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
abstract class CameraDeviceId {
    public static CameraDeviceId create(String str, String str2, String str3, String str4) {
        return new AutoValue_CameraDeviceId(str.toLowerCase(), str2.toLowerCase(), str3.toLowerCase(), str4.toLowerCase());
    }

    public abstract String getBrand();

    public abstract String getCameraId();

    public abstract String getDevice();

    public abstract String getModel();
}
