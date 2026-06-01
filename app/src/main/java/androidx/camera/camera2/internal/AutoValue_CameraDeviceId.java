package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_CameraDeviceId extends CameraDeviceId {
    private final String brand;
    private final String cameraId;
    private final String device;
    private final String model;

    public AutoValue_CameraDeviceId(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("Null brand");
        }
        this.brand = str;
        if (str2 == null) {
            throw new NullPointerException("Null device");
        }
        this.device = str2;
        if (str3 == null) {
            throw new NullPointerException("Null model");
        }
        this.model = str3;
        if (str4 == null) {
            throw new NullPointerException("Null cameraId");
        }
        this.cameraId = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraDeviceId) {
            CameraDeviceId cameraDeviceId = (CameraDeviceId) obj;
            if (this.brand.equals(cameraDeviceId.getBrand()) && this.device.equals(cameraDeviceId.getDevice()) && this.model.equals(cameraDeviceId.getModel()) && this.cameraId.equals(cameraDeviceId.getCameraId())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getBrand() {
        return this.brand;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getDevice() {
        return this.device;
    }

    @Override // androidx.camera.camera2.internal.CameraDeviceId
    public String getModel() {
        return this.model;
    }

    public int hashCode() {
        return ((((((this.brand.hashCode() ^ 1000003) * 1000003) ^ this.device.hashCode()) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CameraDeviceId{brand=");
        sb.append(this.brand);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", cameraId=");
        return a1.a.r(sb, this.cameraId, "}");
    }
}
